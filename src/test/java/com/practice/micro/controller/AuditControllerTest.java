package com.practice.micro.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;
import com.practice.micro.model.Audit;
import com.practice.micro.service.AuditService;


/**
 * The Class AuditControllerTest.
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(AuditController.class)
public class AuditControllerTest {
	
	/** The mock mvc. */
	@Autowired
	private MockMvc mockMvc;
	
	/** The audit service. */
	@MockBean
	private AuditService auditService;
	
	/**
	 * Gets the audit by id test.
	 *
	 * @return the audit by id test
	 * @throws Exception the exception
	 */
	@Test
	public void getAuditByIdTest() throws Exception {
		Audit audit = new Audit(1,"Pending","Sustainability");
		Mockito.when(auditService.getAuditById(1)).thenReturn(Optional.of(audit));
		mockMvc.perform(get("/audit/1").
				contentType(MediaType.APPLICATION_JSON)).
				andExpect(status().isOk()).andExpect(jsonPath("$.id",is(1)));
	}
	
	/**
	 * Test save audit.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testSaveAudit() throws Exception {
		Gson gson = new Gson();
		Audit audit = new Audit(1,"Pending","Sustainability");
		Mockito.when(auditService.saveAudit(audit)).thenReturn(1);
		mockMvc.perform(post("/audit").accept(MediaType.APPLICATION_JSON).content(gson.toJson(audit)).
				contentType(MediaType.APPLICATION_JSON)).
				andExpect(status().isCreated());
	}
}
