package com.louis.info.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.louis.info.pojo.User;
import com.louis.info.service.UserService;
import com.louis.info.util.ParseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 赖小燚
 * www.louis.com
 */
@Controller
@RequestMapping("/manage")
public class ManagerController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestParam("userKey")String userKey,
                        @RequestParam("roleId")Integer id,
                        @RequestParam("password")String password,
                        Model model, HttpServletRequest request){
        if(id!=0){
            model.addAttribute("msg","你不是管理员身份，请联系管理员！");
            return "user/login";
        }
        String key = ParseUtil.parseParamIsIdPhoneEmail(userKey);
        User user = null;
        if("id".equals(key)){
            user = userService.getUserById(ParseUtil.parseString2Int(userKey));
        }
        if("phonenumber".equals(key)){
            user = userService.getUserByPhonenumber(userKey);
        }
        if("email".equals(userKey)){
            user = userService.getUserByEmail(userKey);
        }
        if(user==null){
            //用户为null,返回登录界面
            model.addAttribute("msg","用户不存在");
            return "user/login";    //
        }else {
            //用户存在，但是输入密码错误
            if(!password.equals(user.getPassword())){
                model.addAttribute("msg","密码错误");
                return "user/login";
            }
        }
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        return "redirect:/manage/list";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "user/login";
    }

    @GetMapping("list")
    public String list(@RequestParam(value = "pageNum",defaultValue = "1",required = false)Integer pageNum,
                       @RequestParam(value = "pageSize",defaultValue = "15",required = false)Integer pageSize,Model model){
        if(pageNum <= 0)
            pageNum = 0;
        int pages = userService.getUserCount()/15+1;
        if(pageNum >= pages)
            pageNum = pages;
        pageSize = 15;
        Page<User> page = PageHelper.startPage(pageNum,pageSize);
        List<User> users = userService.getAllUser();
        model.addAttribute("users",users);
        model.addAttribute("pageNum",page.getPageNum());
        model.addAttribute("pages",page.getPages());
        model.addAttribute("total",page.getTotal());
//        model.addAttribute("page",page);
        return "manage/show_user";
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @GetMapping("/delete")
    public String deleteUser(@RequestParam(value = "id")Integer id){
        userService.deleteUserById(id);
        return "redirect:http://localhost:8080/manage/list";
    }

    /**
     * 前往修改或增加用户信息界面
     */
    @GetMapping("/toEdit")
    public String toEditPage(@RequestParam(value = "id",required = false)Integer id,@RequestParam("pageNum")Integer pageNum, Model model){
        //传入id说明是修改用户信息，没传入则是增加用户
        if(id!=null){
            User user = userService.getUserById(id);
            model.addAttribute("user",user);
        }else {
            //管理员添加用户，id由系统生成
            Integer sysId = userService.generateId();
            model.addAttribute("sysId",sysId);
        }
        model.addAttribute("pageNum",pageNum);
        return "manage/edit_user";
    }

    /**
     * 修改用户信息
     * @param user
     * @param pageNum
     * @return
     */
    @PostMapping("/edit")
    @ResponseBody
    public String editUserInfo(User user,@RequestParam("pageNum")Integer pageNum){
        userService.updateUserInfo(user);
        return Integer.toString(pageNum);
    }

    @PostMapping("/add")
    @ResponseBody
    public String addUser(User user,@RequestParam("pageNum")Integer pageNum){
        userService.addUser(user);
        return Integer.toString(pageNum);
    }
}
