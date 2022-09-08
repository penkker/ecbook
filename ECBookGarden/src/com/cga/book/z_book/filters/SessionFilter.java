package com.cga.book.z_book.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

//@WebFilter(urlPatterns = {"*.do","*.html"},
//        initParams = {
//            @WebInitParam(
//                    name = "ini",
//                    value = "/ECBookGarden/page.do?operate=page&page=user/login_regist," +
//                            "/ECBookGarden/user.do?null," +
//                            "/ECBookGarden/page.do?operate=page&page=index_guest,"+
//                            "/ECBookGarden/user.do?operate=guestLogin,"+
//                            "/ECBookGarden/page.do?operate=page&page=admin/login_admin,"+
//                            "/ECBookGarden/admin.do?operate=login"
//            )
//        })
public class SessionFilter implements Filter {

    List<String> baiList = null ;

    @Override
    public void init(FilterConfig config) throws ServletException {

        String bai = config.getInitParameter("ini");
        String[] baiArr = bai.split(",");
        baiList = Arrays.asList(baiArr);

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)servletRequest ;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession() ;

        String uri = request.getRequestURI() ;
        String queryString = request.getQueryString() ;
        String str = uri + "?" + queryString ;

        String userGuest = (String)session.getAttribute("userGuest");   //访客
        String uname = (String)request.getParameter("uname");   //正常用户
        if(baiList.contains(str)){
            filterChain.doFilter(request,response);
        }else if("guest".equals(userGuest)){  //用于判断是否是访客
            filterChain.doFilter(request,response);
        } else{
            if (uname != null) {
                filterChain.doFilter(request,response);
            }else {
                //此时说明响应过来的unamew为空,说明已经进入管理员界面
                //管理员
                Object admin = session.getAttribute("currAdmin");
                //正常用户
                Object currUserObj =  session.getAttribute("currUser");
                //管理员或者正常用户
                if(admin == null){
                    response.sendRedirect("page.do?operate=page&page=user/login_regist");
                }else{
                    filterChain.doFilter(request,response);
                    //防止重定向异常,让到这就截至,不会同时执行下边的代码,防止同时向服务器端请求两次
                    return;
                }
                if(currUserObj == null){  //不能通过导航栏直接访问
                    response.sendRedirect("page.do?operate=page&page=user/login_regist");
                }else{
                    filterChain.doFilter(request,response);
                }

            }

        }

    }

    @Override
    public void destroy() {

    }
}
