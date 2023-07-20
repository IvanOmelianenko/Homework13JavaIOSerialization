import java.io.*;
import java.rmi.RemoteException;
import java.util.Objects;

public class Files {
    public static void main(String[] args) throws IOException {

        File dir = new File("C:\\TestF");
        File file = new File("C:\\TestF\\originalFile.txt");

        File file2 = new File("C:\\TestF\\moveFile.txt");

//        boolean createDir = dir.mkdir();

        if(dir.mkdir()) {
            System.out.println("Directory is created");
        }

        boolean createdFile = false;

        try {
            createdFile = file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException();
        }

        if (createdFile) {
            System.out.println("Original file is created");
        }

        try(FileWriter writer = new FileWriter("C:\\TestF\\originalFile.txt", false)) {
            writer.write("Java world");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            createdFile = file2.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException();
        }

        if (createdFile) {
            System.out.println("Move file is created");
        }

        try (FileReader reader = new FileReader("C:\\TestF\\originalFile.txt");
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            String line = bufferedReader.readLine();

            try (FileWriter writer = new FileWriter("C:\\TestF\\moveFile.txt")) {
                        writer.write(line);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


        if(file.delete()){
            System.out.println("Original file is deleted");
        }

        if(file2.delete()){
            System.out.println("Move file is deleted");
        }

        if(dir.delete()) {
            System.out.println("Directory with files is deleted");
        }

    }
}
