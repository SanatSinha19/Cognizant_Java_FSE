public class ProxyImage implements Image {
    private RealImage realImage;  
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            System.out.println("[Proxy] Image not loaded yet. Creating RealImage now...");
            realImage = new RealImage(fileName);
        } else {
            System.out.println("[Proxy] Using cached image. No need to reload from server.");
        }
        realImage.display();
    }
}