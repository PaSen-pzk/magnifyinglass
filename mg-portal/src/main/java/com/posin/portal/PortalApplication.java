package com.posin.portal;

import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @ClassName : PortalApplication
 * @Description : PortalApplication
 * @Author : ZeKun Pan
 * @Date: 2023-01-11 17:31
 */
@RetrofitScan(basePackages = {"com.posin"})
@SpringBootApplication(scanBasePackages = "com.posin")
@MapperScan(basePackages = {"com.posin.**.dao","com.posin.**.mapper"})
public class PortalApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PortalApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(PortalApplication.class);
    }
}
