package DAO;

import connection.ConnectionDB;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDAO{
    private static final String INSERT_STUDENT_SQL = "INSERT INTO student (name,dateofbirth,address,phonenumber,email,classroom_id) VALUES (?,?,?,?,?,?);";
    private static final String SELECT_STUDENT_BY_ID = "select * from student where id =?";
    private static final String SELECT_ALL_STUDENTS = "select * from student";
    private static final String DELETE_STUDENTS_SQL = "delete from student where id = ?;";
    private static final String UPDATE_STUDENTS_SQL = "update student set name = ?, dateofbirth = ?, address = ?, email = ?, phonenumber =?,  classroom_id = ? where id = ?;";

    private static final String SEARCH_STUDENTS_BY_NAME = "select * from student where student.name like ?;";
    public StudentDAO(){}

    @Override
    public void insertStudent(Student student) throws SQLException {
        System.out.println(INSERT_STUDENT_SQL);
        try (Connection connection = ConnectionDB.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setDate(2, student.getDateOfBirth());
            preparedStatement.setString(3,student.getAddress());
            preparedStatement.setString(4,student.getPhoneNumber());
            preparedStatement.setString(5,student.getEmail());
            preparedStatement.setInt(6,student.getClassroomId());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Student selectStudent(int id) {
        Student student = null;
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID)) {
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                Date dateOfBirth = rs.getDate("dateofbirth");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phonenumber");
                String email = rs.getString("email");
                int classroomId = rs.getInt("classroom_id");
                student = new Student(id,name,dateOfBirth,address,phoneNumber,email,classroomId);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return student;
    }

    @Override
    public List<Student> selectAllStudents() {
        List<Student> students = new ArrayList<>();
        try(Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS)){
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date dateOfBirth = rs.getDate("dateofbirth");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phonenumber");
                String email = rs.getString("email");
                int classroomId = rs.getInt("classroom_id");
                students.add(new Student(id,name,dateOfBirth,address,phoneNumber,email,classroomId));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return students;
    }

    @Override
    public boolean deleteStudent(int id) throws SQLException {
        boolean rowDeleted;
        try(Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENTS_SQL)){
            System.out.println(preparedStatement);
            preparedStatement.setInt(1,id);
            rowDeleted = preparedStatement.executeUpdate() >0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateStudent(Student student) throws SQLException {
        boolean rowUpdated;
        try(Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENTS_SQL)){
            preparedStatement.setString(1,student.getName());
            preparedStatement.setDate(2,student.getDateOfBirth());
            preparedStatement.setString(3,student.getAddress());
            preparedStatement.setString(5,student.getPhoneNumber());
            preparedStatement.setString(4   ,student.getEmail());
            preparedStatement.setInt(6,student.getClassroomId());
            preparedStatement.setInt(7,student.getId());
            rowUpdated = preparedStatement.executeUpdate() >0;
        }
        return rowUpdated;
    }

    @Override
    public List<Student> searchByName(String name) {
        List<Student> students = new ArrayList<>();
        try(Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_STUDENTS_BY_NAME)){
            System.out.println(preparedStatement);
            preparedStatement.setString(1,"%" + name + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String studentName = rs.getString("name");
                Date dateOfBirth = rs.getDate("dateOfBirth");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phonenumber");
                String email = rs.getString("email");
                int classroomId = rs.getInt("classroom_id");

                students.add(new Student(id,name,dateOfBirth,address,phoneNumber,email,classroomId));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return students;
    }
}
