package javabasics.module3;

import java.util.ArrayList;
import java.io.File;
import java.lang.Exception;

/*
 * @author db-ss
 * @email daniel.brashaw@smoothstack.com
**/

public class Module3Assignment1 {

    // the size of empty space to pad the interior files and folders' names
    private final String TAB = "  ";

    public Module3Assignment1(String pathname, Integer recursionLevel) {

        this.exploreRecursively(pathname, recursionLevel, 0);

    }

    public Module3Assignment1(String pathname) {

        this.exploreRecursively(pathname, 0, 0);
    }

    private void exploreRecursively(String pathname, Integer recursionLevel, Integer tabs) {

        File f = new File(pathname);
        File allFiles[] = null;
        try {
            allFiles = f.listFiles();
        } catch (Exception e) {
            System.out.println("Is " + pathname + " a valid directory?");
            return;
        }
        if (allFiles == null) return; // no further recursion (empty folder)

        ArrayList<File> filesInDir = new ArrayList<>(), subDirsInDir = new ArrayList<>();

        for (File fd : allFiles) {
            if (fd.isFile()) {
                filesInDir.add(fd);
            } else {
                subDirsInDir.add(fd);
            }
        }

        for (File fil : filesInDir) {
            for (int i = 0; i < tabs; i++) {
                System.out.print(TAB);
            }
            System.out.println(fil.getName());
        }

        for (File dir : subDirsInDir) {
            for (int i = 0; i < tabs-1; i++) {
                System.out.print(TAB);
            }
            System.out.println("/" + dir.getName() + "/");
            if (recursionLevel > 0) { // fails to recurse on recursionLevel == 0
                this.exploreRecursively(pathname + "/" + dir.getName(), recursionLevel-1, tabs+1);
            }
        }
    }
    
    public static void main(String[] args) {
        Module3Assignment1 a1 = new Module3Assignment1("/");
        // Caution searching in the root directory with recursion
        // this can explode the heap and cause the machine to hang
        Module3Assignment1 aRec = new Module3Assignment1("/", 1);
    }
}
