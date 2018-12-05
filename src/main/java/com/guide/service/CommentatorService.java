package com.guide.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guide.bean.Commentator;
import com.guide.bean.CommentatorAward;
import com.guide.bean.CommentatorAwardExample;
import com.guide.bean.CommentatorAwardExample.Criteria;
import com.guide.bean.Count;
import com.guide.dao.CommentatorAwardMapper;
import com.guide.dao.CommentatorMapper;
import com.guide.po.CommentatorSearchPo;


@Service
public class CommentatorService {

	@Autowired
	CommentatorMapper commentatorMapper;
	
	@Autowired
	CommentatorAwardMapper commentatorAwardMapper;
	/**
	 * 查询所有金牌讲解员
	 * @return
	 */
	public List<Commentator> getAll() {
		// TODO Auto-generated method stub
		return commentatorMapper.selectByExample(null);
	}
	/**
	 * 通过姓名查询讲解员
	 * @param commentatorName
	 * @return
	 */
	public List<Commentator> getcommentatorByName(String commentatorName) {
		// TODO Auto-generated method stub
		System.out.println("commentatorName:Service:"+commentatorName);
		List<Commentator> commentators = commentatorMapper.getCommentatorByName(commentatorName);
		System.out.println("commentators:Service:"+commentators);
		return commentators;
	}
	/**
	 * 插入讲解员
	 * @param commentator
	 */
	public void insertcommentator(Commentator commentator) {
		// TODO Auto-generated method stub
		commentatorMapper.insertSelective(commentator);
	}
	/**
	 * 通过id获取讲解员
	 * @param commentatorId
	 * @return
	 */
	public Commentator getcommentatorById(Integer commentatorId) {
		// TODO Auto-generated method stub
		Commentator commentator = commentatorMapper.selectByPrimaryKey(commentatorId);
		return commentator;
	}
	/**
	 * 通过讲解员id获取讲解员获奖信息
	 * @param commentatorId
	 * @return
	 */
	public List<CommentatorAward> getcommentatorAwardbyId(Integer commentatorId) {
		// TODO Auto-generated method stub
		List<CommentatorAward> commentatorAwards = commentatorAwardMapper.selectCommentatorAwardById(commentatorId);
		return commentatorAwards;
	}
	/**
	 * 更新讲解员
	 * @param commentator
	 */
	public void updatecommentator(Commentator commentator) {
		// TODO Auto-generated method stub
		System.out.println(commentator);
		commentatorMapper.updateByPrimaryKeySelective(commentator);
	}
	/**
	 * 删除讲解员
	 * @param id
	 */
	public void deletecommentator(Integer id) {
		// TODO Auto-generated method stub
		commentatorMapper.deleteByPrimaryKey(id);
	}
	public CommentatorAward getcommentatorAwardbycommentatorId(Integer commentatorAwardId) {
		// TODO Auto-generated method stub
		CommentatorAward commentatorAward = commentatorAwardMapper.selectByPrimaryKey(commentatorAwardId);
		return commentatorAward;
	}
	public void updatecommentatorAward(CommentatorAward commentatorAward) {
		// TODO Auto-generated method stub
		commentatorAwardMapper.updateByPrimaryKeySelective(commentatorAward);
	}
	public void insertcommentatorAward(CommentatorAward commentatorAward) {
		// TODO Auto-generated method stub
		commentatorAwardMapper.insert(commentatorAward);
	}
	public void deletecommentatorAwrad(Integer id) {
		// TODO Auto-generated method stub
		commentatorAwardMapper.deleteByPrimaryKey(id);
	}
	public void deletecommentatorAwradBatch(List<Integer> del_ids) {
		// TODO Auto-generated method stub
		CommentatorAwardExample commentatorAwardExample = new CommentatorAwardExample();
		Criteria criteria = commentatorAwardExample.createCriteria();
		criteria.andCommentatorAwardIdIn(del_ids);
		commentatorAwardMapper.deleteByExample(commentatorAwardExample);
	}
	public List<Count> selectcount() {
		// TODO Auto-generated method stub
		List<Count> list = commentatorMapper.selectcount();
		return list;
	}
	public List<Count> selectsex() {
		// TODO Auto-generated method stub
		List<Count> list = commentatorMapper.selectsex();
		return list;
	}
	public List<Count> selectcity() {
		// TODO Auto-generated method stub
		List<Count> list = commentatorMapper.selectcity();
		return list;
	}
	public List<Commentator> getcommentatorByNSCE(CommentatorSearchPo searchPo) {
		// TODO Auto-generated method stub3
		List<Commentator> list = commentatorMapper.getCommentatorByNSCE(searchPo);
		return list;
	}
}
