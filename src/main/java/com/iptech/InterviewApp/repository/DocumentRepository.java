package com.iptech.InterviewApp.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.iptech.InterviewApp.domain.Document;

@Repository
public class DocumentRepository {
private Map<Long, Document> documents = new HashMap<>();
	
	public Document save (Document document) {
		documents.put(document.getId(), document);
		return document;
	}
	
	public Document findById (Integer documentId) {
		return documents.get(documentId);
	}

	public List<Document> findAll() {
		return documents.entrySet()
			      	 .stream()
			         .map(Entry::getValue)
			         .collect(Collectors.toList());
	}

	public void delete(Long documentId) {
		documents.remove(documentId);
	}
}
