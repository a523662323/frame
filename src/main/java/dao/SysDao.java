package dao;

import common.dao.BaseDao;
import po.User;

public interface SysDao extends BaseDao<User>{

    void getAll();
    User getUser(String name, String password);
}
