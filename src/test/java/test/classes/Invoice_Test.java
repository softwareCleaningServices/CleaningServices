package test.classes;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.Order;
import najah.edu.AdminLogin;
import entities.Data;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Invoice_Test {
    AdminLogin admin;
    Order order=new Order();
    @Given("that the admin is logged in")
    public void that_the_admin_is_logged_in() {
       admin=new AdminLogin();
    }

    @When("the admin enter the order Id to invoiced")
    public void the_admin_enter_the_order_id_to_invoiced() {
        order.setId(11);
    }
    @Then("the invoice will be generated")
    public void the_invoice_will_be_generated() {
        assertTrue(admin.isExistOrder(order.getId()));
        order=Data.getOrderByID(order.getId());
        admin.invoice(order);
    }
    @Then("the order will be paid")
    public void theOrderWillBePaid() {
        assertTrue(admin.isExistOrder(order.getId()));
       order.setPaid(true);
    }
    @When("the admin enter not exist order Id to invoiced")
    public void the_admin_enter_not_exist_order_id_to_invoiced() {
       order.setId(9);
    }
    @Then("the order Id is not exist on the recorded ordered")
    public void the_order_id_is_not_exist_on_the_recorded_ordered() {
        assertFalse(admin.isExistOrder(order.getId()));
        admin.notExistMsg();
    }







}
