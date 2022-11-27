package test;

import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.ProjectsStep;

public class ProjectTest {
    ProjectsStep projectsStep = new ProjectsStep();

    @Test
    public void createProjectTest() {
        projectsStep.createProject("test1", "sdfssd", 1, false, true, true);
    }

    @Test
    public void updateProjectTest() {
        Project project = new Project();
        project.setName("test1");
        project.setDescription("sfffffgf");
        project.setType(2);
        project.setShowAnon(false);
        project.setAccess(true);
        project.setDeleted(true);

        projectsStep.createProject(project);
    }

    @Test
    public void compareProjectTest() {
        Project project = new Project();
        project.setName("test1");
        project.setDescription("sfffffgf");
        project.setType(2);
        project.setShowAnon(false);
        project.setAccess(true);
        project.setDeleted(true);

        Project project1 = new Project();
        project1.setName("test1");
        project1.setDescription("sfffffgf");
        project1.setType(2);
        project1.setShowAnon(false);
        project1.setAccess(true);
        project1.setDeleted(false);

        Assert.assertTrue(project.equals(project1));
    }
}
