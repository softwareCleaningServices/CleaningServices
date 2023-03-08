package test.classes;

import entities.Customer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.RecordCustomer;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class recordCustomerTest {
   RecordCustomer recordCustomer;
Customer customer;
    @Given("that I choose to record new customer")
    public void thatIChooseToRecordNewCustomer() {
      recordCustomer=new RecordCustomer();
    }
    @When("I enter the correct required customer information")
    public void iEnterTheCorrectRequiredCustomerInformation() {
        customer=new Customer("Ibrahim Ahmed","ibrahim@gmail.com","059823135","Nablus","ruba12");
    }
    @Then("the customer will recorded successfully")
    public void theCustomerWillRecordedSuccessfully() {
        assertTrue(customer.isValidEmail());
        assertFalse(customer.isTakenEmail());
            recordCustomer.addNewCustomer(customer);
        System.out.println("Customer recorded successfully");

    }
    @Then("confirmation email will be sent to customer")
    public void confirmationEmailWillBeSentToCustomer() {
        assertTrue(customer.isValidEmail());
        customer.sendConfirmationEmail();
    }


    @When("I enter the customer information but already taken email")
    public void i_enter_the_customer_information_but_already_taken_email() {
        customer=new Customer("Ruba","ruba12@gmail.com","059823135","Nablus","ruba12");
    }

    @Then("I show a message that the email is already taken")
    public void i_show_a_message_that_the_email_is_already_taken() {
        assertTrue(customer.isValidEmail());
        assertTrue(customer.isTakenEmail());
        recordCustomer.takenMsg();
    }

    @Then("I show the customer details who has this email")
    public void i_show_the_customer_details_who_has_this_email() {
        assertTrue(customer.isValidEmail());
        assertTrue(customer.isTakenEmail());
       customer= customer.getCustomerDetails();
        System.out.println(customer);
    }
    @Then("I have option to reenter new email")
    public void i_have_option_to_reenter_new_email() {
        assertTrue(customer.isValidEmail());
        assertTrue(customer.isTakenEmail());
        customer.setEmail("rubaosama@gmail.com");
        assertFalse(customer.isTakenEmail());
        recordCustomer.addNewCustomer(customer);
    }

}