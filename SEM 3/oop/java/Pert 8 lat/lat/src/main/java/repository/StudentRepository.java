package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mysql.cj.protocol.Resultset;

import config.DBUtil;
import model.Student;

public class StudentRepository implements IDataAccess<Student> {
    @Override
    public List<Student> getAll() {
        Connection conn = null;
        String sql = "SELECT * FROM students";
        try {
            List<Student> students = new ArrayList<>();
            conn = DBUtil.openConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultset = statement.executeQuery();
            while (resultset.next()) {
                students.add(new Student(
                    resultset.getInt("id"), 
                    resultset.getString("name"), 
                    resultset.getString("email"))
                );
            }
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Optional<Student> getById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public void insert(Student entity) {
        Connection conn = null;
        String sql = "INSERT INTO students(id, name, email) VALUES (?,?,?)";
        try {
            conn = DBUtil.openConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, entity.getId());
            statement.setString(2, entity.getName());
            statement.setString(3, entity.getEmail());
            
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Student entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
