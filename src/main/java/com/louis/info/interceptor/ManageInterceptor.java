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
public class ManageInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Manage截获");
        String url = request.getRequestURI();
        System.out.println(url);
        if(url.indexOf("/login")>=0){
            //url中有/login，说明事登录请求，放行且跳转到login请求
//            request.getRequestDispatcher("login").forward(request,response);
            String userKey = request.getParameter("userKey");
            Integer id = Integer.parseInt(request.getParameter("roleId"));
            String password = request.getParameter("password");
            String key = ParseUtil.parseParamIsIdPhoneEmail(userKey);
            User user = null;
            //以账号的方式登录
            if("id".equals(key)){
                user = userService.getUserById(ParseUtil.parseString2Int(userKey));
            }
            //以手机号的方式登录
            if("phonenumber".equals(key)){
                user = userService.getUserByPhonenumber(userKey);
            }
            //以邮箱的方式登录
            if("email".equals(key)){
                user = userService.getUserByEmail(userKey);
            }
            System.out.println("id:"+user.getRoleName());
            if(user==null){
                //用户为null，返回登录界面
                request.setAttribute("msg","用户不存在");
                request.getRequestDispatcher("../").forward(request,response);
                return false;
            }else{
                //用户存在，判断身份
                if("普通用户".equals(user.getRoleName())){
                    //普通用户不允许访问后台
                    request.setAttribute("msg","你不是管理员身份，请联系管理员");
                    request.getRequestDispatcher("../").forward(request,response);
                    return false;
                }else{
                    if(!password.equals(user.getPassword())){
                        request.setAttribute("msg","密码错误");
                        request.getRequestDispatcher("../").forward(request,response);
                        return false;
                    }
                }
            }
            request.getSession().setAttribute("user",user);
            return true;
        }else {
            //其他请求需要登录之后才能访问
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user");
            if(user!=null){
                return true;
            }
        }
        request.setAttribute("msg","请先登录");
        request.getRequestDispatcher("../").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
