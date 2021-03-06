package com.codefans.template.web.controller;

import com.codefans.template.common.data.Code;
import com.codefans.template.common.data.Message;
import com.codefans.template.common.data.Messages;
import com.codefans.template.common.util.ValidateUtil;
import com.google.common.base.Throwables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: codefans
 * @Date: 2018-07-08 0:58
 */
@RestController
@RequestMapping("template")
public class TemplateController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemplateController.class);

    @RequestMapping(method= RequestMethod.POST, value="/callback/{version}/{appkey}")
    @ResponseBody
    public Message<String> callback(
            @PathVariable(value = "version") String version,
            @PathVariable(value = "appkey") String appkey,
            @RequestParam(value = "xmlParam") String xmlParam) {

        Message<String> message = null;
        try {
            if (!ValidateUtil.isNotEmpty(version,appkey,xmlParam)) {
                LOGGER.error("参数校验失败version={},appkey={},xmlParam={}", version, appkey, xmlParam);
                return Messages.failed(Code.PARAMATERSISNULL.getValue(), "参数校验失败");
            }

            return message;
        } catch (Exception e) {
            LOGGER.info("回调系统异常.异常信息：{}", Throwables.getStackTraceAsString(e));
            return Messages.failed(Code.SYSTEMEXCEPTION.getValue(), "回调系统异常");
        }
    }

    @RequestMapping(method= RequestMethod.GET, value="/restController")
    public void restController() {

        Message<String> message = null;
        try {

            LOGGER.info("restController...........");

        } catch (Exception e) {
            LOGGER.info("回调系统异常.异常信息：{}", Throwables.getStackTraceAsString(e));
        }
    }

}
