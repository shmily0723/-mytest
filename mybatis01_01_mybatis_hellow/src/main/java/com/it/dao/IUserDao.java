package com.it.dao;

import com.it.entity.User;

import java.util.List;

public interface IUserDao {

    List<User> findAll();
}
