package test.classes;

import entities.Admin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.AdminLogin;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class Login {
    boolean logged;
    najah.edu.Login login;

    @Given("that the user is not logged in")
    public void that_the_user_is_not_logged_in() {
        login=new najah.edu.Login();
        logged=false;
    }
String email;
    @When("the user  enter email {string}")
    public void the_user_enter_email(String email) {
        this.email=email;
       login.setEmail(email);
    }

    @When("the enter password {string}")
    public void the_enter_password(String password) {
        login.setPassword(password);
    }

    @When("the rul is {string}")
    public void the_rul_is(String rul) {
        login.setRul(rul);
    }

    @Then("the message will be display {string}")
    public void the_message_will_be_display(String msg) {
        assertEquals(login.msg(), msg);
        System.out.println(msg);
    }
    @Then("the user move to the {string}")
    public void the_user_move_to_the(String page) {

       if(page.equals("adminPage")){
           assertTrue(login.isCorrectInfo());
           Admin admin=new Admin();
           AdminLogin adminLogin=new AdminLogin();
           admin.setEmail(login.getEmail());
           assertEquals(admin.getEmail(), email);
           adminLogin.setAdmin(admin);
         login.adminLogin();
         test();
        } else if (page.equals("customerPage")) {
          login.customerLogin();
          login.setRul("customer");
         String rul= login.getRul();
         test2();
       }
       else {
           assertFalse(login.isCorrectInfo());
           login.login();
           login.loginPage();

       }

    }
    public void test(){
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("8\n".getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

     login.login();

        System.setIn(stdin);
        System.setOut(stdout);
    }
    public void test2(){
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("5\n".getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);
      login.login();

        System.setIn(stdin);
        System.setOut(stdout);
    }
}
