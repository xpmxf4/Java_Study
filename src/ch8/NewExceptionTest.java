package ch8;

public class NewExceptionTest {
    public static void main(String[] args) {
        try {
            startInstall();
            copyFiles();
        } catch (SpaceException se) {
            System.out.println("에러 메시지 : " + se.getMessage());
            se.printStackTrace();
            System.out.println("공간을 확보한 후에 다시 설치하시기 바랍니다");
        } catch (MemoryException me) {
            System.out.println("에러 메시지 : " + me.getMessage());
            me.printStackTrace();
            System.gc();
            System.out.println("다시 설치를 시도하세요");
        }finally {
            deleteTempFiles();
        }
    }

    static void startInstall() throws SpaceException, MemoryException {
        if(!enoughSpace()) throw new SpaceException("설치할 공간이 부족합니다");
        if(!enoughMemory()) throw new MemoryException("메모리가 부족합니다");
    }

    static void copyFiles(){}
    static void deleteTempFiles(){}

    static boolean enoughSpace(){
        // 설치하는 데 필요한 공간이 있는지 확인하는 코드를 적는다.
        return false;
    }
    static boolean enoughMemory(){
        // 설치하는 데 필요한 메모리 공간이 있는 지 확인하는 코드를 적는다.
        return true;
    }
}   //NewExceptionTest 클래스 끝

class SpaceException extends Exception {
    SpaceException(String msg) {
        super(msg);
    }
}

class MemoryException extends Exception {
    MemoryException(String msg) {
        super(msg);
    }
}

//신기하다... 이번 문제는 생각하면서 여러 번 연습하면 좋을 듯함!
