package com.louis.info.interceptor;

import com.louis.info.pojo.User;
import com.louis.info.service.UserService;
import com.louis.info.util.ParseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 赖小燚
 * www.louis.com
 */
public class UserInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("User截获");
        String url = request.getRequestURI();
        if(url.indexOf("/login")>=0){
            //登录请求，验证用户信息
            String userKey = request.getParameter("userKey");
            String password = request.getParameter("password");
            String searchBy = ParseUtil.parseParamIsIdPhoneEmail(userKey);
            User user = null;
            if("id".equals(searchBy)){
                user = userService.getUserById(ParseUtil.parseString2Int(userKey));
            }
            if("phonenumber".equals(searchBy)){
                user = userService.getUserByPhonenumber(userKey);
            }
            if("email".equals(searchBy)){
                user = userService.getUserByEmail(userKey);
            }
            if(user==null){
                //用户为null，返回登录界面
                request.setAttribute("msg","用户不存在");
                request.getRequestDispatcher("../").forward(request,response);
                return false;
            }else {
                //用户存在，但是密码错误
                if(!password.equals(user.getPassword())){
                    request.setAttribute("msg","密码错误");
                    request.getRequestDispatcher("../").forward(request,response);
                    return false;
                }
            }
            request.getSession().setAttribute("user",user);
            request.setAttribute("user",user);
            return true;
        }else {
            //用户未登录，返回登录界面登录
            if(request.getSession().getAttribute("user")==null){
                request.getRequestDispatcher("../").forward(request,response);
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
