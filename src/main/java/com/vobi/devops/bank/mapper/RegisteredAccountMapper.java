package com.vobi.devops.bank.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.vobi.devops.bank.domain.RegisteredAccount;
import com.vobi.devops.bank.dto.RegisteredAccountDTO;

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
public interface RegisteredAccountMapper { 
	@Mapping(source = "customer.custId", target = "custId_Customer")
	@Mapping(source = "account.accoId", target = "accoId_Account")
	public RegisteredAccountDTO registeredAccountToRegisteredAccountDTO(RegisteredAccount registeredAccount);

	@Mapping(source = "custId_Customer", target = "customer.custId")
	@Mapping(source = "accoId_Account", target = "account.accoId")
	public RegisteredAccount registeredAccountDTOToRegisteredAccount(RegisteredAccountDTO registeredAccountDTO);

	public List<RegisteredAccountDTO> listRegisteredAccountToListRegisteredAccountDTO(
			List<RegisteredAccount> registeredAccounts);

	public List<RegisteredAccount> listRegisteredAccountDTOToListRegisteredAccount(
			List<RegisteredAccountDTO> registeredAccountDTOs);
}
