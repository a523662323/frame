package dao.impl;

import common.dao.BaseDaoImpl;
import dao.SysDao;
import po.Contract;
import po.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("sysDao")
public class SysDaoImpl extends BaseDaoImpl<User> implements SysDao{

    public void getAll() {

    }

    public User getUser(String name,String password){
        String hql = "from User where name = '"+name+"' and password='"+password+"'";
        List list = getSessionFactory().getCurrentSession().createQuery(hql).list();
        if (list.size()>0){
            return (User) list.get(0);
        }
        return null;
    }
}
