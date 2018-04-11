package com.abc.edu.cn.community.controller;

import com.abc.edu.cn.community.entity.*;
import com.abc.edu.cn.community.service.IDiscoverService;
import com.abc.edu.cn.community.service.IMemberService;
import com.abc.edu.cn.community.util.IOUtil;
import com.abc.edu.cn.community.util.Json.ClientResponseJSONBean;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: zhanglei
 * @ Description:
 * @Date: Create in 2018-04-09 23:55
 */
@RestController
@RequestMapping("/api")
public class ApiController {
    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);
    @Autowired
    IMemberService memberService;
    @Autowired
    IDiscoverService discoverService;

    /**
     * 用户登录接口
     *
     * @param loginName 手机号
     * @param password  登录密码
     * @return
     */
    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation("用户登录接口")
    public String getMember(String loginName, String password) {
        logger.info("用户登录:--->" + loginName);

        ClientResponseJSONBean clientResponseJSONBean = null;
        MemberDTO member = null;

        try {

            member = memberService.login(loginName, password);
            clientResponseJSONBean = ClientResponseJSONBean.getSuccessClientResponseJSONBean();
            clientResponseJSONBean.setData(member);

        } catch (Exception e) {

            clientResponseJSONBean = ClientResponseJSONBean.getFailedClientResponseJSONBean();
            clientResponseJSONBean.setMsg(e.getMessage());
            logger.error("用户：--->" + loginName + "登录失败！失败原因:--->" + e.getMessage());
        }

        return clientResponseJSONBean.toJSONString();
    }

    /**
     * 发现列表
     *
     * @param currentPage 当前页数
     * @param size        期望查询总数
     * @return
     */
    @RequestMapping(value = "/discover/list", method = {RequestMethod.POST, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("获取发现列表的接口")
    public String getDiscoverList(int currentPage, int size) {
        ClientResponseJSONBean clientResponseJSONBean = null;
        clientResponseJSONBean = ClientResponseJSONBean.getSuccessClientResponseJSONBean();
        try {

            List<DiscoveryDTO> list = discoverService.list(currentPage, size);
            clientResponseJSONBean.setData(list);
            logger.info("查询的发现列表信息为：" + list.toString());

        } catch (Exception e) {

            logger.error("查询发现列表失败：" + e.getMessage());
            clientResponseJSONBean = ClientResponseJSONBean.getFailedClientResponseJSONBean();
            clientResponseJSONBean.setMsg("查询出现异常" + e.getCause());
            clientResponseJSONBean.setData(new ArrayList<>());
            e.printStackTrace();

        }

        return clientResponseJSONBean.toJSONString();
    }

    /**
     * 发布接口
     *
     * @param publish
     * @return
     */
    @RequestMapping(value = "/publish", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("发布接口")
    public String publish(PublishVO publish) {
        logger.info("发布的信息：" + publish.toString());
        ClientResponseJSONBean clientResponseJSONBean = null;
        clientResponseJSONBean = ClientResponseJSONBean.getSuccessClientResponseJSONBean();

        try {

            int insert = discoverService.insert(publish);
            if (insert != 1) {
                clientResponseJSONBean = ClientResponseJSONBean.getFailedClientResponseJSONBean();
                clientResponseJSONBean.setMsg("插入数据库异常");
            }

        } catch (Exception e) {

            logger.error("插入发布记录失败：" + e.getMessage());
            clientResponseJSONBean = ClientResponseJSONBean.getFailedClientResponseJSONBean();
            clientResponseJSONBean.setMsg("插入数据库异常" + e.getMessage());
            e.printStackTrace();

        }

        return clientResponseJSONBean.toJSONString();
    }

    @RequestMapping(value = "/receiver", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("接收接口")
    public String receive(ReceiverVO receiver) {
        logger.info("更新的信息：" + receiver.toString());
        ClientResponseJSONBean clientResponseJSONBean = null;
        try {

            int update = discoverService.update(receiver);

            clientResponseJSONBean = ClientResponseJSONBean.getSuccessClientResponseJSONBean();
            if (update != 1) {
                clientResponseJSONBean = ClientResponseJSONBean.getFailedClientResponseJSONBean();
                clientResponseJSONBean.setMsg("插入数据库异常");
            }

        } catch (Exception e) {
            logger.error("更新发现失败：" + e.getMessage());
            clientResponseJSONBean = ClientResponseJSONBean.getFailedClientResponseJSONBean();
            clientResponseJSONBean.setMsg("插入数据库异常" + e.getCause());
            e.printStackTrace();
        }
        return clientResponseJSONBean.toJSONString();
    }

    @RequestMapping(value = "/complete", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("完成接口")
    public String receive(CompleteVO complete) {
        logger.info("更新的信息：" + complete.toString());

        ClientResponseJSONBean clientResponseJSONBean = null;

        try {

            int update = discoverService.update(complete);
            clientResponseJSONBean = ClientResponseJSONBean.getSuccessClientResponseJSONBean();

        } catch (Exception e) {
            logger.error("更新完成失败：" + e.getMessage());
            clientResponseJSONBean = ClientResponseJSONBean.getFailedClientResponseJSONBean();
            clientResponseJSONBean.setMsg("插入数据库异常" + e.getCause());
            e.printStackTrace();
        }
        return clientResponseJSONBean.toJSONString();
    }

    @RequestMapping(value = "/comment", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("完成接口")
    public String comment(CommentVO comment) {
        logger.info("更新的信息：" + comment.toString());

        ClientResponseJSONBean clientResponseJSONBean = null;
        clientResponseJSONBean = ClientResponseJSONBean.getSuccessClientResponseJSONBean();

        try {

            int update = discoverService.update(comment);

        } catch (Exception e) {
            logger.error("更新完成失败：" + e.getMessage());
            clientResponseJSONBean = ClientResponseJSONBean.getFailedClientResponseJSONBean();
            clientResponseJSONBean.setMsg("插入数据库异常" + e.getCause());
            e.printStackTrace();
        }
        return clientResponseJSONBean.toJSONString();
    }

    @RequestMapping(value = "/main/menu", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("获取菜单接口")
    public String menu(HttpServletRequest request) {
        String strJSON = null;

        try {
            File file = ResourceUtils.getFile("classpath:config/main_menu.json");
            strJSON = FileUtils.readFileToString(file, "UTF-8");
        } catch (IOException e) {
            logger.error("获取菜单失败" + e.getMessage());
            e.printStackTrace();

        }

        return strJSON;
    }

}
