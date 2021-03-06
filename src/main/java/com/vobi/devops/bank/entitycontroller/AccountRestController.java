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

import com.vobi.devops.bank.domain.Account;
import com.vobi.devops.bank.dto.AccountDTO;
import com.vobi.devops.bank.entityservice.AccountService;
import com.vobi.devops.bank.mapper.AccountMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org/
 *         www.zathuracode.org
 *
 */
@RestController
@RequestMapping("/api/v1/account")
@Slf4j
public class AccountRestController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private AccountMapper accountMapper;

	@GetMapping(value = "/{accoId}")
	public ResponseEntity<?> findById(@PathVariable("accoId") String accoId) throws Exception {
		log.info("Request to findById() Account");

		Optional<Account> optionalAccount = accountService.findById(accoId);

		Account account = (optionalAccount.isPresent() == true) ? optionalAccount.get() : null;

		return ResponseEntity.ok().body(accountMapper.accountToAccountDTO(account));
	}

	@GetMapping()
	public ResponseEntity<?> findAll() throws Exception {
		log.debug("Request to findAll() Account");

		return ResponseEntity.ok().body(accountMapper.listAccountToListAccountDTO(accountService.findAll()));
	}

	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody AccountDTO accountDTO) throws Exception {
		log.debug("Request to save Account: {}", accountDTO);

		Account account = accountMapper.accountDTOToAccount(accountDTO);
		account = accountService.save(account);

		return ResponseEntity.ok().body(accountMapper.accountToAccountDTO(account));
	}

	@PutMapping()
	public ResponseEntity<?> update(@Valid @RequestBody AccountDTO accountDTO) throws Exception {
		log.debug("Request to update Account: {}", accountDTO);

		Account account = accountMapper.accountDTOToAccount(accountDTO);
		account = accountService.update(account);

		return ResponseEntity.ok().body(accountMapper.accountToAccountDTO(account));
	}

	@DeleteMapping(value = "/{accoId}")
	public ResponseEntity<?> delete(@PathVariable("accoId") String accoId) throws Exception {
		log.debug("Request to delete Account");

		accountService.deleteById(accoId);

		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/count")
	public ResponseEntity<?> count() {
		return ResponseEntity.ok().body(accountService.count());
	}
}
