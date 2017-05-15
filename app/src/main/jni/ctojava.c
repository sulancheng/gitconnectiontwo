#include "com_example_su_myappconectiontwo_aboutjni_JniClient.h"
#include <stdlib.h>
#include <stdio.h>

#include <android/log.h>
#define LOG_TAG "System.out"
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, __VA_ARGS__)
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR, LOG_TAG, __VA_ARGS__)
//
// Created by su on 2017/5/8.
//
_Included_com_example_su_myappconectiontwo_aboutjni_JniClient
/**
 * 让C代码调用 java 中JNI类的 public int add(int x, int y)
 * com_example_su_myappconectiontwo_aboutjni_JniClient
 */
void Java_com_example_su_myappconectiontwo_aboutjni_JniClient_callbackAdd(JNIEnv *env, jobject instance) {

    //1.得到字节码
    //jclass      (*FindClass)(JNIEnv*, const char*);
    jclass jclazz = (*env)->FindClass(env,"com/example/su/myappconectiontwo/aboutjni/JniClient");
    //2.得到方法
    //jmethodID   (*GetMethodID)(JNIEnv*, jclass, const char*, const char*);
    //最后一个参数是方法签名
    jmethodID jmethodIDs= (*env)->GetMethodID(env,jclazz,"add","(II)I");
    //3.实例化该类
    // jobject     (*AllocObject)(JNIEnv*, jclass);
    jobject  jobject =(*env)->AllocObject(env,jclazz);
    //4.调用方法
    //jint        (*CallIntMethod)(JNIEnv*, jobject, jmethodID, ...);
    jint value =  (*env)->CallIntMethod(env,jobject,jmethodIDs,99,1);
    //成功调用了public int add(int x, int y)
    printf("value===%d\n",value);
    LOGE("value===%d\n",value);

};
void Java_com_example_su_myappconectiontwo_aboutjni_JniClient_callbackSayHello(JNIEnv *env, jobject instance) {

    //1.得到字节码
    // jclass      (*FindClass)(JNIEnv*, const char*);
    jclass jclazz =(**env).FindClass(env,"com/example/su/myappconectiontwo/aboutjni/JniClient");

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
