package com.posin.portal.retrofit.interceptor;

import com.github.lianjiatech.retrofit.spring.boot.interceptor.BaseGlobalInterceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @ClassName : SourceInterceptor
 * @Description : SourceInterceptor
 * @Author : ZeKun Pan
 * @Date: 2023-01-13 14:27
 * 全局拦截器 BaseGlobalInterceptor
    * 如果我们需要对整个系统的的http请求执行统一的拦截处理，可以自定义实现全局拦截器BaseGlobalInterceptor,
    * 并配置成spring中的bean！例如我们需要在整个系统发起的http请求，都带上来源信息。
 */
@Component
public class SourceInterceptor extends BaseGlobalInterceptor {

    @Override
    protected Response doIntercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request newReq = request.newBuilder()
                .addHeader("source", "test")
                .build();
        return chain.proceed(newReq);
    }
}
