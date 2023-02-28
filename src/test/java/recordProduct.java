import entities.Customer;
import entities.Product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class recordProduct {
    Product product;
    @Given("that I record a new product")
    public void recordProduct() {
        product=new Product();
    }
    @When("I insert the necessary product information.")
    public void insertProductInfo() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the product will recorded successfully")
    public void checkSaved() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
