package test.classes;

import entities.Customer;
import entities.Data;
import entities.Product;
import entities.ProductFile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.AdminLogin;
import najah.edu.Order;
import najah.edu.RecordCustomer;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {
    Order order;
    AdminLogin admin;
    Customer customer;
    boolean added;
    boolean exist;
        @Given("that the order is not added yet")
    public void that_the_order_is_not_added_yet() {
        added=false;
        order=new Order();
        admin=new AdminLogin();
    }
    @When("I enter the correct order details and the product details")
    public void i_enter_the_correct_order_details_and_the_product_details() {
        ArrayList<Product> products=new ArrayList<>();
        products.add(ProductFile.getProduct().get(0));
        products.add(ProductFile.getProduct().get(1));
        order=new Order(products,"waiting");
    }

    @When("the customer is already exist in our customers and his name={string}")
    public void the_customer_is_already_exist_in_our_customers_and_his_name(String name) {
       customer=Data.getCustomerBy(name);
      exist= admin.isExistCustomer(customer.getId());
    }

    @Then("a unique order Id will generated to the order")
    public void a_unique_order_id_will_generated_to_the_order() {
       assertTrue(exist);
       assertEquals(2,order.getProducts().size());
       order.setId(Data.getOrderId());
    }
        @Then("the order added successfully")
    public void the_order_added_successfully() {
            assertTrue(exist);
            assertEquals(2,order.getProducts().size());
        System.out.println("The Order added successfully");
    }


    @When("the customer is new customer and his name={string}")
    public void the_customer_is_new_customer_and_his_name(String name) {
        customer=Data.getCustomerBy(name);
        exist= admin.isExistCustomer(customer.getId());

    }
        @Then("I should add the customer details")
    public void i_should_add_the_customer_details() {
        assertFalse(exist);
        customer=new Customer("Alaa Hasan","alaa@gmail.com","056932146","Tulkarem","alaa20");
        RecordCustomer recordCustomer=new RecordCustomer();
        recordCustomer.addNewCustomer(customer);
    }
    @Then("the order added")
    public void the_order_added() {
    order.setCustomer(customer);
        assertEquals(2, order.getProducts().size());
    admin.addOrder(order);
    System.out.println("The Order added successfully");
    }

}
