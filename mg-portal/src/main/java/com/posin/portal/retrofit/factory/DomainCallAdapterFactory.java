package com.posin.portal.retrofit.factory;

import com.github.lianjiatech.retrofit.spring.boot.exception.RetrofitExecuteIOException;
import com.posin.common.response.model.RESTResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.CallAdapter.Factory;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @ClassName : DomainCallAdapterFactory
 * @Description : DomainCallAdapterFactory
 * @Author : ZeKun Pan
 * @Date: 2023-01-13 14:01
 * BodyCallAdapterFactory
 *
 * 默认启用，可通过配置retrofit.enable-div-call-adapter=false关闭
 * 同步执行http请求，将响应体内容适配成接口方法的返回值类型实例。
 * 除了Retrofit.Call<T>、Retrofit.Response<T>、java.util.concurrent.CompletableFuture<T>之外，其它返回类型都可以使用该适配器。
 * ResponseCallAdapterFactory
 *
 * 默认启用，可通过配置retrofit.enable-response-call-adapter=false关闭
 * 同步执行http请求，将响应体内容适配成Retrofit.Response<T>返回。
 * 如果方法的返回值类型为Retrofit.Response<T>，则可以使用该适配器。
 * Retrofit自动根据方法返回值类型选用对应的CallAdapterFactory执行适配处理！加上Retrofit默认的CallAdapterFactory，可支持多种形式的方法返回值类型：
 *
 * Call<T>: 不执行适配处理，直接返回Call<T>对象
 * CompletableFuture<T>: 将响应体内容适配成CompletableFuture<T>对象返回
 * Void: 不关注返回类型可以使用Void。如果http状态码不是2xx，直接抛错！
 * Response<T>: 将响应内容适配成Response<T>对象返回
 * 其他任意Java类型：将响应体内容适配成一个对应的Java类型对象返回，如果http状态码不是2xx，直接抛错！
 */
@Component
public final class DomainCallAdapterFactory extends Factory {
    public DomainCallAdapterFactory() {
    }

    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        return RESTResponse.class.isAssignableFrom(getRawType(returnType)) ? new DomainCallAdapterFactory.DomainCallAdapter(returnType) : null;
    }

    final class DomainCallAdapter<R> implements CallAdapter<R, RESTResponse<R>> {

        private Type returnType;

        DomainCallAdapter(Type returnType) {
            this.returnType = returnType;
        }

        @Override
        public Type responseType() {
            ParameterizedType parameterizedType = (ParameterizedType)this.returnType;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Assert.notEmpty(actualTypeArguments, "RESTResponse必须指定泛型参数！");
            return actualTypeArguments[0];
        }

        @Override
        public RESTResponse<R> adapt(Call<R> call) {
            RESTResponse<R> restResponse = new RESTResponse<>();
            Response response;
            try {
                response = call.execute();
                restResponse.setCode(response.isSuccessful()?"00":"01");
                restResponse.setMessage(response.message());
                restResponse.setData((R)response.body());
            } catch (IOException var3) {
                throw new RetrofitExecuteIOException(var3);
            }
            return restResponse;
        }
    }
}
