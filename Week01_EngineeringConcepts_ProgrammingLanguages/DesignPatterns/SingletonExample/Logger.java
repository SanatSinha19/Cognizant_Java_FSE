public class Logger {

    // private static instance of itself
    private static Logger instance;

    // private constructor prevents external instantiation
    private Logger() {
        System.out.println("Logger instance created.");
    }

    // public static method to get the single instance (thread-safe)
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Sample logging method
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}