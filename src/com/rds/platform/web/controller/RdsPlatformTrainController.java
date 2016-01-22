package com.rds.platform.web.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
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
import com.rds.platform.model.RdsPlatformTrainModel;
import com.rds.platform.model.common.RdsPlatformFileUploadModel;
import com.rds.platform.service.RdsPlatformTrainService;
import com.rds.platform.web.common.PageUtil;

@Controller
@RequestMapping("platform/train")
public class RdsPlatformTrainController {

	@Setter
	@Autowired
	private RdsPlatformTrainService rdsPlatformTrainService;

	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformtrains")
	@ResponseBody
	public Object queryPlatformTrains(HttpServletRequest request)
			throws Exception {
		Map<String, String> param = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformTrainService.queryPlatformTrains(param);
		return result;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformtrainspage")
	@ResponseBody
	public Object queryPlatformTrainsPage(HttpServletRequest request)
			throws Exception {
		Map<String, String> params = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformTrainService
				.queryPlatformTrainsPage(PageUtil.pageSet(params));
		return result;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("queryplatformtrainfiles")
	@ResponseBody
	public Object queryPlatformTrainFiles(HttpServletRequest request)
			throws Exception {
		Map<String, String> params = RequestUtils.form(request, HashMap.class);
		Object result = rdsPlatformTrainService
				.queryPlatformTrainFiles(PageUtil.pageSet(params));
		return result;
	}

	@RequestMapping("update")
	@ResponseBody
	public Object update(RdsPlatformTrainModel train) {
		return rdsPlatformTrainService.update(train);
	}

	@RequestMapping("delete")
	@ResponseBody
	public Object delete(@RequestParam String ids) {
		return rdsPlatformTrainService.delete(ids);
	}

	@RequestMapping(value = "upload", method = RequestMethod.POST)
	// @ResponseBody
	public void create(RdsPlatformFileUploadModel uploadItem,
			HttpServletResponse response) throws IOException {
		String init_path = ConfigPath.getWebInfPath() + "spring"
				+ File.separator + "properties" + File.separator
				+ "init.properties";
		String uploadfiles = PropertiesUtils
				.readValue(init_path, "uploadfiles");

		CommonsMultipartFile file = uploadItem.getFile();
		InputStream inputStream = file.getInputStream();
		String filepath = uploadfiles + File.separator
				+ file.getOriginalFilename();
		this.inputstreamtofile(inputStream, new File(filepath));

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("path", filepath);
		params.put("tid", uploadItem.getTid());
		params.put("filename", uploadItem.getFilename());

		Object result = rdsPlatformTrainService.insertTrainFile(params);
		response.setContentType("text/html");
		response.getWriter().write(JSONObject.fromObject(result).toString());
		response.flushBuffer();

	}

	/**
	 * @author:limingzhong
	 * @throws:IOException
	 * @desc:下载文件
	 * @params:fileName-文件名称
	 * @Date:2012-02-28
	 */
	@RequestMapping(value = "down",method=RequestMethod.GET)
	public void down(@RequestParam("path") String path,
			@RequestParam("path") String filename, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		filename = URLDecoder.decode(filename, "utf-8");
		path = path.replace("%20", " ");
		File file = new File(path);

		// 清空response
		response.reset();

		// 设置response的Header
		response.addHeader("Content-Disposition", "attachment;filename="
				+ new String(filename.getBytes("gbk"), "iso8859-1"));
		response.addHeader("Content-Length", "" + file.length());

		try {
			// 以流的形式下载文件
			InputStream fis = new BufferedInputStream(new FileInputStream(path));
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();

			OutputStream toClient = new BufferedOutputStream(
					response.getOutputStream());
			toClient.write(buffer);
			toClient.flush();
			toClient.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
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

}
