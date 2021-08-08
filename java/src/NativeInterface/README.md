```bash
export JAVA_INC=/usr/lib/jvm/java-8-openjdk-amd64/include 
```

Step 1: compile the .class file and auto-generate a .h header file

```bash
javac8 -h . HelloJNI.java
```
Step 2: make the shared library with the name linked in said Java source, and implementing said native method

```bash
g++ -std=c++11 -shared -fPIC -I$JAVA_INC -I$JAVA_INC/linux HelloJNIImpl.cpp -o libhello.so
```
Step 3: run JVM with java.library.path set to include said shared library

```bash
java -Djava.library.path=. HelloJNI
```