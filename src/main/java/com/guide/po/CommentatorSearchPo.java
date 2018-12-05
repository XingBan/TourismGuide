package com.guide.po;

public class CommentatorSearchPo {

	private String commentatorName;
	private String commentatorGender;
	private String commentatorCity;
	private String commentatorEducation;
	public String getCommentatorName() {
		return commentatorName;
	}
	public void setCommentatorName(String commentatorName) {
		this.commentatorName = commentatorName;
	}
	public String getCommentatorGender() {
		return commentatorGender;
	}
	public void setCommentatorGender(String commentatorGender) {
		this.commentatorGender = commentatorGender;
	}
	public String getCommentatorCity() {
		return commentatorCity;
	}
	public void setCommentatorCity(String commentatorCity) {
		this.commentatorCity = commentatorCity;
	}
	public String getCommentatorEducation() {
		return commentatorEducation;
	}
	public void setCommentatorEducation(String commentatorEducation) {
		this.commentatorEducation = commentatorEducation;
	}
	@Override
	public String toString() {
		return "CommentatorSearchPo [commentatorName=" + commentatorName + ", commentatorGender=" + commentatorGender
				+ ", commentatorCity=" + commentatorCity + ", commentatorEducation=" + commentatorEducation + "]";
	}
	
	
}
