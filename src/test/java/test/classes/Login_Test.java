package test.classes;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.Login;

import static org.junit.Assert.assertEquals;

public class Login_Test {
boolean logged;
Login login=new Login();
    @Given("that the user is not logged in")
    public void that_the_user_is_not_logged_in() {
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
}
