package com.guide.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guide.bean.Count;
import com.guide.bean.Guide;
import com.guide.bean.GuideAward;
import com.guide.bean.Msg;
import com.guide.po.GuideSearchPo;
import com.guide.service.GuideMessageService;
import com.guide.utils.ImportExcelUtil;

@Controller
@RequestMapping("/guide")
public class GuideMessageController {

	@Autowired
	GuideMessageService guideMessageService;
	private String originalFilename = null;

	/**
	 * 获取所有金牌导游
	 * 
	 * @param pn
	 * @return
	 */
	@RequestMapping("/getguide")
	@ResponseBody
	public Msg getAllGuide(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		// 引入分页插件
		PageHelper.startPage(pn, 5);
		List<Guide> list = guideMessageService.getAll();
		PageInfo page = new PageInfo(list, 5);
		return Msg.success().add("guide", page);

	}

	/**
	 * 通过名字检索金牌导游
	 * 
	 * @param pn
	 * @param guideName
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/getguidebyname", method = RequestMethod.GET)
	@ResponseBody
	public Msg getGuideByName(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam("guideName") String guideName) throws UnsupportedEncodingException {
		guideName = new String(guideName.getBytes("ISO-8859-1"), "UTF-8");
		PageHelper.startPage(pn, 5);
		System.out.println("guideName:Controller:" + guideName);
		List<Guide> guides = guideMessageService.getGuideByName(guideName);
		System.out.println("guides:Controller:" + guides);
		if (guides.size() > 0) {
			PageInfo page = new PageInfo(guides, 5);
			return Msg.success().add("guide", page);
		} else {
			return Msg.fail().add("error", "查无此人");
		}
	}

	/**
	 * 添加金牌导游
	 * 
	 * @param guide
	 * @return
	 */
	@RequestMapping(value = "/insertguide", method = RequestMethod.POST)
	@ResponseBody
	public Msg insertGuide(Guide guide) {
		System.out.println(guide.toString());
		guide.setGuideImageUrl(originalFilename);
		System.out.println(guide);
		guideMessageService.insertGuide(guide);
		return Msg.success();

	}

	// 上传excel文件
	/**
	 * 描述：通过传统方式form表单提交方式导入excel文件
	 * 
	 * @param request
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "uploadexcels", method = { RequestMethod.GET, RequestMethod.POST })
	public Msg uploadExcel(HttpServletRequest request) throws Exception {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		InputStream in = null;
		List<List<Object>> listob = null;
		MultipartFile file = multipartRequest.getFile("upfile");
		if (file.isEmpty()) {
			throw new Exception("文件不存在！");
		}
		in = file.getInputStream();
		listob = new ImportExcelUtil().getBankListByExcel(in, file.getOriginalFilename());
		in.close();

		// 该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
		int failcount = 0;
		int successcount = 0;
		int[] failhang = new int[listob.size()];

		// 该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
		for (int i = 0; i < listob.size(); i++) {
			List<Object> lo = listob.get(i);
			Guide guide = new Guide();
			System.out.println(listob.get(i));
			if (lo.size() != 10) {
				// listob.remove(i);
				failcount++;
				for (int j = 0; i < listob.size(); j++) {
					failhang[j] = i;
					System.out.println("出错了：" + "第" + i + "行");
				}
			} else {
				guide.setGuideName(String.valueOf(lo.get(0)));
				guide.setGuideGender(String.valueOf(lo.get(1)));
				guide.setGuideAge(Integer.parseInt(String.valueOf(lo.get(2))));
				guide.setGuideRecord(String.valueOf(lo.get(3)));
				guide.setGuideEducation(String.valueOf(lo.get(4)));
				guide.setGuideIdcard(String.valueOf(lo.get(5)));
				guide.setGuideCity(String.valueOf(lo.get(6)));
				guide.setGuideWorkPlace(String.valueOf(lo.get(7)));
				guide.setGuideWorkPosition(String.valueOf(lo.get(8)));
				guide.setGuideWorkYear(Integer.parseInt(String.valueOf(lo.get(9))));
				guideMessageService.insertGuide(guide);
				System.out.println("姓名：" + guide.getGuideName() + " 性别: " + guide.getGuideGender() + " 年龄："
						+ guide.getGuideAge() + " 导游职称：" + guide.getGuideRecord() + " 学历：" + guide.getGuideEducation()
						+ " 身份证：" + guide.getGuideIdcard() + " 城市：" + guide.getGuideCity() + " 工作地点："
						+ guide.getGuideWorkPlace() + " 工作职位：" + guide.getGuideWorkPosition() + " 工作年龄："
						+ guide.getGuideWorkYear());
				successcount++;
				System.out.println("成功了：第" + successcount + "次");
			}

		}
		// PrintWriter out = null;
		// response.setCharacterEncoding("utf-8"); // 防止ajax接受到的中文信息乱码
		// out = response.getWriter();
		// out.print("文件导入成功！");
		// out.flush();
		// out.close();
		return Msg.success().add("successcount", successcount).add("failcount", failcount).add("failhang", failhang);
	}

	/**
	 * 通过id获取金牌导游
	 * 
	 * @param guideId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getguideid/{guideId}", method = RequestMethod.GET)
	public Msg getGuideById(@PathVariable("guideId") Integer guideId) {

		Guide guide = guideMessageService.getGuideById(guideId);

		return Msg.success().add("guide", guide);
	}

	/**
	 * 获取所有获奖情况
	 */
	@ResponseBody
	@RequestMapping(value = "/getguideAwardbyid/{id}", method = RequestMethod.GET)
	public Msg getGuideAwardbyId(@PathVariable("id") Integer id) {

		List<GuideAward> guideAwards = guideMessageService.getGuideAwardbyId(id);

		return Msg.success().add("guideAwards", guideAwards);
	}

	/**
	 * 上传图片到/img目录下
	 */
	@RequestMapping(value="/uploadimg",method=RequestMethod.POST)
	@ResponseBody
	public Msg uploadImg(@RequestParam("file") MultipartFile file,HttpServletRequest request){
		String path = null;
		if (!file.isEmpty()) {
			try {
				// 文件存放服务端的位置
				Properties prop = new Properties();
				try {
					InputStream in = new BufferedInputStream(new FileInputStream("D:\\sandbox\\TourismGuide\\src\\main\\resources\\upload.properties"));
					prop.load(in);
					/*Iterator<String> it = prop.stringPropertyNames().iterator();
					while (it.hasNext()) {
						String key = it.next();
						path= prop.getProperty(key);
					}*/
					path=prop.getProperty("path");
					in.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				File dir = new File(path);
				if (!dir.exists())
					dir.mkdirs();
				// 写文件到服务器
				File serverFile = new File( dir + File.separator + file.getOriginalFilename());
				file.transferTo(serverFile);
				originalFilename = null;
				originalFilename = file.getOriginalFilename();
				return Msg.success().add("file", file.getOriginalFilename());
			} catch (Exception e) {
				return Msg.success().add("fail", file.getOriginalFilename() + " => " + e.getMessage());
			}
		} else {
			return Msg.success().add("fail", file.getOriginalFilename() + " because the file was empty.");
		}
	}

	/**
	 * 模板下载
	 *
	 */
	@RequestMapping(value = "/download")
	public ResponseEntity<byte[]> download(HttpServletRequest request, @RequestParam("filename") String filename,
			Model model) throws Exception {
		// 下载文件路径
		filename = new String(filename.getBytes("ISO-8859-1"), "UTF-8");
		String path = request.getServletContext().getRealPath("/file/");
		System.out.println(path);
		File file = new File(path + File.separator + "金牌导游导入模板.xlsx");
		HttpHeaders headers = new HttpHeaders();
		// 下载显示的文件名，解决中文名称乱码问题
		String downloadFielName = new String(filename.getBytes("UTF-8"), "iso-8859-1");
		// 通知浏览器以attachment（下载方式）打开图片
		headers.setContentDispositionFormData("attachment", downloadFielName);
		// application/octet-stream ： 二进制流数据（最常见的文件下载）。
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}

	/**
	 * 更新导游
	 */
	@ResponseBody
	@RequestMapping(value = "/updateguide")
	public Msg updateGuide(Guide guide) {
		System.out.println(guide);
		guide.setGuideImageUrl(originalFilename);
		guideMessageService.updateGuide(guide);
		return Msg.success();
	}

	/**
	 * 删除导游by Id
	 */
	@ResponseBody
	@RequestMapping(value = "/delguide/{id}", method = RequestMethod.DELETE)
	public Msg deleteGuide(@PathVariable("id") Integer id) {
		guideMessageService.deleteGuide(id);
		return Msg.success();
	}

	/**
	 * 通过guideid查询guideaward
	 */
	@ResponseBody
	@RequestMapping(value = "/getguideAwardbyguideId/{guideAwardId}", method = RequestMethod.GET)
	public Msg getguideAwardbyguideId(@PathVariable("guideAwardId") Integer guideAwardId) {
		GuideAward guideAward = guideMessageService.getguideAwardbyguideId(guideAwardId);
		return Msg.success().add("guideAward", guideAward);
	}

	/**
	 * 通过主键保存获奖信息
	 */
	@ResponseBody
	@RequestMapping(value = "/updateguideAwardByguideId")
	public Msg updateguideAwardByguideId(GuideAward guideAward) {

		guideMessageService.updateGuideAward(guideAward);
		return Msg.success();
	}

	/**
	 * 添加获奖信息
	 */
	@ResponseBody
	@RequestMapping(value = "/insertGuideAward", method = RequestMethod.POST)
	public Msg insertGuideAward(GuideAward guideAward) {

		guideMessageService.insertGuideAward(guideAward);

		return Msg.success();
	}

	/**
	 * 单个批量二合一 批量删除：1-2-3 单个删除：1
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/delGuideAward/{ids}", method = RequestMethod.DELETE)
	public Msg delGuideAward(@PathVariable("ids") String ids) {
		// 批量删除
		if (ids.contains("-")) {
			List<Integer> del_ids = new ArrayList<Integer>();
			String[] str_ids = ids.split("-");
			// 组装id的集合
			for (String string : str_ids) {
				del_ids.add(Integer.parseInt(string));
			}
			guideMessageService.deleteGuideAwradBatch(del_ids);
		} else {
			Integer id = Integer.parseInt(ids);
			guideMessageService.deleteGuideAwrad(id);
		}
		return Msg.success();
	}

	/**
	 * 金牌导游按年龄分布
	 */
	@ResponseBody
	@RequestMapping(value = "/selectcount")
	public Msg selectcount() {
		List<Count> list = guideMessageService.selectcount();
		return Msg.success().add("count", list);
	}

	/**
	 * 金牌导游按性别分布
	 */
	@ResponseBody
	@RequestMapping(value = "/selectsex")
	public Msg selectsex() {
		List<Count> list = guideMessageService.selectsex();

		return Msg.success().add("count", list);
	}

	/**
	 * 金牌导游按地区分布
	 */
	@ResponseBody
	@RequestMapping(value = "/selectcity")
	public Msg selectcity() {

		List<Count> list = guideMessageService.selectcity();
		return Msg.success().add("count", list);
	}

	/**
	 * 多条件查询
	 * 
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/searchByNSCE")
	public Msg getGuideByNSCE(GuideSearchPo po) throws UnsupportedEncodingException {
		PageHelper.startPage(1, 5);
		GuideSearchPo searchPo = new GuideSearchPo();
		String guideCity = po.getGuideCity();
		String guideName = po.getGuideName();
		String guideEducation = po.getGuideEducation();
		String guideSex = po.getGuideGender();
		guideCity = new String(guideCity.getBytes("ISO-8859-1"), "UTF-8");
		guideName = new String(guideName.getBytes("ISO-8859-1"), "UTF-8");
		guideEducation = new String(guideEducation.getBytes("ISO-8859-1"), "UTF-8");
		guideSex = new String(guideSex.getBytes("ISO-8859-1"), "UTF-8");
		searchPo.setGuideCity(guideCity);
		searchPo.setGuideEducation(guideEducation);
		searchPo.setGuideName(guideName);
		searchPo.setGuideGender(guideSex);
		System.out.println("GuideSearchPo:" + searchPo);
		List<Guide> guides = guideMessageService.getGuideByNSCE(searchPo);
		System.out.println("guides:Controller:" + guides);
		if (guides.size() > 0) {
			PageInfo page = new PageInfo(guides, 5);
			return Msg.success().add("guide", page);
		} else {
			return Msg.fail().add("error", "查无此人");
		}
	}

}
