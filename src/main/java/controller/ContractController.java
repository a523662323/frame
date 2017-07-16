package controller;

import java.util.List;

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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ContractController {
    @Autowired
    ContractService contractservice;

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

    @RequestMapping("/aui")
    public ModelAndView toaui() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("../aui/html/login");
        return mv;
    }
    @RequestMapping("/testford")
    public ModelAndView forw() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("../res2");
        return mv;
    }


    @RequestMapping("/res2")
    public ModelAndView forw2() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("../res1");
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
