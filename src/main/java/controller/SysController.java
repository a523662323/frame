package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pagemodel.DataGrid;
import po.Contract;
import po.User;
import service.ContractService;
import service.SysService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/sys")
public class SysController {
    @Autowired
    ContractService contractservice;

    @Autowired
    private SysService sysService;

    //获取所有合同列表
    @RequestMapping("/getcontracts/{current}")
    @ResponseBody
    DataGrid<Contract> getcontracts(@PathVariable("current") int current) {
        List<Contract> list = contractservice.getContractlist();
        DataGrid<Contract> grid = new DataGrid<Contract>();
        grid.setCurrent(current);
        grid.setTotal(list.size());
        grid.setRows(list);
        return grid;
    }

    @RequestMapping("/add")
    public ModelAndView runningList(String procInsId) {
        contractservice.add(new User());
        System.out.println(procInsId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("ceshi", "ceshitongguo");
        mv.setViewName("../test");
        return mv;
    }

    @RequestMapping("/addHttp")
    public ModelAndView runningList(String procInsId, HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request);
        System.out.println(response);
        request.getSession().setAttribute("aa","cc");
//        request.setAttribute("aa","aa");
        ModelAndView mv = new ModelAndView();
        mv.addObject("ceshi", "ceshitongguo");
        mv.setViewName("../test");
        return mv;
    }

    @RequestMapping("/toRegis")
    public ModelAndView toRegister() {
        ModelAndView mv = new ModelAndView();
        System.out.println("-------------------res");
        mv.setViewName("../html/sys/register");
        return mv;
    }
    @RequestMapping("/regis")
    public ModelAndView regis() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("../html/sys/register");
        return mv;
    }

    @RequestMapping("/toLogin")
    public ModelAndView toLogin(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("../html/sys/login");
        return mv;
    }


    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request) {
//        List<Contract> contractlist = contractservice.getContractlist();
//        System.out.println(contractlist.size());
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        User user = sysService.getUser(name, password);
        ModelAndView mv = new ModelAndView();
        if (user==null){
            mv.setViewName("../html/sys/loginFail");
        }
        else {
            mv.setViewName("../html/sys/manage");
            mv.addObject("user",user);
        }
        return mv;
    }

    @RequestMapping("/list")
    public ModelAndView findAll(HttpServletRequest request) {
        sysService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("../login");
        return mv;
    }

    @RequestMapping("/manage")
    public ModelAndView toManage(HttpSession session) {
        Object user = session.getAttribute("user");
        ModelAndView mv = new ModelAndView();
//        if(user==null){
//            mv.setViewName("../html/sys/login");
//        }
//        else{
//            mv.setViewName("../html/sys/manage");
//        }

        mv.setViewName("../html/sys/manage");
        return mv;
    }
    @RequestMapping("/submit")
    public ModelAndView aui(String name,String password,HttpServletRequest request) {
        System.out.println("---------------"+request.getParameter("name"));
        System.out.println(request.getParameter("password"));
        ModelAndView mv = new ModelAndView();
        System.out.println("name------------"+name);
        System.out.println(password);
        User user = new User();
        user.setName(name);
        mv.addObject("user", user);
        mv.setViewName("../success");
        return mv;
    }

}
