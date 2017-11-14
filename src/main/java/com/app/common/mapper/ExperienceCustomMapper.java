package com.app.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.app.common.model.Experience;
import com.app.common.model.response.ExperienceResponse;

import tk.mybatis.mapper.common.Mapper;

/**
 * 多表关联查询
 * @author mt
 *
 */
public interface ExperienceCustomMapper extends Mapper<Experience> {
	List<ExperienceResponse> listExperience(@Param("userId")String userId);
}