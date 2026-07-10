public class SearchTest {

    public static void main(String[] args) {

        Product[] unsortedProducts = {
            new Product(105, "Wireless Mouse", "Electronics"),
            new Product(101, "Bluetooth Speaker", "Electronics"),
            new Product(110, "Running Shoes", "Footwear"),
            new Product(102, "Yoga Mat", "Fitness"),
            new Product(108, "Office Chair", "Furniture")
        };

        Product[] sortedProducts = {
            new Product(101, "Bluetooth Speaker", "Electronics"),
            new Product(102, "Yoga Mat", "Fitness"),
            new Product(105, "Wireless Mouse", "Electronics"),
            new Product(108, "Office Chair", "Furniture"),
            new Product(110, "Running Shoes", "Footwear")
        };

        int targetId = 108;

        long startLinear = System.nanoTime();
        Product linearResult = LinearSearch.search(unsortedProducts, targetId);
        long endLinear = System.nanoTime();

        System.out.println("=== Linear Search ===");
        System.out.println("Result: " + linearResult);
        System.out.println("Time taken: " + (endLinear - startLinear) + " ns");

        System.out.println();

        long startBinary = System.nanoTime();
        Product binaryResult = BinarySearch.search(sortedProducts, targetId);
        long endBinary = System.nanoTime();

        System.out.println("=== Binary Search ===");
        System.out.println("Result: " + binaryResult);
        System.out.println("Time taken: " + (endBinary - startBinary) + " ns");
    }
}