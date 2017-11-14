package com.app.web;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.app.common.model.Experience;
import com.app.common.model.User;
import com.app.common.model.param.ExperienceListParam;
import com.app.common.model.response.ExperienceResponse;
import com.app.common.util.FileUtil;
import com.app.common.util.TimeUtil;
import com.app.service.ExperienceService;

import springfox.documentation.annotations.ApiIgnore;

/**
 * 心得控制层
 * @author mt
 *
 */
@Controller
@RequestMapping(value = "")
public class ExperienceController {

	private final Logger log = LoggerFactory.getLogger(ExperienceController.class);
	
	@Value("${experience.filepath:/experience}")
	private String filepath;
	
	@Autowired
	private ExperienceService experienceService;
/*
	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<WxUser>> getAll() {
		log.debug("REST request to get all Users");
		return new ResponseEntity<>(wxUserMapper.selectAll(), HttpStatus.OK);
	}*/
	
	
	/**
	 * 上传心得（文件和输入内容合并，因为ios访问不到文件系统，只能访问照片）
	 * @param file
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "fileUpload", method = RequestMethod.POST)
	public String fileUpLoad(Model model,@RequestParam(value = "file") MultipartFile file,String contentText,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		Subject currentUser = SecurityUtils.getSubject();  
		 User user = (User) currentUser.getSession().getAttribute("user");
		 String filePathDetail="";
		try {
			if(file.isEmpty()){
				//如果未上传文件，则保存输入内容至username+time.txt文件中数据库中保存文件存放路径
				if(StringUtils.isEmpty(contentText)){//输入内容为空，直接提示出错
					model.addAttribute("fileUploadMsg", "上传内容为空，请至少传一项内容");
					model.addAttribute("contentText", contentText);
					return "fileUploadPage";
				}else{
					filePathDetail = filepath+File.separator+user.getUsername();
					//写入文件
//					FileUtil.WriteStringToFile(filePathDetail,user.getUsername()+TimeUtil.getCurrentTime()+".doc",contentText);
					FileUtil.createDoc(filePathDetail,user.getUsername()+TimeUtil.getCurrentTime()+".doc",contentText);
					Experience experience = new Experience();
					experience.setAddtime(new Date());
					experience.setContent("心得体会");
					experience.setFileurl(filePathDetail+File.separator+user.getUsername()+TimeUtil.getCurrentTime()+".doc");
					experience.setUserId(user.getId());
					experienceService.addExperience(experience);
				}
			}else{
				filePathDetail = filepath+File.separator+user.getUsername();
				FileUtil.isToFile(file.getInputStream(),new File(filePathDetail),user.getUsername()+TimeUtil.getCurrentTime()+file.getOriginalFilename(),contentText);
				//暂时不合并
				/*if(!StringUtils.isEmpty(contentText)){
					FileUtil.WriteStringToFile(filePathDetail,user.getUsername()+TimeUtil.getCurrentTime()+file.getOriginalFilename(),contentText);
				}*/
				Experience experience = new Experience();
				experience.setAddtime(new Date());
				experience.setContent(file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf(".")));
				experience.setFileurl(filePathDetail+File.separator+user.getUsername()+TimeUtil.getCurrentTime()+file.getOriginalFilename());
				experience.setUserId(user.getId());
				experienceService.addExperience(experience);
			}
			
		} catch (Exception e) {
			log.error("文件上传失败！错误原因：{}",e.getMessage());
			model.addAttribute("fileUploadMsg", "文件上传失败");
			model.addAttribute("contentText", contentText);
			return "fileUploadPage";
		}
		return "experienceList";
	}
	
	/**
	 * 加载心得数据
	 * @param experienceListParam
	 * @return
	 */
	@RequestMapping(value = "listAllByPage", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<ExperienceResponse> listAllByPage(ExperienceListParam experienceListParam){
		return experienceService.listAllByPage(experienceListParam);
	}
	
	@ApiIgnore
	@RequestMapping(value = "expDownload", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public ResponseEntity<byte[]> download( @ModelAttribute Experience experience,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		File file = new File(experience.getFileurl());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_EVENT_STREAM); // 二进制流
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);

	}
	
	/**
	 * 删除心得
	 * @param experienceListParam
	 * @return
	 */
	@RequestMapping(value = "deletExperience", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public Map<String,Object> deletExperience(Experience experience){
		int deleteExperience = experienceService.deleteExperience(experience);
		Map<String,Object> map=new HashMap<String,Object>();
		if(deleteExperience>0){
			map.put("flag", true);
		}else{
			map.put("flag", false);
		}
		return map;
	}

}
