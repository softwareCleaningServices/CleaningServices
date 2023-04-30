package test.classes;

import entities.Category;
import entities.Data;
import entities.Worker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.AdminLogin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class AddWorkerTest {
Worker worker;
AdminLogin admin;
    @Given("that the worker is not added yet")
    public void that_the_worker_is_not_added_yet() {
        worker=new Worker();
        admin=new AdminLogin();

    }
    @When("the admin enter the worker Name {string}")
    public void the_admin_enter_the_worker_name(String name) {
      worker.setName(name);
    }
    @When("the admin enter the worker Email {string}")
    public void the_admin_enter_the_worker_email(String email) {
       worker.setEmail(email);
    }
    @When("the admin enter the worker Phone {string}")
    public void the_admin_enter_the_worker_phone(String phone) {
       worker.setPhone(phone);
    }
    @When("the admin enter the worker Address {string}")
    public void the_admin_enter_the_worker_address(String address) {
      worker.setAddress(address);
    }
    @When("the admin enter the worker Category {string}")
    public void the_admin_enter_the_worker_category(String category) {
       worker.setCategory(Category.valueOf(category));
    }
    @When("the admin enter the worker Salary {string}")
    public void the_admin_enter_the_worker_salary(String salary) {
       worker.setSalary(Integer.parseInt(salary));
    }
    @When("the admin enter the worker numOfProducts {string}")
    public void the_admin_enter_the_worker_num_of_products(String numOfProducts) {
        worker.setNumOfProd(Integer.parseInt(numOfProducts));
    }
    @Then("the system generate a unique ID for the worker")
    public void the_system_generate_a_unique_id_for_the_worker() {
      worker.setId(Data.getWorkerId());
    }
    @Test
    @Then("the worker will be added to system")
    void the_worker_will_be_added_to_system() {
        Assertions.assertNotNull(worker);
        Assertions.assertTrue(worker.isValidEmail());
       admin.addWorker(worker);
    }

}
