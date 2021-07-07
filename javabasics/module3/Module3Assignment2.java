package javabasics.module3;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.File;

/*
 * @author db-ss
 * @email daniel.brashaw@smoothstack.com
**/

public class Module3Assignment2 {

    private File file = null;

    // default behavior is to create the file if it does not exist
    public Module3Assignment2(String pathname) {

        try {
            this.file = new File(pathname);

            if (!this.file.exists()) {
                this.file.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void appendStringToFile(String contents) {

        // this shouldn't be reached, but it is good practice
        if (this.file == null) {
            System.out.println("File wasn't specified");
            return;
        }
            
        try {
            Files.write(Paths.get(this.file.toURI()),
                        contents.getBytes(),
                        StandardOpenOption.APPEND);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Module3Assignment2 a2 = new Module3Assignment2("./javabasics/module3/text/m3a2.txt");
        a2.appendStringToFile("always be coding.");
    }
}
