package javabasics.module3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/*
 * @author db-ss
 * @email daniel.brashaw@smoothstack.com
**/

public class Module3Assignment3 {

    private File file = null;

    public Module3Assignment3(String pathname) {

        try {
            this.file = new File(pathname);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // case-sensitive count the instances of the character c in the loaded file (it must exist)
    public void countCharInstance(char c) {

        if (this.file == null) {
            System.out.println("File wasn't specified");
            return;
        }
        Long count = 0L;
        String str;

        try (BufferedReader br = new BufferedReader(new FileReader(this.file))) {
            
            while ((str = br.readLine()) != null) {
                // using lambdas for practice
                count += str.chars().filter(ch -> ch == c).count();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("There are " + count + " instance(s) of '" + c + 
                           "' in " + this.file.getName());
    }

    public static void main(String[] args) {
        Module3Assignment3 a3 = new Module3Assignment3("./javabasics/module3/text/m3a2.txt");
        // treat each argument as a char array and count the instances of the chars
        for (String arg : args) {
            for (char c : arg.toCharArray()) {
                a3.countCharInstance(c);
            }
        }
    }
}
