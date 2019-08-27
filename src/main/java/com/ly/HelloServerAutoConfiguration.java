package com.ly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  //标注该类是一个配置类
@EnableConfigurationProperties(HelloProperties.class) //使@ConfigurationProperties生效,让配置的属性注入到bean中
@ConditionalOnClass(HelloServer.class)  //条件注解,当前项目的classpath下存在HelloServer.class
public class HelloServerAutoConfiguration {
    @Autowired
    HelloProperties helloProperties;

    @ConditionalOnMissingBean  //当前bean容器中不存在该bean
    @Bean
    public HelloServer helloServer(){
        return new HelloServer(helloProperties.getName(),helloProperties.getAge());
    }
}
