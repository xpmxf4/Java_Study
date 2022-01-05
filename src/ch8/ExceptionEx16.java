package ch8;

import java.io.*;

public class ExceptionEx16 {
    public static void main(String[] args) {
        try {
            File f = createFile(args[0]);
        } catch (Exception e) {
            System.out.println(e.getMessage() + " 제대로 입력이 되지 않았습니다. ");
        }
    }

    static File createFile(String fileName) throws Exception {
        if (fileName == null || fileName.equals("")) {
            throw new Exception("파일이름이 유효하지 않습니다");
        }
        File f = new File(fileName);
        f.createNewFile();
        return f;
    }
}
