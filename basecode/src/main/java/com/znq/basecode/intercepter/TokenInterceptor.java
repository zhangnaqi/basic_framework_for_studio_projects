package com.znq.basecode.intercepter;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.znq.basecode.annotation.Token;
import com.znq.basecode.utils.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TokenInterceptor implements HandlerInterceptor {

    /**
     * 请求头
     */
    private static final String HEADER_AUTH = "token";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        response.setContentType("application/json; charset=utf-8");
        // 需要令牌
        Token annotation;
        if (handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(Token.class);
        } else {
            return true;
        }
        // 没有声明需要权限或声明不需要权限
        if (annotation == null || !annotation.validate()) {
            return true;
        }

        // 从请求头中读取token
        String token = request.getHeader(HEADER_AUTH);
        if (token == null) {
            log.info("请求失败, 令牌为空");
            throw new RuntimeException("请求失败, 令牌为空");
        }

        // 解析令牌
        Map<String, Object> map = JwtUtil.resolveToken(token);
        return true;

    }
}
