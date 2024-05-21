
package com.example.examproject.service;

import com.example.examproject.model.Project;
import com.example.examproject.model.Task;
import com.example.examproject.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProjectService {
    private ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    public LocalDate getProjectEndDate(int projectId) {
        return projectRepository.showProjectTime(projectId);
    }


    public void printProjectTime(int projectId) {
        LocalDate projectEndTime = projectRepository.showProjectTime(projectId);
        if (projectEndTime != null) {
            System.out.println("Project End Time for project " + projectId + ": " + projectEndTime);
        } else {
            System.out.println("No end time found for project " + projectId);
        }
    }

    public List<Task> assignedTasks(int projectID) {
        return projectRepository.assignedTasks(projectID);
    }

    public List<Project> findProjectsByImminentDeadlines() {
        return projectRepository.findProjectsByImminentDeadlines();
    }

    public List<Project> findOverdueProjects() {
        return projectRepository.findOverdueProjects();
    }

    public List<Project> findCompletedProjects() {
        return projectRepository.findCompletedProjects();
    }

    public List<Project> findAllProjects() {
        return projectRepository.findAllProjects();
    }

    public void createTask(Task task, int userID, int projectID) {
        projectRepository.createTask(task, userID, projectID);
    }
}