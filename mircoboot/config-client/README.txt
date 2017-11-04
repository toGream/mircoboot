一.此模块是配置中心客户端模块,引入此依赖:
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-config</artifactId>
	<version>1.3.3.RELEASE</version>
</dependency>

二.此模块可以在配置文件中配置 spring-cloud-starter-bus-amqp ；
这就是说我们需要装rabbitMq，点击rabbitmq下载。至于怎么使用 rabbitmq，搜索引擎下
通过登录rabbitmq管理界面能查看到关联的服务
    浏览器输入：http://localhost:15672/#/
    用户名：guest，密码guest

说明:
1.以下四项不要知道否则报异常rabbitmq java.net.SocketException: Socket Closed
	#spring.rabbitmq.host=localhost
	#spring.rabbitmq.port=15672
	#spring.rabbitmq.username=admin
	#spring.rabbitmq.password=admin
2.必须引入此依赖和指定properties文件 management.security.enabled=false才能发送post请求：http://localhost:8881/bus/refresh，
不然会报http错误401
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-actuator</artifactId>
	</dependency>
3.获取git文件值得类必须加@RefreshScope注解才能刷新到值
  @RefreshScope	
  