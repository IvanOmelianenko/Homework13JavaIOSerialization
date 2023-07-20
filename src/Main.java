import java.io.*;

public class Main {
    public static void main(String[] args) {

        Cat cat = new Cat("Garfield", 8, 9);
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cat.dat"))){
            oos.writeObject(cat);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cat.dat"))){
            Cat с = (Cat) ois.readObject();
            System.out.println(с);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
