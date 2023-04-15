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
    Category category;
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
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public int getNumOfProd() {
        return numOfProd;
    }
    public void setNumOfProd(int numOfProd) {
        this.numOfProd = numOfProd;
    }
    public void setNumOfProd(){
        numOfProd++;
    }
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public Worker(int id, String name, String phone, String address, String email, int salary, Category category)
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

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public int getSalary() {
        return salary;
    }

    public Worker() {
    }
    public boolean isValidEmail() {
        String emailRegex= "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPat=Pattern.compile (emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher=emailPat.matcher (this.getEmail());
        return matcher.find();
    }

    public boolean isExistWorker() {
        boolean flag=false;
        for(Worker worker:Data.getWorkers()){
            if(worker.getId()==this.id) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
