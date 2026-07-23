class Logger {

    // Create only one object of Logger
    private static Logger instance;

    // Private constructor prevents object creation using new
    private Logger() {
        System.out.println("Logger Instance Created");
    }

    // Public method to access the single object
    public static Logger getInstance() {

        if (instance == null) {
            instance = new Logger();
        }

        return instance;
    }

    // Logging method
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}