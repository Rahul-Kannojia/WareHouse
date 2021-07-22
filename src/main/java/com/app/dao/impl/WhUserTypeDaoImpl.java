package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;
@Repository
public class WhUserTypeDaoImpl implements IWhUserTypeDao {

	@Autowired
	private HibernateTemplate ht;

	public Integer saveWhUserType(WhUserType wht) {
		return (Integer)ht.save(wht);
	}

	public void updateWhUserType(WhUserType wht) {
		ht.update(wht);	
	}

	public void deleteWhUserType(Integer id) {
		WhUserType w=new WhUserType();
		w.setId(id);
		ht.delete(w);		
	}

	public WhUserType getOneWhUserTypeById(Integer id) {
		return ht.get(WhUserType.class,id);
	}

	public List<WhUserType> getAllWhUserType() {
		List<WhUserType> list=ht.loadAll(WhUserType.class);
		return list;	
	}
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<WhUserType> getWhUserTypesByType(String userType) {

		String hql= " from " +WhUserType.class.getName() +" where  type=?";
		List<WhUserType> list=(List<WhUserType>)ht.findByCriteria(DetachedCriteria.forClass(WhUserType.class).add(Restrictions.eq("type", userType)));
		return list;
	}


}
