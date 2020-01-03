package com.practice.micro.repo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.practice.micro.model.Audit;


/**
 * The Class AuditRepoImpl.
 */
@Repository
public class AuditRepoImpl implements AuditRepo {
	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	@Override
	public int saveAudit(Audit audit) {
		return jdbcTemplate.update("INSERT INTO AUDIT_TBL (ID,STATUS,TYPE) VALUES(?,?,?)", 
				audit.getId(),audit.getStatus(),audit.getType());
	}

	
	@Override
	public Optional<Audit> getAuditbyId(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM AUDIT_TBL WHERE ID=?", new Object[]{id},
				(rs,rowNum)-> Optional.of(new Audit(rs.getInt("id"),rs.getString("status"),rs.getString("type"))) 
						);
	}

}
