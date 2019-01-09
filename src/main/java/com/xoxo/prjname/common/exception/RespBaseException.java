package com.xoxo.prjname.common.exception;

import com.xoxo.prjname.common.enums.ExceptionEnum;
import com.xoxo.prjname.common.enums.ResponseEnum;

/**
 * @Package com.learn.ssmmodules.common.exception
 * @Description 业务异常类
 * @Author xiehua@zhongshuheyi.com
 * @Date 2018-11-28 17:25
 */

public class RespBaseException extends CommonException{

    public RespBaseException(String code, String msg){
        super(code,msg);
}

    public RespBaseException(ResponseEnum responseEnum){
        super(responseEnum.getCode(),responseEnum.getMsg());
    }

}
