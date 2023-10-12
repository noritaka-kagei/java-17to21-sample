import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

// This task executing i/o process
public class Task implements Runnable {
    private String additionalMsg;

    Task(String additionalMsg) {
        this.additionalMsg = additionalMsg;
    }

    @Override
    public void run() {
        String file = "sample.txt";

        try {
            FileWriter fileWriter = new FileWriter(file, true); // true: additional writing mode
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // write a message to file
            bufferedWriter.write("Hello World! on " + additionalMsg);
            bufferedWriter.newLine();

            // close writer
            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}