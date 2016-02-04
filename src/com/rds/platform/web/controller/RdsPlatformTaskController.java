package com.rds.platform.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.Setter;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.rds.code.utils.PropertiesUtils;
import com.rds.code.utils.syspath.ConfigPath;
import com.rds.code.utils.web.RequestUtils;
import com.rds.platform.model.RdsPlatformTaskFeedBackModel;
import com.rds.platform.model.RdsPlatformTaskMainModel;
import com.rds.platform.model.RdsPlatformTaskSubModel;
import com.rds.platform.service.RdsPlatformTaskService;
import com.rds.platform.web.common.PageUtil;

@Controller
@RequestMapping("platform/task")
public class RdsPlatformTaskController {
	
	@Setter
	@Autowired
	private RdsPlatformTaskService rdsPlatformTaskService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformgsubs")
	@ResponseBody
	public Object queryPlatformSubTasks(HttpServletRequest request) throws Exception{
		Map<String, String> param = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformTaskService.queryPlatformSubTasks(param);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformmaintaskspage")
	@ResponseBody
	public Object queryPlatformMainTasksPage(HttpServletRequest request) throws Exception{
		Map<String, String> params = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformTaskService.queryPlatformMainTasksPage(PageUtil.pageSet(params));
		return result;
	}
	
	@RequestMapping("updatemaintask")
	@ResponseBody
	public Object updateMainTask(RdsPlatformTaskMainModel model){
		return rdsPlatformTaskService.updateMainTask(model);
	}
	
	@RequestMapping("deletemaintask")
	@ResponseBody
	public Object deleteMainTask(@RequestParam String ids){
		return rdsPlatformTaskService.deleteMainTask(ids);
	}
	
	@RequestMapping("updatemaintaskapproval")
	@ResponseBody
	public Object updateApproval(RdsPlatformTaskMainModel model){
		return rdsPlatformTaskService.updateMainTaskApproval(model);
	}
	
	@RequestMapping("updatesubtask")
	@ResponseBody
	public Object updateSubTask(RdsPlatformTaskSubModel model){
		return rdsPlatformTaskService.updateSubTask(model);
	}
	
	@RequestMapping("updatesubscomplete")
	@ResponseBody
	public Object updateSubsComplete(@RequestParam String ids,@RequestParam String userid){
		return rdsPlatformTaskService.updateSubsComplete(ids,userid);
	}
	
	@RequestMapping(value = "upload", method = RequestMethod.POST)
	// @ResponseBody
	public void create(RdsPlatformTaskFeedBackModel model,
			HttpServletResponse response) throws IOException {
		
		if(model.getFile().getSize()!=0){
			String init_path = ConfigPath.getWebInfPath() + "spring"
					+ File.separator + "properties" + File.separator
					+ "init.properties";
			String uploadfiles = PropertiesUtils
					.readValue(init_path, "uploadfiles");
	
			CommonsMultipartFile file = model.getFile();
			InputStream inputStream = file.getInputStream();
			String filepath = uploadfiles + File.separator
					+ file.getOriginalFilename();
			this.inputstreamtofile(inputStream, new File(filepath));
			
			
	
	//		Map<String, Object> params = new HashMap<String, Object>();
			model.setFilepath(filepath);
			model.setFilename(file.getFileItem().getName());
		}else{
			model.setFilepath("");
		}

		Object result = rdsPlatformTaskService.updateTaskFeedBack(model);
		response.setContentType("text/html");
		response.getWriter().write(JSONObject.fromObject(result).toString());
		response.flushBuffer();

	}
	
	private void inputstreamtofile(InputStream ins, File file)
			throws IOException {
		OutputStream os = new FileOutputStream(file);
		int bytesRead = 0;
		byte[] buffer = new byte[8192];
		while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
			os.write(buffer, 0, bytesRead);
		}
		os.close();
		ins.close();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformtaskfeedback")
	@ResponseBody
	public Object queryPlatformTaskFeedBack(HttpServletRequest request) throws Exception{
		Map<String, String> param = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformTaskService.queryPlatformTaskFeedBack(param);
		return result;
	}
	
	@RequestMapping("updatesure")
	@ResponseBody
	public Object updateSure(@RequestParam String ids){
		return rdsPlatformTaskService.updateSure(ids);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformgsubsbyuser")
	@ResponseBody
	public Object queryPlatformSubTasksByUser(HttpServletRequest request) throws Exception{
		Map<String, String> param = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformTaskService.queryPlatformSubTasksByUser(param);
		return result;
	}
}
