package com.abc.edu.cn.community.service.impl;

import com.abc.edu.cn.community.entity.MemberDTO;
import com.abc.edu.cn.community.mapper.MemberMapper;
import com.abc.edu.cn.community.service.IMemberService;
import com.abc.edu.cn.community.util.CheckPhone;
import com.abc.edu.cn.community.util.exception.MemberException;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, MemberDTO> implements IMemberService {

    private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Override
    public MemberDTO login(String loginName, String password) {

        if (Strings.isNullOrEmpty(loginName) || Strings.isNullOrEmpty(password)) {
            throw new MemberException("手机号或密码不能为空！");
        }
        //验证手机号是否正确
        if (!CheckPhone.isPhoneLegal(loginName)) {
            throw new MemberException("手机号不合法！");
        }
        //查询用户
        MemberDTO user = baseMapper.getByLoginNameAndPassword(loginName, password);

        if (user == null) {
            throw new MemberException("用户不存在或密码不对！");
        }

        return user;
    }

    @Override
    public MemberDTO getByPhone(String loginName) {
        if (Strings.isNullOrEmpty(loginName)) {
            throw new MemberException("手机不能为空！");
        }
        MemberDTO member = baseMapper.getByLoginName(loginName);
        if (member==null) {
            throw new MemberException("该用户不存在！");
        }
        return member;
    }
}
