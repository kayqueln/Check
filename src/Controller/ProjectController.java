/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Project;
import Util.ConnectionFactory;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

public class ProjectController {
   
    public void save(Project project){
        String sql = "INSERT INTO Projects(Name,"
                + "Description,"
                + "CreateDate,"
                + "UpdateDate) VALUES (?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;
        
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreateProject().getTime()));
            statement.setDate(4, new Date(project.getUpdateProject().getTime()));
            statement.execute();
        }
        catch(Exception ex){
            throw new RuntimeException("Erro ao salvar tarefa "+ ex.getMessage(), ex);
        }
        finally{
            ConnectionFactory.closeConnection(connection, statement);
        }
    } 
    
    
    public void update(Project project){
        String sql = "UPDATE Projects SET Name = ?, Description = ?, UpdateDate = ? "
                + "WHERE IdProject = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getUpdateProject().getTime()));
            statement.setInt(4, project.getId());
            statement.execute();
        }
        catch(Exception ex){
            throw new RuntimeException("Erro ao salvar tarefa "+ ex.getMessage(), ex);
        }
        finally{
            ConnectionFactory.closeConnection(connection, statement);
        } 
    }
    
    
    public void removeById(int IdProject){
        String sql = "DELETE FROM Projects WHERE IdProject = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, IdProject);
            statement.execute();
        }
        catch(Exception ex){
            throw new RuntimeException("Erro ao deletar tarefa "+ ex.getMessage(), ex);
        }
        finally{
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    
    public List<Project> getall(){
        String sql = "SELECT * FROM Projects";
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        List<Project> projects = new ArrayList<Project>();
        
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                Project project = new Project();
                project.setId(resultSet.getInt("IdProject"));
                project.setName(resultSet.getString("Name"));
                project.setDescription(resultSet.getString("Description"));
                project.setCreateProject(resultSet.getDate("CreateDate"));
                project.setUpdateProject(resultSet.getDate("UpdateDate"));
                projects.add(project);                
            }
        
        }
        catch(Exception ex){
            throw new RuntimeException("Erro ao mostar projeto "+ ex.getMessage(), ex);
        }
        finally{
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        return projects;
    }
    
}
