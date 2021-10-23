package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Input extends Filter{

    File file;
    public Input(File file, Pipe out) {
        super(null, out);
        this.file = file;
    }

    @Override
    protected void transform() throws Exception {
        final Scanner scanner = new Scanner(file);
        String tempLine = "";
        while (scanner.hasNextLine()) {
            tempLine = scanner.nextLine();
            out.writeLine(tempLine);
        }
        scanner.close();
        out.closeWrite();
    }
}
