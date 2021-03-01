package reto1;

public class OrderProduct {

    private static int id=0;

    private int orderProductId;
    public int getOrderProductId(){return orderProductId;}
    public void setOrderProductId(int orderProductId) {this.orderProductId=orderProductId;}

    private int productId;
    public int getProductId(){return productId;}
    public void setProductId(int productId) {this.productId=productId;}

    private int orderId;
    public int getOrderId(){return orderId;}
    public void setOrderId(int orderId) {this.orderId=orderId;}

    private int quantity;
    public int getQuantity(){return quantity;}
    public void setQuantity(int quantity) {this.quantity=quantity;}

    public OrderProduct(int orderId, int productId, int quantity) {
        this.orderProductId=id++;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public OrderProduct() {
        this.orderProductId=id++;
    }
	public int getId() {
		return 0;
	}
    
}
