package com.min.auth.mapper;

import com.min.model.system.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {

}
