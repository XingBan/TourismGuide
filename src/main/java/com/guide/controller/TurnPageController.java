package com.guide.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guide.bean.Msg;

@Controller
public class TurnPageController {

	@RequestMapping("/turn_guide_page")
	public String turnGuidePage() {

		return "/guide/show_guide";
	}

	@RequestMapping("/turn_add_guide")
	public String turnAddGuide() {

		return "/guide/add_guide_byexcel";
	}

	@RequestMapping(value = "/editguide/{id}")
	public String editGuide(@PathVariable("id") Integer id, HttpServletRequest request) {
		request.setAttribute("guideId", id);
		return "/guide/edit_guide";
	}

	@RequestMapping(value = "/turn_power_page")
	public String turnPowerPage() {
		return "/power/power_control";
	}

	@RequestMapping(value = "/turn_commentator_page")
	public String turnCommentatorPage() {
		return "/commentator/show_commentator";
	}
	
	@RequestMapping("/turn_add_commentator")
	public String turnAddCommentator() {

		return "/commentator/add_commentator_byexcel";
	}
	@RequestMapping(value = "/editcommentator/{id}")
	public String editCommentator(@PathVariable("id") Integer id, HttpServletRequest request) {
		request.setAttribute("commentatorId", id);
		return "/commentator/edit_commentator";
	}
	@RequestMapping("/turn_index")
	public String turnIndex() {

		return "/welcome/index";
	}
}
