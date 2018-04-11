package com.abc.edu.cn.community.mapper;

import com.abc.edu.cn.community.entity.DiscoveryDTO;
import com.abc.edu.cn.community.entity.MemberDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DiscoveryMapper extends SuperMapper<DiscoveryDTO> {

  List<DiscoveryDTO> list();
}
