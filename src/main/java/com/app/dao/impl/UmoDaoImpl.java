package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUomDao;
import com.app.model.Uom;
@Repository
public class UmoDaoImpl implements IUomDao {
	@Autowired
	private HibernateTemplate ht;

	public Integer saveUom(Uom uom) {
		return (Integer)ht.save(uom);
	}
	public void updateUom(Uom uom) {
		ht.update(uom);
	}

	public void deleteUom(Integer uid) {
		Uom u=new Uom();
		u.setUid(uid);
		ht.delete(u);	
	}

	public Uom getOneUomById(Integer uid) {
		return ht.get(Uom.class, uid);
	}

	public List<Uom> getAllUom() {
		List<Uom> list=ht.loadAll(Uom.class);
		return list;
	}
	public boolean isUomModelExist(String Model) {
		@SuppressWarnings("unchecked")
		List<Long> rowsCount=(List<Long>)
		ht.findByCriteria(DetachedCriteria.forClass(Uom.class)
				.setProjection(Projections.rowCount()).add(Restrictions.eq("Model", Model)));
		return rowsCount.get(0)!=0?true:false;
	}


}
