package storage.customer;

import model.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteCustomer implements DataFile{
    private ReadAndWriteCustomer(){

    }
    private static ReadAndWriteCustomer readAndWriteCustomer;
    public  static  ReadAndWriteCustomer getInstance(){
        if (readAndWriteCustomer ==null) readAndWriteCustomer=new ReadAndWriteCustomer();
        return readAndWriteCustomer;
    }

    @Override
    public List<Customer> readFile() {
        List<Customer> customerList= new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream("customer.tvd");
            ObjectInputStream ois= new ObjectInputStream(fis);
            Object obj = ois.readObject();
            customerList = (List<Customer>) obj;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public void writeFile(List<Customer> customerList) {
        try {
            FileOutputStream fos= new FileOutputStream("customer.tvd");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(customerList);
            fos.close();
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
