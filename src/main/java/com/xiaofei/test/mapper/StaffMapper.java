package com.xiaofei.test.mapper;

import com.xiaofei.test.model.StaffDO;
import org.apache.ibatis.annotations.Param;

public interface StaffMapper {

    StaffDO queryByStaffCode(@Param("staffCode") String userName);
}
