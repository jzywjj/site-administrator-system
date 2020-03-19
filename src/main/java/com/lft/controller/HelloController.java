package com.lft.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.lft.domain.Student;
import com.lft.domain.UserAb;
import com.lft.mapper.UserAbMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiResponses({@ApiResponse(code=400,message="请求参数没填好"),
	 @ApiResponse(code=401,message="未授权不允许访问"),
	 @ApiResponse(code=403,message="禁止访问"),
    @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
})
@Api(value = "信息管理",tags = "学生信息管理")
@RestController
public class HelloController {
	
	@Autowired
	private DefaultKaptcha captchaProducer;
	 
	@ApiOperation(value = "查询一个学生",notes = "查询一个学生",responseContainer = "None",response = Student.class)
	@GetMapping(value = "/hi",name = "lft_add_student")
	public Student getOneStudent() {
		
		 return new Student("hh", 10, 12.5);
	}
	 
	 
	 @ApiOperation(value = "返回学生集合",notes = "根据条件返回学生集合",responseContainer = "List",response = Student.class)
	 @PostMapping("/his")
	 public List<Student> getSomeStudent(@RequestBody Student student) {
			
		 return Arrays.asList(new Student("hh", 10, 12.5));
	} 
	 
	 @GetMapping("/hisvoid")
	public void SS() {
		System.out.println("sss");
	}
	 
	 @Autowired
	 private UserAbMapper userAbMapper;
	 @GetMapping("/findUserAbById")
	 public   PageInfo<UserAb> findUserAbById(@RequestParam("id") String id) {
		 Page<UserAb> startPage = PageHelper.startPage(0, 10);
		 String name="dd";
		 UserAb ab=new UserAb();
		 ab.setUserName(name);
		 List<UserAb> selectAll = userAbMapper.selectAll("jjj",ab);
		 //UserAb userAb = userAbMapper.selectByPrimaryKey(id);
		 PageInfo<UserAb> page = new PageInfo<UserAb>(selectAll);
		 return page;
	 }
	 
	 @GetMapping("/sss")
	 public void SvaeUserAb() {
		 String name="dd";
		 UserAb ab=new UserAb();
		 ab.setUserName(name);
		 ab.setId("jjj");
		 userAbMapper.insert(ab);
	 }
	 
	 
	 @ApiOperation(value = "验证码接口",notes = "获取验证码",responseContainer = "none")
	 @GetMapping("/defaultKaptcha")
	 public void defaultKaptcha(HttpServletResponse response,HttpSession session) {
	     response.setDateHeader("Expires", 0);
	     response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
	     response.addHeader("Cache-Control", "post-check=0, pre-check=0");
	     response.setHeader("Pragma", "no-cache");
	     response.setContentType("image/jpeg");
	     String capText = captchaProducer.createText();
	     System.out.println(capText);
	     //将验证码存到session
	     session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
	     BufferedImage bi = captchaProducer.createImage(capText);
	     try {
	         ServletOutputStream out = response.getOutputStream();
	         ImageIO.write(bi, "jpg", out);
	         out.flush();
	         out.close();
	     } catch (IOException e) {
	         e.printStackTrace();
	     }
	 }
	 
	
}
