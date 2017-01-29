package com.search.spring.web.dao;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class PoliticalScience implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int politicalScienceID;

	private String title;
	private String publisher;
	private String ISSN;
	private String eISSN;
	private String ISBN;
	private String fullTextFirst;
	private String fullTextLast;
	private String abstractFirst;
	private String abstractLast;
	public int getPoliticalScienceID() {
		return politicalScienceID;
	}
	public void setPoliticalScienceID(int politicalScienceID) {
		this.politicalScienceID = politicalScienceID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getISSN() {
		return ISSN;
	}
	public void setISSN(String iSSN) {
		ISSN = iSSN;
	}
	public String geteISSN() {
		return eISSN;
	}
	public void seteISSN(String eISSN) {
		this.eISSN = eISSN;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getFullTextFirst() {
		return fullTextFirst;
	}
	public void setFullTextFirst(String fullTextFirst) {
		this.fullTextFirst = fullTextFirst;
	}
	public String getFullTextLast() {
		return fullTextLast;
	}
	public void setFullTextLast(String fullTextLast) {
		this.fullTextLast = fullTextLast;
	}
	public String getAbstractFirst() {
		return abstractFirst;
	}
	public void setAbstractFirst(String abstractFirst) {
		this.abstractFirst = abstractFirst;
	}
	public String getAbstractLast() {
		return abstractLast;
	}
	public void setAbstractLast(String abstractLast) {
		this.abstractLast = abstractLast;
	}
	@Override
	public String toString() {
		return "PoliticalScience [politicalScienceID=" + politicalScienceID
				+ ", title=" + title + ", publisher=" + publisher + ", ISSN="
				+ ISSN + ", eISSN=" + eISSN + ", ISBN=" + ISBN
				+ ", fullTextFirst=" + fullTextFirst + ", fullTextLast="
				+ fullTextLast + ", abstractFirst=" + abstractFirst
				+ ", abstractLast=" + abstractLast + "]";
	}
	
	

}
