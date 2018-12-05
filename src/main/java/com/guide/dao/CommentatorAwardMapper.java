package com.guide.dao;

import com.guide.bean.CommentatorAward;
import com.guide.bean.CommentatorAwardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentatorAwardMapper {
    long countByExample(CommentatorAwardExample example);

    int deleteByExample(CommentatorAwardExample example);

    int deleteByPrimaryKey(Integer commentatorAwardId);

    int insert(CommentatorAward record);

    int insertSelective(CommentatorAward record);

    List<CommentatorAward> selectByExample(CommentatorAwardExample example);
    
    List<CommentatorAward> selectCommentatorAwardById(@Param("commentatorId") Integer commentatorId);

    CommentatorAward selectByPrimaryKey(Integer commentatorAwardId);

    int updateByExampleSelective(@Param("record") CommentatorAward record, @Param("example") CommentatorAwardExample example);

    int updateByExample(@Param("record") CommentatorAward record, @Param("example") CommentatorAwardExample example);

    int updateByPrimaryKeySelective(CommentatorAward record);

    int updateByPrimaryKey(CommentatorAward record);
}