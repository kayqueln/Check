/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


import java.util.Date;


public class Project {
    
    private int Id;
    private String Name;
    private String Description;
    private Date CreateProject;
    private Date UpdateProject;

    public Project(int Id, String Name, String Description, Date CreateProject, Date UpdateProject) {
        this.Id = Id;
        this.Name = Name;
        this.Description = Description;
        this.CreateProject = CreateProject;
        this.UpdateProject = UpdateProject;
    }  

    public Project() {
        
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Nome) {
        this.Name = Nome;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Date getCreateProject() {
        return CreateProject;
    }

    public void setCreateProject(Date CreateProject) {
        this.CreateProject = CreateProject;
    }

    public Date getUpdateProject() {
        return UpdateProject;
    }

    public void setUpdateProject(Date UpdateProject) {
        this.UpdateProject = UpdateProject;
    }

    @Override
    public String toString() {
        return this.Name;
    }
    
    
    
}
