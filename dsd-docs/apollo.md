# Apollo注意事项
## 客户端初次连接Apollo，Portal上客户端数可能显示为0，需要讲配置发布刷新，才能拉到配置
## Apollo配置中心设计上是出于安全考虑，为内部网络使用，所以真实环境下通过meta-server经服务发现(Eureka)返回的是内网地址，只有处于内网中的客户端能够连接配置中心，开发可以本地启动apollo服务


# Apollo资源
##[Apollo示例](https://github.com/ctripcorp/apollo-use-cases)
##[Apollo源码解析](http://www.iocoder.cn/categories/Apollo/)