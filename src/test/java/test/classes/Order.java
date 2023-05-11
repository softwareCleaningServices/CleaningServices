package test.classes;

import entities.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.AdminLogin;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Order {
    najah.edu.Order order;
    AdminLogin admin;
    Customer customer;
    boolean exist;
    List<Product>products;
    String name;
    List<Customer>customers=new ArrayList<>();
    @Before
    public void setUp(){
        customers=new ArrayList<>();
        customers.add(new Customer("Khalid","khalid@gmail.com","059823135","Nablus","khall"));
        customers.add(new Customer("Ali Mohammed","ali@gmail.com","059872345","Tulkarem","ali"));
    }
    @Given("a customer with name {string} and id={int}")
    public void a_customer_with_name_and_id(String name, Integer id) {
        customer=Data.getCustomerBy(name);
        this.name=name;
        customer=Data.getCustomerById(id);
    }
    @Given("a product with name {string} and category={string} and dimension={double} and material={string} and specialTerminate={string} and coast= {double}")
    public void a_product_with_name_and_category_and_dimension_and_material_and_special_terminate_and_coast(String name, String category, Double dimension, String material, String sp, Double coast) {
        products=new ArrayList<>();
        products.add(Product.builder().setName(name).setDimension(dimension).setMaterial(material).setSpecialTreatment(sp).setCategory(Category.valueOf(category)).setCost(coast).build());
    }
    @Given("a product with name {string} and category={string} and size={string} and material={string} and specialTerminate={string} and coast= {double}")
    public void a_product_with_name_and_category_and_size_and_material_and_special_terminate_and_coast(String name, String category, String size, String material, String sp, Double coast) {
        products.add(Product.builder().setName(name).setPictureName("pic").setCover(SizeOfCover.valueOf(size)).setMaterial(material).setSpecialTreatment(sp).setCategory(Category.valueOf(category)).setCost(coast).build());
    }
    @When("the customer orders the two products")
    public void the_customer_orders_the_two_products() {
        order=new najah.edu.Order();
        order.setProducts(products);
    }
    @Then("a new order should be created with status={string}")
    public void a_new_order_should_be_created_with_status(String status) {
        assertNotEquals(0,customer.getId());
        assertNotNull(customer);
        order=new najah.edu.Order(products,status);
    }
    @Then("the order should have a total price of {double}")
    public void the_order_should_have_a_total_price_of(Double total) {
        assertEquals(total,order.getTotal());
        assertNotEquals(0,customer.getId());
        exist=true;
        order.setCustomer(customer);
    }
    @Then("a unique order Id will generated to the order")
    public void a_unique_order_id_will_generated_to_the_order() {
        assertTrue(exist);
        assertEquals(2,order.getProducts().size());
        order.setId(Data.getOrderId());
        admin=new AdminLogin();
    }
    @Then("the order added successfully")
    public void the_order_added_successfully() {
        assertTrue(exist);
        assertEquals(2,order.getProducts().size());
        admin.addOrder(order);
        System.out.println("The Order added successfully");
        order.setWorker(new Worker());
        System.out.println(order.getString());
        order.setPaid(true);
        System.out.println(order.getString());
    }
    @Then("I should add the customer details")
    public void i_should_add_the_customer_details() {
        customer=Data.getCustomerBy(name);
        assertFalse(Data.getCustomers().contains(customer));
        customer=new Customer("Alaa Hasan","alaa@gmail.com","056932146","Tulkarem","alaa20");
        customers.add(customer);


    }
}
