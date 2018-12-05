package com.guide.bean;

public class GuideAward {
    private Integer guideAwardId;

    private Integer guideId;

    private String guideAwardYear;

    private String guideAwardName;

    public Integer getGuideAwardId() {
        return guideAwardId;
    }

    public void setGuideAwardId(Integer guideAwardId) {
        this.guideAwardId = guideAwardId;
    }

    public Integer getGuideId() {
        return guideId;
    }

    public void setGuideId(Integer guideId) {
        this.guideId = guideId;
    }

    public String getGuideAwardYear() {
        return guideAwardYear;
    }

    public void setGuideAwardYear(String guideAwardYear) {
        this.guideAwardYear = guideAwardYear == null ? null : guideAwardYear.trim();
    }

    public String getGuideAwardName() {
        return guideAwardName;
    }

    public void setGuideAwardName(String guideAwardName) {
        this.guideAwardName = guideAwardName == null ? null : guideAwardName.trim();
    }
}