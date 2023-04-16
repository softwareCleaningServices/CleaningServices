package test.classes;

import entities.ProductFile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.AdminLogin;
import najah.edu.Order;

public class DistributeOrderTest {

    Order order;
    @Given("that the order is not recorder yet")
    public void that_the_order_is_not_recorder_yet() {
        order=new Order();
    }
    @When("the order is added")
    public void the_order_is_added() {
    order=new Order(ProductFile.getProduct(),"waiting");
    }
    @Then("the worker who has less number of products is take the product")
    public void the_worker_who_has_less_number_of_products_is_take_the_product() {
        AdminLogin admin=new AdminLogin();
        admin.addOrder(order);
    }

}
