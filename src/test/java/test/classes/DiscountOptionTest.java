package test.classes;
import entities.Product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.AddOrder;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class DiscountOptionTest {
    AddOrder order;
    ArrayList<Product> product;
    double discountFifty ;
    double discountOneAndFifteen ;
    double discountOneHun ;
    double noDiscount ;
    @Given("that i add a new order")
    public void thatIAddANewOrder() {
        order=new AddOrder();
    }
    @When("the total cost of the order more than or equal five hundred")
    public void theTotalCostOfTheOrderMoreThanOrEqualFiveHundred() {
        discountFifty= order.getTotal() >= 500?order.getTotal()-(order.getTotal()*15/100):order.getTotal();
    }
    @Then("the order have a discount twenty percent {double}")
    public void theOrderHaveADiscountTwentyPercentTotal(Double double1) {
        double1=double1-(double1*0.20);
        assertEquals(double1,discountOneAndFifteen);
    }
//    @When("the total cost of the order more than or equal one hundred fifty")
//    public void theTotalCostOfTheOrderMoreThanOrEqualOneHundredFifty() {
//        if (order.getTotal()>=150){
//
//        }
//    }
//    @And("the total cost of the order less than five hundred")
//    public void theTotalCostOfTheOrderLessThanFiveHundred() {
//        if (order.getTotal()<=500){
//
//        }
//    }
//    @Then("the order have a discount fifteen percent")
//    public void theOrderHaveADiscountFifteenPercent() {
//    }
//    @When("the total cost of the order more than or equal one hundred")
//    public void theTotalCostOfTheOrderMoreThanOrEqualOneHundred() {
//        if (order.getTotal()>=100){
//
//        }
//    }
//    @And("the total cost of the order less than one hundred fifty")
//    public void theTotalCostOfTheOrderLessThanOneHundredFifty() {
//        if (order.getTotal()<=150){
//
//        }
//    }
//    @Then("the order have a discount seven percent")
//    public void theOrderHaveADiscountSevenPercent() {
//    }
//    @When("the total cost of the order less than one hundred")
//    public void theTotalCostOfTheOrderLessThanOneHundred() {
//        if (order.getTotal()<=100) {
//
//        }
//    }
//    @Then("the order haven't discount")
//    public void theOrderHavenTDiscount() {
//    }
}
