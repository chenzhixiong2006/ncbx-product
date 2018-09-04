package com.ncbx.user.service;

import java.util.List;

import com.ncbx.entity.User;

public interface UserService {
	public List<User> getUser();
    public int insert(User user) throws Exception;
    public User findUserByName(String name);
}
