package com.posin.portal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.posin.portal.model.UserEntity;

/**
 * @ClassName : IUserService
 * @Description : IUserService
 * @Author : ZeKun Pan
 * @Date: 2023-01-11 23:39
 */
public interface IUserService extends IService<UserEntity> {

    UserEntity getUserById(Integer id);
}
