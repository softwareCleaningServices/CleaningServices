package test.classes;

import entities.Data;
import entities.Product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.AdminLogin;
import najah.edu.InvoiceOrder;
import najah.edu.Order;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Invoice {
    AdminLogin admin;
    Order order=new Order();
    double total=0;
    @Given("that the admin is logged in")
    public void that_the_admin_is_logged_in() {
        admin=new AdminLogin();
        admin.setLogged(true);
    }

    @When("the admin enter the order Id ={int}")
    public void the_admin_enter_the_order_id(Integer orderId) {
        InvoiceOrder invoiceOrder =new InvoiceOrder();
        order= Data.getOrderByID(orderId);
        invoiceOrder.setOrder(order);
    }
    @When("the first product coast ={double}")
    public void the_first_product_coast(Double cost) {
        total+=(cost);
    }

    @When("the second product cost ={double}")
    public void the_second_product_cost(Double cost) {
        total+=(cost);
    }

    @When("the third product cost={double}")
    public void the_third_product_cost(Double cost) {
        total+=(cost);

    }

    @Then("the total order cost ={double}")
    public void the_total_order_cost(Double cost) {
        assertEquals(total,cost);
    }

    @Then("the customer id ={int}")
    public void the_customer_id(Integer customerId) {
        assertEquals(order.getCustomer().getId(),(customerId));

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


    @When("the admin enter not exist order Id={int} to invoiced")
    public void theAdminEnterNotExistOrderIdToInvoiced(Integer orderId) {
        order.setId(orderId);
    }
    @Then("the order Id is not exist on the recorded ordered")
    public void the_order_id_is_not_exist_on_the_recorded_ordered() {
        order=Data.getOrderByID(1);
        assertEquals(order.getId(),0);
        assertEquals(Data.getCustomerById(9).getId(),0);
        List<Product>products=new ArrayList<>();
        order.setProducts(products);
        InvoiceOrder.invoice(order,0);
        admin.notExistMsg();
    }







}