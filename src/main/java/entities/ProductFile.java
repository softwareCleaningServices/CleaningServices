package entities;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductFile { //Create Read Update Delete
        static RandomAccessFile fromFile;
        public static ArrayList<Product> getProduct() {
            ArrayList<Product> products = new ArrayList<>();
            try {
                fromFile=new RandomAccessFile("src/main/resources/allFiles/product", "rw");
                fromFile.seek(0);
                String productSplit;
                Product product;
                while ((productSplit = fromFile.readLine()) != null){
                    String[] array = productSplit.split(",");
                    Double dimension=array[2].equals("")?null:Double.parseDouble(array[2]);
                    Integer numOfSofa=array[3].equals("")?null:Integer.parseInt(array[3]);
                    SizeOfCover sizeOfCover=array[4].equals("")?null:SizeOfCover.valueOf(array[4]);
                    product=Product
                            .builder()
                            .setName(array[0])
                            .setPictureName(array[1])
                            .setDimension(dimension)
                            .setNumOfSofa(numOfSofa)
                            .setCover(sizeOfCover)
                            .setMaterial(array[5])
                            .setSpecialTreatment(array[6])
                            .setCategory(Category.valueOf(array[7]))
                            .setCost(Double.parseDouble(array[8]))
                            .build();
                    products.add(product);
                }
                fromFile.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            return products;
        }
        public static void storeProducts(ArrayList<Product> products) {
            try{
                RandomAccessFile writer = new RandomAccessFile("Back/Products.txt", "rw");
                for (Product product:products) {
                    writer.seek(writer.length());
                    writer.write(product.toString().getBytes());
                    writer.write("\n".getBytes());
                }
                writer.close();
            }
            catch(Exception e){
                System.out.println("Error");
            }
        }
        public static Product getProductByName(String name){
            Product product=new Product();
            for (Product product1:getProduct()){
                if(product1.getName().equals(name)){
                    product=product1;
                    break;
                }
            }
            return product;
        }
        public static ArrayList<Product> getAllProductByCategory(Category category){
            ArrayList<Product> products = new ArrayList<>();
            for (Product product1:getProduct()){
                if(product1.getCategory()==category){
                    products.add(product1);
                    break;
                }
            }
            return products;
        }
    public static Product productInfo() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your product category (CARPET,COVER,SOFA)");
        String category = input.nextLine();
        while (true) {
            if (category.equalsIgnoreCase("CARPET") || category.equalsIgnoreCase("SOFA") || category.equalsIgnoreCase("COVER")) {
                break;
            }
            System.out.println("please,Enter your product category");
            category = input.nextLine();
        }
        System.out.println("Enter your product name");
        String name = input.nextLine();
        while (name.equals("")) {
            System.out.println("please,Enter your product name");
            name = input.nextLine();
        }
        System.out.println("Enter your product picture name");
        String picName = input.nextLine();
        while (picName.equals("")) {
            System.out.println("please,Enter your product picture name");
            picName = input.nextLine();
        }
        System.out.println("Enter your product material");
        String material=input.nextLine();
        while (material.equals("")){
            System.out.println("please,Enter your product material");
            material=input.nextLine();
        }
        System.out.println("Enter your product special treatment");
        String special=input.nextLine();
        while (special.equals("")){
            System.out.println("please,Enter your product special treatment");
            special=input.nextLine();
        }
        double dimension=0;
        int numOfSofa=0;
        String sizeCover=null;
        Product product1 = null;
        double cost;
        if (category.equalsIgnoreCase("CARPET")){
            System.out.println("Enter your carpet dimension(in meter square)");
            dimension = Double.parseDouble(input.nextLine());
            cost=Product.carpetCost(dimension);
            product1= Product
                    .builder()
                    .setName(name)
                    .setPictureName(picName)
                    .setDimension(dimension)
                    .setMaterial(material)
                    .setSpecialTreatment(special)
                    .setCategory(Category.valueOf(category.toUpperCase()))
                    .setCost(cost)
                    .build();
        } else if (category.equalsIgnoreCase("SOFA")) {
            System.out.println("Enter the number of seats in all sofas");
            numOfSofa= Integer.parseInt(input.nextLine());
            cost=Product.sofaCost(numOfSofa);
            product1=Product
                    .builder()
                    .setName(name)
                    .setPictureName(picName)
                    .setNumOfSofa(numOfSofa)
                    .setMaterial(material)
                    .setSpecialTreatment(special)
                    .setCategory(Category.valueOf(category.toUpperCase()))
                    .setCost(cost)
                    .build();
        } else if(category.equalsIgnoreCase("COVER")){
            System.out.println("Enter the size of cover(KING,QUEEN,TWIN_XL,TWIN,CRIB)");
            sizeCover = input.nextLine();
            while (true) {
                if (sizeCover.equalsIgnoreCase("KING") || sizeCover.equalsIgnoreCase("QUEEN") || sizeCover.equalsIgnoreCase("TWIN_XL") || sizeCover.equalsIgnoreCase("TWIN") || sizeCover.equalsIgnoreCase("CRIB")) {
                    break;
                }
                System.out.println("please,Enter the size of cover");
                sizeCover = input.nextLine();
            }
            cost=Product.coverCost(sizeCover);
            product1=Product
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
        return product1;
    }
}