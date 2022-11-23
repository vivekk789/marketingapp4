package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.dto.LeadData;
import com.marketing.entities.Lead;
import com.marketing.services.LeadService;

@Controller
public class LeadController {

	@Autowired
	private LeadService leadService;
	
	//http://localhost:8080/create
	@RequestMapping("/create")
	public String viewCreateLeadPage() {
		return "create_lead";
		
	}
	@RequestMapping("/saveLead")
	public String saveOneLeadInfo(@ModelAttribute("l") Lead lead, ModelMap model) {
		leadService.saveLeadInfo(lead);
		model.addAttribute("msg", "Record is saved");
		return "create_lead";
	
	}
	
//	@RequestMapping("/saveLead")
//	public String saveOneLeadInfo(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,@RequestParam("email") String email,@RequestParam("mobile") String mobile, ModelMap model) {
//		Lead lead = new Lead();
//		lead.setFirstName(firstName);
//		lead.setLastName(lastName);
//		lead.setEmail(email);
//		lead.setMobile(mobile);
//		
//		leadService.saveLeadInfo(lead);
//		model.addAttribute("msg", "Record is saved!!");
//		return "create_lead";
//		
//	}
	
//	@RequestMapping("/saveLead")
//	public String saveOneLeadInfo(LeadData leadData , ModelMap model) {
//		Lead lead = new Lead();
//		lead.setFirstName(leadData.getFirstName());
//		lead.setLastName(leadData.getLastName());
//		lead.setEmail(leadData.getEmail());
//		lead.setMobile(leadData.getMobile());
//		
//		leadService.saveLeadInfo(lead);
//		model.addAttribute("msg",  "Record is saved!!");
//		return "create_lead";
//		
//	}
	
	//http://localhost:8080/listLeads
	@RequestMapping("/listLeads")
	public String listAllLeads(Model model) {
		List<Lead> leads = leadService.getLeads();
		model.addAttribute("leads" , leads);
		return "list_leads";
		
	}
	
	@RequestMapping("/delete")
	public String deleteOneLead(@RequestParam("id") long id , Model model) {
		leadService.deleteLead(id);
		List<Lead> leads = leadService.getLeads();
		model.addAttribute("leads" , leads);
		return "list_leads";
		
	}
	
	@RequestMapping("/update")
	public String getLeadInfo(@RequestParam("id") long id, Model model) {
		Lead lead = leadService.getOneLead(id);
		model.addAttribute("lead", lead);
		return "update_lead";
	}
	
	@RequestMapping("/updateLead")
	public String updateLeadInfo(LeadData data , Model model) {
		Lead l = new Lead();
		l.setId(data.getId());
		l.setFirstName(data.getFirstName());
		l.setLastName(data.getLastName());
		l.setEmail(data.getEmail());
		l.setMobile(data.getMobile());
		
		leadService.saveLeadInfo(l);
		
		List<Lead> leads = leadService.getLeads();
		model.addAttribute("leads" , leads);
		return "list_leads";
		
	}
}
