import entities.Product;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class productFile { //Create Read Update Delete
    static RandomAccessFile fromFile;
    public static ArrayList<Product> readProducts() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            fromFile=new RandomAccessFile("product.txt", "rw");
            fromFile.seek(0);
            String productSplit;
            while ((productSplit = fromFile.readLine()) != null){
                String[] array = productSplit.split(" ");
                products.add(new Product(array[0],array[1],array[2],array[3],array[4]));
            }
            fromFile.close();
        }catch (Exception e){
            System.out.println("Error in read products");
        }
        return products;
    }
    public static void addProduct(Product product){//add to file
        try {
            RandomAccessFile writer = new RandomAccessFile(("src/main/resources/product"),"rw");
            writer.seek(writer.length());
            writer.write(product.toString().getBytes());
            writer.write("\n".getBytes());
            writer.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
