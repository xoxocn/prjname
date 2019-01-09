package com.xoxo.prjname.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.xoxo.prjname.common.constants.RedisConstant;
import com.xoxo.prjname.common.enums.ExceptionEnum;
import com.xoxo.prjname.common.exception.BuizException;
import com.xoxo.prjname.dto.ProductInfoDTO;
import com.xoxo.prjname.entity.ProductInfo;
import com.xoxo.prjname.mapper.generic.ProductInfoMapper;
import com.xoxo.prjname.redis.IRedisService;
import com.xoxo.prjname.service.ProductInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Package com.xoxo.prjname.service.impl
 * @Description
 * @Author xiehua@zhongshuheyi.com
 * @Date 2019-01-08 15:45
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Resource
    private ProductInfoMapper productInfoMapper;
    @Resource
    private IRedisService redisService;

    @Override
    public List<ProductInfoDTO> findProductInfos() {
        String productInfoListStr;
        List<ProductInfoDTO> productInfoDTOS;
        List<ProductInfo> productInfos;
//        异常捕获测试
//        if("".equals("")){
//            throw new BuizException(ExceptionEnum.buiz_ex001);
//        }
        //redis有就取出，没有就去数据库查询
        if (StringUtils.isEmpty((productInfoListStr = redisService.get(RedisConstant.Product.PRODUCT_INFOS)))) {
            productInfos = productInfoMapper.selectByExample(null);
            //存入redis
            redisService.set(RedisConstant.Product.PRODUCT_INFOS, JSONArray.toJSONString(productInfos));
        } else {
            productInfos = JSONArray.parseArray(productInfoListStr, ProductInfo.class);
        }
        //数据转换，entity->dto
        productInfoDTOS = productInfos.stream().
                map(e->{
                    ProductInfoDTO productInfoDTO = new ProductInfoDTO();
                    BeanUtils.copyProperties(e,productInfoDTO);
                    return productInfoDTO;
                }).collect(Collectors.toList());

        return productInfoDTOS;
    }
}
