package com.blogs.app.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@DynamicUpdate
@EqualsAndHashCode(callSuper = false)
public class Blog extends BaseEntity {

	@Column(columnDefinition = "varchar(200)")
	private String title;

	@ManyToOne
	private Author author;

	@Column(columnDefinition = "text")
	private String content;

	private LocalDateTime publishedDate;

	@Column(columnDefinition = "varchar(500)")
	private String tag;
}
