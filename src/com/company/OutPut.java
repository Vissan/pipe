package com.company;

import java.io.File;
import java.io.PrintWriter;

public class OutPut extends Filter {

    File outFile;
    public OutPut(Pipe in, File file) {
        super(in, null);
        this.outFile = file;
    }

    @Override
    protected void transform() throws Exception {
        final PrintWriter printWriter = new PrintWriter(outFile);
        String line = "";
        while ((line=in.readLine())!=null) {
            printWriter.write(line);
            printWriter.write('\n');
        }
        printWriter.flush();
        printWriter.close();
        in.closeRead();
    }
}
