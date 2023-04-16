package test.classes;

import entities.Data;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.CustomerLogin;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateCustomer {
    CustomerLogin customer;
    private String value;
    @Given("that I choose to update customer info")
    public void that_i_choose_to_update_customer_info() {
     customer=new CustomerLogin();
     customer.setCustomer(Data.getCustomers().get(0));
    }

    @When("I select to update my phone and I enter my new phone = {string}")
    public void i_select_to_update_my_phone(String phone) {
        value=phone;
        customer.updateInfo("phone",value);
    }

    @Then("my phone number will updated successfully")
    public void my_phone_number_will_updated_successfully() {
        assertEquals(customer.getCustomer().getPhone(), value);
    customer.updateMsg();
    }

    @When("I select to update my address and I enter my new address = {string}")
    public void i_select_to_update_my_address(String address) {
    value=address;
    customer.updateInfo("address",value);
    }


    @Then("my address will updated successfully")
    public void my_address_will_updated_successfully() {
        assertEquals(customer.getCustomer().getAddress(), value);
        customer.updateMsg();
    }

}
