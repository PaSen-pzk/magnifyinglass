package com.posin.portal.http;

import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;

/**
 * @ClassName : UserServiceHttpApi
 * @Description : UserServiceHttpApi
 * @Author : ZeKun Pan
 * @Date: 2023-01-11 17:48
 */
@RetrofitClient(baseUrl = "${mg-portal-service-path}")
public interface UserServiceHttpApi {


}
