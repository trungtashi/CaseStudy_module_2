package storage.employees;

import model.Employees;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteEmployees implements DataFileEmployees{
    private ReadAndWriteEmployees(){

    }
    private static ReadAndWriteEmployees readAndWriteEmployees;
    public  static  ReadAndWriteEmployees getInstance(){
        if (readAndWriteEmployees ==null) readAndWriteEmployees=new ReadAndWriteEmployees();
        return readAndWriteEmployees;
    }

    @Override
    public List<Employees> readFile() {
        List<Employees> employeesList  = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream("employee.tvd");
            ObjectInputStream ois= new ObjectInputStream(fis);
            Object obj = ois.readObject();
            employeesList = (List<Employees>) obj;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employeesList;
    }

    @Override
    public void writeFile(List<Employees> employeesList) {
        try {
            FileOutputStream fos= new FileOutputStream("employee.tvd");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(employeesList);
            fos.close();
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
