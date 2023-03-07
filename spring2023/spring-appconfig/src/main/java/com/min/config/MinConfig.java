package com.min.config;

import com.min.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//这个也会被spring容器托管，注册到容器中，这本来就是一个@Component，@Configuration代表这是一个配置类，
@Configuration
@ComponentScan("com.min.pojo")
@Import(MinConfig.class)
public class MinConfig {

    //注册一个bean就相当于一个bean标签，id就是方法名，方法的返回值就相当于bean中的class
    @Bean
    public User getUser(){
        return new User();//返回要注入到bean的对象
    }
}
