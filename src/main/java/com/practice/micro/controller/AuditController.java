package com.practice.micro.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.micro.model.Audit;
import com.practice.micro.service.AuditService;

import lombok.extern.slf4j.Slf4j;


/**
 * The Class AuditController.
 */
@RestController
@Slf4j
public class AuditController {
	
	/** The audit service. */
	@Autowired
	private AuditService auditService;
	
	/**
	 * Save audit.
	 *
	 * @param audit the audit
	 * @return the response entity
	 */
	@PostMapping(value="/audit")
	@ResponseBody
	public ResponseEntity<Integer> saveAudit(@Valid @RequestBody Audit audit){
		log.debug("AuditController.saveAudit request {}", audit);
		int i = auditService.saveAudit(audit);
		log.debug("AuditController.saveAudit response {}", i);
		return new ResponseEntity<>(i,HttpStatus.CREATED);
	}
	
	/**
	 * Gets the audit by id.
	 *
	 * @param id the id
	 * @return the audit by id
	 */
	@GetMapping(value="/audit/{id}")
	@ResponseBody
	public ResponseEntity<Audit> getAuditById(@PathVariable("id") int id){
		log.debug("AuditController.getAuditById request {}", id);
		Optional<Audit> audit = auditService.getAuditById(id);
		Audit resp = audit.isPresent() ? audit.get() : new Audit();
		log.debug("AuditController.getAuditById response {}", resp);
		return new ResponseEntity<>(resp,HttpStatus.OK);
	}

}
