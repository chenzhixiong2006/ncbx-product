package com.ncbx.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;

import com.ncbx.gateway.configure.GatewayConfigure;

import reactor.core.publisher.Mono;

/**
 * 网关全局过滤器
 * 该过滤器中可以增加权限等控制
 * @author win7
 *
 */
@Configuration
public class GlobalRouteFilter implements GlobalFilter {
	private static final Logger logger = LoggerFactory.getLogger(GlobalRouteFilter.class);
	@Autowired
	private GatewayConfigure gatewayConfigure;
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    	String urlPath = exchange.getRequest().getURI().getRawPath();
    	logger.info("userPath:{}",urlPath);
    	/*if(!ignoreUrl(urlPath)) {
    		String token = exchange.getRequest().getHeaders().getFirst("Authorization");
    		if(!verifyToken(token)) {
    			 
    			ServerHttpResponse response = exchange.getResponse();
    			response.setStatusCode(HttpStatus.SEE_OTHER);
    			response.getHeaders().set("Location", gatewayConfigure.loginPath+"?from="+urlPath);
    			return response.setComplete();
    		}else {
    			//认证通过，则需要携带用户信息传给调用的服务
    		}
    	}*/
    	/**
    	 * 往请求中添加内容
    	 */
        ServerHttpRequest.Builder builder = exchange.getRequest().mutate();
        builder.header("GlobalFilter","GlobalFilter success");
        logger.info("global filter");
        
        /**
         * 调用下一个过滤器
         */
        Mono<Void> ret = chain.filter(exchange.mutate().request(builder.build()).build());
        return ret;
    }
    
    /**
     * 判断URL是否需要做认证登陆
     * 以auth开头的都需要进行认证
     * @param url
     * @return true表示忽略，false表示不忽略需要认证
     */
    public boolean ignoreUrl(String url) {
    	if(url.startsWith(gatewayConfigure.validatePath)) {
    		return false;
    	}
    	return true;
    }
    
    /**
     * 对token进行认证
     * @param token
     * @return
     */
    public boolean verifyToken(String token) {
    	return true;
    }
}
