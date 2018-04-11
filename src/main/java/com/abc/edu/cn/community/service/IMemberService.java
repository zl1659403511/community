package com.abc.edu.cn.community.service;

import com.abc.edu.cn.community.entity.MemberDTO;
import com.baomidou.mybatisplus.service.IService;

public interface IMemberService extends IService<MemberDTO> {

    /**
     * 用户登录
     * @param loginName 手机号
     * @param password  密码
     * @return
     */
    MemberDTO login(String loginName, String password);

    /**
     * 查询用户信息
     * @param loginName
     * @return
     */
    MemberDTO getByPhone(String loginName);
}
