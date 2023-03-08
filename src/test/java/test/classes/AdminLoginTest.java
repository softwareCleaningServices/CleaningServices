package test.classes;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.AdminLogin;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AdminLoginTest {
AdminLogin adminLogin;
boolean loggedIn;

    @Given("that the admin is not logged in")
    public void thatTheAdminIsNotLoggedIn() {
      adminLogin=new AdminLogin();
      loggedIn=false;
    }

    @When("the entered email is {string}")
    public void theEnteredEmailIs(String email) {
        adminLogin.setEmail(email);

    }

    @When("the entered password is {string}")
    public void theEnteredPasswordIs(String password) {
       adminLogin.setPassword(password);
    }
    @Then("the admin login success")
    public void theAdminLoginSuccess() {
      assertTrue(adminLogin.isCorrectInfo());
        System.out.println("You logged in success");
    }
    @Then("the admin now logged in")
    public void theAdminNowLoggedIn() {
        assertTrue(adminLogin.isCorrectInfo());
        System.out.println("You are now logged in");
        loggedIn=true;
    }

    @Then("the admin login fail")
    public void theAdminLoginFail() {
        assertFalse(adminLogin.isCorrectInfo());
        System.out.println("You are not logged in");
        loggedIn=false;
    }

    @Then("he asked to reenter email and password")
    public void heAskedToReenterEmailAndPassword() {
        assertFalse(adminLogin.isCorrectInfo());
        System.out.println("Try again");
    }

}
