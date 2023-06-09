package com.blogs.app.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BlogRequestDto {

	private Long id;

	@NotBlank(message = "title can not be blank")
	private String title;

	@NotNull(message = "authorId can not be blank")
	private Long authorId;

	@NotBlank(message = "content can not be blank")
	private String content;

	private LocalDateTime publishedDate;

	private String tag;
	
}
