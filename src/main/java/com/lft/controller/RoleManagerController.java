package com.lft.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lft.domain.Role;
import com.lft.domain.Student;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiResponses({@ApiResponse(code=400,message="请求参数没填好"),
	 @ApiResponse(code=401,message="未授权不允许访问"),
	 @ApiResponse(code=403,message="禁止访问"),
   @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
})
@Api(value = "角色管理",tags = "角色管理")
@RestController
@RequestMapping("/role")
public class RoleManagerController {
	
	@ApiOperation(value = "根据角色名查询角色",notes = "根据角色名查询角色",responseContainer = "None",response = Role.class)
	@ApiImplicitParam(name = "roleName",value = "角色名",dataTypeClass = String.class,paramType ="query",required =true)
	@GetMapping("/findRoleByName/{roleName}")
	public Role findRoleByName(@PathVariable("roleName") String roleName) {
		
		return null;
	}
	
	
	@ApiOperation(value = "添加一个角色",notes = "添加一个角色",responseContainer = "None")
	@PostMapping("/addRole")
	public void addRole(@RequestBody Role role) {
		
	}
	
	@ApiOperation(value = "返回角色集合",notes = "返回角色集合",responseContainer = "List",response = Role.class)
	@GetMapping("/findAllRole")
	public List<Role> findAllRole(){
		
		return null;
	}
	
	@ApiOperation(value = "根据ID删除角色",notes = "根据ID删除角色")
	@ApiImplicitParam(name = "roleId",value = "角色ID",dataTypeClass = String.class,paramType ="query",required =true) 
	@GetMapping("/delRoleById/{roleId}")
	public void delRoleById(@PathVariable("roleId") String roleId) {
		
	}
}
