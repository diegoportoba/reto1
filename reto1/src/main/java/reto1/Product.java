package reto1;

public class Product {

    private static int id=0;

    private int productId;
    public int getProductId(){return productId;}
    public void setProductId(int productId) {this.productId=productId;}


    private String name;
    public String getName(){ return name;}
    public void setName(String name) {this.name=name;}

    private int price;
    public int getPrice(){return price;}
    public void setPrice(int price) {this.price=price;}

    private String url;
    public String getUrl(){ return url;}
    public void setUrl(String url) {this.url=url;}

    public Product(String name, int price, String url) {
        this.productId = id++;
        this.name = name;
        this.price = price;
        this.url = url;
    }

}
