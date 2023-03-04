import entities.Category;
import entities.Product;
import java.util.Scanner;

public class Main {
    public static void productInfo(){
        Scanner input=new Scanner(System.in);
        productFile product= new productFile();
        System.out.println("Enter your product name");
        String name=input.nextLine();
        while (name.equals("")){
            System.out.println("please,Enter your product name");
            name=input.nextLine();
        }
        System.out.println("Enter your product picture name");
        String picName=input.nextLine();
        while (picName.equals("")){
            System.out.println("please,Enter your product picture name");
            picName=input.nextLine();
        }
        System.out.println("Enter your product dimension");
        String dimension=input.nextLine();
        while (dimension.equals("")){
            System.out.println("please,Enter your product dimension");
            dimension=input.nextLine();
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
        System.out.println("Enter your product category");
        String category=input.nextLine();
        while(true){
            if(category.equalsIgnoreCase("CARPET")|| category.equalsIgnoreCase("SOFA")|| category.equalsIgnoreCase("COVER")){
                break;
            }
            System.out.println("please,Enter your product category");
            category=input.nextLine();
        }
        product.addProduct(new Product(name,picName,dimension,material,special,Category.valueOf(category.toUpperCase())));
    }
    public static void main(String[]args){
        System.out.println("Hello This is for testing");
        productFile pro= new productFile();
        Scanner inputInt=new Scanner(System.in);
        int x;
        while (true){
            System.out.println("Menu");
            System.out.println("****************************************");
            System.out.println("1-recorded customer");
            System.out.println("2-recorded product");
            x=Integer.parseInt(inputInt.nextLine());
            switch (x){
                case 1:
                    System.out.println("aaa");
                    break;
                case 2:
                    productInfo();
                    break;
                default:
                    System.out.println("invalid input");
                    break;
            }
        }
    }
}
