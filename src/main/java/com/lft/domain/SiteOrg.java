package com.lft.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "组织机构对象")
public class SiteOrg {
	@ApiModelProperty(value = "组织机构Id" ,example="affsfg323rvxzv")
	private String orgId;
	
	@ApiModelProperty(value = "机构名" ,example="xx管理部",required =true)
	private String orgName;
	
	@ApiModelProperty(value = "组织机构上级Id" ,example="affsfg323rvxzv")
	private String pOrgId;
}
