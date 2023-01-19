/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import Controller.ProjectController;
import Controller.TaskController;
import Model.Project;
import Model.Task;
import Util.ConnectionFactory;
import java.sql.Connection;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        
        ProjectController projectController = new ProjectController();
        Project project = new Project();
        
        TaskController taskController = new TaskController();        
        Task task = new Task();
        
        
        //INSERT NA TABELA PROJETOS
//        project.setName("Projeto Teste 3");
//        project.setDescription("Description");
//        project.setCreateProject(calendar.getTime());
//        project.setUpdateProject(calendar.getTime());       
//        projectController.save(project);


        //UPDATE NA TABELA PROJETOS
//        project.setName("Projeto atualizado 2");
//        project.setDescription("Description");
//        project.setUpdateProject(calendar.getTime());
//        project.setId(2);
//        projectController.update(project);


        //DELETE NA TABELA PROJETOS
//        projectController.removeById();


        //READ NA TABELA PROJETOS
//        List<Project> projects = projectController.getall();
//        System.out.println("Total de projetos = "  + projects.size());


        
        //INSERT NA TABELA TAREFAS
//        task.setName("Tarefa teste");
//        task.setDescription("Description");
//        task.setCompleted(false);
//        task.setNotes("Notes");
//        task.setDeadline("16/02/2023");
//        task.setCreateTask(calendar.getTime());
//        task.setUpdateTask(calendar.getTime());
//        task.setIdProject(1);
//        taskController.save(task);


        //UPDATE NA TABELA TAREFAS
//        task.setName("Tarefa 3 *atualizada");
//        task.setDescription("Description");
//        task.setCompleted(false);
//        task.setNotes("Notes");
//        task.setDeadline("10/02/2023");
//        task.setUpdateTask(calendar.getTime());
//        task.setId(3);
//        taskController.update(task);


        //DELETE NA TABELA TAREFAS
//        taskController.removeById(2);


        //READ NA TABELA TAREFAS
//        List<Task> tasks = taskController.getall(2);
//        System.out.println("Total de projetos = "  + tasks.size());

    }
    
}
