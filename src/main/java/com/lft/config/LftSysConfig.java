package com.lft.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lft.utils.LftJWT;
/**
 * 统一的bean配置
 * @author Mr-King
 *
 */
@Configuration
public class LftSysConfig {
	
	@Bean
	public LftJWT lftJWT() {
		
		return new LftJWT();
	}
}
