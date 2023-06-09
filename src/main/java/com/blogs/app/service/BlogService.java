package com.blogs.app.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.app.entity.Author;
import com.blogs.app.entity.Blog;
import com.blogs.app.repository.BlogRepository;
import com.blogs.app.request.BlogRequestDto;
import com.blogs.app.response.BlogException;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;

	/**
	 * Save or Update Blog
	 * 
	 * @param blogRequest
	 * @return
	 */
	public Blog save(BlogRequestDto blogRequest) {
		
		Blog blog = null;
		
		// If id is present fetch blog and update
		if (blogRequest.getId() != null)
			blog= this.get(blogRequest.getId());
		else
			blog = new Blog();
			
		// save or update blog
		return blogRepository.save(convertBlogRequestToBlog(blogRequest, blog));
		
	}

	/**
	 * @param id
	 * @return
	 * @throws BlogException
	 */
	public Blog get(long id) throws BlogException {

		// Get blog by id
		return blogRepository.findByIdAndIsActiveTrueAndIsDeleteFalse(id)
							.orElseThrow(() -> new BlogException("Blog Not Found"));
	}

	/**
	 * @param id
	 */
	@Transactional
	public void delete(long id) {
		
		// check if id is present or not
		this.get(id);	
		
		// delete blog by id
		blogRepository.softDelete(id);
	}

	/*
	 * Get all active blogs with pagination
	 */
	public Page<Blog> getAllActive(int pageNo, int pageSize) {
		
		// Set Pagination
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		
		// Get all active blog
		return blogRepository.findByIsActiveTrueAndIsDeleteFalse(pageable);
	}
	
	/*
	 * Get All BLogs 
	 */
	public List<Blog> getAll() {
		
		// Get all active and inactive blogs
		return blogRepository.findAll();
	}


	/**
	 * @param blogRequestDto
	 * @param blog
	 * @return
	 */
	public Blog convertBlogRequestToBlog(BlogRequestDto blogRequestDto, Blog blog) {
		
		// Mapping for requestdto and entity
		BeanUtils.copyProperties(blogRequestDto, blog);
		
		Author author = new Author();
		
		// Set author id
		author.setId(blogRequestDto.getAuthorId());
		
		// set author in entity
		blog.setAuthor(author);
		
		return blog;
	}
}
