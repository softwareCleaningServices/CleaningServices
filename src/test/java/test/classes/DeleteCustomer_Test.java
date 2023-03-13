package test.classes;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.AdminLogin;
import entities.Customer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DeleteCustomer_Test {
AdminLogin admin;
Customer customer;
    @Given("that the admin choose to delete customer")
    public void that_the_admin_choose_to_delete_customer() {
       admin=new AdminLogin();
    }

    @When("the entered id is exist")
    public void the_entered_id_is_exist() {
        customer=new Customer();
        customer.setId(103);
    }

    @Then("the customer will deleted")
    public void the_customer_will_deleted() {
      assertTrue(admin.isExistCustomer(103));
      admin.deleteCustomer(customer);
    }

    @When("the entered id is not exist int the recorded customer")
    public void the_entered_id_is_not_exist_int_the_recorded_customer() {
        customer=new Customer();
        customer.setId(100);
    }

    @Then("the message that the customer not exist will be shown")
    public void the_message_that_the_customer_not_exist_will_be_shown() {
        assertFalse(admin.isExistCustomer(100));
        admin.deleteCustomer(customer);
    }

}
