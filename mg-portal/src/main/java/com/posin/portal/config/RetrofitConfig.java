package com.posin.portal.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * @ClassName : RetrofitConfig
 * @Description : 可作为外部系统http接口的调用工具
    * 注意：使用Retrofit作为http客户端进行调用时，定义的外部接口的返回值必须是可序列化的
 * @Author : ZeKun Pan
 * @Date: 2023-01-12 16:35
 */
@Configuration
public class RetrofitConfig {

    @Value("${retrofit.base-url}")
    private String baseUrl;

    @Bean
    public Retrofit retrofit() {
        //构建Retrofit实例
        Retrofit retrofit = new Retrofit.Builder()
                //设置网络请求BaseUrl地址
                .baseUrl(baseUrl)
                //设置数据解析器
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        return retrofit;
    }
}
