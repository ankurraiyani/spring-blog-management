package com.blogs.app.entity;

import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class BaseEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

    private Boolean isActive;

    private Boolean isDelete;

    /**
     * Set default values while adding new entry
     */
    @PrePersist
    private void prePersist() {
        this.createdDate = LocalDateTime.now();
        this.isActive = Boolean.TRUE;
        this.isDelete = Boolean.FALSE;
    }

    /**
     * Set updated date time automatically while updating entry
     */
    @PreUpdate
    private void preUpdate() {
        this.modifiedDate = LocalDateTime.now();
    }

}
