#include "com_example_mycalljni_Jniclient.h"

//
// Created by su on 2017/5/9.
//
_Included_com_example_mycalljni_Jniclient
JNIEXPORT jstring JNICALL Java_com_example_mycalljni_Jniclient_hehe
        (JNIEnv *env, jobject jobj){
    return env->NewStringUTF("你好！！！！");
}
