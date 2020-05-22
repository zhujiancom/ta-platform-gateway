package com.ta.platform.filter;

import com.ey.tax.toolset.core.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Creator: zhuji
 * Date: 5/22/2020
 * Time: 2:30 PM
 * Description: 检查请求头或请求参数中是否包含token
 *
 */
@Slf4j
@Component
public class TokenFilter implements GlobalFilter , Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getHeaders().getFirst("X-Access-Token");
        if(StrUtil.isBlank(token)){
            token = exchange.getRequest().getQueryParams().getFirst("X-Access-Token");
        }
        if(StrUtil.isBlank(token)){
            log.error("token is empty...");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -100;
    }
}
