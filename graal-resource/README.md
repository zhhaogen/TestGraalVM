# 获取内部资源
需要在resource-config.json配置,否则会读取内容为null
可以在arguments内添加参数，或者META-INF/native-image/{groupID}/{artifactID}/native-image.properties添加参数
nativeImage { 
    arguments(
            "--no-fallback"
        )
} 