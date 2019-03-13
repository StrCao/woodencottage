1. 启动项目，ChatDemoApplication
2. 访问：localhost:8080/sub01, 开启第一个客户端订阅</br>
   访问：localhost:8080/sub02, 开启第二个客户端订阅
3. 访问：localhost:8080/client01，打开第一个客户端页面, 点击开启按钮，开启第一个客户端websocket连接</br>
   访问：localhost:8080/client02，打开第二个客户端页面, 点击开启按钮，开启第二个客户端websocket连接
4. 访问: localhost:8080/pub01，向第一个客户端消息通道发送一条消息</br>
   访问: localhost:8080/pub02，向第二个客户端消息通道发送一条消息
5. 点开第一个客户端页面，可以看到弹出框弹出一条消息</br>
   点开第二个客户端页面，可以看到弹出框弹出一条消息
说明：项目启动了两个通道，client01通过通道1与pub01通信，client02通过通道2与pub02通信