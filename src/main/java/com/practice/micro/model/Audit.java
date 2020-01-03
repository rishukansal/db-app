package com.practice.micro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The Class Audit.
 */

@Data
/**
 * Instantiates a new audit.
 */
@NoArgsConstructor

/**
 * Instantiates a new audit.
 *
 * @param id the id
 * @param status the status
 * @param type the type
 */
@AllArgsConstructor
public class Audit {
	
	/** The id. */
	private int id;
	
	/** The status. */
	private String status;
	
	/** The type. */
	private String type;

}
