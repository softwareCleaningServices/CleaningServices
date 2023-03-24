package test.classes;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.AdminLogin;

import static org.junit.Assert.assertTrue;

public class GenerateAboutTest {
    AdminLogin admin=new AdminLogin();

    @Given("that the admin is logged in in the system")
    public void that_the_admin_is_logged_in_in_the_system() {
     admin.setLogged(true);
    }

    @When("the admin select to generate About report")
    public void the_admin_select_to_generate_about_report() {
     admin.adminOptions(5);
    }

    @Then("the report will be generated")
    public void the_report_will_be_generated() {
        assertTrue(admin.isLogged());

        admin.generateAbout();

    }

}
