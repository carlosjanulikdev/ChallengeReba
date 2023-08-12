package com.challenge.reba.service;

import com.challenge.reba.model.DocumentType;

import java.util.List;

public interface IDocumentTypeService {

    DocumentType findById(Long id);
    List<DocumentType> findAll();
}
