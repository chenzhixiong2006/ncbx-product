package com.ncbx.shopweb.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ncbx.entity.User;
import com.ncbx.pojo.Constants;
import com.ncbx.shopweb.feign.UserServiceFeign;
import com.ncbx.shopweb.pojo.ResponseCodeEnum;
import com.ncbx.shopweb.pojo.ResponseResult;
@RestController
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserServiceFeign userServiceFeign;
	
	@RequestMapping(value="login",method=RequestMethod.POST)
    public ResponseResult login(String account,String pwd,HttpSession session) {
		ResponseResult result = new ResponseResult();
		User user = userServiceFeign.login(account,pwd);
		if(user!=null) {
			session.setAttribute(Constants.SESSION_USER, user);
			result = new ResponseResult(ResponseCodeEnum.SUCCEED.getCode(),ResponseCodeEnum.SUCCEED.getDesc());
		}else {
			result = new ResponseResult(ResponseCodeEnum.USER_NOT_EXIST_ERROR.getCode(),ResponseCodeEnum.USER_NOT_EXIST_ERROR.getDesc());
			logger.info("user {} not exist",account);
		}
        return result;
    }
}
