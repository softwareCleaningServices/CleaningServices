package test.classes;

import entities.Customer;
import najah.edu.BusinessReport;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.List;

public class BusinessReportTest {
    List<Customer> customer;
    int numCustomer;
    int[] numWorker;
    int numOrders;
    int numSofa;
    int numCarpet;
    int[] numCover;
    @Given("that needs the number of all business customers")
    public void thatNeedsTheNumberOfAllBusinessCustomers() {
        customer=new ArrayList<>();
    }

    @When("the admin enters to show the report")
    public void theAdminEntersToShowTheReport() {
    }

    @Then("calculate number of all business customers")
    public void calculateNumberOfAllBusinessCustomers() {
        numCustomer=BusinessReport.numberOfAllCustomers();
    }

    @Given("that needs the number of all business worker")
    public void thatNeedsTheNumberOfAllBusinessWorker() {
    }
    @Then("calculate number of all business worker")
    public void calculateNumberOfAllBusinessWorker() {
        numWorker=BusinessReport.numberOfAllWorker();
    }

    @Given("that needs the number of all business worker in category sofa")
    public void thatNeedsTheNumberOfAllBusinessWorkerInCategorySofa() {
    }

    @Then("calculate number of all business worker in category sofa")
    public void calculateNumberOfAllBusinessWorkerInCategorySofa() {
    }

    @Given("that needs the number of all business worker in category carpet")
    public void thatNeedsTheNumberOfAllBusinessWorkerInCategoryCarpet() {
    }

    @Then("calculate number of all business worker in category carpet")
    public void calculateNumberOfAllBusinessWorkerInCategoryCarpet() {
    }

    @Given("that needs the number of all business worker in category cover")
    public void thatNeedsTheNumberOfAllBusinessWorkerInCategoryCover() {
    }

    @Then("calculate number of all business worker in category cover")
    public void calculateNumberOfAllBusinessWorkerInCategoryCover() {
    }
    @Given("that needs the number of all orders in this month")
    public void thatNeedsTheNumberOfAllOrdersInThisMonth() {
    }

    @Then("calculate number of all business orders in this month")
    public void calculateNumberOfAllBusinessOrdersInThisMonth() {
        numOrders=BusinessReport.numberOfAllOrdersInThisMonth();
    }

    @Given("that needs the number of sofas in all orders in this month")
    public void thatNeedsTheNumberOfSofasInAllOrdersInThisMonth() {
    }

    @Then("calculate number of sofas in all orders in this month")
    public void calculateNumberOfSofasInAllOrdersInThisMonth() {
        numSofa=BusinessReport.numberOfSofaInThisMonth();
    }

    @Given("that needs the number of carpets in all orders in this month")
    public void thatNeedsTheNumberOfCarpetsInAllOrdersInThisMonth() {
    }

    @Then("calculate number of carpets in all orders in this month")
    public void calculateNumberOfCarpetsInAllOrdersInThisMonth() {
        numCarpet=BusinessReport.numberOfCarpetInThisMonth();
    }

    @Given("that needs the number of covers in all orders in this month")
    public void thatNeedsTheNumberOfCoversInAllOrdersInThisMonth() {
    }

    @Then("calculate number of covers in all orders in this month")
    public void calculateNumberOfCoversInAllOrdersInThisMonth() {
        numCover=BusinessReport.numberOfCoverInThisMonth();
    }
    @Given("that needs the number of covers size King in all orders in this month")
    public void thatNeedsTheNumberOfCoversSizeKingInAllOrdersInThisMonth() {
    }

    @Then("calculate number of covers size King in all orders in this month")
    public void calculateNumberOfCoversSizeKingInAllOrdersInThisMonth() {
        numCover=BusinessReport.numberOfCoverInThisMonth();
    }

    @Given("that needs the number of covers size Queen in all orders in this month")
    public void thatNeedsTheNumberOfCoversSizeQueenInAllOrdersInThisMonth() {
    }

    @Then("calculate number of covers size Queen in all orders in this month")
    public void calculateNumberOfCoversSizeQueenInAllOrdersInThisMonth() {
        numCover=BusinessReport.numberOfCoverInThisMonth();
    }

    @Given("that needs the number of covers size TWIN_XL in all orders in this month")
    public void thatNeedsTheNumberOfCoversSizeTwin_XLInAllOrdersInThisMonth() {
    }

    @Then("calculate number of covers size TWIN_XL in all orders in this month")
    public void calculateNumberOfCoversSizeTwin_XLInAllOrdersInThisMonth() {
        numCover=BusinessReport.numberOfCoverInThisMonth();
    }

    @Given("that needs the number of covers size TWIN in all orders in this month")
    public void thatNeedsTheNumberOfCoversSizeTwinInAllOrdersInThisMonth() {
    }

    @Then("calculate number of covers size TWIN in all orders in this month")
    public void calculateNumberOfCoversSizeTwinInAllOrdersInThisMonth() {
        numCover=BusinessReport.numberOfCoverInThisMonth();
    }

    @Given("that needs the number of covers size CRIB in all orders in this month")
    public void thatNeedsTheNumberOfCoversSizeCribInAllOrdersInThisMonth() {
    }

    @Then("calculate number of covers size CRIB in all orders in this month")
    public void calculateNumberOfCoversSizeCribInAllOrdersInThisMonth() {
        numCover=BusinessReport.numberOfCoverInThisMonth();
    }
}
