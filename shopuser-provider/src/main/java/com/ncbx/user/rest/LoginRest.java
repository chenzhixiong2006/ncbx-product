package com.ncbx.user.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ncbx.entity.User;
import com.ncbx.tool.RedisUtil;
import com.ncbx.user.service.UserService;
@RestController
public class LoginRest {
	private static final Logger logger = LoggerFactory.getLogger(LoginRest.class);
	private static final long expire_time = 60*60;//过期时间
	@Autowired
	private UserService userService;
	
	/**
	 * 注入redis工具
	 */
	@Autowired
    private RedisUtil redisUtil;
	
	@RequestMapping(value="login",method=RequestMethod.POST)
    public User login(String account,String pwd) {
		User user = userService.findUserByName(account);
		if(user!=null) {
			if(!user.getPwd().equals(pwd)) {
				logger.info("user {} password error",account);
				return null;
			}else {
				//登录成功后将用户存放到Redis缓存中，做缓存共享
				//redisUtil.set("U_SESSIONID_"+user.getId(),user.getName(),expire_time);//存放到redis中,一小时后过期，做单点登录使用
				return user;
			}
		}else {
			logger.info("user {} not exist",account);
		}
        return null;
    }
}
