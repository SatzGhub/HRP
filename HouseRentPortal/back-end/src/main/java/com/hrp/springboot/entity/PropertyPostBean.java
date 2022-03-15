package com.hrp.springboot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROP_POST")
public class PropertyPostBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="prop_Id")
	private int propId;
	
	@Column(name="locality")
	private String locality;
	
	@Column(name="city")
	private String city;
	
	@Column(name="h_type")
	private String type;
	
	@Column(name="sq_feet")
	private String sqFeet;
	
	@Column(name="price")
	private double price;
	
	@Column(name="owner_id")
	private int ownerId;
	
	public PropertyPostBean() {
		// TODO Auto-generated constructor stub
	}
	
	public PropertyPostBean(int propId, String locality, String city, String type,String  sqFeet, double price, int ownerId) {
		super();
		this.propId = propId;
		this.locality = locality;
		this.city = city;
		this.type = type;
		this.price = price;
		this.ownerId = ownerId;
		this.sqFeet = sqFeet;
	}

	public String getSqFeet() {
		return sqFeet;
	}

	public void setSqFeet(String sqFeet) {
		this.sqFeet = sqFeet;
	}

	public int getPropId() {
		return propId;
	}

	public void setPropId(int propId) {
		this.propId = propId;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	@Override
	public String toString() {
		return "PropertyPostBean [propId=" + propId + ", locality=" + locality + ", city=" + city + ", type=" + type
				+ ", price=" + price + ", ownerId=" + ownerId + "]";
	}

}
