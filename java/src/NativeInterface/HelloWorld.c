#include <stdio.h>
#include "Helloworld.h"
#include <string.h>

JNIEXPORT void JNICALL Java_Helloworld_Hello (JNIEnv *env, jobject obj){
	printf("Hello from c");
	return;
}

JNIEXPORT void JNICALL Java_Helloworld_send (JNIEnv *env, jobject obj, jstring a){
	printf("Hello from c. Following comes from JAVA\n");
	char buf[128];
	const char *str = (*env)->GetStringUTFChars(env, a, 0);
	printf("%s", str);
	(*env)->ReleaseStringUTFChars(env, a, str);
	
	return;
}
