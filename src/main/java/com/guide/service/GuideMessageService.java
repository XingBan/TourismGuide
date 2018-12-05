package com.guide.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guide.bean.Count;
import com.guide.bean.Guide;
import com.guide.bean.GuideAward;
import com.guide.bean.GuideAwardExample;
import com.guide.bean.GuideAwardExample.Criteria;
import com.guide.dao.GuideAwardMapper;
import com.guide.dao.GuideMapper;
import com.guide.po.GuideSearchPo;

@Service
public class GuideMessageService {

	@Autowired
	GuideMapper guideMapper;
	
	@Autowired
	GuideAwardMapper guideAwardMapper;
	/**
	 * 查询所有金牌导游
	 * @return
	 */
	public List<Guide> getAll() {
		// TODO Auto-generated method stub
		return guideMapper.selectByExample(null);
	}
	/**
	 * 通过姓名查询导游
	 * @param guideName
	 * @return
	 */
	public List<Guide> getGuideByName(String guideName) {
		// TODO Auto-generated method stub
		List<Guide> guides = guideMapper.getGuideByName(guideName);
		return guides;
	}
	/**
	 * 插入导游
	 * @param guide
	 */
	public void insertGuide(Guide guide) {
		// TODO Auto-generated method stub
		guideMapper.insertSelective(guide);
	}
	/**
	 * 通过id获取导游
	 */
	public Guide getGuideById(Integer guideId) {
		// TODO Auto-generated method stub
		Guide guide = guideMapper.selectByPrimaryKey(guideId);
		return guide;
	}
	/**
	 * 通过导游id获取导游获奖信息
	 * @param guideId
	 * @return
	 */
	public List<GuideAward> getGuideAwardbyId(Integer guideId) {
		// TODO Auto-generated method stub
		List<GuideAward> guideAwards = guideAwardMapper.selectGuideAwardById(guideId);
		return guideAwards;
	}
	/**
	 * 更新导游
	 * @param guide
	 */
	public void updateGuide(Guide guide) {
		// TODO Auto-generated method stub
		System.out.println(guide);
		guideMapper.updateByPrimaryKeySelective(guide);
	}
	/**
	 * 删除导游
	 * @param id
	 */
	public void deleteGuide(Integer id) {
		// TODO Auto-generated method stub
		guideMapper.deleteByPrimaryKey(id);
	}
	/**
	 * 通过id获取获奖信息
	 * @param guideAwardId
	 * @return
	 */
	public GuideAward getguideAwardbyguideId(Integer guideAwardId) {
		// TODO Auto-generated method stub
		GuideAward guideAward = guideAwardMapper.selectByPrimaryKey(guideAwardId);
		return guideAward;
	}
	/**
	 * 更新获奖信息
	 * @param guideAward
	 */
	public void updateGuideAward(GuideAward guideAward) {
		// TODO Auto-generated method stub
		guideAwardMapper.updateByPrimaryKeySelective(guideAward);
	}
	/**
	 * 插入获奖信息
	 * @param guideAward
	 */
	public void insertGuideAward(GuideAward guideAward) {
		// TODO Auto-generated method stub
		guideAwardMapper.insert(guideAward);
	}
	/**
	 * 删除获奖信息
	 * @param id
	 */
	public void deleteGuideAwrad(Integer id) {
		// TODO Auto-generated method stub
		guideAwardMapper.deleteByPrimaryKey(id);
	}
	/**
	 * 批量删除
	 * @param del_ids
	 */
	public void deleteGuideAwradBatch(List<Integer> del_ids) {
		// TODO Auto-generated method stub
		GuideAwardExample guideAwardExample = new GuideAwardExample();
		Criteria criteria = guideAwardExample.createCriteria();
		criteria.andGuideAwardIdIn(del_ids);
		guideAwardMapper.deleteByExample(guideAwardExample);
	}
	/**
	 * 按年龄分布
	 * @return
	 */
	public List<Count> selectcount() {
		// TODO Auto-generated method stub
		List<Count> list = guideMapper.selectcount();
		return list;
	}
	/**
	 * 按性别分布
	 * @return
	 */
	public List<Count> selectsex() {
		// TODO Auto-generated method stub
		List<Count> list = guideMapper.selectsex();
		return list;
	}
	/**
	 * 按城市分布
	 * @return
	 */
	public List<Count> selectcity() {
		// TODO Auto-generated method stub
		List<Count> list = guideMapper.selectcity();
		return list;
	}
	public List<Guide> getGuideByNSCE(GuideSearchPo po) {
		// TODO Auto-generated method stub
		List<Guide> list = guideMapper.getGuideByNSCE(po);
		return list;
	}

}
