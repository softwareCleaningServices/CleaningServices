package test.classes;

import entities.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class RecordProducts {
    Product product ;
    Category category;
    String name;
    String pictureName;
    Double dimension;
    SizeOfCover cover;
    Integer numOfSofa;
    String material;
    String specialTreatment;
    Double cost;

    @Before
    public void initialization() {
        product = Product.builder().build();
    }

    @Given("that I recorded a new {string}")
    public void that_i_recorded_a_new(String string) {
        category = Category.valueOf(string.toUpperCase());
        product.setCategory(category);
    }
    @When("the user  enter name {string}")
    public void the_user_enter_name(String string) {
        name=string;
        product.setName(string);
    }
    @When("enter picture Name {string}")
    public void enter_picture_name(String string) {
        pictureName=string;
        product.setPictureName(string);
    }
    @When("enter dimension {double}")
    public void enter_dimension(Double double1) {
        dimension=double1;
        product.setDimension(double1);
    }
    @When("enter cover {string}")
    public void enter_cover(String string) {
        cover=SizeOfCover.valueOf(string);
        product.setCover(SizeOfCover.valueOf(string.toUpperCase()));
    }
    @When("enter num Of Sofa {int}")
    public void enter_num_of_sofa(Integer int1) {
        numOfSofa=int1;
        product.setNumOfSofa(int1);
    }
    @When("enter material {string}")
    public void enter_material(String string) {
        material=string;
        product.setMaterial(string);
    }
    @When("enter special Treatment {string}")
    public void enter_special_treatment(String string) {
        specialTreatment=string;
        product.setSpecialTreatment(string);
    }
    @When("calculate the cost {double}")
    public void calculate_the_cost(Double double1) {
        cost=double1;
        product.setCost(double1);
    }
    @Then("the product will be recorded successfully")
    public void the_will_recorded_successfully() {
        assertEquals(name,product.getName());
        assertEquals(pictureName,product.getPictureName());
        assertEquals(material,product.getMaterial());
        assertEquals(specialTreatment,product.getSpecialTreatment());
        assertEquals(cost,product.getCost());
        assertEquals(category,product.getCategory());
        if(category==Category.CARPET){
            assertEquals(dimension,product.getDimension());
        }else if(category==Category.COVER){
            assertEquals(cover,product.getCover());
        }else if(category==Category.SOFA){
            assertEquals(numOfSofa,product.getNumOfSofa());
        }
    }
}
