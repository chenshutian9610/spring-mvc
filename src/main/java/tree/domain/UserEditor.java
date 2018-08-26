package tree.domain;

import java.beans.PropertyEditorSupport;
// 必须和 User 放在同一个包中
public class UserEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[]str=text.split(":");
        User user=new User(str[0],str[1]);
        setValue(user);
    }
}
