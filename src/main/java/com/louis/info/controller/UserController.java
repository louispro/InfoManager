package com.louis.info.controller;

import com.louis.info.pojo.User;
import com.louis.info.service.UserService;
import com.louis.info.util.FileUtil;
import com.louis.info.util.ParseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * 赖小燚
 * www.louis.com
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestParam("userKey")String userKey, @RequestParam("password")String password, Model model, HttpServletRequest request){
        return "user/user_info";
    }

    @GetMapping("/toUserInfo")
    public String toUserInfoPage(){
        return "user/user_info";
    }

    @GetMapping("/toEdit")
    public String toEdit(){
        return "user/edit_info";
    }

    @PostMapping("/editInfo")
    public String EditInfo(@RequestParam("username")String username,
                           @RequestParam("education")String education,
                           @RequestParam("phonenumber")String phonenumber,
                           @RequestParam("address")String address,
                           @RequestParam("email")String email,
                           @RequestParam("height")Integer height,
                           @RequestParam("weight")Integer weight,Model model,
                           @RequestParam("imageUrl")MultipartFile file, HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");    //获取session中的user
        user.setUsername(username);
        user.setEducation(education);
        user.setPhonenumber(phonenumber);
        user.setAddress(address);
        user.setEmail(email);
        user.setHeight(height);
        user.setWeight(weight);
        //如果上传了图片
        if(!file.isEmpty()){
            //上传文件的格式需为jpg,jpeg,png格式的图片
            String format = file.getOriginalFilename().split("\\.")[1];
            if(!FileUtil.isImage(format.toLowerCase())){
                model.addAttribute("msg","请上传jpg,jpeg,png格式的图片");
                return "user/edit_info";
            }
            try {
                String filename = user.getId()+"."+format;
                file.transferTo(new File("D:\\Codes\\JavaCode\\InfoManager\\src\\main\\webapp\\static\\img\\user\\"+filename));
                user.setImageUrl(filename);
            } catch (IOException e) {
                e.printStackTrace();
                model.addAttribute("msg","信息修改失败");
                return "user/edit_info";
            }
        }
        System.out.println(user);
        userService.updateUserInfo(user);
        model.addAttribute("user",user);
        return "user/user_info";
    }

    /**
     * 退出登录
     * @param request
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "user/login";
    }

    @GetMapping("/toRegist")
    public String toRegistPage(){
        return "user/regist";
    }

    @PostMapping("/regist")
    public String regist(@RequestParam("username")String username,
                         @RequestParam("password")String password,
                         @RequestParam("phonenumber")String phonenumber,Model model){
        User user = userService.getUserByPhonenumber(phonenumber);
        if(user!=null){
            //user==null，说明手机号已经被使用
            model.addAttribute("msg","该手机号已经被注册");
            model.addAttribute("username",username);
            model.addAttribute("password",password);
            model.addAttribute("phonenumber",phonenumber);
            return "user/regist";
        }
        model.addAttribute("msg","注册成功");
        userService.addUser4Param(userService.generateId(),username,password,phonenumber);
        return "user/login";
    }

    @RequestMapping("/error")
    public String errorTest(){
        String str = null;
        str.equals("louis");
        return "/";
    }
}
