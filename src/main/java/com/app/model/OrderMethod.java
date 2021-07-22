package com.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author mohammad navab husain
 *
 */
@Entity
@Table(name="ORDERMETHODTABLE")
public class OrderMethod {
	@Id
	@GeneratedValue(generator="ordermethodgen")
	@GenericGenerator(name="ordermethodgen", strategy="increment")
	@Column(name ="OMID")
	private Integer id;

	@Column(name ="MODE")
	private String mode;

	@Column(name ="CODE")
	private String code;

	@Column(name ="DESCG")
	private String dc;

	@Column(name ="METHOD")
	private String method;

	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="ACCEPT",
	joinColumns=@JoinColumn(name="OMID"))
	@OrderColumn(name="POS")
	@Column(name="DATA")
	private List<String> accept = new ArrayList<>();

	public OrderMethod() {
		super();
	}
	public OrderMethod(Integer id) {
		super();
		this.id = id;
	}
	
	public OrderMethod(Integer id, String mode, String code, String dc, String method, List<String> accept) {
		super();
		this.id = id;
		this.mode = mode;
		this.code = code;
		this.dc = dc;
		this.method = method;
		this.accept = accept;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<String> getAccept() {
		return accept;
	}
	public void setAccept(List<String> accept) {
		this.accept = accept;
	}
	public String getDc() {
		return dc;
	}
	public void setDc(String dc) {
		this.dc = dc;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}

}