package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Uom;
import com.example.service.IUomService;

@Controller
@RequestMapping("/Uom")
public class UomController {
	
	@Autowired
	private IUomService service;
	
	@GetMapping("/register")
	public String UomRegister(Model model)
	{
		/*
		 * form backing object --> "uom" object name and new Uom(); class name
		 */
		model.addAttribute("uom", new Uom ());
		System.out.println("one");	
		return "UomRegister";
	}
	
    // Save  data
	@PostMapping("/save")
	public String SaveUom(@ModelAttribute Uom uom, Model model) 
	{
		Integer id = service.SaveUom(uom);
		String message = "Uom is Saved  '" + id + "'";
		model.addAttribute("F1", message);
		/*
		 * form backing object --> "uom" object name and new Uom(); class name
		 */
		model.addAttribute("uom", new Uom ());
		return "UomRegister";
	}
	
    // GETALL DATA 
	@GetMapping("/all")
	public String GetAllUom(@ModelAttribute Uom uom, Model model) {
		List<Uom> list = service.GetAllUom();
		model.addAttribute("F2", list);
		return "UomData";
	}
	
	// EDIT THE DATA
	@GetMapping("/Edit")
	public String EditUom(@RequestParam Integer id,
			    Model model)
	{
		Uom u=service.GetOneUom(id);
		model.addAttribute("F3", u);
		return "UomEdit";
	}
	
	// DELETE THE DATA
	@GetMapping("/del")
	public String deleteUom(@RequestParam Integer id,Model model)
	{
		service.deleteUom(id);
		model.addAttribute("F2", service.GetAllUom());
		model.addAttribute("F6", "Uom data is  '"+id+"' deleted");
		return "UomData";
	}
	
	// UPDATE THE DATA
	@PostMapping("/Update")
	public String StringUpdateUom(@ModelAttribute Uom uom ,
			Model model)
	{
		service.UpdateUom(uom);
		model.addAttribute("F5", "Uom is '"+uom.getUomId()+"' updated");
		model.addAttribute("F2", service.GetAllUom());		
		return "UomData";
	}
	
	/*
	 * This method takes the ModelAndView is return type
	 * here we are generate one Excel file (__.xlsx file)
	 * In that file list data in excel file 
	 * so we use ModelAndView View is use the UomExcel page
	 * Model Is Model Data we are combine data as one object
	 */
	
	
	
	
	/*
	 * This method takes the ModelAndView is return type
	 * here we are generate one pdf file (__.pdf file)
	 * In that file list data in pdf file 
	 * so we use ModelAndView View is use the pdf page
	 * Model Is Model Data we are combine data as one object
	 */
	

	
	@GetMapping("/validate")
	public @ResponseBody String validateModel(
			@RequestParam String model)
	{
		String message = "";
		if(service.isUomModelExist(model)) {
			message = "Uom Model '"+model+"' already exist";
		}
		
		return message;
	}
	
	
	
}
