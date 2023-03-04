package entities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Product {
    private String name;
    private String pictureName;
    private String dimension;
    private String material;
    private String specialTreatment;

    private Category category;
    //private String picturePath="src/main/resources/img"+pictureName+".jpg";//TODO name from user then concatenation with path
    //BufferedImage picture;
//    {
//        try {
//            picture = ImageIO.read(new File(picturePath));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
    public Product() {

    }

    public Product(String name, String pictureName, String dimension, String material, String specialTreatment ,Category category) {
        this.name = name;
        this.pictureName = pictureName;
        this.dimension = dimension;
        this.material = material;
        this.specialTreatment = specialTreatment;
        this.category= category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getSpecialTreatment() {
        return specialTreatment;
    }

    public void setSpecialTreatment(String specialTreatment) {
        this.specialTreatment = specialTreatment;
    }

    @Override
    public String toString() {
        return name + " " + pictureName + " " + dimension + " " + material + " " + specialTreatment + " " +category;
    }

}
