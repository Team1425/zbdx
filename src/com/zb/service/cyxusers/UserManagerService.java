package com.zb.service.cyxusers;

import com.zb.dao.cyxusers.UserLoginDao;
import com.zb.dao.cyxusers.UserManagerDao;
import com.zb.pojo.CyxUsers;

import java.util.List;

public class UserManagerService {
    public void addUser(CyxUsers users){
        UserManagerDao userManagerDao=new UserManagerDao();
        userManagerDao.insertUser(users);
    }

    public List<CyxUsers> findUser(CyxUsers users) {
        UserManagerDao userManagerDao = new UserManagerDao();
        return userManagerDao.selectUserByProperty(users);
    }

    public CyxUsers findUserByUserId(int userid) {
        UserManagerDao userManagerDao = new UserManagerDao();
        return userManagerDao.selectUserByUserId(userid);
    }

    public void modifyUser(CyxUsers users) {
        UserManagerDao userManagerDao = new UserManagerDao();
        userManagerDao.updateUserByUserId(users);
    }

    public void dropUser(int userid) {
        UserManagerDao userManagerDao = new UserManagerDao();
        userManagerDao.deleteUserByUserId(userid);
    }
}
