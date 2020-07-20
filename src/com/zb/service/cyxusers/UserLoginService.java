package com.zb.service.cyxusers;
/*我日*/
import com.zb.dao.cyxusers.UserLoginDao;
import com.zb.pojo.CyxUsers;
import com.zb.utils.CyxUserNotFoundException;

public class UserLoginService {
    public CyxUsers userLogin(String username, String userpwd) {
        UserLoginDao userLoginDao = new UserLoginDao();
        CyxUsers users = userLoginDao.selectUsersByUserNameAndUserPwd(username, userpwd);
        if(users == null){
            throw new CyxUserNotFoundException("用户名或密码有误！");
        }
        return users;
    }
}
