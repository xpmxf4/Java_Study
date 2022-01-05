package ch8;

import java.io.*;

public class ExceptionEx15 {
    public static void main(String[] args) {
        File f = createFile(args[0]);
        System.out.println(f.getName() + " 파일이 성공적으로 생성되었습니다");
    }

    static File createFile(String filename) {
        try {
            if (filename == null || filename.equals("")) {
                throw new Exception("파일이름이 유효하지 않습니다");
            }
        } catch (Exception e) {
            // filename 이 부적절한 경우, 파일 이름을 '제목없음.txt' 라고 한다.
            filename = "제목없음.txt";
        }finally {
            File f = new File(filename);
            createNewFile(f);
            return f;
        }
    }

    static void createNewFile(File f){
        try {
            f.createNewFile();
        } catch (Exception e) {

        }
    }
}
