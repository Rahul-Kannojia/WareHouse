package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IItemDao;
import com.app.model.Item;
@Repository
public class ItemDaoImpl implements IItemDao{

	@Autowired
	private HibernateTemplate ht;

	public Integer saveItem(Item item) {
		return (Integer)ht.save(item);
	}

	public void updateItem(Item item) {
		ht.update(item);

	}

	public void deleteItem(Integer id) {
		Item i=new Item();
		i.setId(id);
		ht.delete(i);
	}

	public Item getOneItemById(Integer id) {
		return ht.get(Item.class, id);
	}

	public List<Item> getAllItems() {
		List<Item> list=ht.loadAll(Item.class);
		return list;
	}

}
