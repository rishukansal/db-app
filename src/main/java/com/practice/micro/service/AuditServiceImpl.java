package com.practice.micro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.micro.model.Audit;
import com.practice.micro.repo.AuditRepo;


/**
 * The Class AuditServiceImpl.
 */
@Service
public class AuditServiceImpl implements AuditService {
	
	/** The audit repo. */
	@Autowired
	private AuditRepo auditRepo;


	@Override
	public int saveAudit(Audit audit) {
		return auditRepo.saveAudit(audit);
	}

	
	@Override
	public Optional<Audit> getAuditById(int id) {
		return auditRepo.getAuditbyId(id);
	}

}
