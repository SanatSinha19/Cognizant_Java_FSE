public class ProxyTest {

    public static void main(String[] args) {

        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        System.out.println("--- First call to image1.display() ---");
        image1.display();  

        System.out.println("\n--- Second call to image1.display() ---");
        image1.display(); 

        System.out.println("\n--- First call to image2.display() ---");
        image2.display();   

        System.out.println("\n--- Second call to image2.display() ---");
        image2.display(); 
    }
}