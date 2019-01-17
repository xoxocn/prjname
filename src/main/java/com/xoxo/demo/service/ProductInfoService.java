package com.xoxo.demo.service;

import com.xoxo.demo.dto.ProductInfoDTO;

import java.util.List;

/**
 * @Package com.xoxo.demo.service
 * @Description
 * @Author xiehua@zhongshuheyi.com
 * @Date 2019-01-08 15:45
 */
public interface ProductInfoService {

    List<ProductInfoDTO> findProductInfos();

}
