package com.vobi.devops.bank.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.vobi.devops.bank.domain.DocumentType;
import com.vobi.devops.bank.dto.DocumentTypeDTO;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org/
 *         www.zathuracode.org
 *
 *         Mapper Build with MapStruct https://mapstruct.org/ MapStruct is a
 *         code generator that greatly simplifies the implementation of mappings
 *         between Java bean type based on a convention over configuration
 *         approach.
 */
@Mapper
public interface DocumentTypeMapper {
	public DocumentTypeDTO documentTypeToDocumentTypeDTO(DocumentType documentType);

	public DocumentType documentTypeDTOToDocumentType(DocumentTypeDTO documentTypeDTO);

	public List<DocumentTypeDTO> listDocumentTypeToListDocumentTypeDTO(List<DocumentType> documentTypes);

	public List<DocumentType> listDocumentTypeDTOToListDocumentType(List<DocumentTypeDTO> documentTypeDTOs);
}
