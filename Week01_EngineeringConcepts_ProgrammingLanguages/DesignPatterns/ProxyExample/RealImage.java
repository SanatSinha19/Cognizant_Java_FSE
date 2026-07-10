public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromServer(); 
    }

    private void loadFromServer() {
        System.out.println("Loading " + fileName + " from remote server...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(fileName + " loaded successfully.");
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}