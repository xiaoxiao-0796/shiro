package com.xiaofei.test.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface RoleMapper {

    Set<String> queryRoleNameByStaffCode(@Param("staffCode") String userName);
}
