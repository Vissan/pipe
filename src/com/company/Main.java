package com.company;

import java.io.File;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        File in = new File("E:\\TestUse\\in.txt");
        File out = new File("E:\\TestUse\\out.txt");

        final Scanner file_in = new Scanner(in);
        final Scanner file_out = new Scanner(out);

        /**
         * 仅需要两个管道和两个过滤器
         */
        Pipe in_de = new Pipe();
        Pipe de_out = new Pipe();

        Input input = new Input(in, in_de);
        Deal deal = new Deal(in_de, de_out);
        OutPut outPut = new OutPut(de_out, out);

        input.transform();
        deal.transform();
        outPut.transform();

        System.out.println("读入的文件");
        while (file_in.hasNextLine()) {
            System.out.println(file_in.nextLine());
        }

        System.out.println("输出的文件");
        while (file_out.hasNextLine()) {
            System.out.println(file_out.nextLine());
        }

        file_in.close();
        file_out.close();
    }
}
