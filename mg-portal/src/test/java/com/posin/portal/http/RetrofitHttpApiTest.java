package com.posin.portal.http;

import com.posin.common.response.model.RESTResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RetrofitHttpApiTest {

    @Autowired
    Retrofit retrofit;

    @Test
    public void invokeTest() throws IOException {
        UserServiceHttpApi userServiceHttpApi = retrofit.create(UserServiceHttpApi.class);
        Call<RESTResponse> apiResponse = userServiceHttpApi.deploy();
        //同步执行
//        Response<RESTResponse> responseResponse = apiResponse.execute();
//        System.out.println(responseResponse);
        //异步执行
        apiResponse.enqueue(new Callback<RESTResponse>() {
            @Override
            public void onResponse(Call<RESTResponse> call, Response<RESTResponse> response) {
                System.out.println("success");
                System.out.println(response);
            }

            @Override
            public void onFailure(Call<RESTResponse> call, Throwable throwable) {
                System.out.println("failure");
                throwable.printStackTrace();
            }
        });
        System.out.println("执行成功");
    }

}