package aiss.gitminer.controller;


import aiss.gitminer.model.Project;
import aiss.gitminer.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gitminer/projects")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping
    public List<Project> getProjects() {return projectRepository.findAll();}

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable String id) {return projectRepository.findById(id).get();}

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Project createProject(@RequestBody Project project) {return projectRepository.save(project);}

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public Project updateProject(@PathVariable String id, @RequestBody Project project) {

        Project old = projectRepository.findById(id).get();
        old.setName(project.getName());
        old.setWebUrl(project.getWebUrl());
        old.setCommits(project.getCommits());
        old.setIssues(project.getIssues());

        return projectRepository.save(old);
    }


}
