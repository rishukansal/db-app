package com.practice.micro.service;

import java.util.Optional;

import com.practice.micro.model.Audit;


/**
 * The Interface AuditService.
 */
public interface AuditService {
	
	/**
	 * Save audit.
	 *
	 * @param audit the audit
	 * @return the int
	 */
	public int saveAudit(Audit audit);
	
	/**
	 * Gets the audit by id.
	 *
	 * @param id the id
	 * @return the audit by id
	 */
	public Optional<Audit> getAuditById(int id);

}
