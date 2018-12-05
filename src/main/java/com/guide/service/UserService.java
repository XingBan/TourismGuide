package com.guide.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guide.bean.User;
import com.guide.bean.UserExample;
import com.guide.bean.UserExample.Criteria;
import com.guide.dao.UserMapper;

@Service
public class UserService{

	@Autowired
	UserMapper userMapper;
	
	public User findByUp(String userName, String userPwd) {
		System.out.println("userName:"+userName);
		System.out.println("userpwd:"+userPwd);
		
		//xiamian de mieyou zhixingdao
		User user = userMapper.selectByUserPwd(userName, userPwd);
		System.out.println("user:"+user);
		
		return user;
	}

	public List<User> getUser() {
		// TODO Auto-generated method stub
		
		List<User> users = userMapper.selectByExample(null);
		return users;
	}

	public User findUserById(Integer id) {
		System.out.println("id2:" + id);
		User user = userMapper.selectByPrimaryKey(id);
		System.out.println("user2:" + user);
		return user;
	}

	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userMapper.insert(user);
	}

	public boolean checkUser(String userName) {
		// TODO Auto-generated method stub
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(userName);
		long count = userMapper.countByExample(example);
		return count == 0;
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userMapper.updateByPrimaryKeySelective(user);
		
	}

	public void deleteBatch(List<Integer> del_ids) {
		// TODO Auto-generated method stub
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdIn(del_ids);
		userMapper.deleteByExample(example);
		
	}

	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		userMapper.deleteByPrimaryKey(id);
	}

}
