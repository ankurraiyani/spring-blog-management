package com.blogs.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.app.entity.Blog;
import com.blogs.app.request.BlogRequestDto;
import com.blogs.app.response.ApiResponse;
import com.blogs.app.service.BlogService;
import com.blogs.app.service.ResponseGenerator;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/blog")
public class BlogController {

	@Autowired
	private BlogService blogService;

	/**
	 * @param blogRequest
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	public ResponseEntity<ApiResponse> createBlogPost(@Valid @RequestBody BlogRequestDto blogRequest) throws Exception {
		
		// Save or update blog
		Blog blog = blogService.save(blogRequest);
		
		// If blog is returned send success resposne else failure response.
		return blog.getId() > 0 ? ResponseGenerator.success("Successfully Saved.") 
								: ResponseGenerator.failure(); 
	}

	/**
	 * @param id
	 * @return
	 */
	@GetMapping("/get/{id}")
	public ResponseEntity<ApiResponse> readBlogPost(@PathVariable Long id) {

		// Fetch blog by id
		return ResponseGenerator.success(blogService.get(id));
	}

	/**
	 * @param id
	 * @return
	 */
	@GetMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteBlogPost(@PathVariable Long id) {
		
		// delete blog by id
		blogService.delete(id);
		
		return ResponseGenerator.success("Successfully Deleted.");
	}

	@GetMapping("/get/all-active/{page}/{pageSize}")
	public ResponseEntity<ApiResponse> getAllBlogPosts(@PathVariable("page") Integer page, @PathVariable("pageSize") Integer pageSize ) throws Exception {
		
		// get all active blogs
		return ResponseGenerator.success(blogService.getAllActive(page, pageSize));
	}
	
	@GetMapping("/get/all")
	public ResponseEntity<ApiResponse> getAllBlogPosts() {
		
		// get all blogs
		return ResponseGenerator.success(blogService.getAll());
	}
}
