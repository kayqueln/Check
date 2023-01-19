/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Task;
import Util.ConnectionFactory;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.util.ArrayList;
import java.sql.ResultSet;

public class TaskController {
    
    public void save(Task task){
       String sql = "INSERT INTO Tasks (Name, "
               + "Description, "
               + "Completed, "
               + "Notes, "
               + "Deadline,"
               + "CreateDate,"
               + "UpdateDate,"
               + "IdProject) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
       
       Connection connection = null;
       PreparedStatement statement = null;
       
       try{
           connection = ConnectionFactory.getConnection();
           statement = connection.prepareStatement(sql);
           statement.setString(1, task.getName());
           statement.setString(2, task.getDescription());
           statement.setBoolean(3, task.isCompleted());
           statement.setString(4, task.getNotes());
           statement.setDate(5, new Date(task.getDeadline().getTime()));
           statement.setDate(6, new Date(task.getCreateTask().getTime()));
           statement.setDate(7, new Date(task.getUpdateTask().getTime()));
           statement.setInt(8, task.getIdProject());
           statement.execute();
       }
       catch(Exception ex){
           throw new RuntimeException("Erro ao salvar tarefa "+ ex.getMessage(), ex);
       }
       finally{
           ConnectionFactory.closeConnection(connection, statement);
       }      
    }
    
    
    public void update(Task task){
        String sql = "UPDATE Tasks SET "
                + "Name = ?, "
                + "Description = ?, "
                + "Notes = ?, "
                + "Deadline = ?, "
                + "Completed = ?, "
                + "UpdateDate = ?"
                + "WHERE IdTask = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, task.getName());
            statement.setString(2, task.getDescription());
            statement.setString(3, task.getNotes());
            statement.setDate(4, new Date(task.getDeadline().getTime()));
            statement.setBoolean(5, task.isCompleted());
            statement.setDate(6, new Date(task.getUpdateTask().getTime()));
            statement.setInt(7, task.getId());
            statement.execute();
        }
        catch(Exception ex){
            throw new RuntimeException("Erro ao atualizar tarefa "+ ex.getMessage(), ex);
        }
        finally{
            ConnectionFactory.closeConnection(connection, statement);
        }   
    }
    
    
    public void removeById(int taskId){
        String sql = "DELETE FROM Tasks WHERE IdTask = ?";

        Connection connection = null;
        PreparedStatement statement = null;
        
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, taskId);
            statement.execute();
        }
        catch(Exception ex){
            throw new RuntimeException("Erro ao deletar tarefa "+ ex.getMessage(), ex);
        }
        finally{
            ConnectionFactory.closeConnection(connection, statement);
        }             
    }
    
     
    public List<Task> getall(int IdProject){
        String sql = "SELECT * FROM Tasks WHERE IdProject = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        List<Task> tasks = new ArrayList<Task>();
                
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, IdProject);
            resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                Task task = new Task();
                task.setId(resultSet.getInt("IdTask"));
                task.setName(resultSet.getString("Name"));
                task.setDescription(resultSet.getString("Description"));
                task.setNotes(resultSet.getString("Notes"));
                task.setCompleted(resultSet.getBoolean("Completed"));
                task.setDeadline(resultSet.getDate("Deadline"));
                task.setCreateTask(resultSet.getDate("CreateDate"));
                task.setUpdateTask(resultSet.getDate("UpdateDate"));
                task.setIdProject(resultSet.getInt("IdProject"));
                tasks.add(task);
            }
        }
        catch(Exception ex){
            throw new RuntimeException("Erro ao mostrar tarefa "+ ex.getMessage(), ex);
        } 
        finally{
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        return tasks;
    }
    
}
