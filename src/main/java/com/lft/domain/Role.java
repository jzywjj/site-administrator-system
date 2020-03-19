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
@ApiModel(description = "角色对象")
public class Role {
	@ApiModelProperty(value = "角色id" ,example="235434w2543")
	private String roleId;
	
	@ApiModelProperty(value = "角色名" ,example="管理员",required =true)
	private String roleName;
}
