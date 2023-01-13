package com.posin.portal.retrofit.config;

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
 * 数据转码器 Converter
     * Retrofi使用Converter将@Body注解标注的对象转换成请求体，将响应体数据转换成一个Java对象，可以选用以下几种Converter：
     *
     * Gson: com.squareup.Retrofit:converter-gson
     * Jackson: com.squareup.Retrofit:converter-jackson
     * Moshi: com.squareup.Retrofit:converter-moshi
     * Protobuf: com.squareup.Retrofit:converter-protobuf
     * Wire: com.squareup.Retrofit:converter-wire
     * Simple XML: com.squareup.Retrofit:converter-simplexml
     * retrofit-spring-boot-starter默认使用的是jackson进行序列化转换！如果需要使用其它序列化方式，在项目中引入对应的依赖，再把对应的ConverterFactory配置成spring的bean即可。
     *
     * 我们也可以通过继承Converter.Factory扩展实现自己的Converter；然后将自定义的Converter.Factory配置成spring的bean！
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
                //设置数据解析器  (数据转码器 Converter)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        return retrofit;
    }
}
