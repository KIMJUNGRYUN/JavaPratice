public class User {
    private String id;
    private String name;
    private String password;

    public User(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean validatePassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }


    @Override
    public String toString() {
        return "User{" + "id='" + id + "', name='" + name + "'}";
    }
}
