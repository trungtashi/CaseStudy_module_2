package storage;

import model.Hotel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteEmployees {
    public static List<Hotel> readFile(){
        List<Hotel> employees= new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream("employees.txt");
            ObjectInputStream ois= new ObjectInputStream(fis);
            Object obj = ois.readObject();
            employees=(List<Hotel>) obj;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employees;
    }
    public static void writeFile(List<Hotel> hotels){
        try {
            FileOutputStream fos= new FileOutputStream("employees.trung");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(hotels);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
