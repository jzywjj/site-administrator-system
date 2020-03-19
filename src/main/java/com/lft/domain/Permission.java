package com.lft.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel(description = "权限对象")
public class Permission {
	
	@ApiModelProperty(value = "权限ID" ,example="a21314fsadscc")
	private String permissionId;
	
	@ApiModelProperty(value = "资源的url" ,example="/login/getXXX")
	private String url;
	
	@ApiModelProperty(value = "资源的类型 0-url 1-按钮，2-xx" ,example="1")
	private String resType;
	
	@ApiModelProperty(value = "资源名" ,example="添加用户")
	private String pname;
	
	@ApiModelProperty(value = "资源上级ID" ,example="a21314fsadscc")
	private String pId;
}
