package com.guide.dao;

import com.guide.bean.Commentator;
import com.guide.bean.CommentatorExample;
import com.guide.bean.Count;
import com.guide.bean.Guide;
import com.guide.po.CommentatorSearchPo;
import com.guide.po.GuideSearchPo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentatorMapper {
	long countByExample(CommentatorExample example);

	int deleteByExample(CommentatorExample example);

	int deleteByPrimaryKey(Integer commentatorId);

	int insert(Commentator record);

	int insertSelective(Commentator record);

	List<Commentator> selectByExample(CommentatorExample example);

	Commentator selectByPrimaryKey(Integer commentatorId);

	int updateByExampleSelective(@Param("record") Commentator record, @Param("example") CommentatorExample example);

	int updateByExample(@Param("record") Commentator record, @Param("example") CommentatorExample example);

	int updateByPrimaryKeySelective(Commentator record);

	int updateByPrimaryKey(Commentator record);
	
	List<Commentator> getCommentatorByNSCE(CommentatorSearchPo po);

	List<Commentator> getCommentatorByName(@Param("commentatorName") String commentatorName);

	List<Count> selectcount();

	List<Count> selectsex();

	List<Count> selectcity();
}