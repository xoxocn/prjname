package com.xoxo.prjname.common.config.Interceptor;

import com.xoxo.prjname.common.annotation.VerifySign;
import com.xoxo.prjname.common.enums.ResponseEnum;
import com.xoxo.prjname.common.exception.RespBaseException;
import com.xoxo.prjname.common.utils.VerifySignUtil;
import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Package com.learn.ssmmodules.config.bean.Interceptor
 * @Description 验签拦截器
 * @Author xiehua@zhongshuheyi.com
 * @Date 2018-11-09 17:15
 */
public class VerifySignInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!verifySignMethod(handler, request)) {
            throw new RespBaseException(ResponseEnum.sign_fail);
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }

    private boolean verifySignMethod(Object handler, HttpServletRequest request) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            //获取方法上的注解
            VerifySign verifySign = handlerMethod.getMethod().getAnnotation(VerifySign.class);
            //如果方法上的注解为空 则获取类的注解
            if (verifySign == null) {
                verifySign = handlerMethod.getMethod().getDeclaringClass().getAnnotation(VerifySign.class);
            }
            if (verifySign != null) {
                if (VerifySignUtil.md5Verify(request)) {
                    return true;
                }
                return false;
            }
        }
        return true;
    }
}
