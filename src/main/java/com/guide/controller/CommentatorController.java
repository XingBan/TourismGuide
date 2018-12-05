package com.guide.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
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
import com.guide.bean.Commentator;
import com.guide.bean.CommentatorAward;
import com.guide.bean.Count;
import com.guide.bean.Commentator;
import com.guide.bean.Msg;
import com.guide.po.CommentatorSearchPo;
import com.guide.service.CommentatorService;
import com.guide.utils.ImportExcelUtil;

@Controller
@RequestMapping("/commentator")
public class CommentatorController {
	@Autowired
	CommentatorService commentatorService;
	private String originalFilename = null;

	/**
	 * 获取所有金牌讲解员
	 * 
	 * @param pn
	 * @return
	 */
	@RequestMapping("/getcommentator")
	@ResponseBody
	public Msg getAllcommentator(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		// 引入分页插件
		PageHelper.startPage(pn, 5);
		List<Commentator> list = commentatorService.getAll();
		
		PageInfo page = new PageInfo(list, 5);
		return Msg.success().add("commentator", page);

	}

	/**
	 * 通过名字检索金牌讲解员
	 * 
	 * @param pn
	 * @param commentatorName
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/getcommentatorbyname", method = RequestMethod.GET)
	@ResponseBody
	public Msg getcommentatorByName(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam("commentatorName") String commentatorName) throws UnsupportedEncodingException {
		commentatorName = new String(commentatorName.getBytes("ISO-8859-1"), "UTF-8");
		PageHelper.startPage(pn, 5);
		System.out.println("commentatorName:Controller:" + commentatorName);
		List<Commentator> commentators = commentatorService.getcommentatorByName(commentatorName);
		System.out.println("commentators:Controller:" + commentators);
		if (commentators.size() > 0) {
			PageInfo page = new PageInfo(commentators, 5);
			return Msg.success().add("commentator", page);
		} else {
			return Msg.fail().add("error", "查无此人");
		}
	}

	/**
	 * 添加金牌讲解员
	 * 
	 * @param commentator
	 * @return
	 */
	@RequestMapping(value = "/insertcommentator", method = RequestMethod.POST)
	@ResponseBody
	public Msg insertcommentator(Commentator commentator) {
		System.out.println(commentator.toString());
		commentator.setCommentatorImageUrl(originalFilename);
		System.out.println(commentator);
		commentatorService.insertcommentator(commentator);
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
		System.out.println("通过传统方式form表单提交方式导入excel文件！");

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
			Commentator commentator = new Commentator();
			System.out.println(listob.get(i));
			if (lo.size() != 10) {
				// listob.remove(i);
				failcount++;
				for (int j = 0; i < listob.size(); j++) {
					failhang[j] = i;
					System.out.println("出错了：" + "第" + i + "行");
				}
			} else {
				commentator.setCommentatorName(String.valueOf(lo.get(0)));
				commentator.setCommentatorGender(String.valueOf(lo.get(1)));
				commentator.setCommentatorAge(Integer.parseInt(String.valueOf(lo.get(2))));
				commentator.setCommentatorRecord(String.valueOf(lo.get(3)));
				commentator.setCommentatorEducation(String.valueOf(lo.get(4)));
				commentator.setCommentatorIdcard(String.valueOf(lo.get(5)));
				commentator.setCommentatorCity(String.valueOf(lo.get(6)));
				commentator.setCommentatorWorkPlace(String.valueOf(lo.get(7)));
				commentator.setCommentatorWorkPosition(String.valueOf(lo.get(8)));
				commentator.setCommentatorWorkYear(Integer.parseInt(String.valueOf(lo.get(9))));
				commentatorService.insertcommentator(commentator);
				System.out.println("姓名：" + commentator.getCommentatorName() + " 性别: "
						+ commentator.getCommentatorGender() + " 年龄：" + commentator.getCommentatorAge() + " 讲解员职称："
						+ commentator.getCommentatorRecord() + " 学历：" + commentator.getCommentatorEducation() + " 身份证："
						+ commentator.getCommentatorIdcard() + " 城市：" + commentator.getCommentatorCity() + " 工作地点："
						+ commentator.getCommentatorWorkPlace() + " 工作职位：" + commentator.getCommentatorWorkPosition()
						+ " 工作年龄：" + commentator.getCommentatorWorkYear());
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
	 * 通过id获取金牌讲解员
	 * 
	 * @param commentatorId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getcommentatorid/{commentatorId}", method = RequestMethod.GET)
	public Msg getcommentatorById(@PathVariable("commentatorId") Integer commentatorId) {

		Commentator commentator = commentatorService.getcommentatorById(commentatorId);

		return Msg.success().add("commentator", commentator);
	}

	/**
	 * 获取所有获奖情况
	 */
	@ResponseBody
	@RequestMapping(value = "/getcommentatorAwardbyid/{id}", method = RequestMethod.GET)
	public Msg getcommentatorAwardbyId(@PathVariable("id") Integer id) {

		List<CommentatorAward> commentatorAwards = commentatorService.getcommentatorAwardbyId(id);

		return Msg.success().add("commentatorAwards", commentatorAwards);
	}

	/**
	 * 上传图片到/img目录下
	 */
	@RequestMapping(value = "/uploadimg", method = RequestMethod.POST)
	@ResponseBody
	public Msg uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
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
				System.out.println("path:" + path);
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
		File file = new File(path + File.separator + "金牌讲解员导入模板.xlsx");
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
	 * 更新讲解员
	 */
	@ResponseBody
	@RequestMapping(value = "/updatecommentator")
	public Msg updatecommentator(Commentator commentator) {
		System.out.println(commentator);
		commentator.setCommentatorImageUrl(originalFilename);
		commentatorService.updatecommentator(commentator);
		return Msg.success();
	}

	/**
	 * 删除讲解员by Id
	 */
	@ResponseBody
	@RequestMapping(value = "/delcommentator/{id}", method = RequestMethod.DELETE)
	public Msg deletecommentator(@PathVariable("id") Integer id) {
		commentatorService.deletecommentator(id);
		return Msg.success();
	}

	/**
	 * 通过commentatorid查询commentatoraward
	 */
	@ResponseBody
	@RequestMapping(value = "/getcommentatorAwardbycommentatorId/{commentatorAwardId}", method = RequestMethod.GET)
	public Msg getcommentatorAwardbycommentatorId(@PathVariable("commentatorAwardId") Integer commentatorAwardId) {
		CommentatorAward commentatorAward = commentatorService.getcommentatorAwardbycommentatorId(commentatorAwardId);
		return Msg.success().add("commentatorAward", commentatorAward);
	}

	/**
	 * 通过主键保存获奖信息
	 */
	@ResponseBody
	@RequestMapping(value = "/updatecommentatorAwardBycommentatorId")
	public Msg updatecommentatorAwardBycommentatorId(CommentatorAward commentatorAward) {

		commentatorService.updatecommentatorAward(commentatorAward);
		return Msg.success();
	}

	/**
	 * 添加获奖信息
	 */
	@ResponseBody
	@RequestMapping(value = "/insertcommentatorAward", method = RequestMethod.POST)
	public Msg insertcommentatorAward(CommentatorAward commentatorAward) {

		commentatorService.insertcommentatorAward(commentatorAward);

		return Msg.success();
	}

	/**
	 * 单个批量二合一 批量删除：1-2-3 单个删除：1
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/delcommentatorAward/{ids}", method = RequestMethod.DELETE)
	public Msg delcommentatorAward(@PathVariable("ids") String ids) {
		// 批量删除
		if (ids.contains("-")) {
			List<Integer> del_ids = new ArrayList<Integer>();
			String[] str_ids = ids.split("-");
			// 组装id的集合
			for (String string : str_ids) {
				del_ids.add(Integer.parseInt(string));
			}
			commentatorService.deletecommentatorAwradBatch(del_ids);
		} else {
			Integer id = Integer.parseInt(ids);
			commentatorService.deletecommentatorAwrad(id);
		}
		return Msg.success();
	}

	/**
	 * 金牌讲解员按年龄分布
	 */
	@ResponseBody
	@RequestMapping(value = "/selectcount")
	public Msg selectcount() {
		List<Count> list = commentatorService.selectcount();
		return Msg.success().add("count", list);
	}

	/**
	 * 金牌讲解员按性别分布
	 */
	@ResponseBody
	@RequestMapping(value = "/selectsex")
	public Msg selectsex() {
		List<Count> list = commentatorService.selectsex();

		return Msg.success().add("count", list);
	}

	/**
	 * 金牌讲解员按地区分布
	 */
	@ResponseBody
	@RequestMapping(value = "/selectcity")
	public Msg selectcity() {

		List<Count> list = commentatorService.selectcity();
		return Msg.success().add("count", list);
	}

	/**
	 * 多条件查询
	 * 
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/searchByNSCE")
	public Msg getCommentatorByNSCE(CommentatorSearchPo po) throws UnsupportedEncodingException {
		PageHelper.startPage(1, 5);
		CommentatorSearchPo searchPo = new CommentatorSearchPo();
		String commentatorCity = po.getCommentatorCity();
		String commentatorName = po.getCommentatorName();
		String commentatorEducation = po.getCommentatorEducation();
		String commentatorSex = po.getCommentatorGender();
		commentatorCity = new String(commentatorCity.getBytes("ISO-8859-1"), "UTF-8");
		commentatorName = new String(commentatorName.getBytes("ISO-8859-1"), "UTF-8");
		commentatorEducation = new String(commentatorEducation.getBytes("ISO-8859-1"), "UTF-8");
		commentatorSex = new String(commentatorSex.getBytes("ISO-8859-1"), "UTF-8");
		searchPo.setCommentatorCity(commentatorCity);
		searchPo.setCommentatorEducation(commentatorEducation);
		searchPo.setCommentatorName(commentatorName);
		searchPo.setCommentatorGender(commentatorSex);
		System.out.println("commentatorSearchPo:" + searchPo);
		List<Commentator> commentators = commentatorService.getcommentatorByNSCE(searchPo);
		System.out.println("commentators:Controller:" + commentators);
		if (commentators.size() > 0) {
			PageInfo page = new PageInfo(commentators, 5);
			return Msg.success().add("commentator", page);
		} else {
			return Msg.fail().add("error", "查无此人");
		}
	}
}
