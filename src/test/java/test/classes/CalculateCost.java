package test.classes;

import entities.Category;
import entities.Product;
import entities.ProductFile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateCost {
    Product product;
    double cost;
    double []costCat;
    @Given("the cost of categories is defined in the cost file")
    public void theCostOfCategoriesIsDefinedInTheCostFile() {
        costCat= ProductFile.getCostOfCategory();
    }

    @When("I record a new product and set category {string}")
    public void iRecordANewProductAndSetCategory(String category) {
        product=new Product();
        product.setCategory(Category.valueOf(category));
    }

    @Then("the carpet cost with dimensions {double} calculated will")
    public void theCarpetCostWithDimensionsCalculatedWill(double dimensions) {
        cost=costCat[0]*dimensions;
        assertEquals(cost, Product.carpetCost(dimensions));
    }

    @Then("the sofa cost with number of sofa {int} calculated will")
    public void theSofaCostWithNumberOfSofaCalculatedWill(int numOfSofa) {
        cost=costCat[1]*numOfSofa;
        assertEquals(cost, Product.sofaCost(numOfSofa));
    }

    @Then("the cover cost with size {string} calculated will")
    public void theCoverCostWithSizeCalculatedWill(String sizeOfCover) {
        if(sizeOfCover.equalsIgnoreCase("KING")){
            cost=costCat[2];
        }else if (sizeOfCover.equalsIgnoreCase("QUEEN")) {
            cost=costCat[3];
        }else if (sizeOfCover.equalsIgnoreCase("TWIN_XL")) {
            cost=costCat[4];
        }else if (sizeOfCover.equalsIgnoreCase("TWIN")) {
            cost=costCat[5];
        }else if (sizeOfCover.equalsIgnoreCase("CRIB")) {
            cost=costCat[6];
        }
        assertEquals(cost, Product.coverCost(sizeOfCover));
    }
}
