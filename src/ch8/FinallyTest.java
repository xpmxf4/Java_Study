package ch8;

public class FinallyTest {
    public static void main(String[] args) {
        try {
            startInstall();
            copyFiles();
            deleteTempFiles();  // 중복
        } catch (Exception e) {
            e.printStackTrace();
            deleteTempFiles();  // 중복
        }
    }

    static void startInstall(){}
    static void copyFiles(){}
    static void deleteTempFiles(){}

}
