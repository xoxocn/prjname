package com.xoxo.prjname.service;

import com.xoxo.prjname.dto.ProductInfoDTO;

import java.util.List;

/**
 * @Package com.xoxo.prjname.service
 * @Description
 * @Author xiehua@zhongshuheyi.com
 * @Date 2019-01-08 15:45
 */
public interface ProductInfoService {

    List<ProductInfoDTO> findProductInfos();

}
