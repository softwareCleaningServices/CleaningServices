import entities.Product;

public class Main {
    public static void main(String[]args){
        System.out.println("Hello This is for testing");
        productFile pro= new productFile();
        Product a=new Product("carpet","carpet","200*100","cloth","no");
        Product b=new Product("a1","carpet","200*100","cloth","no");
        Product c=new Product("a2","carpet","200*100","cloth","no");
        pro.addProduct(a);
        pro.addProduct(b);
        pro.addProduct(c);
    }
}
