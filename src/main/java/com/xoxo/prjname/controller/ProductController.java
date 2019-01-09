package com.xoxo.prjname.controller;

import com.xoxo.prjname.common.VO.ResultVO;
import com.xoxo.prjname.common.annotation.VerifySign;
import com.xoxo.prjname.dto.ProductInfoDTO;
import com.xoxo.prjname.service.ProductInfoService;
import com.xoxo.prjname.common.utils.ResultVOUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Package com.xoxo.prjname.controller
 * @Description
 * @Author xiehua@zhongshuheyi.com
 * @Date 2019-01-08 16:07
 */
@RestController
public class ProductController {

    @Resource
    private ProductInfoService productInfoService;


//    @VerifySign 验签注解（在需要验签的方法上放上此注解即可）
    @GetMapping(value = "findProductInfos")
    public ResultVO<List<ProductInfoDTO>> findProductInfos() {
        List<ProductInfoDTO> productInfoDTOS = productInfoService.findProductInfos();
        return ResultVOUtil.success(productInfoDTOS);
    }
}
