/**
 * Created by yuyuzhu on 2019/6/7.
 */

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.exception.ZuulException;
import com.netflix.zuul.context.RequestContext;
import javax.servlet.http.HttpServletResponse;

class TestPreGoovyFilter extends ZuulFilter {

    @Override
    public boolean shouldFilter() {
        String path  = RequestContext.getCurrentContext().getRequest().getRequestURI();
        println("in groovy filter!!!")
        return path != null && path.toLowerCase().endsWith(uri());
    }

    public Object uri() {
        return "/healthcheck";
    }

    public String responseBody() {
        return "<health>ok</health>";
    }

    @Override
    Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        // Set the default response code for static filters to be 200
        ctx.getResponse().setStatus(HttpServletResponse.SC_OK);
        ctx.getResponse().setContentType('application/xml')
        // first StaticResponseFilter instance to match wins, others do not set body and/or status
        if (ctx.getResponseBody() == null) {
            ctx.setResponseBody(responseBody())
            ctx.sendZuulResponse = false;
        }
    }

    @Override
    String filterType() {
        return "pre";
    }

    @Override
    int filterOrder() {
        return 0;
    }
}