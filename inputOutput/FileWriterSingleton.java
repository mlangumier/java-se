package inputOutput;

public class FileWriterSingleton {
    private static FileWriterSingleton instance;

    private FileWriterSingleton() {};

    public static FileWriterSingleton getInstance() {
        if(instance == null) {
            instance = new FileWriterSingleton();
        }
        return instance;
    }

    // Add data to file

    // Get data from file
}
