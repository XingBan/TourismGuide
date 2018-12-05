package com.guide.bean;

public class CommentatorAward {
    private Integer commentatorAwardId;

    private Integer commentatorId;

    private String commentatorAwardYear;

    private String commentatorAwardName;

    public Integer getCommentatorAwardId() {
        return commentatorAwardId;
    }

    public void setCommentatorAwardId(Integer commentatorAwardId) {
        this.commentatorAwardId = commentatorAwardId;
    }

    public Integer getCommentatorId() {
        return commentatorId;
    }

    public void setCommentatorId(Integer commentatorId) {
        this.commentatorId = commentatorId;
    }

    public String getCommentatorAwardYear() {
        return commentatorAwardYear;
    }

    public void setCommentatorAwardYear(String commentatorAwardYear) {
        this.commentatorAwardYear = commentatorAwardYear == null ? null : commentatorAwardYear.trim();
    }

    public String getCommentatorAwardName() {
        return commentatorAwardName;
    }

    public void setCommentatorAwardName(String commentatorAwardName) {
        this.commentatorAwardName = commentatorAwardName == null ? null : commentatorAwardName.trim();
    }
}