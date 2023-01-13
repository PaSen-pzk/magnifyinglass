package com.posin.portal.retrofit.http;

import com.github.lianjiatech.retrofit.spring.boot.annotation.Intercept;
import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import com.posin.common.response.model.RESTResponse;
import com.posin.portal.retrofit.interceptor.TimeStampInterceptor;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * @ClassName : UserServiceHttpApi
 * @Description : UserServiceHttpApi
    * @POST post请求，如果有参数需要添加 @FormUrlEncoded注解，即和@Field配合使用
    * @GET
 * @Author : ZeKun Pan
 * @Date: 2023-01-11 17:48
 */
@RetrofitClient(baseUrl = "${out-system-service-path}", poolName = "test2")
@Intercept(handler = TimeStampInterceptor.class, include = {"/si/**"}, exclude = {"/si/post/test"})
public interface UserServiceHttpApi {

    @GET("/si/verify/deploy")
    Call<RESTResponse> deploy();

    @FormUrlEncoded
    @POST("/si/post/test")
    Call<RESTResponse> postTest(@Field("format")String format);
}
