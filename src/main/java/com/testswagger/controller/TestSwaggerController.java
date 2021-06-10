package com.testswagger.controller;

import com.testswagger.domain.Student;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;

/**
 * @Author zhangdj
 * @Date 2021/5/10:15:47
 * @Description:
 */
@Api(tags = "说明该类的作用，可以在UI界面上看到的注解", value = "API - VehiclesController:该参数没什么意义，在UI界面上也看到", description = "车辆模块接口详情")
@RestController
@RequestMapping("/vehicles")
public class TestSwaggerController {
    private static Logger logger = LoggerFactory.getLogger(TestSwaggerController.class);


    @ApiOperation(value = "查询车辆接口", notes = "此接口描述xxxxxxxxxxxxx<br/>xxxxxxx<br>值得庆幸的是这儿支持html标签<hr/>", response = String.class)
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
    @RequestMapping(value = "", method = RequestMethod.GET)
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


    @ApiOperation(value = "根据车牌查询车辆", notes = "这种类型的查询是精确查询,其结果只有一条数据", response = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "vno", value = "车牌", required = false,
                    dataType = "string", paramType = "path", defaultValue = "辽A12345")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful — 请求已完成"),
            @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
            @ApiResponse(code = 401, message = "未授权客户机访问数据"),
            @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
            @ApiResponse(code = 500, message = "服务器不能完成请求")}
    )
    @ResponseBody
    @RequestMapping(value = "vno={vno}", method = RequestMethod.GET)
    public ModelMap getVno(@PathVariable(value = "vno") String vno)
            throws Exception {

        logger.info("http://localhost:8501/api/v1/vehicles/vno={}", vno);
        logger.info("## 请求时间：{}", new Date());

        ModelMap map = new ModelMap();
        map.addAttribute("vno", vno);

        return map;
    }

    @ApiOperation(value = "车辆位置查询接口", notes = "根据车牌查询车辆位置信息", response = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "vno", value = "车牌", required = false,
                    dataType = "string", paramType = "path", defaultValue = "辽A12345")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful — 请求已完成"),
            @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
            @ApiResponse(code = 401, message = "未授权客户机访问数据"),
            @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
            @ApiResponse(code = 500, message = "服务器不能完成请求")}
    )
    @ResponseBody
    @RequestMapping(value = "vno={vno}/location", method = RequestMethod.GET)
    public ModelMap getLocation(@PathVariable(value = "vno") String vno)
            throws Exception {
        logger.info("getLocation");
        logger.info("## 请求时间：{}", new Date());

        ModelMap map = new ModelMap();
        map.addAttribute("vno", vno);

        return map;
    }


    @ApiOperation(value = "根据车辆id查询", notes = "精确查询,最常规的方式,支持POST和GET方式", response = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = false,
                    dataType = "string", paramType = "path", defaultValue = "12344444")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful — 请求已完成"),
            @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
            @ApiResponse(code = 401, message = "未授权客户机访问数据"),
            @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
            @ApiResponse(code = 500, message = "服务器不能完成请求")}
    )
    @ResponseBody
    @RequestMapping(value = "{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelMap getById(@PathVariable(value = "id") String id)
            throws Exception {

        System.out.println("根据车辆id查询");
        logger.info("http://localhost:8501/api/v1/vehicles/{}", id);
        logger.info("## 请求时间：{}", new Date());

        ModelMap map = new ModelMap();
        map.addAttribute("{RequestMethod.GET,RequestMethod.POST}", id);

        return map;
    }

    @ApiOperation(value = "根据车辆id查询", notes = "精确查询,最常规的方式,支持POST和GET方式", response = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = false,
                    dataType = "string", paramType = "path", defaultValue = "12344444")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful — 请求已完成"),
            @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
            @ApiResponse(code = 403, message = "服务器拒绝请求"),
            @ApiResponse(code = 401, message = "未授权客户机访问数据"),
            @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
            @ApiResponse(code = 500, message = "服务器不能完成请求")}
    )
    @ResponseBody
    @RequestMapping(value = "{id}", method = {RequestMethod.DELETE})
    public ModelMap delById(@PathVariable(value = "id") String id)
            throws Exception {

        logger.info("http://localhost:8501/api/v1/vehicles/{}", id);
        logger.info("## 请求时间：{}", new Date());

        ModelMap map = new ModelMap();
        map.addAttribute("RequestMethod.DELETE", id);
        return map;
    }

    @ApiOperation(value = "根据ID查找相关信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true,
                    dataType = "string", paramType = "path", defaultValue = "12344444")
    })
    @GetMapping("/findByID")
    public ModelMap findById(String id)
            throws Exception {

        System.out.println("根据ID找到了相关的信息");
        ModelMap map = new ModelMap();
        map.addAttribute("RequestMethod.DELETE", id);
        return map;
    }

    @ApiOperation(value = "编辑公告", notes = "编辑公告", httpMethod = "POST")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(
            @ApiParam(name = "title", value = "公告标题", required = true) @RequestParam("title") String title,
            @ApiParam(name = "content", value = "公告内容", required = true) @RequestParam("content") String content) {
        return null;
    }

    @ApiOperation(value = "学生VO参数接收", notes = "学生VO参数接收", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "student", value = "student", required = true,
                    dataType = "Student", paramType = "query")
    })
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String student(@RequestBody Student student) {
        return null;
    }
}