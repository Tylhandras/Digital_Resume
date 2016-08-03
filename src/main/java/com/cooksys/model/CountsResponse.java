package com.cooksys.model;

public class CountsResponse {
	
	private String title;
	private Long anonHits;
	private Long userHits;
	private Long conversionRate;
	
	public CountsResponse(String title, Long anonHits, Long userHits, Long conversionRate) {
		super();
		this.title = title;
		this.anonHits = anonHits;
		this.userHits = userHits;
		this.conversionRate = conversionRate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getAnonHits() {
		return anonHits;
	}

	public void setAnonHits(Long anonHits) {
		this.anonHits = anonHits;
	}

	public Long getUserHits() {
		return userHits;
	}

	public void setUserHits(Long userHits) {
		this.userHits = userHits;
	}

	public Long getConversionRate() {
		return conversionRate;
	}

	public void setConversionRate(Long conversionRate) {
		this.conversionRate = conversionRate;
	}

}
