package com.lft.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@ApiResponses({@ApiResponse(code=400,message="请求参数没填好"),
	 @ApiResponse(code=401,message="未授权不允许访问"),
	 @ApiResponse(code=403,message="禁止访问"),
	 @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对"),
	 @ApiResponse(code=500,message="服务端出错请联系管理员")
})
@Api(value = "用户管理",tags = "用户管理")
@RestController
@RequestMapping("/sys")
public class UserController extends BaseController{
	
	
	
	
	public String getUserDetails(HttpServletRequest request) {
		String userid = claims.getId();
		return null;
	}
}
