package com.posin.portal.retrofit.interceptor;

import com.github.lianjiatech.retrofit.spring.boot.interceptor.BaseHttpExceptionMessageFormatter;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @ClassName : CustomHttpExceptionMessageFormatter
 * @Description : CustomHttpExceptionMessageFormatter
 * @Author : ZeKun Pan
 * @Date: 2023-01-13 13:51
 */
public class CustomHttpExceptionMessageFormatter extends BaseHttpExceptionMessageFormatter {
    public CustomHttpExceptionMessageFormatter() {
    }

    @Override
    public String alarmFormat(Request request, Response response) {
        StringBuilder builder = new StringBuilder("HTTP execute fail！");
        if (request != null) {
            builder.append(request.toString());
        }
        if (response != null) {
            builder.append("; ").append(response.toString());
        }
        return builder.toString();
    }
}
