package com.abc.edu.cn.community.mapper;

import com.abc.edu.cn.community.entity.MemberDTO;
import org.apache.ibatis.annotations.Param;

public interface MemberMapper extends SuperMapper<MemberDTO> {

    /**
     * 查需用户
     * @param loginName 手机号
     * @param password  登录密码
     * @return
     */
    MemberDTO getByLoginNameAndPassword(@Param("loginName") String loginName,@Param("password")String password);

    /**
     * 根据手机号查询用户信息
     * @return loginName 用户手机号
     */
    MemberDTO getByLoginName(@Param("loginName")String loginName);
}
