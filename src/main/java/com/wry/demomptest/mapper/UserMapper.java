package com.wry.demomptest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wry.demomptest.entity.User;
import org.springframework.stereotype.Repository;

//核心代码
// BaseMapper中封装了常用的增删改查，只需要用我们的接口继承BaseMapper接口即可
@Repository
public interface UserMapper extends BaseMapper<User> {
}
