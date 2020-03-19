package com.lft.controller;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lft.common.R;
import com.lft.common.RCode;
import com.lft.utils.LftJWT;
import com.lft.utils.LftUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiResponses({@ApiResponse(code=400,message="请求参数没填好"),
	 @ApiResponse(code=401,message="未授权不允许访问"),
	 @ApiResponse(code=403,message="禁止访问"),
	 @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对"),
	 @ApiResponse(code=500,message="服务端出错请联系管理员")
})
@Api(value = "登录管理",tags = "登录管理")
@RestController
@RequestMapping("/login")
public class LoginController{
	
	@Autowired
	private LftJWT lftJWT;
	
	@Autowired
	private StringRedisTemplate  stringRedisTemplate;
	
	
	
	@ApiOperation(value = "手机号登录",notes = "手机号登录")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "phoneNum",value = "电话号码",dataTypeClass = String.class,paramType ="query",required =true),
			@ApiImplicitParam(name = "verificationCode",value = "短信验证码",dataTypeClass = String.class,paramType ="query",required =true)
	})
	@PostMapping("/loginWithVerificationCode")
	public R LoginWithVerificationCode(@RequestParam("phoneNum")String phoneNum,@RequestParam("verificationCode")String verificationCode) {
		
		String rCode = stringRedisTemplate.opsForValue().get(phoneNum);
		if(rCode==null||!rCode.equals(verificationCode)) {
			return new R(RCode.MOBILEORPASSWORDERROR);
		}else {
			//查询用户权限标识码，放在token
			//将用户id,用户名 ，机构id,机构名放在token中
			Map<String,Object>param=new HashMap<>();
			String token = lftJWT.generateJwt("userId", "userName", param);
			return new R(RCode.SUCCESS,token);
		}
		
	}
	
	@ApiOperation(value = "手机号密码登录",notes = "手机号密码登录")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "phoneNum",value = "手机号",dataTypeClass = String.class,paramType ="query",required =true),
			@ApiImplicitParam(name = "pwd",value = "密码",dataTypeClass = String.class,paramType ="query",required =true)
	})
	@PostMapping("/loginWithPhoneNumAndPassWord")
	public String LoginWithPhoneNumAndPassWord(@RequestParam("phoneNum")String phoneNum,@RequestParam("pwd")String pwd) {
		
		return null;
	}
	

	@ApiOperation(value = "发送验证码",notes = "发送验证码")
	@ApiImplicitParam(name = "phoneNum",value = "电话号码",dataTypeClass = String.class,paramType ="path",required =true)
	@GetMapping("/sendVerificationCode/{phoneNum}")
	public R sendVerificationCode(@PathVariable("phoneNum")String phoneNum) {
		
		String verificationCode = LftUtils.generateVerificationCode();
		//调用短信发送接口
		try {
			LftUtils.sendSms(phoneNum, verificationCode);
			stringRedisTemplate.opsForValue().set(phoneNum, verificationCode, Duration.ofMinutes(5L));
		} catch (Exception e) {
			e.printStackTrace();
			return R.ERROR();
		}
		return  R.SUCCESS();
		
	}
	
}
