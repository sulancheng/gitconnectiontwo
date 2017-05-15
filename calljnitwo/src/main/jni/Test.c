#include <stdio.h>
#include <jni.h>
#include <stdlib.h>


/**
 * 调用java代码中JNI类里面的public void sayHello()
 *
 */

void Java_com_atguigu_ccalljava2_JNI_callbackSayHello(JNIEnv *env, jobject instance) {

    //1.得到字节码
    // jclass      (*FindClass)(JNIEnv*, const char*);
    jclass jclazz =(**env).FindClass(env,"com/atguigu/ccalljava2/JNI");

    //2.得到对应的方法
    //jmethodID   (*GetMethodID)(JNIEnv*, jclass, const char*, const char*);
    jmethodID jmethodid =  (**env).GetMethodID(env,jclazz,"sayHello","()V");

    //3.实例化JNI类
    //jobject     (*AllocObject)(JNIEnv*, jclass);
    jobject jobj= (**env).AllocObject(env,jclazz);

    //4.调用方法
    //void        (*CallVoidMethod)(JNIEnv*, jobject, jmethodID, ...);
    (**env).CallVoidMethod(env,jobj,jmethodid);//就这样成功调用了Java中JNI里面的sayHello()方法

};
