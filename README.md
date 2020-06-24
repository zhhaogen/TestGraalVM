# graalvm 教程和例子
## 环境
```
Microsoft Windows [版本 10.0.18363.719]
(c) 2019 Microsoft Corporation。保留所有权利。
```
```
Microsoft Visual Studio Community 2017 
版本 15.9.17
VisualStudio.15.Release/15.9.17+28307.905
Microsoft .NET Framework
版本 4.8.03752

已安装的版本: Community
```
```
openjdk version "11.0.7" 2020-04-14
OpenJDK Runtime Environment GraalVM CE 20.2.0-dev (build 11.0.7+10-jvmci-20.1-b02)
OpenJDK 64-Bit Server VM GraalVM CE 20.2.0-dev (build 11.0.7+10-jvmci-20.1-b02, mixed mode, sharing)
```
```
------------------------------------------------------------
Gradle 5.4.1
------------------------------------------------------------

Build time:   2019-04-26 08:14:42 UTC
Revision:     261d171646b36a6a28d5a19a69676cd098a4c19d

Kotlin:       1.3.21
Groovy:       2.5.4
Ant:          Apache Ant(TM) version 1.9.13 compiled on July 10 2018
JVM:          11.0.7 (GraalVM Community 11.0.7+10-jvmci-20.1-b02)
OS:           Windows 10 10.0 amd64
```

## 插件

## 运行前
执行命令:
```
cmd /k "C:\Program Files (x86)\Microsoft Visual Studio\2017\Community\VC\Auxiliary\Build\vcvarsx86_amd64.bat"
```
## 配置参数
META-INF/native-image/{groupID}/{artifactID}/ 下不同文件可以配置参数
native-image.properties 可以配置构建参数
resource-config.json 为内部资源配置
reflect-config.json 为反射类配置
jni-config.json 
proxy-config.json

## java.lang.NoClassDefFoundError || java.lang.ClassNotFoundException
如果存在此类，首先尝试在reflect-config.json中加入此类
## 反射配置
具体参考(https://github.com/oracle/graal/blob/master/substratevm/REFLECTION.md)
反射所有Declared方法和字段
```
{
  "name":"org.apache.log4j.Category", 
  "allDeclaredFields":true,
  "allDeclaredMethods":true,
  "allDeclaredConstructors":true
}
```
指定特定方法
```
"methods":[{ "name":"<init>", "parameterTypes":[] }]
```
指定特定字段
```
"fields":[{"name":"value"}]
```
所有公开方法
```
"allPublicMethods":true
```
## --initialize-at-run-time 和--initialize-at-build-time

