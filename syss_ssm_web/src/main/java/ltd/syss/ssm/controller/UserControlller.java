package ltd.syss.ssm.controller;

import ltd.syss.ssm.domain.Role;
import ltd.syss.ssm.domain.UserInfo;
import ltd.syss.ssm.service.IRoleService;
import ltd.syss.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
@Controller
@RequestMapping("/user")
public class UserControlller extends Exception{

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    //查询指定id的用户
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception{
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show1");
        return mv;
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userList = userService.findAll();
        mv.addObject("userList", userList);
        mv.setViewName("user-list");
        return mv;
    }


    //用户添加
    @RequestMapping("/save.do")
    public String save(UserInfo userInfo) throws Exception {
        userService.save(userInfo);
        return "redirect:findAll.do";
    }

    /*用户管理-添加角色，回显用户没有的角色*/
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id", required = true)  String userId) throws Exception{
        UserInfo user = userService.findById(userId);
        List<Role> roleList = roleService.findOtherRole(userId);

        ModelAndView mv = new ModelAndView();
        mv.addObject("user",user);
        mv.addObject("roleList",roleList);
        mv.setViewName("user-role-add");
        return mv;
    }
    /*用户添加角色业务*/
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId" , required = true) String userId,
                                @RequestParam(name = "roleIds" , required = true) String[] roleIds) throws Exception{

        userService.addRoleToUser(userId,roleIds);
        return "redirect:findAll.do";
    }

}
