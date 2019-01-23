1. 使用rpm安装：安装包在百度云盘
2. 安装完之后修改配置文件：
```swagger codegen
vi /etc/mongod.conf
将bindIp修改为0.0.0.0
bindIp: 0.0.0.0  # Enter 0.0.0.0,:: to bind to all IPv4 and IPv6 addresses or, alternatively, use the net.bindIpAll setting.
```
3. 使用service mongod start启动服务，