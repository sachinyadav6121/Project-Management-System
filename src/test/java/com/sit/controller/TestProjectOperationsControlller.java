package com.sit.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sit.model.Project;
import com.sit.service.ProjectServiceImpl;

@WebMvcTest(controllers = ProjectOperationsController.class)
public class TestProjectOperationsControlller {

	@MockBean
	private ProjectServiceImpl projService;
	
	@InjectMocks
    private ProjectOperationsController projectController;

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void insertProjectTest() throws Exception{
		Project project = new Project(); // Create a valid project object
		project.setPid(1);project.setName("ABC");project.setDescription("project successfully completed");project.setStartDate(new Date(2023,05,25));
        when(projService.addProject(project)).thenReturn("Project details is saved with ID ::"+project.getPid());
        MockHttpServletRequestBuilder req=MockMvcRequestBuilders.post("/addProject");
        MvcResult result = mockMvc.perform(req).andReturn();
        MockHttpServletResponse response = result.getResponse();
		String contentAsString = response.getContentAsString();
		int status = response.getStatus();
		assertEquals("Project details is saved with ID ::1",contentAsString);
	}
}
