package app.model;

import app.entities.Role;
import app.entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    private static Model instance = new Model();
    private List<User> model;
    private DBase dBase;
    private Statement statement;
    private ResultSet rs;

    public static Model getInstance() {
        return instance;
    }

    private Model()
    {
        model = new ArrayList<User>();
        try {
            dBase = DBase.getInstance();
            statement = dBase.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser(User user) {
        try {
            statement.execute("INSERT INTO users (name, pass, type) VALUES ('" + user.getName() + "', '" + user.getPass() + "', '" + user.getType() + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        model.add(user);
    }

    public List<String> list() {
        return model.stream().map(User::getName).collect(Collectors.toList());
    }

    public List<User> selectUsersAndRoles() {
        List<User> users = new ArrayList<>();
        try {
            rs = statement.executeQuery("SELECT users.id, users.name, roles.type FROM users LEFT JOIN roles ON users.type=roles.id;");
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setType(rs.getString("type"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
//        return users.stream().map(User::getNameAndType).collect(Collectors.toList());
    }

    public List<Role> getRoleList() {
        List<Role> roles = new ArrayList<>();
        try {
            dBase = DBase.getInstance();
            Statement statement = dBase.getConnection().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM roles;");
            while (rs.next()) {
                Role role = new Role();
                role.setId(rs.getInt("id"));
                role.setType(rs.getString("type"));
                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    public User getUserById(int userId) {
        return null;
    }

    public void deleteUserById(int userId) {

    }
}
