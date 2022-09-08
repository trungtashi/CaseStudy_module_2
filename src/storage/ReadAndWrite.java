package storage;

import model.Hotel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public static List<Hotel> readFile(){
        List<Hotel> hotelList= new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream("hotel.txt");
            ObjectInputStream ois= new ObjectInputStream(fis);
            Object obj = ois.readObject();
            hotelList=(List<Hotel>) obj;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return hotelList;
    }
    public static void writeFile(List<Hotel> hotels){
        try {
            FileOutputStream fos= new FileOutputStream("hotel.txt");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(hotels);
            fos.close();
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
