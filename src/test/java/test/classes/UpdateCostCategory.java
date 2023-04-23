package test.classes;

import entities.Category;
import entities.Product;
import entities.ProductFile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.AdminLogin;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateCostCategory {
    AdminLogin admin;
    double[] newCost;
    @Given("that I choose to update cost of the category")
    public void thatIChooseToUpdateCostOfTheCategory() {
        admin=new AdminLogin();
    }

    @When("I select to update cost")
    public void iSelectToUpdateCost() {
        ProductFile.updateCostOfCategory();
    }

    @Then("the cost will updated successfully")
    public void theCostWillUpdatedSuccessfully() {
        newCost=ProductFile.getCostOfCategory();
    }
}
