package com.guide.dao;

import com.guide.bean.GuideAward;
import com.guide.bean.GuideAwardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GuideAwardMapper {
    long countByExample(GuideAwardExample example);

    int deleteByExample(GuideAwardExample example);

    int deleteByPrimaryKey(Integer guideAwardId);

    int insert(GuideAward record);

    int insertSelective(GuideAward record);

    List<GuideAward> selectByExample(GuideAwardExample example);
    
    List<GuideAward> selectGuideAwardById(@Param("guideId") Integer guideId);

    GuideAward selectByPrimaryKey(Integer guideAwardId);

    int updateByExampleSelective(@Param("record") GuideAward record, @Param("example") GuideAwardExample example);

    int updateByExample(@Param("record") GuideAward record, @Param("example") GuideAwardExample example);

    int updateByPrimaryKeySelective(GuideAward record);

    int updateByPrimaryKey(GuideAward record);
}