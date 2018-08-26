package tree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tree.domain.User;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/interceptor")
    @ResponseBody
    public String testInterceptor(){
        System.out.println("hello");
        return "详情见 IDE 控制台";
    }

    @RequestMapping("/editor")
    @ResponseBody
    public User testUserEditor(@RequestParam(value = "user",required = false) User user){
        System.out.println(user==null); //  如果请求参数中 user 参数为空，则为 true（同种情况下，如果移除上面的 @RequestParam，则为 false）
        return user;
    }

    /**
     *  只有使用 @Valid 这个标志才会使用数据校验，否则不会，如上面的 /redirect
     *  使用 @Valid 的入参后面必须跟着一个 BindingResult 或 Errors 入参来接收错误，它们是成对出现的
     *      BindingResult 和 Errors 使用 getAllErrors 得到一个 List<ObjectError>，
     *      ObjectError 使用 getDefaultMessage 得到错误信息
     */
    @RequestMapping("/validating")
    public String validating(@Valid @ModelAttribute("user") User user, BindingResult result , ModelMap map){
        if(result.hasErrors()){
            map.addAttribute("errors",result.getAllErrors());
            return "validate";
        }
        return "success";
    }
}
