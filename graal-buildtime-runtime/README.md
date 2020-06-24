#  --initialize-at-run-time 和--initialize-at-build-time测试
默认情况下UserServer会标记为run-time，或者加入--initialize-at-run-time=cn.zhg.test.graalvm.UserServer，参见build\native-image\reports\run_time_classes.txt
在runtime情况下，每次运行都会初始化类，静态初始化每次运行都会进行，输出结果
```
静态初始化Wed 
构造初始化
一切正常,Wed 
```
输出的时间都是不一样的。

如果加入--initialize-at-build-time=cn.zhg.test.graalvm.UserServer ，则UserServer会标记为build-time，在执行gradle nativeImage时会静态初始化，输出
```
> Task :graal-test:nativeImage
[graal-test:4136]    classlist:   2,058.45 ms,  0.96 GB
静态初始化Wed 
```
UserServer在构建时已经初始化，每次运行时，输出内容为
```
构造初始化
一切正常,Wed 
```
输出的时间都是一样的。
