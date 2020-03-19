package com.lft.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "用户对象")
public class User {
	
	@ApiModelProperty(value = "用户id" ,example="a21314fsadscc")
	private String id;//用户id
	
	@ApiModelProperty(value = "11位数电话号码" ,example="13823444413",required =true)
	private String tel;//用户电话号码
	
	@ApiModelProperty(value = "用户性别 0-男，1-女" ,example="013823444413")
	private String sex;//用户性别
	
	@ApiModelProperty(value = "11位数电话号码" ,example="13823444413",required =true)
	private String userName;//用户中文名  examp 张三
	
	@ApiModelProperty(value = "身份证号" ,example="423333xxxx")
	private String iDNumber;//身份证号
	
	@ApiModelProperty(value = "登录账号" ,example="zhangsan")
	private String logName;//登录账号 exam zhangsan
	
	@ApiModelProperty(value = "登录密码" ,example="xxxxxx")
	private String password;
	
	@ApiModelProperty(value = "用户类型 0-一般用户，1-管理员用户" ,example="1")
	private String userType;//用户类型
	
}
