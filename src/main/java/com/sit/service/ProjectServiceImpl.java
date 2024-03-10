package com.sit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sit.advice.ProjectException;
import com.sit.model.Project;
import com.sit.repository.ProjectRepo;

@Service
public class ProjectServiceImpl implements IProjectService {
	
	@Autowired
	private ProjectRepo projectRepo;
	
	@Override
	public Project getProjectByName(String name) {
		Optional<Project> proj = projectRepo.findByName(name);
		if (!proj.isPresent()) {
			return null;
		}
		return proj.get();
	}

	@Override
	public String addProject(Project proj) throws ProjectException{
		Project project = getProjectByName(proj.getName());
		if (project!=null) {
			throw new ProjectException("Project is already exists");
		}
		int idVal = projectRepo.save(proj).getPid();
		return "Project details is saved with ID :: "+idVal;
	}

	@Override
	public Project updateProject(Project project) throws ProjectException{
		Optional<Project> proj = projectRepo.findById(project.getPid());
		if (!proj.isPresent()) {
			throw new ProjectException("Project is not found with id :: "+project.getPid());
		} 
		return projectRepo.save(project);
	}

	@Override
	public String deleteProject(int pid) throws ProjectException {
		Optional<Project> project = projectRepo.findById(pid);
		if (!project.isPresent()) {
			throw new ProjectException("Project is not found with id :: "+pid);
		}
		projectRepo.deleteById(pid);
		return " Project is deleted with id :: "+pid;
	}

	@Override
	public Project getProject(int pid) throws ProjectException {
		Optional<Project> project = projectRepo.findById(pid);
		 if (!project.isPresent()) {
	            throw new ProjectException("Project not found with id: " + pid);
	        }
	        return project.get();
	}

	@Override
	public List<Project> getAllProject() {
		return  projectRepo.findAll();
	}
}
