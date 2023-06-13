package com.web.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.web.store.model.ItemBean;
import com.web.store.service.ItemService;

@Controller
public class sortShoseController {
	ItemService itemService;
	
	@Autowired
	public sortShoseController(ItemService itemService) {
		this.itemService = itemService;
	}
	@GetMapping("/sortShose")
	public String list(Model model) {
		List<ItemBean> sortitems =itemService.getSort();		
		List<ItemBean> hotitems = itemService.getHotitems();
		int sum = sortitems.size()+hotitems.size();
		model.addAttribute("sum", sum);
		model.addAttribute("sortitems", sortitems);
		model.addAttribute("hotitems",hotitems);
		return "sortShose";
	}
	
	
}
