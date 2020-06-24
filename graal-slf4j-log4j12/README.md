# slf4j日志框架
根据所需的appender和layout加入到reflect-config.json配置文件中
这里还可以通过设置log4j.configuration环境变量为外部配置文件,参考`org.apache.log4j.LogManager`static区块
错误
```
WARN Failed to set property [conversionPattern] to value "%m%n  %l%n".
``` 
参考`org.apache.log4j.config.PropertySetter.setProperties(Properties properties, String prefix)`
问题来自于`org.apache.log4j.config.PropertySetter.convertArg(String val, Class type)`一些class的反射