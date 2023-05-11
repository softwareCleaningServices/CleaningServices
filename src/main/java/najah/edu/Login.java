package najah.edu;


import entities.Data;

public class Login {
    private String email;
    private String password;
    private String rul;
    Login loginVar;
    public Login() {
    }
    public Login(String email, String password, String rul) {
        this.email = email;
        this.password = password;
        this.rul = rul;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRul() {
        return rul;
    }
    public void setRul(String rul) {
        this.rul = rul;
    }
    @Override
    public String toString() {
        return
                email +" " + password +" "  + rul + "\r\n";
    }
    public String msg(){
        String message;
            if (rul.equals("admin")) {
                message = "Admin login success";
            } else if (rul.equals("customer")) {
                message = "Customer login success";
            }

        else {
            message="login fail";
        }
        return message;
    }
    public boolean isCorrectInfo() {
        int flag=0;
        for (Login logins: Data.users()){
            if(logins.getEmail().equals(email)){
                this.loginVar =logins;
                flag=1;
                break;
            }
        }
        return flag==1;
    }
    public void login() {
        if (isCorrectInfo()) {
            if (loginVar.getRul().equals("admin")) {
                AdminLogin admin = new AdminLogin();
                admin.adminPage();
            } else if (loginVar.getRul().equals("customer")) {
                CustomerLogin customerLogin = new CustomerLogin();
                customerLogin.setCustomer(Data.getCustomerBy(email));
                customerLogin.customerPage();
            }
        }
    }
    public void adminLogin() {
        AdminLogin admin = new AdminLogin();
        admin.adminMenu();
    }
    public void customerLogin() {
        CustomerLogin customerLogin = new CustomerLogin();
        customerLogin.setCustomer(Data.getCustomerBy(email));
        customerLogin.menu();
    }
    public void loginPage() {
        Main.menu();
    }
}