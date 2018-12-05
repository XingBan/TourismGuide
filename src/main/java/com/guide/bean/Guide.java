package com.guide.bean;

public class Guide {
    private Integer guideId;

    private String guideName;

    private String guideGender;

    private Integer guideAge;

    private String guideRecord;

    private String guideEducation;

    private String guideIdcard;

    private String guideProvince;

    private String guideCity;

    private String guideWorkPlace;

    private String guideWorkPosition;

    private Integer guideWorkYear;

    private String guideImageUrl;

    public Integer getGuideId() {
        return guideId;
    }

    public void setGuideId(Integer guideId) {
        this.guideId = guideId;
    }

    public String getGuideName() {
        return guideName;
    }

    public void setGuideName(String guideName) {
        this.guideName = guideName == null ? null : guideName.trim();
    }

    public String getGuideGender() {
        return guideGender;
    }

    public void setGuideGender(String guideGender) {
        this.guideGender = guideGender == null ? null : guideGender.trim();
    }

    public Integer getGuideAge() {
        return guideAge;
    }

    public void setGuideAge(Integer guideAge) {
        this.guideAge = guideAge;
    }

    public String getGuideRecord() {
        return guideRecord;
    }

    public void setGuideRecord(String guideRecord) {
        this.guideRecord = guideRecord == null ? null : guideRecord.trim();
    }

    public String getGuideEducation() {
        return guideEducation;
    }

    public void setGuideEducation(String guideEducation) {
        this.guideEducation = guideEducation == null ? null : guideEducation.trim();
    }

    public String getGuideIdcard() {
        return guideIdcard;
    }

    public void setGuideIdcard(String guideIdcard) {
        this.guideIdcard = guideIdcard == null ? null : guideIdcard.trim();
    }

    public String getGuideProvince() {
        return guideProvince;
    }

    public void setGuideProvince(String guideProvince) {
        this.guideProvince = guideProvince == null ? null : guideProvince.trim();
    }

    public String getGuideCity() {
        return guideCity;
    }

    public void setGuideCity(String guideCity) {
        this.guideCity = guideCity == null ? null : guideCity.trim();
    }

    public String getGuideWorkPlace() {
        return guideWorkPlace;
    }

    public void setGuideWorkPlace(String guideWorkPlace) {
        this.guideWorkPlace = guideWorkPlace == null ? null : guideWorkPlace.trim();
    }

    public String getGuideWorkPosition() {
        return guideWorkPosition;
    }

    public void setGuideWorkPosition(String guideWorkPosition) {
        this.guideWorkPosition = guideWorkPosition == null ? null : guideWorkPosition.trim();
    }

    public Integer getGuideWorkYear() {
        return guideWorkYear;
    }

    public void setGuideWorkYear(Integer guideWorkYear) {
        this.guideWorkYear = guideWorkYear;
    }

    public String getGuideImageUrl() {
        return guideImageUrl;
    }

    public void setGuideImageUrl(String guideImageUrl) {
        this.guideImageUrl = guideImageUrl == null ? null : guideImageUrl.trim();
    }

	@Override
	public String toString() {
		return "Guide [guideId=" + guideId + ", guideName=" + guideName + ", guideGender=" + guideGender + ", guideAge="
				+ guideAge + ", guideRecord=" + guideRecord + ", guideEducation=" + guideEducation + ", guideIdcard="
				+ guideIdcard + ", guideProvince=" + guideProvince + ", guideCity=" + guideCity + ", guideWorkPlace="
				+ guideWorkPlace + ", guideWorkPosition=" + guideWorkPosition + ", guideWorkYear=" + guideWorkYear
				+ ", guideImageUrl=" + guideImageUrl + "]";
	}
    
}