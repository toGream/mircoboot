一:此模块为服务提供者.

二:在微服务架构中为例保证程序的可用性，防止程序出错导致网络阻塞，出现了断路器模型。
断路器的状况反应了一个程序的可用性和健壮性，它是一个重要指标。
Hystrix Dashboard是作为断路器状态的一个组件，提供了数据监控和友好的图形化界面。
1.这三个依赖是必须的:
<!--监控中心-->  
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
<!-- hystrix 断路器-->  
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-hystrix-dashboard</artifactId>
</dependency>
<!-- hystrix-dashboard监控 -->  
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-hystrix</artifactId>
</dependency>

2.在程序的入口ServiceHiApplication类，加上@EnableHystrix注解开启断路器，
这个是必须的，并且需要在程序中声明断路点HystrixCommand；加上@EnableHystrixDashboard注解，开启HystrixDashboard

3.@HystrixCommand(fallbackMethod = "hiError")这个也是需要的，不然http://localhost:8762/hystrix没有图形
@Value("${server.port}")
String port;
@RequestMapping("/hi")
@HystrixCommand(fallbackMethod = "hiError")
public String home(@RequestParam String name) {
    return "hi "+name+",i am from port:" +port;
}

public String hiError(String name) {
    return "hi,"+name+",sorry,error!";
}