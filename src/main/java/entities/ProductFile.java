package entities;

import najah.edu.Order;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ProductFile { //Create Read Update Delete
    static RandomAccessFile fromFile;
    static Logger logger = Logger.getLogger(ProductFile.class.getName());
    public static List<Product> getProduct() {
        List<Product> products = new ArrayList<>();
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
                int orderId=Integer.parseInt(array[9]);
                product=Product
                        .builder()
                        .setName(array[0])
                        .setOrderId(orderId)
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
            logger.info(e.getMessage());
        }
        return products;
    }
    public static void storeProducts(List<Product> products) {
        try(RandomAccessFile writer = new RandomAccessFile("src/main/resources/Back/product", "rw")){
            for (Product product:products) {
                writer.seek(writer.length());
                writer.write(product.toString().getBytes());
                writer.write("\n".getBytes());
            }
        }
        catch(Exception e){
            logger.info("Error");
        }
    }
    public static ArrayList<Product> getProductByOrder(int id){
       ArrayList<Product> products=new ArrayList<>();
        for (Product product1:getProduct()){
            if(product1.getOrderId()==id){
                products.add(product1);
            }
        }
        return products;
    }
    public static List<Product> getAllProductByCategory(Category category){
        List<Product> products = new ArrayList<>();
        for (Product product1:getProduct()){
            if(product1.getCategory()==category){
                products.add(product1);
                break;
            }
        }
        return products;
    }
    public static double totalAfterDiscount(Order order){
        double newTotal;
        double disc=discount(order.getTotal());
        newTotal=order.getTotal()-(order.getTotal()*disc);
        return newTotal;
    }
public static double discount(double total){
        double disc;

    if(total>=500){
        disc = 0.2;
    }else if(total>=150 && total<500){
        disc = 0.15;
    }else if(total>=100 && total<150){
        disc = 0.07;
    }else{
        disc=0;
    }
    return disc;
}
    private ProductFile(){}
}
