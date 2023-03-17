package entities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Worker {
    private int id;
    private String name;
    private String phone;
    private String address;
    private String email;
    private int salary;
    String category;
    private int numOfProd;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return
                id +
                "," + name +
                "," + phone +
                "," + address +
                "," + email +
                "," + salary +
                "," + category+
                "," + numOfProd +
                "\r\n";
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setNumOfProd(int numOfProd) {
        this.numOfProd = numOfProd;
    }

    public String getCategory() {
        return category;
    }

    public Worker(int id, String name, String phone, String address, String email, int salary, String category)
    {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.email=email;
        this.salary=salary;
        this.category=category;
        this.numOfProd=0;
    }
    public void setNumOfProd(){
        numOfProd++;
    }

    public int getNumOfProd() {
        return numOfProd;
    }

    public String getEmail() {
        return email;
    }

    public Worker() {
    }

    public boolean isValidEmail() {
        String emailRegex= "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPat=Pattern.compile (emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher=emailPat.matcher (this.getEmail());
        return matcher.find();
    }
}
