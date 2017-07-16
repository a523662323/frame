package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class TestController {


    @RequestMapping("/method1")
    public ModelAndView toaui() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("../aui/html/login");
        System.out.println("----------------1");
//        return mv;
        return null;
    }


    @RequestMapping("/method2")
    public ModelAndView forw() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("../res2");
//        return mv;
        System.out.println("-------------------2");
        return null;
    }


    @RequestMapping("/res2")
    public ModelAndView forw2() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("../res1");
        return mv;
    }

}
