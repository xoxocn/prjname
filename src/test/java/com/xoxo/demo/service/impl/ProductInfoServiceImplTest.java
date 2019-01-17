package com.xoxo.demo.service.impl;

import com.xoxo.demo.DemoApplicationTests;
import com.xoxo.demo.dto.ProductInfoDTO;
import com.xoxo.demo.service.ProductInfoService;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.List;

/**
 * @Package com.xoxo.demo.service.impl
 * @Description
 * @Author xiehua@zhongshuheyi.com
 * @Date 2019-01-09 16:58
 */
public class ProductInfoServiceImplTest extends DemoApplicationTests {

    @Resource
    private ProductInfoService productInfoService;

    @Test
    public void findProductInfos() throws Exception {
        List<ProductInfoDTO> productInfos = productInfoService.findProductInfos();
        Assert.assertTrue(productInfos.size()==3);
        System.out.println(Arrays.toString(productInfos.toArray()));
    }

}