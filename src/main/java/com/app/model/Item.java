package com.app.model;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="itemtab")
public class Item {
	@Id
	@GeneratedValue(generator="itemgen")
	@GenericGenerator(name="itemgen", strategy="increment")
	@Column(name="id")
	private Integer id;

	@Column(name="itemcode")
	private String code;

	@Column(name="width")
	private double w;

	@Column(name="length")
	private double l;

	@Column(name="hight")
	private double h;

	@Column(name="cost")
	private double baseCost;

	@Column(name="currency")
	private String baseCurrency;

	@ManyToOne
	@JoinColumn(name="uidfk")
	private Uom uom;

	@ManyToOne
	@JoinColumn(name="omSaleId")
	private OrderMethod saleType;

	@ManyToOne
	@JoinColumn(name="omPurchaseId")
	private OrderMethod purchaseType;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="itm_venusr_tab",joinColumns=@JoinColumn(name="itmIdFk"),
	inverseJoinColumns=@JoinColumn(name="ventIdFk"))
	@Fetch(value=FetchMode.SUBSELECT)
	private List<WhUserType> venUsers=new ArrayList<WhUserType>(0);

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="itm_cust_tab",joinColumns=@JoinColumn(name="itmIdFk"),
	inverseJoinColumns=@JoinColumn(name="custIdFk"))
	@Fetch(value=FetchMode.SUBSELECT)
	private List<WhUserType> custUsers=new ArrayList<WhUserType>(0);

	public Item() {
		super();
	}

	public Item(Integer id) {
		super();
		this.id = id;
	}

	public Item(Integer id, String code, double w, double l, double h, double baseCost, String baseCurrency, Uom uom,
			OrderMethod saleType, OrderMethod purchaseType, List<WhUserType> venUsers, List<WhUserType> custUsers) {
		super();
		this.id = id;
		this.code = code;
		this.w = w;
		this.l = l;
		this.h = h;
		this.baseCost = baseCost;
		this.baseCurrency = baseCurrency;
		this.uom = uom;
		this.saleType = saleType;
		this.purchaseType = purchaseType;
		this.venUsers = venUsers;
		this.custUsers = custUsers;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getW() {
		return w;
	}

	public void setW(double w) {
		this.w = w;
	}

	public double getL() {
		return l;
	}

	public void setL(double l) {
		this.l = l;
	}

	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}

	public double getBaseCost() {
		return baseCost;
	}

	public void setBaseCost(double baseCost) {
		this.baseCost = baseCost;
	}

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public Uom getUom() {
		return uom;
	}

	public void setUom(Uom uom) {
		this.uom = uom;
	}

	public OrderMethod getSaleType() {
		return saleType;
	}

	public void setSaleType(OrderMethod saleType) {
		this.saleType = saleType;
	}

	public OrderMethod getPurchaseType() {
		return purchaseType;
	}

	public void setPurchaseType(OrderMethod purchaseType) {
		this.purchaseType = purchaseType;
	}

	public List<WhUserType> getVenUsers() {
		return venUsers;
	}

	public void setVenUsers(List<WhUserType> venUsers) {
		this.venUsers = venUsers;
	}

	public List<WhUserType> getCustUsers() {
		return custUsers;
	}

	public void setCustUsers(List<WhUserType> custUsers) {
		this.custUsers = custUsers;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", code=" + code + ", w=" + w + ", l=" + l + ", h=" + h + ", baseCost=" + baseCost
				+ ", baseCurrency=" + baseCurrency + ", uom=" + uom + ", saleType=" + saleType + ", purchaseType="
				+ purchaseType + ", venUsers=" + venUsers + ", custUsers=" + custUsers + "]";
	}


}
