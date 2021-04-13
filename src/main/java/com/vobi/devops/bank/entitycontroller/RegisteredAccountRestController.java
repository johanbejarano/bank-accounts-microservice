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

import com.vobi.devops.bank.domain.RegisteredAccount;
import com.vobi.devops.bank.dto.RegisteredAccountDTO;
import com.vobi.devops.bank.entityservice.RegisteredAccountService;
import com.vobi.devops.bank.mapper.RegisteredAccountMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org/
 *         www.zathuracode.org
 *
 */
@RestController
@RequestMapping("/api/v1/registeredAccount")
@Slf4j
public class RegisteredAccountRestController {
	@Autowired
	private RegisteredAccountService registeredAccountService;
	@Autowired
	private RegisteredAccountMapper registeredAccountMapper;

	@GetMapping(value = "/{reacId}")
	public ResponseEntity<?> findById(@PathVariable("reacId") Integer reacId) throws Exception {
		log.debug("Request to findById() RegisteredAccount");

		Optional<RegisteredAccount> optionalRegisteredAccount = registeredAccountService.findById(reacId);

		RegisteredAccount registeredAccount = (optionalRegisteredAccount.isPresent() == true)
				? optionalRegisteredAccount.get()
				: null;

		return ResponseEntity.ok()
				.body(registeredAccountMapper.registeredAccountToRegisteredAccountDTO(registeredAccount));
	}

	@GetMapping()
	public ResponseEntity<?> findAll() throws Exception {
		log.debug("Request to findAll() RegisteredAccount");

		return ResponseEntity.ok().body(registeredAccountMapper
				.listRegisteredAccountToListRegisteredAccountDTO(registeredAccountService.findAll()));
	}

	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody RegisteredAccountDTO registeredAccountDTO) throws Exception {
		log.debug("Request to save RegisteredAccount: {}", registeredAccountDTO);

		RegisteredAccount registeredAccount = registeredAccountMapper
				.registeredAccountDTOToRegisteredAccount(registeredAccountDTO);
		registeredAccount = registeredAccountService.save(registeredAccount);

		return ResponseEntity.ok()
				.body(registeredAccountMapper.registeredAccountToRegisteredAccountDTO(registeredAccount));
	}

	@PutMapping()
	public ResponseEntity<?> update(@Valid @RequestBody RegisteredAccountDTO registeredAccountDTO) throws Exception {
		log.debug("Request to update RegisteredAccount: {}", registeredAccountDTO);

		RegisteredAccount registeredAccount = registeredAccountMapper
				.registeredAccountDTOToRegisteredAccount(registeredAccountDTO);
		registeredAccount = registeredAccountService.update(registeredAccount);

		return ResponseEntity.ok()
				.body(registeredAccountMapper.registeredAccountToRegisteredAccountDTO(registeredAccount));
	}

	@DeleteMapping(value = "/{reacId}")
	public ResponseEntity<?> delete(@PathVariable("reacId") Integer reacId) throws Exception {
		log.debug("Request to delete RegisteredAccount");

		registeredAccountService.deleteById(reacId);

		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/count")
	public ResponseEntity<?> count() {
		return ResponseEntity.ok().body(registeredAccountService.count());
	}
}
