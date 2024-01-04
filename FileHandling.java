import java.io.*;
import java.util.logging.Logger;

//Program to read a source file and write it into a Target file
public class FileHandling {

    public static void main(String[] args) {

        Logger logger = Logger.getLogger(FileHandling.class.getName());

        String fileOut = "output.txt";
        String fileIn = "input.txt";

        try {

            //reader to read a file
            Reader reader = new FileReader(fileIn);

            //writer for writing into a file
            Writer writer = new FileWriter(fileOut);

            int character;

            System.out.println("Read file contains :");

            //Reading the file using a integer one by one char and writing it into the target file
            while ((character = reader.read()) != -1) {
                writer.write(character);
                System.out.print((char) character);
            }

            reader.close();
            writer.flush();
            writer.close();

            logger.info("Completed Reading  and writing into a file ");

        }
        catch (IOException e) {
            e.printStackTrace();
            logger.warning("IOException Found");
        }
    }
}