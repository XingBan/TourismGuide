package com.guide.bean;

public class Commentator {
    private Integer commentatorId;

    private String commentatorName;

    private String commentatorGender;

    private Integer commentatorAge;

    private String commentatorRecord;

    private String commentatorEducation;

    private String commentatorIdcard;

    private String commentatorProvince;

    private String commentatorCity;

    private String commentatorWorkPlace;

    private String commentatorWorkPosition;

    private Integer commentatorWorkYear;

    private String commentatorImageUrl;

    public Integer getCommentatorId() {
        return commentatorId;
    }

    public void setCommentatorId(Integer commentatorId) {
        this.commentatorId = commentatorId;
    }

    public String getCommentatorName() {
        return commentatorName;
    }

    public void setCommentatorName(String commentatorName) {
        this.commentatorName = commentatorName == null ? null : commentatorName.trim();
    }

    public String getCommentatorGender() {
        return commentatorGender;
    }

    public void setCommentatorGender(String commentatorGender) {
        this.commentatorGender = commentatorGender == null ? null : commentatorGender.trim();
    }

    public Integer getCommentatorAge() {
        return commentatorAge;
    }

    public void setCommentatorAge(Integer commentatorAge) {
        this.commentatorAge = commentatorAge;
    }

    public String getCommentatorRecord() {
        return commentatorRecord;
    }

    public void setCommentatorRecord(String commentatorRecord) {
        this.commentatorRecord = commentatorRecord == null ? null : commentatorRecord.trim();
    }

    public String getCommentatorEducation() {
        return commentatorEducation;
    }

    public void setCommentatorEducation(String commentatorEducation) {
        this.commentatorEducation = commentatorEducation == null ? null : commentatorEducation.trim();
    }

    public String getCommentatorIdcard() {
        return commentatorIdcard;
    }

    public void setCommentatorIdcard(String commentatorIdcard) {
        this.commentatorIdcard = commentatorIdcard == null ? null : commentatorIdcard.trim();
    }

    public String getCommentatorProvince() {
        return commentatorProvince;
    }

    public void setCommentatorProvince(String commentatorProvince) {
        this.commentatorProvince = commentatorProvince == null ? null : commentatorProvince.trim();
    }

    public String getCommentatorCity() {
        return commentatorCity;
    }

    public void setCommentatorCity(String commentatorCity) {
        this.commentatorCity = commentatorCity == null ? null : commentatorCity.trim();
    }

    public String getCommentatorWorkPlace() {
        return commentatorWorkPlace;
    }

    public void setCommentatorWorkPlace(String commentatorWorkPlace) {
        this.commentatorWorkPlace = commentatorWorkPlace == null ? null : commentatorWorkPlace.trim();
    }

    public String getCommentatorWorkPosition() {
        return commentatorWorkPosition;
    }

    public void setCommentatorWorkPosition(String commentatorWorkPosition) {
        this.commentatorWorkPosition = commentatorWorkPosition == null ? null : commentatorWorkPosition.trim();
    }

    public Integer getCommentatorWorkYear() {
        return commentatorWorkYear;
    }

    public void setCommentatorWorkYear(Integer commentatorWorkYear) {
        this.commentatorWorkYear = commentatorWorkYear;
    }

    public String getCommentatorImageUrl() {
        return commentatorImageUrl;
    }

    public void setCommentatorImageUrl(String commentatorImageUrl) {
        this.commentatorImageUrl = commentatorImageUrl == null ? null : commentatorImageUrl.trim();
    }
}