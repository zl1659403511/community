package com.abc.edu.cn.community.service.impl;

import com.abc.edu.cn.community.entity.*;
import com.abc.edu.cn.community.mapper.DiscoveryMapper;
import com.abc.edu.cn.community.service.IDiscoverService;
import com.abc.edu.cn.community.service.IMemberService;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.toolkit.PackageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: zhanglei
 * @ Description:
 * @Date: Create in 2018-04-10 16:16
 */
@Service
public class DiscoverServerImpl extends ServiceImpl<DiscoveryMapper, DiscoveryDTO> implements IDiscoverService {
    @Autowired
    IMemberService memberService;

    @Override
    public List<DiscoveryDTO> list(int current, int size) {
        if (size <= 0) {
            size = 10;
        }
        if (current <= 0) {
            current = 1;
        }
        PageHelper.startPage(current, size);
        List<DiscoveryDTO> list = baseMapper.list();
        return list;
    }

    @Override
    public int insert(PublishVO publishVO) {

        DiscoveryDTO discovery = new DiscoveryDTO();
        discovery.setActivitiyPlace(publishVO.getActivityPlace());
        discovery.setActivityTime(publishVO.getActivityTime());
        discovery.setPublishTime(publishVO.getPublishTime());
        discovery.setActivityContent(publishVO.getActivityContent());
        discovery.setIsfinished(publishVO.getIsFinished());
        discovery.setIsOver(publishVO.getIsOver());
        discovery.setIsreceived(publishVO.getIsReceived());

        MemberDTO member = memberService.getByPhone(publishVO.getLoginName());
        discovery.setActivityOrganize(member.getRealName());
        discovery.setActivityContact(publishVO.getLoginName());

        return baseMapper.insert(discovery);
    }

    @Override
    public int update(ReceiverVO receiverVO) {
        DiscoveryDTO discovery = new DiscoveryDTO();
        discovery.setId(receiverVO.getId());
        discovery.setIsreceived(receiverVO.getIsReceived());
        discovery.setReceiverManagement(receiverVO.getReceiverManagement());
        MemberDTO member = memberService.getByPhone(receiverVO.getLoginName());
        discovery.setReceiverName(member.getRealName());
        discovery.setReceiverTime(new Date());
        discovery.setReceiverPartner(member.getName());
        discovery.setReceiverPhone(member.getLoginName());

        return baseMapper.updateById(discovery);
    }

    @Override
    public int update(CompleteVO completeVO) {
        DiscoveryDTO discovery = new DiscoveryDTO();
        discovery.setId(completeVO.getId());
        discovery.setActivityTopic(completeVO.getActivityTopic());
        discovery.setActivityImage1(completeVO.getActivityImage1());
        discovery.setActivityImage2(completeVO.getActivityImage2());
        discovery.setActivityImage3(completeVO.getActivityImage3());
        discovery.setActivityText1(completeVO.getActivityText1());
        discovery.setActivityText2(completeVO.getActivityText2());
        discovery.setActivityText3(completeVO.getActivityText3());
        discovery.setFinishTime(completeVO.getFinishTime());
        discovery.setIsfinished(completeVO.getIsFinished());
        return baseMapper.updateById(discovery);
    }

    @Override
    public int update(CommentVO comment) {
        DiscoveryDTO discovery = new DiscoveryDTO();
        discovery.setId(comment.getId());
        discovery.setActivityComment(comment.getActivityComment());
        discovery.setIsOver(comment.getIsOver());
        return baseMapper.updateById(discovery);
    }
}
