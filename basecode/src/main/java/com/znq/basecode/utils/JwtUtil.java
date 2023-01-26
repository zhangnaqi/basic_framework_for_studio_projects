package com.znq.basecode.utils;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.Map;

public class JwtUtil {

    /**
     * 密码
     */
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    /**
     * 令牌前缀
     */
    private static final String TOKEN_PREFIX = "helpage";

    /**
     * 令牌过期时间
     */
    private static final Integer EXPIRE_SECONDS = 2 * 60 * 60 * 1000;

    /**
     * 生成令牌
     */
    public static String generateToken(Map<String, Object> map, Integer userId) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_SECONDS);
        String jwt = Jwts.builder()
                .setClaims(map)
                .setExpiration(date)
                .setSubject(userId.toString())
                .signWith(key)
                .compact();
        return TOKEN_PREFIX + "_" + jwt;
    }

    /**
     * 验证令牌
     */
    public static Map<String, Object> resolveToken(String token) {
        if (token == null) {
            throw new RuntimeException("令牌为空");
        }
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token.replaceFirst(TOKEN_PREFIX + "_", ""))
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw new RuntimeException("令牌已过期");
        } catch (Exception e) {
            throw new RuntimeException("令牌解析异常");
        }
    }

}
