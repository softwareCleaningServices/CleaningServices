package test.classes;

import entities.Customer;
import entities.Data;
import entities.Product;
import entities.ProductFile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.Order;
import najah.edu.AdminLogin;
import najah.edu.RecordCustomer;


import java.util.ArrayList;

import static org.junit.Assert.*;

public class OrderTest {
    Order order=new Order();
    AdminLogin admin=new AdminLogin();
    Customer customer;
    boolean added;
    @Given("that the order is not added yet")
    public void that_the_order_is_not_added_yet() {
        added=false;
    }
    @When("I enter the correct order details")
    public void i_enter_the_correct_order_details() {
        ArrayList<Product>products=new ArrayList<>();
        products.add(ProductFile.getProduct().get(0));
    order=new Order(products,"waiting");

    }
    @When("the customer is already exist in our customers")
    public void the_customer_is_already_exist_in_our_customers() {
         customer= Data.getCustomerBy("Ali Mohammed");
        assertNotEquals(customer.getId(), 0);
        order.setCustomer(customer);
        System.out.println(customer);
    }

    @Then("the order added successfully")
    public void the_order_added_successfully() {
        assertNotEquals(customer.getId(),0);
        admin.addOrder(order);
        System.out.println("The Order added successfully");
    }
    @When("the customer is new customer")
    public void the_customer_is_new_customer() {
        customer= Data.getCustomerBy("Alaa Hasan");


    }

    @Then("I should add the customer details")
    public void i_should_add_the_customer_details() {
        assertEquals(0, customer.getId());
        customer=new Customer("Alaa Hasan","alaa@gmail.com","056932146","Tulkarem","alaa20");
        RecordCustomer recordCustomer=new RecordCustomer();
        recordCustomer.addNewCustomer(customer);
    }

    @Then("the order added")
    public void the_order_added() {
    order.setCustomer(customer);
    admin.addOrder(order);
    }
}
