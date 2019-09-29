package com.sky.controller;

import com.sky.controller.entity.User;
import com.sky.util.FreeMarkerUtil;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class TestController {
    /*
     * 分页效果的实现
     * */
    @GetMapping("/pageList")
    public String list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "2") Integer size,
                       ModelMap map) {
        List<User> demoList = new ArrayList<>(4);
        demoList.add(new User("1231","sky",23,100.9,true,new Date()));
        demoList.add(new User("1232","sky",23,100.9,true,new Date()));
        demoList.add(new User("1233","sky",23,100.9,true,new Date()));
        demoList.add(new User("1234","sky",23,100.9,true,new Date()));
        demoList.add(new User("1235","sky",23,100.9,true,new Date()));
        demoList.add(new User("1231","sky",23,100.9,true,new Date()));
        demoList.add(new User("1232","sky",23,100.9,true,new Date()));
        demoList.add(new User("1233","sky",23,100.9,true,new Date()));
        demoList.add(new User("1234","sky",23,100.9,true,new Date()));
        demoList.add(new User("1235","sky",23,100.9,true,new Date()));
        demoList.add(new User("1231","sky",23,100.9,true,new Date()));
        demoList.add(new User("1232","sky",23,100.9,true,new Date()));
        demoList.add(new User("1233","sky",23,100.9,true,new Date()));
        demoList.add(new User("1234","sky",23,100.9,true,new Date()));
        demoList.add(new User("1235","sky",23,100.9,true,new Date()));
        demoList.add(new User("1231","sky",23,100.9,true,new Date()));
        demoList.add(new User("1232","sky",23,100.9,true,new Date()));
        demoList.add(new User("1233","sky",23,100.9,true,new Date()));
        demoList.add(new User("1234","sky",23,100.9,true,new Date()));
        demoList.add(new User("1235","sky",23,100.9,true,new Date()));
        demoList.add(new User("1231","sky",23,100.9,true,new Date()));
        demoList.add(new User("1232","sky",23,100.9,true,new Date()));
        demoList.add(new User("1233","sky",23,100.9,true,new Date()));
        demoList.add(new User("1234","sky",23,100.9,true,new Date()));
        demoList.add(new User("1235","sky",23,100.9,true,new Date()));
        demoList.add(new User("1231","sky",23,100.9,true,new Date()));
        demoList.add(new User("1232","sky",23,100.9,true,new Date()));
        demoList.add(new User("1233","sky",23,100.9,true,new Date()));
        demoList.add(new User("1234","sky",23,100.9,true,new Date()));
        demoList.add(new User("1235","sky",23,100.9,true,new Date()));

        int start = (page - 1) * 2;
        int end = start + size;
        List<User> subList = demoList.subList(start, end);
        int totalPage = (int) Math.ceil(demoList.size() / size);
        map.put("productInfoPage", subList);
        map.put("totalPage", totalPage);
        map.put("currentPage", page);
        map.put("size", size);
        return "Page";
    }






    @RequestMapping(value="/list")
    public String list(User user,ModelMap map) {
        List<User> userList = new ArrayList<User>();
        User u = new User("123","sky",23,100.9,true,new Date());
        User u2 = new User("124","sky",23,100.9,true,new Date());
        User u3 = new User("125","sky",23,100.9,true,new Date());
        userList.add(u);
        userList.add(u2);
        userList.add(u3);
        map.put("user", userList);
        return "User";
    }
    // delete
    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id")String id,HttpServletResponse response,ModelMap map) {
        System.out.printf("删除成功！");
        try {
            response.sendRedirect("/list");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value="/addForm")
    public String addForm() {
        return "AddForm";
    }
    @RequestMapping(value="/add",method = RequestMethod.POST)
    public String add(User user, ModelMap map) {
        map.put("link","/list");
       return "Success";
    }






    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
