package com.sit.model;

import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pid;
	@NotNull(message = "Project name is required")
	@Size(min = 3, max = 20,message = "Project name should be 3 to 20 characters" )
	private String name;
	@NotNull(message = "Project description is required")
	@Size(min = 5, max = 100,message = "Project description should be 5 to 100 characters" )
	private String description;
	@NotNull(message = "Project start date is required")
	private Date startDate;
	@NotNull(message = "Project end date is required")
	private Date endDate;
	
	@CreationTimestamp
	@Column(name = "CREATED_DATE", updatable = false)
	private LocalDateTime creationDate;
	@UpdateTimestamp
	@Column(name = "UPDATED_DATE", insertable = false) 
	private LocalDateTime updationDate;
	
	public Project() {
		
	}
	
	public Project(String name, String description, Date startDate, Date endDate) {
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	

	public Project(Integer pid,String name, String description,Date startDate,Date endDate) {
		this.pid = pid;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Integer getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid=pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
