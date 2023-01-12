package com.posin.portal.http;

import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import com.posin.common.response.model.RESTResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @ClassName : UserServiceHttpApi
 * @Description : UserServiceHttpApi
 * @Author : ZeKun Pan
 * @Date: 2023-01-11 17:48
 */
@RetrofitClient(baseUrl = "${mg-portal-service-path}")
public interface UserServiceHttpApi {

    @GET("/users/get")
    RESTResponse getUserList(@Query("id") Integer id);
}
