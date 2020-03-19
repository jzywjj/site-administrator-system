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
@ApiModel(description = "学生实体")
public class Student {
	
	@ApiModelProperty(value = "学生姓名" ,example="张三",required =true)
	private String name;
	
	@ApiModelProperty(value = "学生年龄" ,example="10",required =true)
	private Integer age;
	
	@ApiModelProperty(value = "销售额" ,example="18.5",required =true)
	private Double sale;
}
