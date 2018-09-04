package com.ncbx.shopweb.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncbx.entity.User;
import com.ncbx.pojo.Constants;

@RestController
@RequestMapping(value="auth/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	/**
	 * 获取用户信息
	 * @param session
	 * @return
	 */
	@GetMapping(value="info")
    public User userInfo(HttpSession session) {
		User user = (User)session.getAttribute(Constants.SESSION_USER);
		logger.info("get user ifo {}",user.getName());
        return user;
    }
}
