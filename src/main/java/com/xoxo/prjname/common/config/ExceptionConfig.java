package com.xoxo.prjname.common.config;


import com.xoxo.prjname.common.VO.ResultVO;
import com.xoxo.prjname.common.enums.ResponseEnum;
import com.xoxo.prjname.common.exception.BuizException;
import com.xoxo.prjname.common.exception.RespBaseException;
import com.xoxo.prjname.common.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Package com.learn.ssmmodules.config
 * @Description 统一异常捕获
 * @Author xiehua@zhongshuheyi.com
 * @Date 2018-11-28 16:28
 */
@RestControllerAdvice
@Slf4j
public class ExceptionConfig {

    @ExceptionHandler(value = Exception.class)
    public ResultVO exceptionHandle(Exception e) {
        log.warn("异常：{}",e.getMessage());
        return ResultVOUtil.exception(ResponseEnum.server_error);
    }

    @ExceptionHandler(value = RespBaseException.class)
    public ResultVO rspBaseHandle(RespBaseException e){
        log.warn("基础异常：{}",e.getMessage());
        return ResultVOUtil.exception(e);
    }

    @ExceptionHandler(value = BuizException.class)
    public ResultVO BuizHandle(BuizException e){
        log.warn("业务异常：{}",e.getMessage());
        return ResultVOUtil.exception(e);
    }
}
