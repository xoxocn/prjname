package com.xoxo.prjname.service.impl;

import com.xoxo.prjname.PrjnameApplicationTests;
import com.xoxo.prjname.dto.ProductInfoDTO;
import com.xoxo.prjname.service.ProductInfoService;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Package com.xoxo.prjname.service.impl
 * @Description
 * @Author xiehua@zhongshuheyi.com
 * @Date 2019-01-09 16:58
 */
public class ProductInfoServiceImplTest extends PrjnameApplicationTests {

    @Resource
    private ProductInfoService productInfoService;

    @Test
    public void findProductInfos() throws Exception {
        List<ProductInfoDTO> productInfos = productInfoService.findProductInfos();
        Assert.assertTrue(productInfos.size()==3);
        System.out.println(Arrays.toString(productInfos.toArray()));
    }

}