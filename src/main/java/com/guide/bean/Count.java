package com.guide.bean;

public class Count {

	private Integer counts;
	private String groups;
	public Integer getCounts() {
		return counts;
	}
	public void setCounts(Integer counts) {
		this.counts = counts;
	}
	public String getGroups() {
		return groups;
	}
	public void setGroups(String groups) {
		this.groups = groups;
	}
	@Override
	public String toString() {
		return "Count [counts=" + counts + ", groups=" + groups + "]";
	}
	
	
}
