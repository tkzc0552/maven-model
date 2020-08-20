package com.zhm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.management.modelmbean.ModelMBeanOperationInfo;

@SpringBootApplication
//用来扫描和发现指定包及其子包中的Entity定义
@EntityScan(basePackages = {"com.zhm.**.entity"})
//注解用于Srping JPA的代码配置，用于取代xml形式的配置文件
@EnableJpaRepositories(basePackages = {"com.zhm.**.dao"})
//注解加载指定的属性文件
@PropertySource("classpath:env/${spring.profiles.active}/application.properties")
//在 SpringBootApplication 上使用@ServletComponentScan 注解后，
// Servlet、Filter、Listener 可以直接通过 @WebServlet、@WebFilter、@WebListener 注解自动注册，无需其他代码
@ServletComponentScan


public class ModelBootstrap {
    public static void main(String[] args){
        SpringApplication.run(ModelBootstrap.class,args);
    }

}
