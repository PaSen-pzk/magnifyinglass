package com.posin.portal.http;

import com.posin.common.response.model.RESTResponse;
import com.posin.portal.annotation.Sign;
import com.posin.portal.model.UserEntity;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @ClassName : FkServiceHttpApi
 * @Description : FkServiceHttpApi
 * @Author : ZeKun Pan
 * @Date: 2023-01-13 10:51
 */
@Sign(accessKeyId = "${si.key}", accessKeySecret = "${si.secret}")
public interface SecretServiceHttpApi {

    @GET("person")
    Call<RESTResponse> getPerson(@Query("id") Long id);

    @POST("savePerson")
    Call<RESTResponse> savePerson(@Body UserEntity userEntity);
}
