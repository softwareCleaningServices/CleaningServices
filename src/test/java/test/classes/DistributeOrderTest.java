package test.classes;

import entities.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.DistributeOrder;
import najah.edu.Order;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DistributeOrderTest {
    List<Integer> distribution;
    List<Order> orders;
    List<Worker> workers;

    @Given("a list of available workers")
    public void a_list_of_available_workers() {
        workers = Data.getWorkers();
        workers.add(new Worker(120, "Salem", "059812346", "Nablus", "salem@gmail.com", 2000, Category.CARPET));
        workers.add(new Worker(130, "Ali", "059812346", "Nablus", "salem@gmail.com", 3000, Category.COVER));
        workers.add(new Worker(140, "Hiba", "059812346", "Nablus", "salem@gmail.com", 1500, Category.CARPET));

    }

    @Given("a list of orders to be distributed with status={string}")
    public void a_list_of_orders_to_be_distributed_with_status(String status) {
        List<Product> products = new ArrayList<>();
        orders = new ArrayList<>();
        products.add(Product
                .builder()
                .setName("prod")
                .setPictureName("pic")
                .setCover(SizeOfCover.KING)
                .setMaterial("material")
                .setSpecialTreatment("sp")
                .setCategory(Category.COVER)
                .setCost(120.0)
                .build());
        Order order = new Order();
        order.setCustomer(new Customer("Khalid", "khalid@gmail.com", "059823135", "Nablus", "khall"));
        order = new Order(products, status);
        orders.add(order);
        order = new Order(products, status);
        orders.add(order);


    }

    @When("the admin select the distribution process")
    public void the_admin_select_the_distribution_process() {
        distribution = DistributeOrder.distributeOrder(orders, workers);
    }

    @Then("the orders should be evenly distributed among the available workers")
    public void the_orders_should_be_evenly_distributed_among_the_available_workers() {
        List<Integer> expected = new ArrayList<>();
        expected.add(110);
        expected.add(120);
        System.out.println(expected);
        System.out.println(distribution);
        assertEquals(expected, distribution);

    }


    @Then("the orders status should change to {string}")
    public void the_orders_status_should_change_to(String status) {
        for (Order order : orders) {
            order.setStatus(status);
        }

    }

    @Given("no workers are available")
    public void no_workers_are_available() {
        workers = new ArrayList<>();
    }

    @Then("the system should show that there are no available workers")
    public void the_system_should_show_that_there_are_no_available_workers() {
        List<Integer> expected = new ArrayList<>();
        expected.add(110);
        expected.add(120);
        assertNotEquals(expected, distribution);
        System.out.println("There is no available worker ");
    }


}
