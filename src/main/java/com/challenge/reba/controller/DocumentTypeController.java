package com.challenge.reba.controller;

import com.challenge.reba.model.DocumentType;
import com.challenge.reba.service.IDocumentTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/document-type")
public class DocumentTypeController {
    Logger logger = LoggerFactory.getLogger(DocumentTypeController.class);

    @Autowired
    private IDocumentTypeService documentTypeService;

    /**
     *
     * @param id
     * @return a DocumentType by id
     */
    @GetMapping(value = "/get/{id}")
    public DocumentType findById(@PathVariable(required = true) Long id){
        logger.info("Id:{}", id);

        return documentTypeService.findById(id);
    }

    /**
     *
     * @return a JSON with all document types
     */
    @GetMapping(value = "/findAll")
    public @ResponseBody Iterable<DocumentType> findAll() {
        return documentTypeService.findAll();
    }
}
