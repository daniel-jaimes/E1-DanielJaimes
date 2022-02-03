package dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputWriter {
    private BufferedWriter outputWriter;
    protected static FileWriter writerPath(String path) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(path);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return fw;
    }
    public OutputWriter() {
        System.out.println("ESCRIBIENDO DATOS...");
        outputWriter = new BufferedWriter(OutputWriter.writerPath("files/salida1.txt"));
    }
    public void writeLine(String line){
        try {
            outputWriter.write(line + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void close() {
        try {
            outputWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
