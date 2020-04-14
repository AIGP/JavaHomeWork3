package HomeWork3;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
    public static void main(String[] args) {
        //task1
        byte[] arr;
        arr=readFileInByteArr("C:\\DataLite\\1.txt", 50);
        for (int i = 0; i < arr.length; i++) {
            System.out.print((char) arr[i]);
        }
        //task2
        ArrayList<String> fileNames=new ArrayList<>();
        fileNames.add("C:\\DataLite\\1.txt");
        fileNames.add("C:\\DataLite\\2.txt");
        fileNames.add("C:\\DataLite\\3.txt");
        fileNames.add("C:\\DataLite\\4.txt");
        fileNames.add("C:\\DataLite\\5.txt");
        unionFiles(fileNames,"C:\\DataLite\\6.txt");

        //task3
        readFilePage("C:\\DataLite\\7.txt", 1800);

    }
    public static byte[] readFileInByteArr(String file_path, int arr_size){
        byte[] arr = new byte[arr_size];
        try (FileInputStream in = new FileInputStream(file_path)){
            in.read(arr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }

    public static void unionFiles(ArrayList<String> fileNames, String file_path){
        long file_length;
        File file;
        try (FileOutputStream out = new FileOutputStream(file_path)){
            for (int i = 0; i < fileNames.size(); i++) {
                file = new File(fileNames.get(i));
                file_length = file.length();
                out.write(readFileInByteArr(fileNames.get(i), (int) file_length));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFilePage(String file_path, int page_size){
        long t=System.currentTimeMillis();
        try(RandomAccessFile raf = new RandomAccessFile (file_path,"r"))
        {
            System.out.println("\n\nFile open time: "+(System.currentTimeMillis()-t));
            byte arr[]=new byte[page_size];
            int c=0;
            Scanner in = new Scanner(System.in);
            while(true) {
                System.out.print("\nВведите номер страницы. Для выхода введите 0\nНомер: ");
                c = in.nextInt();
                if (c < 1) {
                    return;
                }
                t=System.currentTimeMillis();
                raf.seek(page_size * (c - 1));
                raf.read(arr);
                for (int i = 0; i < arr.length; i++) {
                    System.out.print((char) arr[i]);
                }
                System.out.println("\n\nPage read time: "+(System.currentTimeMillis()-t));
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}
