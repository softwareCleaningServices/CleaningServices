package najah.edu;


import entities.Data;

public class Login {
    private String email;
    private String password;
    private String rul;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRul(String rul) {
        this.rul = rul;
    }

    public Login(String email, String password, String rul) {
        this.email = email;
        this.password = password;
        this.rul = rul;
    }

    public Login() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRul() {
        return rul;
    }

    public String msg(){
        String message="";
        if(isCorrectInfo()) {
            if (rul.equals("admin")) {
                message = "Admin login success";
            } else if (rul.equals("customer")) {
                message = "Customer login success";
            }
        }
             else {
            message="login fail";
        }
        return message;
    }

    @Override
    public String toString() {
        return
                 email +" " + password +" "  + "customer" + "\r\n";

    }

    public boolean isCorrectInfo() {
        int flag=0;
        for (Login login: Data.users()){
            if(login.getEmail().equals(email)&&login.getPassword().equals(password)){
            this.login=login;
                flag=1;
                break;
            }
        }
        return flag==1;
    }
    Login login;
    public void login() {
        if (isCorrectInfo()) {
            if (login.getRul().equals("admin")) {
                AdminLogin admin = new AdminLogin();
                admin.adminPage();
            } else if (login.getRul().equals("customer")) {
                CustomerLogin customerLogin = new CustomerLogin();
                customerLogin.setCustomer(Data.getCustomerBy(email));
                customerLogin.customerPage();
            }
        }
    }
}
