package com.xiaofei.test.web;

import com.xiaofei.test.common.VerifyCode;
import com.xiaofei.test.model.StaffDO;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@Slf4j
public class LoginController {

    @RequestMapping("/login.do")
    public String login(StaffDO staffDO,HttpServletResponse response, HttpSession session){
        String verifycode = (String)session.getAttribute("verifycode");
        if (!verifycode.equalsIgnoreCase(staffDO.getVerifycode())){
            log.warn("验证码错误");
            return "login";
        }else {
           session.removeAttribute("verifycode");
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(staffDO.getStaffCode(), staffDO.getPassword());
        try {
            log.info("登入验证:{}",staffDO);
            subject.login(token);
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            return "login";
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            return "login";
        }catch (AuthenticationException e){
            e.printStackTrace();
            return "login";
        }
        return "index";
    }

    @RequestMapping(value = "/getVerifyCode.do", method = RequestMethod.GET)
    public void getVerifyCode(HttpServletResponse response, HttpSession session)
            throws ServletException, IOException {
        response.setContentType("image/png");
        response.setHeader("cache", "no-cache");
        OutputStream outputStream = response.getOutputStream();
        VerifyCode vc = new VerifyCode();
        BufferedImage image = vc.getImage(session,85, 23);//设置验证码图片大小
        VerifyCode.output(image, response.getOutputStream());
        outputStream.flush();
    }

    @RequestMapping(value = "test1" ,method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions(value = "com.bestpay.ecurrency.pcms.pcpf.pcm.fabrication.action.cardDerived")
    public String test1(){
            return "nihao";
    }
}
