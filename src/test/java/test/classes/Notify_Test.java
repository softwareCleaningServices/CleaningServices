package test.classes;

import entities.Data;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.Order;
import najah.edu.AdminLogin;


import static org.junit.Assert.assertEquals;

public class Notify_Test {
    AdminLogin admin;
    Order order=new Order();
    String status;
    @Given("the admin choose to change the order status")
    public void the_admin_choose_to_change_the_order_status() {
        admin=new AdminLogin();
       // admin.adminOptions(2);
    }

    @When("the admin set order status to {string}")
    public void the_admin_set_order_status_to(String status) {
       order= Data.getOrderByID(11);
       admin.changeStatus(11,status);
      this.status=status;
    }

    @Then("a notify message will send to customer")
    public void a_notify_message_will_send_to_customer() {
        assertEquals("complete", status);
       System.out.println(order);
        admin.notifyCustomer(order.getCustomer());

    }
}
