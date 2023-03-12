package test.classes;
import entities.Category;
import entities.Product;
import entities.ProductFile;
import entities.SizeOfCover;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.Order;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class DiscountOptionTest {
    Order order;
    Product product1;
    ArrayList <Product> product=new ArrayList<Product>();
    double discountFifty ;
    double discountOneHunFifty;
    double discountOneHun ;
    double noDiscount ;
    @Given("that i add a new order")
    public void thatIAddANewOrder() {
        order=new Order();
    }
    @When("the total cost of the order more than or equal five hundred")
    public void theTotalCostOfTheOrderMoreThanOrEqualFiveHundred() {
        product1=Product
                .builder()
                .setName("name")
                .setPictureName("picName")
                .setCover(SizeOfCover.KING)
                .setMaterial("material")
                .setSpecialTreatment("special")
                .setCategory(Category.COVER)
                .setCost(600.0)
                .build();
        product.add(product1);
        order.setProducts(product);
        discountFifty= order.getTotal() >= 500?order.getTotal()-(order.getTotal()*20/100):order.getTotal();
    }
    @Then("the order have a discount twenty percent")
    public void theOrderHaveADiscountTwentyPercentTotal() {
        assertEquals(ProductFile.totalAfterDiscount(order),discountFifty);
    }
    @When("the total cost of the order more than or equal one hundred fifty and less than five hundred")
    public void theTotalCostOfTheOrderBetweenOneHundredFiftyAndFiveHundred() {
        product1=Product
                .builder()
                .setName("name")
                .setPictureName("picName")
                .setCover(SizeOfCover.KING)
                .setMaterial("material")
                .setSpecialTreatment("special")
                .setCategory(Category.COVER)
                .setCost(170.0)
                .build();
        product.add(product1);
        order.setProducts(product);
        if (order.getTotal()>=150 && order.getTotal()<500){
            discountOneHunFifty=order.getTotal()-(order.getTotal()*0.15);
        }
    }
    @Then("the order have a discount fifteen percent")
    public void theOrderHaveADiscountFifteenPercent() {
        assertEquals(ProductFile.totalAfterDiscount(order), discountOneHunFifty);
    }
    @When("the total cost of the order more than or equal one hundred and less than one hundred fifty")
    public void theTotalCostOfTheOrderBetweenOneHundredAndOneHundredFifty() {
        product1=Product
                .builder()
                .setName("name")
                .setPictureName("picName")
                .setCover(SizeOfCover.KING)
                .setMaterial("material")
                .setSpecialTreatment("special")
                .setCategory(Category.COVER)
                .setCost(120.0)
                .build();
        product.add(product1);
        order.setProducts(product);
        if (order.getTotal()>=100 && order.getTotal()<150){
            discountOneHun=order.getTotal()-(order.getTotal()*0.07);
        }
    }
    @Then("the order have a discount seven percent")
    public void theOrderHaveADiscountSevenPercent() {
        assertEquals(ProductFile.totalAfterDiscount(order),discountOneHun);
    }
    @When("the total cost of the order less than one hundred")
    public void theTotalCostOfTheOrderLessThanOneHundred() {
        product1=Product
                .builder()
                .setName("name")
                .setPictureName("picName")
                .setCover(SizeOfCover.KING)
                .setMaterial("material")
                .setSpecialTreatment("special")
                .setCategory(Category.COVER)
                .setCost(50.0)
                .build();
        product.add(product1);
        order.setProducts(product);
        noDiscount=order.getTotal();
    }
    @Then("the order haven't discount")
    public void theOrderHavenTDiscount() {
        assertEquals(ProductFile.totalAfterDiscount(order),noDiscount);
    }
}
