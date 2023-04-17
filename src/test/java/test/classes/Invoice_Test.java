package test.classes;

import entities.Data;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.AdminLogin;
import najah.edu.InvoiceOrder;
import najah.edu.Order;

import static org.junit.jupiter.api.Assertions.*;

public class Invoice_Test {
    AdminLogin admin;
    Order order=new Order();
    double total=0;
    @Given("that the admin is logged in")
    public void that_the_admin_is_logged_in() {
       admin=new AdminLogin();
       admin.setLogged(true);
    }

    @When("the admin enter the order Id ={string}")
    public void the_admin_enter_the_order_id(String orderId) {
    InvoiceOrder invoice =new InvoiceOrder();
    order= Data.getOrderByID(Integer.parseInt(orderId));
    invoice.setOrder(order);
    }

    @When("the first product coast ={string}")
    public void the_first_product_coast(String cost) {
        total+=Double.parseDouble(cost);
    }

    @When("the second product cost ={string}")
    public void the_second_product_cost(String cost) {
        total+=Double.parseDouble(cost);
    }

    @When("the third product cost={string}")
    public void the_third_product_cost(String cost) {
        total+=Double.parseDouble(cost);

    }

    @Then("the total order cost ={string}")
    public void the_total_order_cost(String cost) {
        total+=Double.parseDouble(cost);
    }

    @Then("the customer id ={string}")
    public void the_customer_id(String customerId) {
        assertEquals(order.getCustomer().getId(), Integer.parseInt(customerId));

    }
    @Then("the invoice will be generated")
    public void the_invoice_will_be_generated() {
        assertTrue(admin.isExistOrder(order.getId()));
        InvoiceOrder.invoice(order,total);
    }
    @Then("the order will set to paid")
    public void theOrderWillSetToPaid() {
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
