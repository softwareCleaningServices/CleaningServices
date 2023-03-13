package test.classes;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.Order;
import najah.edu.AdminLogin;
import entities.Data;

import static org.junit.Assert.assertTrue;

public class Invoice_Test {
    AdminLogin admin;
    Order order;
    @Given("that the admin is logged in")
    public void that_the_admin_is_logged_in() {
       admin=new AdminLogin();
    }

    @When("the admin select to invoice the order")
    public void the_admin_select_to_invoice_the_order() {

    }

    @When("he enter the order Id")
    public void he_enter_the_order_id() {
        order= Data.getOrderByID(11);
    }

    @Then("the invoice will be printed")
    public void the_invoice_will_be_printed() {
      assertTrue(admin.isExistOrder(order.getId()));
      admin.invoice(order);
    }


}
