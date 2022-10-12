package DAO;

import model.Classroom;

import java.sql.SQLException;
import java.util.List;

public interface IClassroomDAO {

    public Classroom selectClassroom(int id);

    public List<Classroom> selectAllClassrooms();



}
