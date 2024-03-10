package com.sit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.sit.advice.ProjectException;
import com.sit.model.Project;
import com.sit.repository.ProjectRepo;

@SpringBootTest
@ExtendWith(value = { MockitoExtension.class })
public class TestProjectServiceImpl {
	
	@Mock
	private ProjectRepo projectRepo;

	@InjectMocks
	private ProjectServiceImpl projectService;
	
	private Project project;
	
	@DisplayName("JUnit test for addProject method")
	@Test
	public void addProjectTest() throws ProjectException {
		when(projectRepo.findByName("ABC")).thenReturn(Optional.empty());
		when(projectRepo.save(project)).thenReturn(project);
		
		String msg = projectService.addProject(project);
		assertEquals("Project details is saved with ID :: 1", msg);
	}
	
}
