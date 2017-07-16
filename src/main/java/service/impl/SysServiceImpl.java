package service.impl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.SysDao;
import service.SysService;

import java.util.List;

@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,timeout=5)
@Service("SysService")
public class SysServiceImpl implements SysService {

    @Autowired
    private SysDao sysDao;

    public List<User> findAll() {
        return null;
    }

    public User getUser(String name, String password) {
        return sysDao.getUser(name,password);
    }
}
