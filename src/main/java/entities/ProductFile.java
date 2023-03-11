package entities;

import najah.edu.AddOrder;

import java.io.RandomAccessFile;
import java.util.ArrayList;

public class ProductFile { //Create Read Update Delete
    static RandomAccessFile fromFile;
    public static ArrayList<Product> getProduct() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            fromFile=new RandomAccessFile("src/main/resources/Back/product", "rw");
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
            RandomAccessFile writer = new RandomAccessFile("src/main/resources/Back/product", "rw");
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
    public static double totalAfterDiscount(AddOrder order){
        double newTotal;
        if(order.getTotal()>=500){
            newTotal = order.getTotal()-(order.getTotal()*20/100);
        }else if(order.getTotal()>=150 && order.getTotal()<500){
            newTotal = order.getTotal()-(order.getTotal()*15/100);
        }else if(order.getTotal()>=100 && order.getTotal()<150){
            newTotal = order.getTotal()-(order.getTotal()*7/100);
        }else{
            newTotal = order.getTotal();
        }
        return newTotal;
    }
}
