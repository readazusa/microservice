package club.microservice.client.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Created by 念梓  on 2017/8/31.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
@Component
public class TokenFilter extends ZuulFilter {

    private static  final Logger log = LogManager.getLogger(TokenFilter.class);


    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        log.info("执行shouldfilter...........");
//        RequestContext context = RequestContext.getCurrentContext();
//        HttpServletRequest request = context.getRequest();
//        log.info("shuldurl: {}",request.getRequestURI());
//        Enumeration<String> headers =  request.getHeaderNames();
//
//        while(headers.hasMoreElements()){
//            String header = headers.nextElement();
//            log.info("header: {},values: {}",header,request.getHeader(header));
//        }
//
//        Enumeration<String> attres = request.getAttributeNames();
//
//        while (attres.hasMoreElements()){
//            String attr = attres.nextElement();
//            log.info("attr: {}, value: {}",attr,request.getAttribute(attr));
//        }

        return false;
    }

    @Override
    public Object run() {
//        RequestContext context = RequestContext.getCurrentContext();
//        HttpServletRequest request = context.getRequest();
//        Enumeration<String> headers =  request.getHeaderNames();
//        log.info("run: {}",request.getRequestURI());
//        while(headers.hasMoreElements()){
//            String header = headers.nextElement();
//            log.info("header: {},values: {}",header,request.getHeader(header));
//        }
//
//        Enumeration<String> attres = request.getAttributeNames();
//
//        while (attres.hasMoreElements()){
//            String attr = attres.nextElement();
//            log.info("attr: {}, value: {}",attr,request.getAttribute(attr));
//        }
//
//
//
//        context.setSendZuulResponse(false);
//        context.setResponseStatusCode(401);
//        context.addZuulResponseHeader("content-type","application/json;charset=utf-8");
//        context.setResponseBody("错误");

        return null;
    }
}
