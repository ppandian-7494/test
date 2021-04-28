package com.iptech.InterviewApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.iptech.InterviewApp.domain.Document;
import com.iptech.InterviewApp.repository.DocumentRepository;

public class DocumentService {
private Long documentId = 1L;
	
	@Autowired
	private DocumentRepository documentRepo;
	
	public Document save(Document document) {
		if (document.getId() == null)
			document.setId(documentId++);
		
		return documentRepo.save(document);
	}

	public Document findById(Integer documentId) {
		return documentRepo.findById(documentId);
	}

	public List<Document> findAll() {
		return documentRepo.findAll();
	}

	public void delete(Long documentId) {
		documentRepo.delete(documentId);
	}
}
