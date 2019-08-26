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




    */
}
