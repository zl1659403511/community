package com.abc.edu.cn.community.service;

import com.abc.edu.cn.community.entity.*;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * @Author: zhanglei
 * @ Description:
 * @Date: Create in 2018-04-10 14:45
 */
public interface IDiscoverService extends IService<DiscoveryDTO> {
    /**
     * 查询发现列表
     *
     * @param current 当前页数
     * @param size    期望查询总数
     * @return
     */
    List<DiscoveryDTO> list(int current, int size);

    /**
     * 插入发现记录
     * @param publishVO 插入参数
     * @return
     */
    int insert(PublishVO publishVO);

    /**
     * 更新发现记录
     * @param receiverVO 更新参数
     * @return
     */
    int update(ReceiverVO receiverVO);
    /**
     * 更新发现记录
     * @param completeVO 更新参数
     * @return
     */
    int update(CompleteVO completeVO);
    /**
     * 更新发现记录
     * @param comment 更新参数
     * @return
     */
    int update(CommentVO comment);
}
