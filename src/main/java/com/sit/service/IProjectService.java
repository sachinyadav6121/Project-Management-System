package com.sit.service;

import java.util.List;

import com.sit.advice.ProjectException;
import com.sit.model.Project;

public interface IProjectService {

	public String addProject(Project project) throws ProjectException;
	public Project getProjectByName(String name);
	public Project updateProject(Project project) throws ProjectException;
	public String deleteProject(int pid) throws ProjectException;
	public Project getProject(int pid) throws ProjectException;
	public List<Project> getAllProject();
}
