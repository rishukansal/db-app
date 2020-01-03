package com.practice.micro.repo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.practice.micro.model.Audit;


/**
 * The Class AuditRepoTest.
 */
@ExtendWith(SpringExtension.class)
@JdbcTest
@ComponentScan
public class AuditRepoTest {
	
	/** The audit repo. */
	@Autowired
	private AuditRepo auditRepo;
	
	/**
	 * Save audit test.
	 */
	@Test
	public void saveAuditTest() {
		Audit audit = new Audit(1,"Started","Tracability");
		int i = auditRepo.saveAudit(audit);
		Optional<Audit> auditReturned = auditRepo.getAuditbyId(1);
		assertThat(auditReturned).isPresent();
		assertThat(i).isEqualTo(1);
	}
	

}
