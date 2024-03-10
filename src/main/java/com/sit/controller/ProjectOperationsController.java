package com.sit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sit.advice.ProjectException;
import com.sit.model.Project;
import com.sit.service.IProjectService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/project-api")
public class ProjectOperationsController {

	@Autowired
	private IProjectService projectService;
	
	@PostMapping("/addProject")
	public ResponseEntity<String> insertProject(@RequestBody @Validated Project project, BindingResult result) throws ProjectException{
			if (result.hasErrors()) {
				return ResponseEntity.badRequest().body("Validation errors: " + result.getAllErrors());
			}
			String msg = projectService.addProject(project);
			return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	
	@GetMapping("/getProject/{pid}")
	public ResponseEntity<Project> fetchProject(@PathVariable int pid) throws ProjectException {
		Project project = projectService.getProject(pid);
		return new ResponseEntity<Project>(project,HttpStatus.OK);
	}
	
	@GetMapping("/getAllProjects")
	public ResponseEntity<List<Project>> fetchAllProjects() throws Exception{
		List<Project> allProject = projectService.getAllProject();
		return new ResponseEntity<List<Project>>(allProject,HttpStatus.OK);
	}
	
	@PutMapping("/updateProject")
	public ResponseEntity<?> modifyProject(@RequestBody @Validated Project project, BindingResult result) throws ProjectException{
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().body("Validation errors: " + result.getAllErrors());
		}
		Project proj = projectService.updateProject(project);
		return new ResponseEntity<Project>(proj,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteProject/{pid}")
	public ResponseEntity<String> deleteProject(@PathVariable int pid) throws ProjectException{
		String result = projectService.deleteProject(pid);
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
}
