import entities.Category;
import entities.Customer;
import entities.Product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class recordProduct {
    Product product;
    Category category;
    @Given("that I recorded a new {string}")
    public void recordCategory(String string) {
        category=Category.valueOf(string.toUpperCase());
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I insert the necessary {string} information")
    public void insertInfo(String string) {
        String name=null;
        String pictureName=null;
        String dimension=null;
        String material=null;
        String specialTreatment=null;
        product=new Product(name,pictureName,dimension,material,specialTreatment,Category.valueOf(string.toUpperCase()));
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the {string} will recorded successfully")
    public void recordSuccess(String string) {

        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
