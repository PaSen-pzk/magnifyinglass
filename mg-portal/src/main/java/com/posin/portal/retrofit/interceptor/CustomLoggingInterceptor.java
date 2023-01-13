package com.posin.portal.retrofit.interceptor;

import com.github.lianjiatech.retrofit.spring.boot.interceptor.BaseLoggingInterceptor;
import com.github.lianjiatech.retrofit.spring.boot.interceptor.DefaultLoggingInterceptor;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

import java.io.IOException;

/**
 * @ClassName : CustomLoggongInterceptor
 * @Description : CustomLoggongInterceptor
 * @Author : ZeKun Pan
 * @Date: 2023-01-13 11:44
 * 通过@RetrofitClient的logLevel和logStrategy属性 指定每个接口的日志打印级别以及日志打印策略
     * logLevel: 支持5种日志打印级别(ERROR, WARN, INFO, DEBUG, TRACE)，默认INFO；
     * logStrategy: 支持4种日志打印策略（NONE, BASIC, HEADERS, BODY），默认BASIC;
     * 4种日志打印策略含义如下：
         * NONE：No logs.
         * BASIC：Logs request and response lines.
         * HEADERS：Logs request and response lines and their respective headers.
         * BODY：Logs request and response lines and their respective headers and bodies (if present).
 */
public class CustomLoggingInterceptor extends BaseLoggingInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(DefaultLoggingInterceptor.class);
    private final HttpLoggingInterceptor httpLoggingInterceptor;

    public CustomLoggingInterceptor(Level logLevel, LogStrategy logStrategy, HttpLoggingInterceptor httpLoggingInterceptor) {
        super(logLevel, logStrategy);
        okhttp3.logging.HttpLoggingInterceptor.Logger logger = this.httpLoggingInterceptorLogger(logLevel);
        this.httpLoggingInterceptor = new HttpLoggingInterceptor(logger);
        String name = logStrategy.name();
        okhttp3.logging.HttpLoggingInterceptor.Level level = okhttp3.logging.HttpLoggingInterceptor.Level.valueOf(name);
        this.httpLoggingInterceptor.setLevel(level);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        return this.httpLoggingInterceptor.intercept(chain);
    }

    public okhttp3.logging.HttpLoggingInterceptor.Logger httpLoggingInterceptorLogger(Level level) {
        Logger var10000;
        if (level == Level.DEBUG) {
            var10000 = logger;
            return var10000::debug;
        } else if (level == Level.ERROR) {
            var10000 = logger;
            return var10000::error;
        } else if (level == Level.INFO) {
            var10000 = logger;
            return var10000::info;
        } else if (level == Level.TRACE) {
            var10000 = logger;
            return var10000::trace;
        } else if (level == Level.WARN) {
            var10000 = logger;
            return var10000::warn;
        } else {
            throw new UnsupportedOperationException("We don't support this log level currently.");
        }
    }
}
