package com.posin.portal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.posin.common.response.model.RESTResponse;
import com.posin.portal.http.UserServiceHttpApi;
import com.posin.portal.mapper.UserMapper;
import com.posin.portal.model.UserEntity;
import com.posin.portal.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
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
