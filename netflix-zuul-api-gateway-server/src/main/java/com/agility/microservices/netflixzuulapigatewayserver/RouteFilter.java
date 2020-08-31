package com.agility.microservices.netflixzuulapigatewayserver;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/*
* We can ignore this Component by configure the zuul in global to exclude the Authorization in Sensitive Header
*    zuul.sensitive-headers=Cookie,Set-Cookie
*/
@Component
public class RouteFilter extends ZuulFilter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();

        // Alter ignored headers as per: https://gitter.im/spring-cloud/spring-cloud?at=56fea31f11ea211749c3ed22
        Set<String> headers = (Set<String>) ctx.get("ignoredHeaders");
        // We need our JWT tokens relayed to resource servers
        headers.remove("authorization");

        return null;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 10000;
    }
}