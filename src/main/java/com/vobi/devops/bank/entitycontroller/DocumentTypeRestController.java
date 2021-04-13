package com.vobi.devops.bank.entitycontroller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vobi.devops.bank.domain.DocumentType;
import com.vobi.devops.bank.dto.DocumentTypeDTO;
import com.vobi.devops.bank.entityservice.DocumentTypeService;
import com.vobi.devops.bank.mapper.DocumentTypeMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org/
 *         www.zathuracode.org
 *
 */
@RestController
@RequestMapping("/api/v1/documentType")
@Slf4j
public class DocumentTypeRestController {
	@Autowired
	private DocumentTypeService documentTypeService;
	@Autowired
	private DocumentTypeMapper documentTypeMapper;

	@GetMapping(value = "/{dotyId}")
	public ResponseEntity<?> findById(@PathVariable("dotyId") Integer dotyId) throws Exception {
		log.debug("Request to findById() DocumentType");

		Optional<DocumentType> optionalDocumentType = documentTypeService.findById(dotyId);

		DocumentType documentType = (optionalDocumentType.isPresent() == true) ? optionalDocumentType.get() : null;

		return ResponseEntity.ok().body(documentTypeMapper.documentTypeToDocumentTypeDTO(documentType));
	}

	@GetMapping()
	public ResponseEntity<?> findAll() throws Exception {
		log.debug("Request to findAll() DocumentType");

		return ResponseEntity.ok()
				.body(documentTypeMapper.listDocumentTypeToListDocumentTypeDTO(documentTypeService.findAll()));
	}

	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody DocumentTypeDTO documentTypeDTO) throws Exception {
		log.debug("Request to save DocumentType: {}", documentTypeDTO);

		DocumentType documentType = documentTypeMapper.documentTypeDTOToDocumentType(documentTypeDTO);
		documentType = documentTypeService.save(documentType);

		return ResponseEntity.ok().body(documentTypeMapper.documentTypeToDocumentTypeDTO(documentType));
	}

	@PutMapping()
	public ResponseEntity<?> update(@Valid @RequestBody DocumentTypeDTO documentTypeDTO) throws Exception {
		log.debug("Request to update DocumentType: {}", documentTypeDTO);

		DocumentType documentType = documentTypeMapper.documentTypeDTOToDocumentType(documentTypeDTO);
		documentType = documentTypeService.update(documentType);

		return ResponseEntity.ok().body(documentTypeMapper.documentTypeToDocumentTypeDTO(documentType));
	}

	@DeleteMapping(value = "/{dotyId}")
	public ResponseEntity<?> delete(@PathVariable("dotyId") Integer dotyId) throws Exception {
		log.debug("Request to delete DocumentType");

		documentTypeService.deleteById(dotyId);

		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/count")
	public ResponseEntity<?> count() {
		return ResponseEntity.ok().body(documentTypeService.count());
	}
}
