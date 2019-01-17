package com.xoxo.demo.controller;

import com.xoxo.demo.common.VO.ResultVO;
import com.xoxo.demo.dto.ProductInfoDTO;
import com.xoxo.demo.service.ProductInfoService;
import com.xoxo.demo.common.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Package com.xoxo.demo.controller
 * @Description
 * @Author xiehua@zhongshuheyi.com
 * @Date 2019-01-08 16:07
 */
@Slf4j
@RestController
public class ProductController {

    @Resource
    private ProductInfoService productInfoService;


//    @VerifySign 验签注解（在需要验签的方法上放上此注解即可）
    @GetMapping(value = "findProductInfos")
    public ResultVO<List<ProductInfoDTO>> findProductInfos() {
        log.info("findProductInfos ------start");
        List<ProductInfoDTO> productInfoDTOS = productInfoService.findProductInfos();
        log.info("findProductInfos ------end");
        return ResultVOUtil.success(productInfoDTOS);
    }
}
