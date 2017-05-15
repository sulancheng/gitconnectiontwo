package com.example.mymeituxx;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.mt.mtxx.image.JNI;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends Activity {


    //使用so库
    static {

        System.loadLibrary("mtimage-jni");
    }

    //调用so库里面的native方法


    private ImageView mImageView;
    private String mPicPath;
    private Bitmap mRawBitmap;
    private JNI mJNI;
    private Bitmap mNewBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView) findViewById(R.id.iv);
        mJNI = new JNI();
        requestMultiplePermissions();
    }

    // 打开相册
    public void openPic(View view) {

        // 意图打开相册；传入路径

        Intent intent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 100);

    }

    //美化图片
    public void ps(View view) {

        if(mRawBitmap!=null) {

            //1.获取图片的像素的个个数
            int width = mRawBitmap.getWidth();
            int height = mRawBitmap.getHeight();
            //2.定义一个数组存放图片的像素点
            int pixels[] = new int[width * height];
            //3.将图片的像素数据导入到数组
            mRawBitmap.getPixels(pixels, 0, width, 0, 0, width, height);
            //4.处理图片
            mJNI.StyleClassicStudio(pixels, width, height);
            //5.把处理后的像素点---->Bitmap
            mNewBitmap = Bitmap.createBitmap(pixels, width, height, mRawBitmap.getConfig());

            mImageView.setImageBitmap(mNewBitmap);

        }


    }

    //保存图片
    public void save(View view) {

        if(mNewBitmap!=null) {

            try {
                //mPicPath = 图片路径/name
                File file = new File(mPicPath);
                //图片相册路径
                String path = file.getParent();

                File f = new File(path, "new_"+file.getName());
                //f保存图片路径
                FileOutputStream stream = new FileOutputStream(f);

                mNewBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);//通过流保存。

                Toast.makeText(this, "保存到了："+f.getAbsolutePath(), Toast.LENGTH_LONG).show();

                //让媒体库更新数据,更新指定的文件f
                sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(f)));



            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }

    private void requestMultiplePermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            boolean b1 = checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
            boolean b2 = checkSelfPermission(Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED;
            boolean b3 = checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
            boolean b4 = checkSelfPermission(Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED;

//            PermissionUtils.requestPermission(this,1000,Manifest.permission.WRITE_EXTERNAL_STORAGE,true);
//            PermissionUtils.requestPermission(this,1000,Manifest.permission.READ_PHONE_STATE,true);
//            PermissionUtils.requestPermission(this,1000,Manifest.permission.ACCESS_FINE_LOCATION,true);
//            PermissionUtils.requestPermission(this,1000,Manifest.permission.READ_CONTACTS,true);


            if (!b1 || !b2 || !b3 || !b4){
                String[] permissions = new String[]{Manifest.permission.READ_PHONE_STATE,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.READ_CONTACTS,Manifest.permission.WRITE_EXTERNAL_STORAGE};
                requestPermissions(permissions, 2000);
            } else {

            }
        } else {

        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        boolean flag = false;
        if (requestCode == 2000) {
            for (int i = 0; i < grantResults.length; ++i) {
                if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                    flag = true;
                    break;
                }
            }
            if(flag){
                Log.i("onRequestPermission","权限申请");
            }else {
            }
        }
    }
    // 得到打开相册的选择图片的结果,图片数据在Intent data
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 100 && resultCode == RESULT_OK) {

            Uri uri = data.getData();
            //MediaStore.Images.Media.DATA图片实际路径
            //cursor
            Cursor cursor = getContentResolver().query(uri, new String[]{MediaStore.Images.Media.DATA}, null, null, null);
            cursor.moveToFirst();
            mPicPath = cursor.getString(0);

            //mPicPath --- >Bitmap

            mRawBitmap = BitmapFactory.decodeFile(mPicPath);

            mImageView.setImageBitmap(mRawBitmap);

        }

    }

}
