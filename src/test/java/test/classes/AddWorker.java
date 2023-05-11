package test.classes;

import entities.Category;
import entities.Data;
import entities.Worker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.AdminLogin;

import static org.junit.Assert.*;

public class AddWorker {
    Worker worker;
    AdminLogin admin;
    String name;
    String phone;
    String email;
    String address;
    int salary;
    @Given("that the worker is not added yet")
    public void that_the_worker_is_not_added_yet() {
        worker=new Worker();
        admin=new AdminLogin();

    }
    @When("the admin enter the worker Name {string}")
    public void the_admin_enter_the_worker_name(String name) {
      worker.setName(name);
      this.name=name;
    }
    @When("the admin enter the worker Email {string}")
    public void the_admin_enter_the_worker_email(String email) {
       worker.setEmail(email);
       this.email=email;
    }
    @When("the admin enter the worker Phone {string}")
    public void the_admin_enter_the_worker_phone(String phone) {
       worker.setPhone(phone);
       this.phone=phone;
    }
    @When("the admin enter the worker Address {string}")
    public void the_admin_enter_the_worker_address(String address) {
      worker.setAddress(address);
      this.address=address;
    }
  Category category;
    @When("the admin enter the worker Category {string}")
    public void the_admin_enter_the_worker_category(String category) {
       worker.setCategory(Category.valueOf(category));
       this.category=Category.valueOf(category);
    }
    @When("the admin enter the worker Salary {string}")
    public void the_admin_enter_the_worker_salary(String salary) {
       worker.setSalary(Integer.parseInt(salary));
       this.salary=Integer.parseInt(salary);
    }
    int num;
    int id;
    @When("the admin enter the worker numOfProducts {string}")
    public void the_admin_enter_the_worker_num_of_products(String numOfProducts) {
        worker.setNumOfProd(Integer.parseInt(numOfProducts));
        num=Integer.parseInt(numOfProducts);
    }
    @Then("the system generate a unique ID for the worker")
    public void the_system_generate_a_unique_id_for_the_worker() {
        id=Data.getWorkerId();
        worker.setId(id);
    }
    @Then("the worker will be added to system")
    public void the_worker_will_be_added_to_system() {
        assertNotNull(worker);
        assertTrue(worker.isValidEmail());
        worker=new Worker(id,name,phone,address,email,salary,category);
        assertEquals(worker.getSalary(),salary);
        assertEquals(worker.getId(),id);
        assertEquals(worker.getCategory(),category);
        assertEquals(worker.getName(),name);
        assertEquals(worker.getPhone(),phone);




        admin.addWorker(worker);
    }

}
