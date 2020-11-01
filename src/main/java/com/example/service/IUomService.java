package com.example.service;

import java.util.List;

import com.example.model.Uom;

public interface IUomService {

	/**
	 * this method read uom object and perform the Save opertation
	 * 
	 * @return the Uom id
	 */
	public Integer SaveUom(Uom uom);

	/**
	 * this method find all the Data
	 * 
	 * @return list format
	 */
	public List<Uom> GetAllUom();

	/**
	 * 
	 * @param this method take the Uom object parameter and perform the Update
	 *             Operation
	 */
	public void UpdateUom(Uom uom);

	/**
	 * this method
	 * 
	 * @param id as parameter and perform and
	 * @return the data
	 */
	public Uom GetOneUom(Integer id);

	/**
	 * this method
	 * 
	 * @param id and perform the delete Operation
	 */
	public void deleteUom(Integer id);

			

	public boolean isUomModelExist(String UomModel);

}
