package com.hrp.springboot.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="RENT_REQ")
public class RentRequestBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="req_Id")
	private int reqId;
	
	@Column(name="prop_Id")
	private int propId;
	
	@Column(name="requester_id")
	private int requesterId;
	
	@Column(name="owner_id")
	private int ownerId;
	
	@Column(name="owner_approval")
	private String ownerApproval;
	
		
	public RentRequestBean() {
		// TODO Auto-generated constructor stub
	}


	public RentRequestBean(int reqId, int propId, int requesterId,int ownerId, String ownerApproval) {
		super();
		this.reqId = reqId;
		this.propId = propId;
		this.requesterId = requesterId;
		this.ownerApproval = ownerApproval;
		this.ownerId =  ownerId;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}


	public int getReqId() {
		return reqId;
	}


	public void setReqId(int reqId) {
		this.reqId = reqId;
	}


	public int getPropId() {
		return propId;
	}


	public void setPropId(int propId) {
		this.propId = propId;
	}


	public int getRequesterId() {
		return requesterId;
	}


	public void setRequesterId(int requesterId) {
		this.requesterId = requesterId;
	}


	public String getOwnerApproval() {
		return ownerApproval;
	}


	public void setOwnerApproval(String ownerApproval) {
		this.ownerApproval = ownerApproval;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "RentRequestBean [reqId=" + reqId + ", propId=" + propId + ", requesterId=" + requesterId
				+ ", ownerApproval=" + ownerApproval + "]";
	}
	

}
