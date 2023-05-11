package najah.edu;

import entities.Category;
import entities.Product;
import entities.SizeOfCover;
import java.util.Scanner;
import java.util.logging.Logger;

public class RecordProduct {
    private RecordProduct(){}
    static Logger logger = Logger.getLogger(RecordProduct.class.getName());
    public static void menu(){

    }
    public static Product addAProduct() {
        Scanner input = new Scanner(System.in);
        logger.info("Enter your product category (CARPET,COVER,SOFA)");
        String category=checkCategory();
        logger.info("Enter your product name");
        String name = input.nextLine();
        name=checkEnter(name);
        logger.info("Enter your product picture name");
        String picName = input.nextLine();
        picName=checkEnter(picName);
        logger.info("Enter your product material");
        String material=input.nextLine();
        material=checkEnter(material);
        logger.info("Enter your product special treatment");
        String special=input.nextLine();
        special=checkEnter(special);
        Product product1 = null;
        if (category.equalsIgnoreCase("CARPET")){
            logger.info("Enter your carpet dimension(in meter square)");
            product1=carpetProduct(name,picName,material,special,category);
        } else if (category.equalsIgnoreCase("SOFA")) {
            logger.info("Enter the number of seats in all sofas");
            product1=sofaProduct(name,picName,material,special,category);
        } else if(category.equalsIgnoreCase("COVER")){
            logger.info("Enter the size of cover(KING,QUEEN,TWIN_XL,TWIN,CRIB)");
            product1=coverProduct(name,picName,material,special,category);
        }
        return product1;
    }
    public static String checkCategory(){
        Scanner input = new Scanner(System.in);
        String category = input.nextLine();
        while (!category.equalsIgnoreCase("CARPET") &&
                !category.equalsIgnoreCase("SOFA") &&
                !category.equalsIgnoreCase("COVER")) {
            logger.info("please,Enter your product category");
            category = input.nextLine();
        }
        return category;
    }
    public static String checkEnter(String string){
        Scanner input = new Scanner(System.in);
        while (string.equals("")) {
            logger.info("please,Enter again");
            string = input.nextLine();
        }
        return string;
    }
    public static Product carpetProduct(String name, String picName, String material, String special, String category){
        Scanner input = new Scanner(System.in);
        double dimension = Double.parseDouble(input.nextLine());
        double cost=Product.carpetCost(dimension);
        return Product
                .builder()
                .setName(name)
                .setPictureName(picName)
                .setDimension(dimension)
                .setMaterial(material)
                .setSpecialTreatment(special)
                .setCategory(Category.valueOf(category.toUpperCase()))
                .setCost(cost)
                .build();
    }
    public static Product sofaProduct(String name, String picName, String material, String special, String category){
        Scanner input = new Scanner(System.in);
        int numOfSofa= Integer.parseInt(input.nextLine());
        double cost=Product.sofaCost(numOfSofa);
        return Product
                .builder()
                .setName(name)
                .setPictureName(picName)
                .setNumOfSofa(numOfSofa)
                .setMaterial(material)
                .setSpecialTreatment(special)
                .setCategory(Category.valueOf(category.toUpperCase()))
                .setCost(cost)
                .build();
    }
    public static Product coverProduct(String name, String picName, String material, String special, String category){
        Scanner input = new Scanner(System.in);
        String sizeCover = input.nextLine();
        while (!sizeCover.equalsIgnoreCase("KING") &&
                !sizeCover.equalsIgnoreCase("QUEEN") &&
                !sizeCover.equalsIgnoreCase("TWIN_XL") &&
                !sizeCover.equalsIgnoreCase("TWIN") &&
                !sizeCover.equalsIgnoreCase("CRIB")) {
            logger.info("please,Enter the size of cover");
            sizeCover = input.nextLine();
        }
        double cost=Product.coverCost(sizeCover);
        return Product
                .builder()
                .setName(name)
                .setPictureName(picName)
                .setCover(SizeOfCover.valueOf(sizeCover.toUpperCase()))
                .setMaterial(material)
                .setSpecialTreatment(special)
                .setCategory(Category.valueOf(category.toUpperCase()))
                .setCost(cost)
                .build();
    }

}