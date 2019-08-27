package com.zcy.controller;

import org.springframework.stereotype.Controller;

/**
 * @Description
 * @author:caiyuan
 * @date:2019/8/26 0026
 * @ver:1.0
 **/
@Controller
public class TestController {
    /*
        spring常用注解：
        1，声明bean：
            @Component : 没有明确的角色
            @Controller : 声明Controller
            @Service : 声明Service，使用在ServiceImpl上
            @Repository : 声明Dao

        2，注入bean：
            @Autowired
            @Inject
            @Resource

        3，java配置类相关注解：
            @Configuration : 声明当前类为配置类，相当于xml
            @Bean : 注解在方法上，声明当前方法的返回值为一个bean
            @ComponentScan : 用于对Component进行扫描

        4，切面（AOP）相关注解
            @Aspect : 声明一个切面（类上）
                -@After : 在方法执行之后执行 （方法上）
                -@Before : 在方法执行之前执行
                -@Around : 在方法执行
                -@PointCut : 声明切点
                -@EnableAspectAutoProxy : 在配置类上使用，开启spring对AspectJ代理的支持

        5，@Bean的属性支持：
            @Scope : 设置spring容器如何新建Bean实例，注解在有@Bean的方法上
                -Singleton : 单例，spring容器中只有一个bean 默认
                -Prototype : 每次调用都新建一个bean
                -Request : 给每个 http request 都新建一个bean
                -Session : 给每个 http session 都新建一个bean
                -GlobalSession : 给每个 global http session 都新建一个bean
            @StepScope
            @PostConstruct

        6，@Value注解
            @Value : 为属性注入值（属性上）

        7，环境切换
            @Profile
            @Conditional

        8，异步相关
            @EnableAsync
            @Async

        9，定时任务相关
            @EnableScheduling
            @Scheduled



    */
}
