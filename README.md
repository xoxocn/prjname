## spring-boot-demo

自用SpringBoot框架

1. 日志模块介绍

   1.1 日志目录结构

      ​	${LOG_PATH}/info.log

      			 	/debug.log

      			 	/error.log

      			 	/warn.log

   1.2 代码配置

   ​	com.xoxo.demo.common.config.ExceptionConfig：全局异常拦截器

   ​	com.xoxo.demo.common.enums：各种枚举配置

   ​	com.xoxo.demo.common.exception.CommonException：基础异常类，所有自定义异常类必须继承它

   1.3 日志模块使用：

   ​	以前代码捕获异常需要try catch捕获，现在都交给全局异常拦截器进行捕获，如需详细配置，可以前往

   com.xoxo.demo.common.config.ExceptionConfig进行配置。

   ​	例子：

   ```
   /**
    * 所有日志打印使用@Slf4j注解即可
    */
   @Slf4j
   @Service
   public class ProductInfoServiceImpl implements ProductInfoService {
   
       @Resource
       private ProductInfoMapper productInfoMapper;
       @Resource
       private IRedisService redisService;
   
       @Override
       public List<ProductInfoDTO> findProductInfos() {
           log.info("findProductInfos ------start");
           String productInfoListStr;
           List<ProductInfoDTO> productInfoDTOS;
           List<ProductInfo> productInfos;
           // 异常捕获测试，直接抛出异常即可
           if("".equals("")){
               throw new BuizException(ExceptionEnum.buiz_ex001);
           }
           log.info("findProductInfos ------end");
       }
   ```

   

   2.其他模块......

