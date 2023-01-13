package com.posin.portal.impl;

import com.posin.common.response.model.RESTResponse;
import com.posin.portal.http.UserServiceHttpApi;
import com.posin.portal.model.UserEntity;
import com.posin.portal.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

/**
 * @ClassName : UserServiceImpl
 * @Description : UserServiceImpl
 * @Author : ZeKun Pan
 * @Date: 2023-01-11 23:33
 */
@Service
public class UserServiceImpl{

    @Autowired
    IUserService userService;
    @Autowired
    Retrofit retrofit;

    public void test(Integer id) throws IOException {
        RESTResponse response = new RESTResponse();
        UserEntity user = userService.getUserById(id);
        response.setData(user);
        UserServiceHttpApi userServiceHttpApi = retrofit.create(UserServiceHttpApi.class);
        Call<RESTResponse> apiResponse = userServiceHttpApi.deploy();
        // 异步请求
//        apiResponse.enqueue(new Callback<RESTResponse>() {
//            //请求成功回调
//            @Override
//            public void onResponse(Call<RESTResponse> call, Response<RESTResponse> response) {
//
//            }
//            //请求失败回调
//            @Override
//            public void onFailure(Call<RESTResponse> call, Throwable throwable) {
//
//            }
//        });
        //请求同步
        Response<RESTResponse> syncResponse = apiResponse.execute();
        System.out.println(syncResponse);
    }
}
