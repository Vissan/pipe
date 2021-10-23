package com.company;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Pipe {

    public Scanner reader;
    public PrintWriter writer;

    public Pipe() {
        final PipedReader pr = new PipedReader();
        final PipedWriter pw = new PipedWriter();

        try {
            pr.connect(pw);
        } catch (IOException e) {
            e.printStackTrace();
        }

        reader = new Scanner(pr);
        writer = new PrintWriter(pw);
    }

    public void writeLine(String line) throws IOException {
        writer.println(line);
    }

    public String readLine() throws IOException {
        if (reader.hasNextLine()) {
            return reader.nextLine();
        }
        return null;
    }

    public void closeRead() throws IOException {
        reader.close();
    }

    public void closeWrite() throws IOException {
        writer.flush();
        writer.close();
    }
}
