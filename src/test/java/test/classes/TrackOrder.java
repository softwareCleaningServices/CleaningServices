package test.classes;

import entities.Customer;
import entities.Data;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.AdminLogin;
import najah.edu.Order;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TrackOrder {
Customer customer;
AdminLogin admin;
Order order;
    @Given("the customer with id={int}")
    public void the_customer_with_id(Integer custId) {
        customer= Data.getCustomerById(custId);
        admin=new AdminLogin();
    }

    @Given("the order has a unique Id {int}")
    public void the_order_has_a_unique_id(Integer orderId) {
      order=Data.getOrderByID(orderId);
    }
int orderId=0;
    @When("the customer enters the Id number ={int}")
    public void the_customer_enters_the_id_number(Integer orderId) {
    this.orderId=orderId;
    }

    @Then("the system displays the status of the order")
    public void the_system_displays_the_status_of_the_order() {
        assertEquals(order.getCustomer().getId(), customer.getId());
        assertEquals(order.getId(), orderId);
        order.displayStatus();
    }

    @Then("the system displays the other order details")
    public void the_system_displays_the_other_order_details() {
        order.displayDetails();
    }

    @Then("the system displays a not exist message")
    public void the_system_displays_a_not_exist_message() {
        assertNotEquals(order.getId(), orderId);

    }

    @Given("admin login and enter the order id ={int}")
    public void admin_login_and_enter_the_order_id(Integer orderId) {
       this.orderId=orderId;
       order=Data.getOrderByID(orderId);
    }

    @When("the admin select to update order status")
    public void the_admin_select_to_update_order_status() {

    }
    String oldStatus;
    String newStatus;
    @When("the order status is {string}")
    public void the_order_status_is(String string) {
       oldStatus=string;
    }

    @When("the order is updated to status {string}")
    public void the_order_is_updated_to_status(String string) {
       newStatus=string;
       order.setStatus(newStatus);
        List<Order>orders=Data.getOrders();
        for (Order order1:orders){
            if(order1.getId()==order.getId()){
                order1.setStatus(newStatus);
                break;
            }
        }
    }

    @Then("the order status should be {string}")
    public void the_order_status_should_be(String string) {
        assertEquals(newStatus,string);
        System.out.println("New status: "+newStatus);
    }

}
