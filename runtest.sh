javac -cp lib/junit-platform-console-standalone.jar -d out main/*.java test/*.java
java -jar lib/junit-platform-console-standalone.jar --class-path out --scan-classpath
