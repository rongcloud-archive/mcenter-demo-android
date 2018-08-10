## MCenter

**消息中心集成 demo**

### 功能:
* 完整的消息中心代码集成示例。
* 内置大量消息供后台投放。
* 无须处理代码逻辑，实现跳转逻辑，后台可自定义调转 Uri。

### 使用注意
* `Mcenter`使用了1.1.2版本的 ConstraintLayout,需要在项目中的`build.gradle`添加 google() 依赖：

	``` java
	allprojects {
    	repositories {
        	google()
        	...
    	}
	}
	```
*  assests 目录下 users_config.json 的格式不可以修改，否则会导致无法正确解析。


### 相关文档
[消息中心产品文档](http://www.rongcloud.cn/docs/mcenter.html)
