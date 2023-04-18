package test.classes;

import entities.Category;
import entities.Product;
import entities.Worker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.AdminLogin;
import najah.edu.DistributeOrder;
import najah.edu.Order;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistributeOrderTest {

    Order order;
    String category;
    Worker worker;
    @Given("that add order contains product with category ={string}")
    public void that_add_order_contains_product_with_category(String category) {
        List<Product> productList=new ArrayList<>();
        productList.add(new Product("carpet","SDFG",4.0,"","DFGH", Category.valueOf(category),320.0,12,110)) ;
        order=new Order(productList,"waiting");
        this.category=category;
    }

    @When("select to add order")
    public void select_to_add_order() {
    }

    @Then("I get the worker who works on {string} category")
    public void i_get_the_worker_who_works_on_category(String category) {
        assertEquals(this.category, category);
    }

    @Then("has the minimum number of waiting orders")
    public void has_the_minimum_number_of_waiting_orders() {
       worker= DistributeOrder.getWorker(order.getProducts().get(0));
    }

    @Then("the worker ID set to {int}")
    public void the_worker_id_set_to(Integer id) {
        System.out.println(worker.getId());
        assertEquals(worker.getId(), (int) id);
        AdminLogin admin=new AdminLogin();
        admin.addOrder(order);


    }


}
