package tree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import tree.domain.User;

import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes("user")                  //  将 user 保存进 session 中，但 user 只在本控制器有用
public class SessionController {
    @ModelAttribute("user")                 //  @SessionAttributes 依赖于方法上的 @ModelAttribute，如果没有这个将报错
    public User init(){
        return new User();
    }

    @RequestMapping("/redirect")
    public String redirect(@ModelAttribute("user")User user){
            user.setName("triski");         //  user 的改变会同步到模型中，如果没有 @SessionAttributes 则不会
        return "redirect:result";           //  如果是转发则使用 forward
    }

    @RequestMapping("/result")
    public String result(ModelMap map,SessionStatus status){
        User user=(User)map.get("user");
        System.out.println(user.getName()); //  triski
        status.setComplete();               //  清除 session 中的 user，但模型中的 user 还在
        return "success";
    }
}
