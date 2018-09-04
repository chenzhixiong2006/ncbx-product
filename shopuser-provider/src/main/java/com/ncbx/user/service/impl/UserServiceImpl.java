package com.ncbx.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncbx.entity.User;
import com.ncbx.user.dao.UserDao;
import com.ncbx.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
    private UserDao  userDao;
 
    public List<User> getUser() {
        return userDao.getUser();
    }
    
 
    @Transactional(rollbackFor=Exception.class)
    public int insert(User user) throws Exception {
    	int rs =  userDao.insert(user);
    	return rs;
    }

    public User findUserByName(String name) {
    	return userDao.findUserByName(name);
    }
}
