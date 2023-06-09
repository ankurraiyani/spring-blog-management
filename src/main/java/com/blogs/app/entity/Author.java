package com.blogs.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Author extends BaseEntity {

	@Column(columnDefinition = "varchar(100)")
	private String firstName;
	
	@Column(columnDefinition = "varchar(100)")
	private String lastName;
	
	@Column(columnDefinition = "varchar(200)")
	private String email;                               
	
}
