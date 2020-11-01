package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Uom;

public interface UomRepo extends JpaRepository<Uom, Integer>
{	
	@Query("SELECT COUNT(UomModel) FROM Uom WHERE UomModel=:UomModel")
	Integer getUomModelCount(String UomModel);

}
