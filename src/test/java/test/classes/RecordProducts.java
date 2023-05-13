package test.classes;

import entities.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.RecordProduct;


import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RecordProducts {
    Product product ;
    Product product1;
    double []cost=ProductFile.getCostOfCategory();
    @Given("the user wants to add a new product")
    public void theUserWantsToAddANewProduct() {
        product=Product.builder().build();
    }

    @When("the user enters a valid information for carpet")
    public void theUserEntersAValidInformationForCarpet() {
        ByteArrayInputStream in = new ByteArrayInputStream("carpet\ncarpetName\ncarpetPic\nsoph\ncolorWhite\n10.0\n".getBytes());
        System.setIn(in);
    }
    @Then("a new carpet product with the given details is added to the system")
    public void aNewCarpetProductWithTheGivenDetailsIsAddedToTheSystem() {
        product=RecordProduct.addAProduct();
        product1=Product
                .builder()
                .setName("carpetName")
                .setPictureName("carpetPic")
                .setDimension(10.0)
                .setMaterial("soph")
                .setSpecialTreatment("colorWhite")
                .setCategory(Category.valueOf("carpet".toUpperCase()))
                .setCost(cost[0]*10.0)
                .build();
        assertEquals(product1, product);
    }

    @When("the user enters a valid information for sofa")
    public void theUserEntersAValidInformationForSofa() {
        ByteArrayInputStream in = new ByteArrayInputStream("sofa\nsofaName\nsofaPic\nsoph\ncolorWhite\n7\n".getBytes());
        System.setIn(in);
    }

    @Then("a new sofa product with the given details is added to the system")
    public void aNewSofaProductWithTheGivenDetailsIsAddedToTheSystem() {
        product=RecordProduct.addAProduct();
        product1=Product
                .builder()
                .setName("sofaName")
                .setPictureName("sofaPic")
                .setNumOfSofa(7)
                .setMaterial("soph")
                .setSpecialTreatment("colorWhite")
                .setCategory(Category.valueOf("sofa".toUpperCase()))
                .setCost(cost[1]*7)
                .build();
        assertEquals(product1, product);
    }

    @When("the user enters a valid information for cover King")
    public void theUserEntersAValidInformationForCoverKing() {
        ByteArrayInputStream in = new ByteArrayInputStream("cover\ncoverName\ncoverPic\nsoph\ncolorWhite\nKing\n".getBytes());
        System.setIn(in);
    }

    @Then("a new King cover product with the given details is added to the system")
    public void aNewKingCoverProductWithTheGivenDetailsIsAddedToTheSystem() {
        product=RecordProduct.addAProduct();
        product1=Product
                .builder()
                .setName("coverName")
                .setPictureName("coverPic")
                .setCover(SizeOfCover.KING)
                .setMaterial("soph")
                .setSpecialTreatment("colorWhite")
                .setCategory(Category.valueOf("cover".toUpperCase()))
                .setCost(cost[2])
                .build();
        assertEquals(product1, product);
    }

    @When("the user enters a valid information for cover Queen")
    public void theUserEntersAValidInformationForCoverQueen() {
        ByteArrayInputStream in = new ByteArrayInputStream("cover\ncoverName\ncoverPic\nsoph\ncolorWhite\nQueen\n".getBytes());
        System.setIn(in);
    }

    @Then("a new Queen cover product with the given details is added to the system")
    public void aNewQueenCoverProductWithTheGivenDetailsIsAddedToTheSystem() {
        product=RecordProduct.addAProduct();
        product1=Product
                .builder()
                .setName("coverName")
                .setPictureName("coverPic")
                .setCover(SizeOfCover.QUEEN)
                .setMaterial("soph")
                .setSpecialTreatment("colorWhite")
                .setCategory(Category.valueOf("cover".toUpperCase()))
                .setCost(cost[3])
                .build();
        assertEquals(product1, product);
    }

    @When("the user enters a valid information for cover TWIN_XL")
    public void theUserEntersAValidInformationForCoverTWIN_XL() {
        ByteArrayInputStream in = new ByteArrayInputStream("cover\ncoverName\ncoverPic\nsoph\ncolorWhite\nTWIN_XL\n".getBytes());
        System.setIn(in);
    }

    @Then("a new TWIN_XL cover product with the given details is added to the system")
    public void aNewTWIN_XLCoverProductWithTheGivenDetailsIsAddedToTheSystem() {
        product=RecordProduct.addAProduct();
        product1=Product
                .builder()
                .setName("coverName")
                .setPictureName("coverPic")
                .setCover(SizeOfCover.TWIN_XL)
                .setMaterial("soph")
                .setSpecialTreatment("colorWhite")
                .setCategory(Category.valueOf("cover".toUpperCase()))
                .setCost(cost[4])
                .build();
        assertEquals(product1, product);
    }

    @When("the user enters a valid information for cover TWIN")
    public void theUserEntersAValidInformationForCoverTWIN() {
        ByteArrayInputStream in = new ByteArrayInputStream("cover\ncoverName\ncoverPic\nsoph\ncolorWhite\nTWIN\n".getBytes());
        System.setIn(in);
    }

    @Then("a new TWIN cover product with the given details is added to the system")
    public void aNewTWINCoverProductWithTheGivenDetailsIsAddedToTheSystem() {
        product=RecordProduct.addAProduct();
        product1=Product
                .builder()
                .setName("coverName")
                .setPictureName("coverPic")
                .setCover(SizeOfCover.TWIN)
                .setMaterial("soph")
                .setSpecialTreatment("colorWhite")
                .setCategory(Category.valueOf("cover".toUpperCase()))
                .setCost(cost[5])
                .build();
        assertEquals(product1, product);
    }

    @When("the user enters a valid information for cover Crib")
    public void theUserEntersAValidInformationForCoverCrib() {
        ByteArrayInputStream in = new ByteArrayInputStream("cove\ncover\ncoverName\ncoverPic\nsoph\ncolorWhite\nCRB\nCRIB\n".getBytes());
        System.setIn(in);
    }

    @Then("a new Crib cover product with the given details is added to the system")
    public void aNewCribCoverProductWithTheGivenDetailsIsAddedToTheSystem() {
        product=RecordProduct.addAProduct();
        product1=Product
                .builder()
                .setName("coverName")
                .setPictureName("coverPic")
                .setCover(SizeOfCover.CRIB)
                .setMaterial("soph")
                .setSpecialTreatment("colorWhite")
                .setCategory(Category.valueOf("cover".toUpperCase()))
                .setCost(cost[6])
                .build();
        assertEquals(product1, product);
    }
}
