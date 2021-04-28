package com.iptech.InterviewApp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.iptech.InterviewApp.domain.Document;
import com.iptech.InterviewApp.service.DocumentService;

@Controller
public class DocumentController {
	@Autowired
	private DocumentService documentService;
	
	@GetMapping("/documents")
	public String getPeople (ModelMap model) {
		List<Document> documents = documentService.findAll();
		
		Document document = new Document();
		
		model.put("document", document);
		model.put("documents", documents);
		
		return "documents";
	}
	
	@GetMapping("/documents/{documentId}")
	public String getDocument (@PathVariable Integer documentId, ModelMap model) {
		Document document = documentService.findById(documentId);
		model.put("document", document);
		return "documents";
	}
	
	@PostMapping("/documents")
	public String postPeople (Document document) {
		Document savedDocument = documentService.save(document);
		System.out.println(savedDocument);
		return "redirect:/documents";
	}
	
	@PostMapping("/documents/{documentId}")
	public String postDocument (Document document) {
		Document savedDocument = documentService.save(document);
		System.out.println(savedDocument);
		return "redirect:/documents/" + savedDocument.getId();
	}
	
	@PostMapping("/documents/{documentId}/delete")
	public String deleteDocument (@PathVariable Long documentId) {
		documentService.delete(documentId);
		return "redirect:/documents";
	}

}
