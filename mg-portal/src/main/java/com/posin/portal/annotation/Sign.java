package com.posin.portal.annotation;

import com.github.lianjiatech.retrofit.spring.boot.annotation.InterceptMark;
import com.github.lianjiatech.retrofit.spring.boot.interceptor.BasePathMatchInterceptor;
import com.posin.portal.interceptor.SignInterceptor;

import java.lang.annotation.*;

/**
 * @ClassName : Sign
 * @Description : Sign
 * 自定义拦截注解必须使用@InterceptMark标记，并且注解中必须包括include()、exclude()、handler()属性信息。使用的步骤主要分为3步：
    * 1. 自定义拦截注解
    * 2. 继承BasePathMatchInterceptor编写拦截处理器
    * 3. 接口上使用自定义拦截注解；
 * 使用范围：
    * 例如我们需要在请求头里面动态加入accessKeyId、accessKeySecret签名信息才能正常发起http请求，这个时候可以自定义一个加签拦截器注解@Sign来实现
 * 注意：
    * accessKeyId和accessKeySecret字段值会依据@Sign注解的accessKeyId()和accessKeySecret()值自动注入，如果@Sign指定的是占位符形式的字符串，则会取配置属性值进行注入。
    * 另外，accessKeyId和accessKeySecret字段必须提供setter方法。
 * @Author : ZeKun Pan
 * @Date: 2023-01-13 10:45
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@InterceptMark
public @interface Sign {
    /**
     * 密钥key
     * 支持占位符形式配置。
     *
     * @return
     */
    String accessKeyId();

    /**
     * 密钥
     * 支持占位符形式配置。
     *
     * @return
     */
    String accessKeySecret();

    /**
     * 拦截器匹配路径
     *
     * @return
     */
    String[] include() default {"/**"};

    /**
     * 拦截器排除匹配，排除指定路径拦截
     *
     * @return
     */
    String[] exclude() default {};

    /**
     * 处理该注解的拦截器类
     * 优先从spring容器获取对应的Bean，如果获取不到，则使用反射创建一个！
     *
     * @return
     */
    Class<? extends BasePathMatchInterceptor> handler() default SignInterceptor.class;
}
