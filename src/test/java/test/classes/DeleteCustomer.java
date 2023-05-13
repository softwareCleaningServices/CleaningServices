package test.classes;

import entities.Data;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.AdminLogin;
import entities.Customer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DeleteCustomer {
    AdminLogin admin;
    Customer customer;
    @Given("that the admin choose to delete customer")
    public void that_the_admin_choose_to_delete_customer() {
       admin=new AdminLogin();
        customer=new Customer();
    }

    @When("the entered customer id is exist")
    public void theEnteredCustomerIdIsExist() {
        customer.setId(111);
    }

    @Then("the customer will deleted")
    public void the_customer_will_deleted() {
      assertTrue(admin.isExistCustomer(111));
      admin.deleteCustomer(customer);
    }

    @When("the entered customer id is not exist int the recorded customer")
    public void theEnteredCustomerIdIsNotExistIntTheRecordedCustomer() {
        customer=new Customer();
        customer= Data.getCustomerById(100);
    }
    @Then("the message that the customer not exist will be shown")
    public void the_message_that_the_customer_not_exist_will_be_shown() {
        assertFalse(admin.isExistCustomer(100));
        admin.deleteCustomer(customer);
    }

}
