package test.classes;

import entities.Data;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.Order;
import najah.edu.AdminLogin;

import static org.junit.Assert.*;

public class Notify_Test {
    AdminLogin admin;
    Order order;
    String status;
    @Given("the admin select an order id={int}")
    public void the_admin_select_an_order_id(Integer orderID) {
        admin=new AdminLogin();
        order=Data.getOrderByID(orderID);
    }


    @When("the admin set order status to {string}")
    public void the_admin_set_order_status_to(String status) {
        admin.changeStatus(order.getId(),status);
        this.status=status;
    }

    @Then("a notify message will send to customer")
    public void a_notify_message_will_send_to_customer() {
        assertEquals("complete", status);
        assertNotNull(order);
        System.out.println(order);
        admin.notifyCustomer(order.getCustomer());

    }
    @Then("no message will send to customer since the order not complete")
    public void no_message_will_send_to_customer_since_the_order_not_complete() {
        assertNotEquals("complete", status);
        assertNotNull(order);
    }
}
