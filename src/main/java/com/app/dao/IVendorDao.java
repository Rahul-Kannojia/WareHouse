package com.app.dao;

import java.util.List;

import com.app.model.Vendor;

public interface IVendorDao {

	public Integer saveVendor(Vendor ven);

	public void updateVendor(Vendor ven);

	public void deleteVendor(Integer venId);

	public Vendor getOneVendorById(Integer venId);

	public List<Vendor> getAllVendors();

}
