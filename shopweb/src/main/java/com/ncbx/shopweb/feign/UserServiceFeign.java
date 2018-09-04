package com.ncbx.shopweb.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ncbx.entity.User;


/**
 * Feign方式调用shopuserprovider的登录服务
 * @author win7
 *
 */
@FeignClient(value = "shopuserprovider")
public interface  UserServiceFeign {
	@RequestMapping(value = "/login",method = RequestMethod.POST)
    public User login(@RequestParam(value = "account") String account,@RequestParam(value = "pwd") String pwd);
}
