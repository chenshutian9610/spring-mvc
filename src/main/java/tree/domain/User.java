package tree.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class User {
    @NotBlank(message = "名字不能为空")
    private String name;
    @Size(min = 8,max = 20,message = "密码必须是 8 到 20 位的字符")
    private String pwd;
    @Email(message="email 格式错误")
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-DD")
    @Past   //  过去的时间，与此相对的是 @Future
    private Date birthday;


    public User(){}

    public User(String name,String pwd){
        this.name=name;
        this.pwd=pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "user : "+name+"\t"+pwd+"\t"+birthday+"\t"+email;
    }
}

