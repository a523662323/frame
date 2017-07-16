package service;

import po.User;

import java.util.List;

/**
 * Created by Administrator on 2017/7/11.
 */
public interface SysService {
    List<User> findAll();

    User getUser(String name, String password);
}
