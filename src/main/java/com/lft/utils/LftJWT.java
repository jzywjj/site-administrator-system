package com.lft.utils;

import java.util.Date;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;

@Data
@ConfigurationProperties("lft.jwt.config")

public class LftJWT {
	
	private String key;
	
	private Long ttl;
	
	public String generateJwt(String id,String name,Map<String ,Object> param) {
		long now=System.currentTimeMillis();
		long exp=now+ttl;
		JwtBuilder jwtBuilder = Jwts.builder().setId(id).setSubject(name)
		.setIssuedAt(new Date())// 设置签发时间
				.signWith(SignatureAlgorithm.HS256, key)
				.setExpiration(new Date(exp));//设置失效时间
				param.forEach((k,v)->{
					jwtBuilder.claim(k, v);
				});
		String token = jwtBuilder.compact();// 设置签名秘钥
		
		return token;
	}
	
	public Claims parserJwt(String token) {
		Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
		return claims;
	}
}
