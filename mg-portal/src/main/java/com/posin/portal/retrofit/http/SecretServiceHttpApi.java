package com.posin.portal.retrofit.http;

import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import com.github.lianjiatech.retrofit.spring.boot.interceptor.BaseLoggingInterceptor;
import com.posin.common.response.model.RESTResponse;
import com.posin.portal.retrofit.annotation.Sign;
import com.posin.portal.retrofit.model.UserEntity;
import org.slf4j.event.Level;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @ClassName : FkServiceHttpApi
 * @Description : FkServiceHttpApi
    * >> 通过@RetrofitClient的logLevel和logStrategy属性 指定每个接口的日志打印级别以及日志打印策略
    * >> 默认使用了DefaultLoggingInterceptor执行真正的日志打印功能，其底层就是okhttp原生的HttpLoggingInterceptor
        * 自定义实现自己的日志打印拦截器，只需要继承BaseLoggingInterceptor（具体可以参考DefaultLoggingInterceptor的实现），然后在配置文件中进行相关配置即可。
    * >> Http异常信息格式化器, 美化输出http请求参数, 默认使用DefaultHttpExceptionMessageFormatter进行请求数据格式化
        * 自定义实现自己的异常信息格式化器, 继承BaseHttpExceptionMessageFormatter, 再进行相关配置即可
 * @Author : ZeKun Pan
 * @Date: 2023-01-13 10:51
 */
@RetrofitClient(baseUrl = "", poolName = "test1", logLevel = Level.DEBUG, logStrategy = BaseLoggingInterceptor.LogStrategy.BASIC)
@Sign(accessKeyId = "${si.key}", accessKeySecret = "${si.secret}")
public interface SecretServiceHttpApi {

    @GET("person")
    Call<RESTResponse> getPerson(@Query("id") Long id);

    @POST("savePerson")
    Call<RESTResponse> savePerson(@Body UserEntity userEntity);
}
