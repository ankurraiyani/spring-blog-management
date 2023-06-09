package com.blogs.app.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.blogs.app.entity.Blog;


@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
	
	// Get all active blogs
	Page<Blog> findByIsActiveTrueAndIsDeleteFalse(Pageable pageable);

	// Get active blog by id
	Optional<Blog> findByIdAndIsActiveTrueAndIsDeleteFalse(Long id);

	// Soft delete blogs by id
	@Modifying
	@Query("UPDATE Blog SET isActive = false, isDelete = true WHERE id = :id")
	void softDelete(Long id);
}
