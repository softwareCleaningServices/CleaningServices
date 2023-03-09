package test.classes;
import entities.ProductFile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.AddOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class DiscountOptionTest {
    AddOrder order;
    ProductFile product;
    boolean discountFifty = false;
    boolean discountOneAndFifteen = false;
    boolean discountOneHun = false;
    boolean noDiscount = false;
    @Given("that i add a new order")
    public void thatIAddANewOrder() {
        order=new AddOrder();
    }
    @When("the total cost of the order more than or equal five hundred")
    public void theTotalCostOfTheOrderMoreThanOrEqualFiveHundred() {
        discountFifty= order.getTotal() >= 500;
    }
    @Then("the order have a discount twenty percent")
    public void theOrderHaveADiscountTwentyPercent() {
    }
    @When("the total cost of the order more than or equal one hundred fifty")
    public void theTotalCostOfTheOrderMoreThanOrEqualOneHundredFifty() {
        if (order.getTotal()>=150){
            discountOneAndFifteen=true;
        }
    }
    @And("the total cost of the order less than five hundred")
    public void theTotalCostOfTheOrderLessThanFiveHundred() {
        if (order.getTotal()<=500){

        }
    }
    @Then("the order have a discount fifteen percent")
    public void theOrderHaveADiscountFifteenPercent() {
    }
    @When("the total cost of the order more than or equal one hundred")
    public void theTotalCostOfTheOrderMoreThanOrEqualOneHundred() {
        if (order.getTotal()>=100){
            discountOneHun=true;
        }
    }
    @And("the total cost of the order less than one hundred fifty")
    public void theTotalCostOfTheOrderLessThanOneHundredFifty() {
        if (order.getTotal()<=150){

        }
    }
    @Then("the order have a discount seven percent")
    public void theOrderHaveADiscountSevenPercent() {
    }
    @When("the total cost of the order less than one hundred")
    public void theTotalCostOfTheOrderLessThanOneHundred() {
        if (order.getTotal()<=100) {
            noDiscount = true;
        }
    }
    @Then("the order haven't discount")
    public void theOrderHavenTDiscount() {
    }
}
