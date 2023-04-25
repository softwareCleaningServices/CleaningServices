package test.classes;

import entities.ProductFile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.AdminLogin;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
public class UpdateCostCategory {
    AdminLogin admin;
    double [] costCat;
    double[] newCost;
    @Given("that I choose to update cost of the category")
    public void thatIChooseToUpdateCostOfTheCategory() {
        admin=new AdminLogin();
    }
    @When("I select to update cost of category {string} to {string}")
    public void iSelectToUpdateCostOfCategoryTo(String num, String cost) {
        costCat=ProductFile.switchInUpdateCostOfCategory(Integer.parseInt(num),Double.parseDouble(cost));
        newCost=ProductFile.getCostOfCategory();
        newCost[Integer.parseInt(num)-1]=Double.parseDouble(cost);
    }
    @Then("the cost will updated successfully")
    public void theCostWillUpdatedSuccessfully() {
        assertArrayEquals(newCost,costCat);
    }
}
