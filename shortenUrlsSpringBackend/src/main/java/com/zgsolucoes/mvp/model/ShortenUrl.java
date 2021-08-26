package com.zgsolucoes.mvp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shortenUrls")
public class ShortenUrl {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="codeForUrl", nullable = false)
	private String codeForUrl;
	
	@Column(name="longUrl", nullable = false)
	private String longUrl;
	
	public ShortenUrl() {
		
	}

	public ShortenUrl(String codeForUrl, String longUrl) {
		setLongUrl(longUrl);
		setCodeForUrl(codeForUrl);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/*
	 * public String getShortUrl() { return "zg.com.br/" + getCodeForUrl(); }
	 */
	
	public String getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}

	public String getCodeForUrl() {
		return codeForUrl;
	}

	public void setCodeForUrl(String codeForUrl) {
		this.codeForUrl = codeForUrl;
	}
	
}
