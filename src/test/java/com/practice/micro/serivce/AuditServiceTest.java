package com.practice.micro.serivce;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.practice.micro.model.Audit;
import com.practice.micro.repo.AuditRepo;
import com.practice.micro.service.AuditService;
import com.practice.micro.service.AuditServiceImpl;


/**
 * The Class AuditServiceTest.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AuditServiceTest {
	
	/**
	 * The Class AuditServiceImplTestContextConfig.
	 */
	@TestConfiguration
	static class AuditServiceImplTestContextConfig {
		
		/**
		 * Audit service.
		 *
		 * @return the audit service
		 */
		@Bean
		public AuditService auditService() {
			return new AuditServiceImpl();
		}
	}
	
	/** The audit service. */
	@Autowired
	private AuditService auditService;
	
	/** The audit repo. */
	@MockBean
	private AuditRepo auditRepo;
	
	/**
	 * Setup.
	 */
	@BeforeEach
	public void setup() {
		Audit audit = new Audit(1,"Started","Tracbility");
		Mockito.when(auditRepo.getAuditbyId(1)).thenReturn(Optional.of(audit));
	}
	
	/**
	 * Gets the audit by id test.
	 *
	 * @return the audit by id test
	 */
	@Test
	public void getAuditByIdTest() {
		Optional<Audit> auditReturned = auditService.getAuditById(1);
		assertThat(auditReturned.get().getId()).isEqualTo(1);
	}

}
