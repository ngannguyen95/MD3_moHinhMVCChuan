package rikkeiacademy.config;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Config <T>{
    public static Scanner scanner(){
        Scanner scanner=new Scanner(System.in);
        return scanner;
    }
    public static final String PATH_CATEGORY="C:\\Users\\Admin\\Desktop\\rikkei_data\\Java\\A.Test\\hoHinhMVC\\src\\rikkeiacademy\\database\\category.txt";
public static final String PATH_PRODUCT="C:\\Users\\Admin\\Desktop\\rikkei_data\\Java\\A.Test\\hoHinhMVC\\src\\rikkeiacademy\\database\\product.txt";
    // phương thức đọc file
    public List<T> readFromFile(String pathFile){
        List<T> tlist=new ArrayList<>();
        try {
            FileInputStream fis=new FileInputStream(pathFile);
            ObjectInputStream ois=new ObjectInputStream(fis);
            tlist=(List<T>) ois.readObject();
            fis.close();
            ois.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found!!");
        }catch (IOException e1){
            System.err.println("IOE Exception ");
        }catch (ClassNotFoundException c){
            System.err.println("Class not found Exception");
        }
        return tlist;
    }

    // phương thức ghi file
    public void writeToFile(String pathFile,List<T> list){
        try {
            FileOutputStream fos=new FileOutputStream(pathFile);
            ObjectOutputStream  oos=new ObjectOutputStream(fos);
            oos.writeObject(list);
            fos.close();
            oos.close();

        }catch (FileNotFoundException f){
            System.err.println("File not Found Exception");
        }catch (IOException i){
            System.err.println("IOException");
        }
    }

}
