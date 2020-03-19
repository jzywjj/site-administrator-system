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
@ApiModel(description = "返回结果")
public class Res<T> {
	
	@ApiModelProperty(value = "响应数据" ,example="res")
	private T res;
	
	@ApiModelProperty(value = "状态码" ,example="200")
	private Integer statusCode=200;

	public Res(T res) {
		this.res = res;
	}
	
	
}
