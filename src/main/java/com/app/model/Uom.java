package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="UOMTAB")
public class Uom {
	@Id
	@GeneratedValue(generator="uomgen")
	@GenericGenerator(name="uomgen",strategy="increment")
	@Column(name ="UID")
	private Integer uid;

	@Column(name ="TYPE")
	private String type;

	@Column(name ="MODEL")
	private String model;

	@Column(name ="DCG")
	private String dc;

	public Uom() {
		super();
	}

	public Uom(Integer uid) {
		super();
		this.uid = uid;
	}

	public Uom(Integer uid, String type, String model, String dc) {
		super();
		this.uid = uid;
		this.type = type;
		this.model = model;
		this.dc = dc;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDc() {
		return dc;
	}

	public void setDc(String dc) {
		this.dc = dc;
	}

}
