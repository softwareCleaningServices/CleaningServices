package test.classes;

import entities.ProductFile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.AdminLogin;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

public class UpdateCostCategory {
    AdminLogin admin;
    double []cost;
    double []newCost;
    @Given("the admin wants to update the cost of a product category")
    public void theAdminWantsToUpdateTheCostOfAProductCategory() {
        admin = new AdminLogin();
    }

    @When("the user enters a valid category number and a new cost")
    public void theUserEntersAValidCategoryNumberAndANewCost() {
        ByteArrayInputStream in = new ByteArrayInputStream("2\n100.0\nno\n".getBytes());
        System.setIn(in);
    }

    @Then("the system updates the cost of the selected category")
    public void theSystemUpdatesTheCostOfTheSelectedCategory() {
        cost=ProductFile.getCostOfCategory();
        cost[1]=100.0;
        ProductFile.updateCostOfCategory();
        newCost=ProductFile.getCostOfCategory();
        assertArrayEquals(cost,newCost);
    }

    @When("the user enters a valid many category number and a new cost")
    public void theUserEntersAValidManyCategoryNumberAndANewCost() {
        ByteArrayInputStream in = new ByteArrayInputStream("2\n100.0\nyes\n3\n150.0\nno\n".getBytes());
        System.setIn(in);
    }

    @Then("the system updates the cost of all selected category")
    public void theSystemUpdatesTheCostOfAllSelectedCategory() {
        cost=ProductFile.getCostOfCategory();
        cost[1]=100.0;
        cost[2]=150.0;
        ProductFile.updateCostOfCategory();
        newCost=ProductFile.getCostOfCategory();
        assertArrayEquals(cost,newCost);
    }

    @When("the user enters a Not valid category number up")
    public void theUserEntersANotValidCategoryNumberUp() {
        ByteArrayInputStream in2 = new ByteArrayInputStream("9\nno\n".getBytes());
        System.setIn(in2);
    }

    @Then("the system return the same cost of the selected category")
    public void theSystemReturnTheSameCostOfTheSelectedCategory() {
        cost=ProductFile.getCostOfCategory();
        ProductFile.updateCostOfCategory();
        newCost=ProductFile.getCostOfCategory();
        assertArrayEquals(cost,newCost);
    }

    @When("the user enters a Not valid category number down")
    public void theUserEntersANotValidCategoryNumberDown() {
        ByteArrayInputStream in2 = new ByteArrayInputStream("0\nno\n".getBytes());
        System.setIn(in2);
    }
}
