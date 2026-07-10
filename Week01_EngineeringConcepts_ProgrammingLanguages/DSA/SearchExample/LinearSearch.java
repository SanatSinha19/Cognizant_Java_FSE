public class LinearSearch {

    public static Product search(Product[] products, int targetId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductId() == targetId) {
                return products[i]; 
            }
        }
        return null; 
    }
}