# swing界面
构建命令:
```
gradle nativeImage -p graal-swing
```
最后结果
```
Warning: Image 'graal-swing' is a fallback image that requires a JDK for execution (use --no-fallback to suppress fallback image generation and to print more detailed information why a fallback image was necessary)
```
生成的exe文件离不开jdk，不能单独运行