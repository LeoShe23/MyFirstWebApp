package app.entities;

public class User {
    private int id;
    private String name;
    private String pass;
    private String type;

//    public User(String name, String pass, String type) {
////        this.id = id;
//        this.name = name;
//        this.pass = pass;
//        this.type = type;
//    }

    public User() {

    }

    public String getNameAndType() {
        return getName() + "\t|\t" + getType();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (id != 0 ? id != user.id : user.id != 0) return false;
        return pass != null ? pass.equals(user.pass) : user.pass == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (pass != null ? pass.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
