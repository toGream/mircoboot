本模块是测试服务追踪的模块之一，需要引入spring-cloud-starter-zipkin依赖和设置spring.zipkin.base-url
server.port=8988
spring.zipkin.base-url=http://localhost:9411
spring.application.name=service-hi

#说明:
1.不引入spring-cloud-starter-eureka需要引入spring-boot-starter-web
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

2.<version>1.2.4.RELEASE</version>版本匹配非常重要，org.springframework.cloud.sleuth.sampler.AlwaysSampler类在1.2.5RELEASE没有此类
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-zipkin</artifactId>
    <version>1.2.4.RELEASE</version>
</dependency>

3.追踪服务请求需要在服务调用类加下面方法：
@Bean
public AlwaysSampler defaultSampler(){
	return new AlwaysSampler();
}