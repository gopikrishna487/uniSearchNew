package com.search.spring.web.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author RAJASEKHAR
 *<h2>TitleListASSIA</h2>
 *
 *<ol>persist into the database</ol>
 */

// no name = here so the entity can be used as Person
@javax.persistence.Entity
// table name specified here
@javax.persistence.Table(name = "TitleListASSIA")
public class TitleListASSIA implements Serializable
{
	@Column
	@Id
	private String serialTitle;
	@Column
	private String ISSNPrint;
	@Column
	private String ISSNElectronic;
	@Column
	private String publisherName;
	@Column
	private String countryOfPublication;
	@Column
	private String ASSIA;

	public String getSerialTitle() {
		return serialTitle;
	}
	public void setSerialTitle(String serialTitle) {
		this.serialTitle = serialTitle;
	}
	public String getISSNPrint() {
		return ISSNPrint;
	}
	public void setISSNPrint(String iSSNPrint) {
		ISSNPrint = iSSNPrint;
	}
	public String getISSNElectronic() {
		return ISSNElectronic;
	}
	public void setISSNElectronic(String iSSNElectronic) {
		ISSNElectronic = iSSNElectronic;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public String getCountryOfPublication() {
		return countryOfPublication;
	}
	public void setCountryOfPublication(String countryOfPublication) {
		this.countryOfPublication = countryOfPublication;
	}
	public String getASSIA() {
		return ASSIA;
	}
	public void setASSIA(String aSSIA) {
		ASSIA = aSSIA;
	}
	@Override
	public String toString() {
		StringBuffer sb=new StringBuffer();
		sb.append("["+serialTitle+"\n");
		sb.append(ISSNElectronic+"\n");
		sb.append(ISSNPrint+"\n");
		sb.append(countryOfPublication+"\n");
		sb.append(publisherName+"\n");
		sb.append(ASSIA+"\n");
		
		sb.append("]");
		sb.append("\t");
		return sb.toString();
		
	}

}
