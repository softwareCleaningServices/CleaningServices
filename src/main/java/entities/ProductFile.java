package entities;

import najah.edu.Order;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class ProductFile {
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
                        .setOrderId(Integer.parseInt(array[9]))
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
    public static List<Product> getProductByOrder(int id){
        List<Product> products=new ArrayList<>();
        for (Product product1:getProduct()){
            if(product1.getOrderId()==id){
                products.add(product1);
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
        }else if(total>=150){
            disc = 0.15;
        }else if(total>=100){
            disc = 0.07;
        }else{
            disc=0;
        }
        return disc;
    }
    public static void updateCostOfCategory() {
        Scanner input = new Scanner(System.in);
        double[] costCat;
        double cost=0;
        while (true) {
            logger.info("To change cost of carpet enter 1");
            logger.info("To change cost of sofa enter 2");
            logger.info("To change cost of KING cover enter 3");
            logger.info("To change cost of QUEEN cover enter 4");
            logger.info("To change cost of TWIN_XL cover enter 5");
            logger.info("To change cost of TWIN cover enter 6");
            logger.info("To change cost of CRIB cover enter 7");
            int num = input.nextInt();
            if(num >=0 && num <=7){
                logger.info("Enter the new Cost");
                cost = input.nextDouble();
            }
            costCat = switchInUpdateCostOfCategory(num, cost);
            logger.info("Do you need to change the cost of another category?\"yes or no\"");
            input.nextLine();//to throw away the \n
            String ans = input.nextLine();
            if (ans.equalsIgnoreCase("no")) {
                break;
            }
        }
        storeCostOfCategory(costCat);
    }
    public static double [] switchInUpdateCostOfCategory(int num,double cost){
        double []costCat = getCostOfCategory();
        if(num<1||num>7){
            logger.info("error!no category in this number");
        }else{
            costCat[num-1]=cost;
        }
        return costCat;
    }
    public static double[] getCostOfCategory(){
        double []costCat=new double[7];
        try {
            fromFile=new RandomAccessFile("src/main/resources/Back/Cost.txt", "rw");
            fromFile.seek(0);
            String costSplit=fromFile.readLine();
            String[] array=costSplit.split(",");
            for (int i=0;i<array.length;i++){
                costCat[i]=Double.parseDouble(array[i]);
            }
            fromFile.close();
        }catch (Exception e){
            logger.info(e.getMessage());
        }
        return costCat;
    }
    public static void storeCostOfCategory(double []costCat){
        try(RandomAccessFile writer = new RandomAccessFile("src/main/resources/Back/Cost.txt", "rw")){
            writer.seek(0);
            String cost=String.format("%s,%s,%s,%s,%s,%s,%s", costCat[0],costCat[1],costCat[2],costCat[3],costCat[4],costCat[5],costCat[6]);
            writer.write(cost.getBytes());
            writer.write("\n".getBytes());
        }
        catch(Exception e){
            logger.info("Error");
        }
    }
    private ProductFile(){}
}
