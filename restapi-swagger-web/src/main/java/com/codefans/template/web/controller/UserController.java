package com.codefans.template.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author: ShengzhiCai
 * @date: 2018-10-16 17:29
 */

@RestController
@RequestMapping("/user")
@Validated
@Api(value = "USER", description = "测试UserController")
public class UserController {

    private static Logger logger = LogManager.getLogger(UserController.class.getName());


    @RequestMapping(value="",method={RequestMethod.GET })
    @ApiOperation(value = "查询个人信息接口",notes = "查询个人信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType="string", name = "token", value = "访问凭证", required = true),
    })

    public List<String> query(@RequestParam("page") int page,
                              @RequestParam("count") int count) {

        return new ArrayList<String>();
    }

    @RequestMapping(value="",method={RequestMethod.POST })
    @ApiOperation(value = "增加个人信息接口",notes = "增加个人信息接口")
    public void insert(@RequestAttribute("name") String name) {

        System.out.println("insert finish.");

    }
}
