package test.classes;

import entities.Customer;
import entities.Data;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RecordCustomer {
    najah.edu.RecordCustomer recordCustomer;
    Customer customer;
    boolean taken=false;
    List<Customer>customers;

    @Given("that I enter customer name={string}")
    public void that_i_enter_customer_name(String name) {

        customer=new Customer();
        recordCustomer =new najah.edu.RecordCustomer();
        customer.setFullName(name);
        customers=new ArrayList<>();
        customers.add(new Customer("Khalid","khalid@gmail.com","059823135","Nablus","khall"));
        customers.add(new Customer("Ali Mohammed","ali@gmail.com","059872345","Tulkarem","ali"));
    }

    @Given("customer email={string}")
    public void customer_email(String email) {
        customer.setEmail(email);
    }

    @Given("customer phone={string}")
    public void customer_phone(String phone) {
        customer.setPhone(phone);

    }

    @Given("customer address={string}")
    public void customer_address(String address) {
        customer.setAddress(address);
    }

    @Given("customer password={string}")
    public void customer_password(String password) {
        customer.setPassword(password);
    }

    @When("I chose to record new customer")
    public void i_chose_to_record_new_customer() {
        for (Customer cust:customers){
            if(cust.getEmail().equals(customer.getEmail())){
                taken=true;
                break;
            }
        }
    }

    @Then("a unique customer ID will be generated for the customer")
    public void a_unique_customer_id_will_be_generated_for_the_customer() {
        assertTrue(customer.isValidEmail());
        assertFalse(taken);
        customer.setId(Data.getId());
    }

    @Then("the customer will recorded successfully")
    public void theCustomerWillRecordedSuccessfully() {
        assertTrue(customer.isValidEmail());
        assertFalse(customer.isTakenEmail());
        assertFalse(taken);
        recordCustomer.addNewCustomer(customer);
        customer.hashCode();
        test();
        System.out.println("Customer recorded successfully");

    }

    @Then("confirmation email will be sent to customer")
    public void confirmationEmailWillBeSentToCustomer() {
        assertTrue(customer.isValidEmail());
        customer.sendEmail("Signup","Hello You are Signed-Up to Cleaning System Company Welcome to our application","We send a confirmation message to customer on email");
    }
    @Then("I show a message that the email is already taken")
    public void i_show_a_message_that_the_email_is_already_taken() {
        assertTrue(customer.isValidEmail());
        assertTrue(taken);
        recordCustomer.takenMsg();
    }

    @Then("I show the customer details who has this email")
    public void i_show_the_customer_details_who_has_this_email() {
        assertTrue(customer.isValidEmail());
        assertTrue(customer.isTakenEmail());
        System.out.println(customer.getCustomerDetails());
    }
    @Then("I have option to reenter new email")
    public void i_have_option_to_reenter_new_email() {
        assertTrue(customer.isValidEmail());
        assertTrue(taken);
        customer.setEmail("hibah@gmail.com");
        assertFalse(customers.contains(customer));
        customers.add(customer);
test2();

    }
    public void test(){
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("Hiba\nhiba@gmail.com\n05432\nNAblus\nhhh\n".getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        najah.edu.RecordCustomer recordCustomer1=new najah.edu.RecordCustomer();
        recordCustomer1.newCustomer();


        System.setIn(stdin);
        System.setOut(stdout);
    }
    public void test2(){
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("Hiba\nali@gmail.com\n05432\nNAblus\nhhh\nhiba@gmail.com\n".getBytes()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        najah.edu.RecordCustomer recordCustomer1=new najah.edu.RecordCustomer();
        recordCustomer1.newCustomer();


        System.setIn(stdin);
        System.setOut(stdout);
    }

}
