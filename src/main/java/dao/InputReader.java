package dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputReader {
    private BufferedReader inputReader;
    protected static FileReader readerPath(String path) {
        FileReader fr = null;
        try {
            fr = new FileReader(path);
        } catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        return fr;
    }

    public InputReader() {
        System.out.println("LEIENDO DATOS...");
        inputReader = new BufferedReader(InputReader.readerPath("files/entrada.txt"));
    }
    public String readLine() {
        String str = null;
        try {
            String aux;
            if((aux = inputReader.readLine()) != null) str = aux;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return str;
    }

    public void close() {
        try {
            inputReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
