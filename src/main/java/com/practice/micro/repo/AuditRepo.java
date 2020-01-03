package com.practice.micro.repo;

import java.util.Optional;

import com.practice.micro.model.Audit;


/**
 * The Interface AuditRepo.
 */
public interface AuditRepo {
	
	/**
	 * Save audit.
	 *
	 * @param audit the audit
	 * @return the int
	 */
	public int saveAudit(Audit audit);
	
	/**
	 * Gets the auditby id.
	 *
	 * @param id the id
	 * @return the auditby id
	 */
	public Optional<Audit> getAuditbyId(int id);

}
