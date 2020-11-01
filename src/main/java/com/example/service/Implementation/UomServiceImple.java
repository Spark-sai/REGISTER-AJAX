package com.example.service.Implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exception.UomNotFoundException;
import com.example.Repository.UomRepo;
import com.example.model.Uom;
import com.example.service.IUomService;

@Service
public class UomServiceImple implements IUomService {

	@Autowired
	private UomRepo repo;

	@Override
	public Integer SaveUom(Uom uom) {
		return repo.save(uom).getUomId();
	}

	@Override
	public List<Uom> GetAllUom() {
		List<Uom> list = repo.findAll();
		list.sort((u1, u2) -> u1.getUomId() - u2.getUomId());
		return list;
	}

	@Override
	public void UpdateUom(Uom uom) {
		repo.save(uom);
	}

	@Override
	public Uom GetOneUom(Integer id) {
		return repo.findById(id).orElseThrow(() -> new UomNotFoundException("Uom not '" + id + "' Exit"));
	}

	@Override
	public void deleteUom(Integer id) {
		Optional<Uom> u = repo.findById(id);
		if (u.isPresent()) {
			repo.delete(u.get());

		} else {
			throw new UomNotFoundException("Uom is not Found");
		}

	}

	
	
	public boolean isUomModelExist(String UomModel) {
		/*
		boolean flag = true;
		Integer count = repo.getUomModelCount(UomModel);
		if(count==0)  {
			flag = false; // not exist
		} else {
			flag = true; //exst
		}
		return flag; */
		return repo.getUomModelCount(UomModel) > 0 ? true : false;
}
}
