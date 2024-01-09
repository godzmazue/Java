import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.logging.Logger;

//Program to read a source file and write it into a Target file
public class FileHandling {

    class FileHandlingException extends Exception {
        public FileHandlingException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static void main(String[] args) throws FileReadingException {

        Logger logger = Logger.getLogger(FileHandling.class.getName());


        String fileOut = "output.txt";
        String fileIn = "input.txt";

        try {

            //reader to read a file

            Reader reader = new FileReader(fileIn);
            BufferedReader in = new BufferedReader(reader);

            //writer for writing into a file
            Writer writer = new FileWriter(fileOut);
            BufferedWriter out = new BufferedWriter(writer);


            ArrayList list = new ArrayList<>();
            String data ;

            //Reading the file using bufferedReader line by line  writing it into the target file
            while ((data = in.readLine()) != null) {
                writer.write(data+"\n");
                list.add(data);
            }

            reader.close();
            writer.flush();
            writer.close();

            logger.info(String.valueOf(list));

            logger.info("Completed Reading  and writing into a file ");

        }
        catch (IOException e) {
            throw new FileReadingException("File Handling Exception",e);
        }
    }
}
