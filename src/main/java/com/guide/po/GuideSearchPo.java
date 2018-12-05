package com.guide.po;

public class GuideSearchPo {

	private String guideName;
	private String guideGender;
	private String guideCity;
	private String guideEducation;
	public String getGuideName() {
		return guideName;
	}
	public void setGuideName(String guideName) {
		this.guideName = guideName;
	}
	public String getGuideGender() {
		return guideGender;
	}
	public void setGuideGender(String guideGender) {
		this.guideGender = guideGender;
	}
	public String getGuideCity() {
		return guideCity;
	}
	public void setGuideCity(String guideCity) {
		this.guideCity = guideCity;
	}
	public String getGuideEducation() {
		return guideEducation;
	}
	public void setGuideEducation(String guideEducation) {
		this.guideEducation = guideEducation;
	}
	@Override
	public String toString() {
		return "GuideSearchPo [guideName=" + guideName + ", guideGender=" + guideGender + ", guideCity=" + guideCity
				+ ", guideEducation=" + guideEducation + "]";
	}
	
}
