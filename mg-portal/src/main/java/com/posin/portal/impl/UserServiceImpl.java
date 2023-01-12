package com.posin.portal.impl;

import com.posin.common.response.model.RESTResponse;
import com.posin.portal.http.UserServiceHttpApi;
import com.posin.portal.model.UserEntity;
import com.posin.portal.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName : UserServiceImpl
 * @Description : UserServiceImpl
 * @Author : ZeKun Pan
 * @Date: 2023-01-11 23:33
 */
@Service
public class UserServiceImpl implements UserServiceHttpApi {

    @Autowired
    IUserService userService;

    @Override
    public RESTResponse getUserList(Integer id) {
        RESTResponse response = new RESTResponse();
        UserEntity user = userService.getUserById(id);
        response.setData(user);
        return response;
    }
}
