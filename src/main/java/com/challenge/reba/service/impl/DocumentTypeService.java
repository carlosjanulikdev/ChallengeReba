package com.challenge.reba.service.impl;

import com.challenge.reba.model.DocumentType;
import com.challenge.reba.repository.DocumentTypeRepository;
import com.challenge.reba.service.IDocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentTypeService implements IDocumentTypeService {

    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    public DocumentType findById(Long id){
        return documentTypeRepository.findById(id).get();
    }
    public List<DocumentType> findAll(){
        return (List<DocumentType>) documentTypeRepository.findAll();
    }
}
