package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Uom_tab")
public class Uom {
	@Id
	@GeneratedValue
	@Column(name = "Uom_Id_Col")
	private Integer UomId;

	@Column(name = "Uom_Type_Col")
	private String UomType;

	@Column(name = "Uom_Model_Col")
	private String UomModel;

	@Column(name = "Uom_Description_Col")
	private String UomDescription;

}
