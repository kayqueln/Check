/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author Administrador
 */
public class Task {
    
    private int Id;
    private String Name;
    private String Description;
    private boolean Completed;
    private String Notes;
    private Date deadline;
    private Date CreateTask;
    private Date UpdateTask;
    private int IdProject;

    public Task(int Id, int IdProject, String Name, String Description, boolean Completed, String Notes, Date deadline, Date CreateTask, Date UpdateTask) {
        this.Id = Id;
        this.IdProject = IdProject;
        this.Name = Name;
        this.Description = Description;
        this.Completed = Completed;
        this.Notes = Notes;
        this.deadline = deadline;
        this.CreateTask = CreateTask;
        this.UpdateTask = UpdateTask;
    }
    
    public Task(){
        this.CreateTask = new Date();
    }
    

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getIdProject() {
        return IdProject;
    }

    public void setIdProject(int IdProject) {
        this.IdProject = IdProject;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public boolean isCompleted() {
        return Completed;
    }

    public void setCompleted(boolean Completed) {
        this.Completed = Completed;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getCreateTask() {
        return CreateTask;
    }

    public void setCreateTask(Date CreateTask) {
        this.CreateTask = CreateTask;
    }

    public Date getUpdateTask() {
        return UpdateTask;
    }

    public void setUpdateTask(Date UpdateTask) {
        this.UpdateTask = UpdateTask;
    }

    @Override
    public String toString() {
        return "Task{" + "Id=" + Id + ", IdProject=" + IdProject + ", Name=" + Name + ", Description=" + Description + ", Completed=" + Completed + ", Notes=" + Notes + ", deadline=" + deadline + ", CreateTask=" + CreateTask + ", UpdateTask=" + UpdateTask + '}';
    }
}
