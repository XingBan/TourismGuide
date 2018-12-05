package com.guide.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guide.bean.Msg;
import com.guide.bean.User;
import com.guide.service.UserService;
import com.guide.utils.MD5Util;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	/**
	 * 登陆操作
	 * @param request
	 * @param aUser
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/login_to", method = RequestMethod.POST)
	public Msg login(HttpServletRequest request, User aUser) {
		request.getSession().invalidate();
		System.out.println("执行了login ");
		//System.out.println(MD5Util.encrypt(aUser.getUserName()));
		//System.out.println(MD5Util.encrypt(aUser.getUserPwd()));
		User user = userService.findByUp(aUser.getUserName(), aUser.getUserPwd());
		System.out.println("userController:" + user);
		if (user != null) {
			request.getSession().setAttribute("username", user.getUserName());
			request.getSession().setAttribute("userpower", user.getUserPower());
			request.getSession().setAttribute("userid", user.getUserId());
			request.getSession().setAttribute("userpwd", user.getUserPwd());
			request.getSession().setMaxInactiveInterval(-1);
			return Msg.success().add("user", user).add("message", "登录成功!");

		} else {
			return Msg.fail().add("message", "登录失败!");
		}
	}
	
	/**
	 * id搜索用户
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/getuserbyid/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Msg selectUserById(@PathVariable("id")Integer id){
		System.out.println("id:" + id);
		User user = userService.findUserById(id);
		System.out.println("user:" + user);
		return Msg.success().add("user", user);
	}

	/**
	 * 获取所有用户
	 * @return
	 */
	@RequestMapping("/getuser")
	@ResponseBody
	public Msg getAllUser(@RequestParam(value="pn",defaultValue="1") Integer pn
			,HttpServletRequest request) {
		//System.out.println("执行了1");
		PageHelper.startPage(pn,5);
		List<User> user = userService.getUser();
		
		PageInfo pageInfo = new PageInfo(user,5);
		return Msg.success().add("users", pageInfo);

	}
	/**
	 * 检查用户名是否可用
	 * @param userName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkuser")
	public Msg checkuser(@RequestParam("userName")String userName){
		
		//数据库用户名重复校验
		boolean b = userService.checkUser(userName);
		if(b){
			return Msg.success();
		}else{
			return Msg.fail().add("va_msg", "用户名不可用");
		}
	}
	/**
	 * 插入用户
	 */
	@ResponseBody
	@RequestMapping(value="/insertuser",method=RequestMethod.POST)
	public Msg insertUser(User user){
		userService.saveUser(user);
		return Msg.success();
	}
	/**
	 * 更新用户
	 */
	@ResponseBody
	@RequestMapping(value="/updateuser/{userId}",method=RequestMethod.PUT)
	public Msg saveUser(User user){
		//System.out.println("请求体中的值："+request.getParameter("gender"));
		//System.out.println("将要更新的员工数据："+employee);
		userService.updateUser(user);
		return Msg.success();
	}
	/**
	 * 单个批量二合一
	 * 批量删除：1-2-3
	 * 单个删除：1
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/deluser/{ids}",method=RequestMethod.DELETE)
	public Msg deleteUser(@PathVariable("ids")String ids){
		//批量删除
		if(ids.contains("-")){
			List<Integer> del_ids = new ArrayList<Integer>();
			String[] str_ids = ids.split("-");
			//组装id的集合
			for (String string : str_ids) {
				del_ids.add(Integer.parseInt(string));
			}
			userService.deleteBatch(del_ids);
		}else{
			Integer id = Integer.parseInt(ids);
			userService.deleteUser(id);
		}
		return Msg.success();
	}
	/**
	 * 登陆成功跳转
	 * @return
	 */
	@RequestMapping("/login_success")
	public String turnToMain(){
		return "/welcome/index";
	}
	/**
	 * 退出登录
	 */
	@ResponseBody
	@RequestMapping("/login_out")
	public Msg loginout(HttpServletRequest request){
		request.getSession().invalidate();
		return Msg.success();
	}
}
