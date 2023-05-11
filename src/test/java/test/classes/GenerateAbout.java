package test.classes;

import entities.Data;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.AdminLogin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GenerateAbout {
    AdminLogin admin=new AdminLogin();
    int cash;
    int paid;
    int debt;

    @Given("that the admin is logged in in the system")
    public void that_the_admin_is_logged_in_in_the_system() {
     admin.setLogged(true);
    }

    @When("the admin select to generate About report")
    public void the_admin_select_to_generate_about_report() {
     admin.adminOptions(5);
         paid= Data.getPaid(true);
         debt=Data.getPaid(false);
         int not=Data.getCountOrders("else");
         assertEquals(0,not);
         cash=paid+debt;
    }

    @Then("the report will be generated with total cash and total dept and total paid")
    public void the_report_will_be_generated_with_total_cash_and_total_dept_and_total_paid() {
        assertTrue(admin.isLogged());
        assertEquals(cash,paid+debt);

        admin.generateAbout();
    }
    @Then("the report generated with all field puts to {int}")
    public void the_report_generated_with_all_field_puts_to(Integer int1) {
        assertEquals(0,(int)int1);
        admin.generateAbout();
    }

}
