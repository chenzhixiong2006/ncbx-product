package com.ncbx.shopweb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ncbx.entity.User;
import com.ncbx.pojo.Constants;



public class SessionInterceptor extends HandlerInterceptorAdapter {
	//private static String[] IGNORE_URI = {"/login"};
	private static final Logger logger = LoggerFactory.getLogger(SessionInterceptor.class);
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		/*boolean flag = false;
        String url = request.getRequestURL().toString();
        
		for (String s : IGNORE_URI) {
            if (url.contains(s)) {
                flag = true;
                break;
            }
        }*/
        //if (!flag) {
    	User user = (User)request.getSession().getAttribute(Constants.SESSION_USER);
        if (null == user) {
        	//未登录
        	String servletPath = request.getServletPath();
        	logger.info("当前url：{}",servletPath);
        	//logger.error("session失效，当前url：" + url+";module Paht:"+servletPath);
        	
        	if (request.getHeader("x-requested-with") != null && 
        					request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
        		
        		response.setHeader("sessionstatus", "timeout");//在响应头设置session状态  
        		response.setCharacterEncoding("text/html;charset=utf-8");
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().print("error");
	        } else { 
    			response.sendRedirect("/login.html?from=auth/user/info");
	        }
        	return false;
        }
        //}
        return super.preHandle(request, response, handler);
    }
	 
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }
}