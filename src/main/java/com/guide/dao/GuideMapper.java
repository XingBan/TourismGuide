package com.guide.dao;

import com.guide.bean.Count;
import com.guide.bean.Guide;
import com.guide.bean.GuideExample;
import com.guide.po.GuideSearchPo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GuideMapper {
    long countByExample(GuideExample example);

    int deleteByExample(GuideExample example);

    int deleteByPrimaryKey(Integer guideId);

    int insert(Guide record);

    int insertSelective(Guide record);

    List<Guide> selectByExample(GuideExample example);

    Guide selectByPrimaryKey(Integer guideId);

    int updateByExampleSelective(@Param("record") Guide record, @Param("example") GuideExample example);

    int updateByExample(@Param("record") Guide record, @Param("example") GuideExample example);

    int updateByPrimaryKeySelective(Guide record);

    int updateByPrimaryKey(Guide record);
    
    List<Guide> getGuideByNSCE(GuideSearchPo po);
    
    List<Guide> getGuideByName(@Param("guideName") String guideName);
    
    List<Count> selectcount();
    
    List<Count> selectsex();
    
    List<Count> selectcity();
}