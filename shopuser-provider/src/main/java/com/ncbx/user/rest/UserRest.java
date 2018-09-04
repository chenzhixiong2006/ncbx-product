package com.ncbx.user.rest;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncbx.entity.User;

@RestController
@RequestMapping(value="auth/user")
public class UserRest {
	private static final Logger logger = LoggerFactory.getLogger(UserRest.class);
	@GetMapping(value="info")
    public User userInfo(HttpSession session) {
		User user = (User)session.getAttribute("user");
		logger.info("get user ifo {}",user.getName());
        return user;
    }
}
