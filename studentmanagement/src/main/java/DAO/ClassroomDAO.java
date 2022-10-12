package DAO;

import connection.ConnectionDB;
import model.Classroom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassroomDAO implements IClassroomDAO{
    private static final String SELECT_CLASSROOM_BY_ID = "select * from classroom where id =?";
    private static final String SELECT_ALL_CLASSROOMS = "select * from classroom";


    //Trung
    //hoangoccho
    public ClassroomDAO() {
    }



    @Override
    public Classroom selectClassroom(int id) {
        Classroom classroom = null;
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLASSROOM_BY_ID)) {
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                classroom = new Classroom(id,name);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return classroom;
    }

    @Override
    public List<Classroom> selectAllClassrooms() {
        List<Classroom> classrooms = new ArrayList<>();
        try(Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLASSROOMS)){
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                classrooms.add(new Classroom(id,name));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return classrooms;
    }
}
