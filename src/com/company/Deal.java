package com.company;

import java.io.IOException;
import java.util.ArrayList;

public class Deal extends Filter{

    //处理每一行
    ArrayList<String> wordList = new ArrayList<>();
    //处理所有的行
    ArrayList<String> lineList = new ArrayList<>();

    public Deal(Pipe in, Pipe out) {
        super(in, out);
    }

    @Override
    protected void transform() throws IOException {
        String tempLine = "";
        while ((tempLine=in.readLine())!=null) {
            AddWord(tempLine);
            deal();
            for (int i=0; i<lineList.size(); i++) {
                out.writeLine(lineList.get(i));
            }
            wordList.clear();
            lineList.clear();
        }
        in.closeRead();
        out.closeWrite();

    }

    public void AddWord(String line) throws IOException {
        String word = "";
        for (int i=0; i<line.length(); i++) {
            if (line.charAt(i)!=' ') {
                word += line.charAt(i);
            } else {
                wordList.add(word);
                word = "";
            }
        }
        if (word.length()>0)
            wordList.add(word);
    }

    public void deal() {
        int index = 0;
        if (wordList.contains("#include")) {
            index = wordList.indexOf("#include");
            wordList.set(index, "头文件替换掉啦");
        } else if (wordList.contains("//")) {
            index = wordList.indexOf("//");
            wordList.set(index, "这是注释的位置");
        }
        String line = "";
        for (String s : wordList) {
            line += s;
        }
        lineList.add(line);
    }
}
