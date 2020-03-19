package com.lft;

import java.util.Date;

import org.junit.jupiter.api.Test;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

class Jwt {

	@Test
	void test() {
		String jws = Jwts.builder().setId("888").setSubject("小白").setIssuedAt(new Date())// 设置签发时间
				.signWith(SignatureAlgorithm.HS256, "lft-dataCenter").compact();// 设置签名秘钥
		System.out.println(jws);
	}
	
	@Test
	public void parseJwt() {
		String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiLlsI_nmb0iLCJpYXQiOjE1ODM4MDk0MDh9.Ad22dCJuSY0NaqivnSPpemmEoqPdCKG0IYiD4QFgKKY";
		Claims claims = Jwts.parser().setSigningKey("lft-dataCenter").parseClaimsJws(token).getBody();
		System.out.println("id:" + claims.getId());
		System.out.println("subject:" + claims.getSubject());
		System.out.println("IssuedAt:" + claims.getIssuedAt());
	}
}
