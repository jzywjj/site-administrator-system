package com.lft.vo;

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
@ApiModel(description = "请求验证码返回结果")
public class SmsRes {
	
	@ApiModelProperty(value = "发送回执ID" ,example="3252333333")
	private String BizId;//发送回执ID，可根据该ID在接口QuerySendDetails中查询具体的发送状态。
	
	@ApiModelProperty(value = "请求状态码" ,example="OK")
	private String Code;//请求状态码。返回OK代表请求成功。
	
	@ApiModelProperty(value = "状态码的描述" ,example="OK")
	private String Message	;//状态码的描述。
	
	@ApiModelProperty(value = "请求ID" ,example="23465364")
	private String RequestId;//请求ID	
}
