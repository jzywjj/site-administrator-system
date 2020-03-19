package com.lft.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 数据响应对象
 *    {
 *      success ：是否成功
 *      code    ：返回码
 *      message ：返回信息
 *      //返回数据
 *      data：  ：{
 *
 *      }
 *    }
 */
@NoArgsConstructor
@Data
public class R<T> {
	@ApiModelProperty(value = "是否成功" ,example="true")
    private boolean success;//是否成功
	@ApiModelProperty(value = "返回码" ,example="200")
    private Integer code;// 返回码
	
	@ApiModelProperty(value = "返回信息" ,example="操作成功")
    private String message;//返回信息
	
	@ApiModelProperty(value = "返回结果" ,example="xxxx")
    private T data;// 返回数据

    public R(RCode code) {
        this.success = code.success;
        this.code = code.code;
        this.message = code.message;
    }

    public R(RCode code,T data) {
        this.success = code.success;
        this.code = code.code;
        this.message = code.message;
        this.data = data;
    }

    public R(Integer code,String message,boolean success) {
        this.code = code;
        this.message = message;
        this.success = success;
    }

    public static R SUCCESS(){
        return new R(RCode.SUCCESS);
    }

    public static R ERROR(){
        return new R(RCode.SERVER_ERROR);
    }

    public static R FAIL(){
        return new R(RCode.FAIL);
    }
}
