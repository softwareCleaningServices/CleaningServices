package test.classes;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class Login {
    boolean logged;
    najah.edu.Login login;

    @Given("that the user is not logged in")
    public void that_the_user_is_not_logged_in() {
        login=new najah.edu.Login();
        logged=false;
    }

    @When("the user  enter email {string}")
    public void the_user_enter_email(String email) {
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
         login.adminLogin();
        } else if (page.equals("customerPage")) {
          login.customerLogin();
       }
       else {
           login.loginPage();
       }

    }
}
