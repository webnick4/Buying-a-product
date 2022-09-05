package lesson19.models;

public class Cashier {
    private String name;
    private String login;
    private byte age;
    private long id;

    public Cashier(String name, String login, byte age, long id) {
        this.name = name;
        this.login = login;
        this.age = age;
        this.id = id;
    }

    public Cashier() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
