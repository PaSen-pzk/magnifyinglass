package com.posin.portal.retrofit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.posin.portal.retrofit.mapper.UserMapper;
import com.posin.portal.retrofit.model.UserEntity;
import com.posin.portal.retrofit.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @ClassName : UserService
 * @Description : UserService
 * @Author : ZeKun Pan
 * @Date: 2023-01-11 23:29
 */
@Service
public class UserService extends ServiceImpl<UserMapper, UserEntity> implements IUserService {

    @Override
    public UserEntity getUserById(Integer id) {
        UserEntity user = this.getById(id);
        return user;

    }
}
