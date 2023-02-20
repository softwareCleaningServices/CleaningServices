package entities;

public class Customer {
    private int id;
    private String fName;
    private String lName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String phone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Customer(int id, String fName, String lName, String email, String phone, String city, String street, String password) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.phone = phone;
        this.city = city;
        this.street = street;
        this.email = email;
        this.password = password;
    }

    private String city;
    private String street;
    private String email;
    private String password;


}
