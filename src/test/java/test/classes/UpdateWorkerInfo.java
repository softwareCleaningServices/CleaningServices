package test.classes;

import entities.Data;
import entities.Worker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.AdminLogin;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateWorkerInfo {
    AdminLogin admin;
    Worker worker;
    String attribute;
    String value;
    @Given("that I choose to update worker info")
    public void that_i_choose_to_update_worker_info() {
       admin=new AdminLogin();
       worker= Data.getWorkerById(130);
    }

    @When("I select to update Salary")
    public void i_select_to_update_salary() {
        attribute="salary";

    }

    @When("I enter the new salary = {string}")
    public void i_enter_the_new_salary(String salary) {
       admin.updateWorker(attribute,salary,worker);
       value=salary;
    }

    @Then("the salary will updated successfully")
    public void the_salary_will_updated_successfully() {
        assertEquals(String.valueOf(worker.getSalary()), value);
    }

    @When("I select to update Phone")
    public void i_select_to_update_phone() {
      attribute="Phone";
    }
    @When("I enter the new Phone = {string}")
    public void i_enter_the_new_phone(String phone) {
        admin.updateWorker(attribute,phone,worker);
        value=phone;
    }

    @Then("the phone will updated successfully")
    public void the_phone_will_updated_successfully() {
        assertEquals(worker.getPhone(), value);

    }

    @When("I select to update Address")
    public void i_select_to_update_address() {
        attribute="Address";
    }

    @When("I enter the new address = {string}")
    public void i_enter_the_new_address(String address) {
        admin.updateWorker(attribute,address,worker);
        value=address;
    }

    @Then("the address will updated successfully")
    public void the_address_will_updated_successfully() {
        assertEquals(worker.getAddress(), value);
        List<Worker>workers=Data.getWorkers();
        for (Worker worker1:workers){
            if(worker1.getId()==worker.getId()){
                worker1=worker;
            }
        }
        Data.updateWorkers(workers);
    }
    @When("I select to update email")
    public void i_select_to_update_email() {
       attribute="email";
    }
    @When("I enter the new email = {string}")
    public void i_enter_the_new_email(String email) {
        admin.updateWorker(attribute,email,worker);
        value=email;
    }

    @Then("the email will updated successfully")
    public void the_email_will_updated_successfully() {
        assertEquals(worker.getEmail(), value);
        List<Worker>workers=Data.getWorkers();
        for (Worker worker1:workers){
            if(worker1.getId()==worker.getId()){
                worker1=worker;
            }
        }
        Data.updateWorkers(workers);
    }
}
