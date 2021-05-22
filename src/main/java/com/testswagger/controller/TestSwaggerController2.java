package com.testswagger.controller;

import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Author zhangdj
 * @Date 2021/5/10:16:01
 * @Description:
 */
@Api(value = "swagger 测试类2", description = "测试类2接口api")
@RestController
@RequestMapping("/test2")
public class TestSwaggerController2 {
    private static Logger logger = LoggerFactory.getLogger(TestSwaggerController.class);


    @ApiOperation(value = "查询测试2接口", notes = "接口描述信息", response = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "vno", value = "车牌", required = false,
                    dataType = "string", paramType = "query", defaultValue = "辽A12345"),
            @ApiImplicitParam(name = "page", value = "page", required = false,
                    dataType = "Integer", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "count", value = "count", required = false,
                    dataType = "Integer", paramType = "query", defaultValue = "10")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful — 请求已完成"),
            @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
            @ApiResponse(code = 401, message = "未授权客户机访问数据"),
            @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
            @ApiResponse(code = 500, message = "服务器不能完成请求")}
    )
    @ResponseBody
    @RequestMapping(value = "asd")
    public ModelMap findVehicles(@RequestParam(value = "vno", required = false) String vno,
                                 @RequestParam(value = "page", required = false) Integer page,
                                 @RequestParam(value = "count", required = false) Integer count)
            throws Exception {

        logger.info("http://localhost:8501/api/v1/vehicles");
        logger.info("## {},{},{}", vno, page, count);
        logger.info("## 请求时间：{}", new Date());

        ModelMap map = new ModelMap();
        map.addAttribute("vno", vno);
        map.addAttribute("page", page);
        return map;
    }
}