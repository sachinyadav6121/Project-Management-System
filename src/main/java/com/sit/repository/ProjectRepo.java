package com.sit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sit.model.Project;

public interface ProjectRepo extends JpaRepository<Project, Integer> {
	Optional<Project>  findByName(String name);
}
