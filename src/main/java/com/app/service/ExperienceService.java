package com.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.common.mapper.ExperienceCustomMapper;
import com.app.common.mapper.ExperienceMapper;
import com.app.common.model.Experience;
import com.app.common.model.param.ExperienceListParam;
import com.app.common.model.response.ExperienceResponse;
import com.app.common.util.PageUtil;

/**
 * 心得service
 * @author mt
 *
 */
@Service
public class ExperienceService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ExperienceMapper experienceMapper;
	
	@Autowired
	private ExperienceCustomMapper experienceCustomMapper;
	
	/**
	 * 新增心得
	 * @param experience
	 * @return
	 */
	public int addExperience(Experience experience){
		return experienceMapper.insertSelective(experience);
	}
	
	/**
	 * 获取心得列表
	 * @param experienceListParam
	 * @return
	 */
	public List<ExperienceResponse> listAllByPage(ExperienceListParam experienceListParam){
		PageUtil.startPage(experienceListParam);
		List<ExperienceResponse> listExperience = experienceCustomMapper.listExperience(experienceListParam.getUserId());
		return listExperience;
		/*Example example = new Example(Experience.class);
		Criteria criteria = example.createCriteria();
		if(StringUtil.isEmpty(experienceListParam.getUserId())){
			criteria.andEqualTo(Experience.JavaFieldEnum.userId.name(), experienceListParam.getUserId());
		}
		example.setOrderByClause(Experience.JavaFieldEnum.addtime.name() + " desc");
		List<Experience> selectByExample = experienceMapper.selectByExample(example);
		return selectByExample;*/
	}
	
	/**
	 * 删除心得
	 * @param experience
	 * @return
	 */
	public int deleteExperience(Experience experience){
		return experienceMapper.deleteByPrimaryKey(experience.getId());
	}
	
}
