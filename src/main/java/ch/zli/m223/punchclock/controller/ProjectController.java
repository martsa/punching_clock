package ch.zli.m223.punchclock.controller;


import ch.zli.m223.punchclock.domain.Project;
import ch.zli.m223.punchclock.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    /**
     * Give a list with all project back
     * @return List<Project>
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Project> getAllProjects(){
        return projectService.findAll();
    }

    /**
     * create a new project data
     * @param project
     **/
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Project createProject(@Valid @RequestBody Project project){
        return projectService.createProject(project);
    }

    /**
     * Delete project data with referenc to id
     * @param id
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProject(@PathVariable("id") Long id){
        projectService.deleteProject(id);
    }

    /**
     * Update project data
     * @param project
     * @return
     */
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Project updateProject(@Valid @RequestBody Project project){
        return projectService.updateProject(project);
    }



}
