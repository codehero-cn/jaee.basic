package javaeebasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication是Sprnig Boot项目的核心注解，目的是开启自动配置
//@ComponentScan("com.test.test.*") 扫描具体的包
//@ComponentScan(basePackages = {"com.test.test"}) 扫描父类之后的包
@SpringBootApplication
public class AppSwagger {

    public static void main(String[] args) {
        SpringApplication.run(AppSwagger.class, args);
    }

}

