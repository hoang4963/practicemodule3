
package servlet;




import DAO.ClassroomDAO;
import DAO.StudentDAO;
import model.Classroom;
import model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = "/students")
public class StudentServlet extends HttpServlet {
    private StudentDAO studentDAO;
    private ClassroomDAO classroomDAO;
    public void init() {
        studentDAO = new StudentDAO();
        classroomDAO = new ClassroomDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteStudent(request, response);
                    break;
                case "searchByName":
                    searchByName(request,response);
                    break;
                default:
                    listStudent(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("searchByName");
        List<Student> searchStudents;
        searchStudents = studentDAO.searchByName(name);
        request.setAttribute("searchStudents", searchStudents);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/search.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
        List<Classroom> classrooms = classroomDAO.selectAllClassrooms();
        request.setAttribute("listClassrooms",classrooms);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student existingStudent = studentDAO.selectStudent(id);
        request.setAttribute("student", existingStudent);
        List<Classroom> classrooms = classroomDAO.selectAllClassrooms();
        request.setAttribute("listClassrooms", classrooms);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/edit.jsp");
        dispatcher.forward(request, response);

    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response) {
        List<Student> listStudent = studentDAO.selectAllStudents();
        request.setAttribute("listStudent", listStudent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertStudent(request, response);
                    break;
                case "edit":
                    updateStudent(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    private void insertStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        Date dateOfBirth = Date.valueOf(request.getParameter("dateOfBirth"));
        String address = request.getParameter("address");
        String phoneNumer = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        int classroomId = Integer.parseInt(request.getParameter("classroomId"));
        Student newStudent = new Student(name,dateOfBirth,address,phoneNumer,email,classroomId);
        studentDAO.insertStudent(newStudent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/create.jsp");
        dispatcher.forward(request, response);
    }
    private void updateStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Date dateOfBirth = Date.valueOf(request.getParameter("dateOfBirth"));
        String address = request.getParameter("address");
        String phoneNumer = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        int classroomId = Integer.parseInt(request.getParameter("classroomId"));
        Student student = new Student(id, name,dateOfBirth,address,phoneNumer,email,classroomId);
        studentDAO.updateStudent(student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/edit.jsp");
        dispatcher.forward(request, response);
    }
    private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentDAO.deleteStudent(id);
        List<Student> listStudent = studentDAO.selectAllStudents();
        request.setAttribute("listStudent", listStudent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/list.jsp");
        dispatcher.forward(request, response);
    }
}
