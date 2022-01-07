package ch8;

// 프로그램을 설치하는 코드를 작성하여라.
// 프로그램을 설치할 떄는 단계가 다음과 같다.
// 1. startInstall();
// 1.1 memory 가 부족한 경우
// 1.2 Space 가 부족한 경우
// 1.3 A 가 부족한 경우
// 1.4 B 가 부족한 경우
// 2. 필요한 파일을 복사함
// 3. 필요없는 파일을 삭제함

public class ChainedExceptionEx {
    public static void main(String[] args) {
        try {
            install();
            copyFiles();
        } catch (InstallException ie) {
            System.out.println("설치오류가 발생했습니다.");
        } finally {
            deleteTempFiles();
        }
    }

    static void install() throws InstallException{
        try{
            startInstall();
        }catch (MemoryException22 | SpaceException22 | ExceptionA | ExceptionB e) {
            e.printStackTrace();
            InstallException ie = new InstallException("설치오류입니다");
            ie.initCause(e);
            throw ie;
        }
    }

    static void startInstall() throws MemoryException22, SpaceException22, ExceptionA, ExceptionB{    // 1
        if(!enoughMemory()) throw new MemoryException22("메모리가 부족함!");
        if(!enoughSpace()) throw new SpaceException22("공간이 부족함");
        if(!enoughA()) throw new ExceptionA("A 가 부족함");
        if(!enoughB()) throw new ExceptionB("B 가 부족함");

        System.out.println("런타임 에러가 발생하지 않았기에, 프로그램 설치를 시작합니다...");
    }

    static void copyFiles() {       // 2
        System.out.println("파일을 복사중입니다...");
    }

    static void deleteTempFiles() { // 3
        System.out.println("임시파일을 삭제중입니다...");
    }

    static boolean enoughMemory() { // 메모리가 충분하다는 가정
        return true;
    }

    static boolean enoughSpace() { // 공간이 부족하다는 가정
        return false;
    }

    static boolean enoughA() {
        return true;
    }

    static boolean enoughB() {
        return true;
    }
}

class InstallException extends Exception {
    InstallException(String msg){
        super(msg);
    }
}

class MemoryException22 extends Exception {
    MemoryException22(String msg){
        super(msg);
    }
}

class SpaceException22 extends Exception {
    SpaceException22(String msg) {
        super(msg);
    }
}

class ExceptionA extends Exception {
    ExceptionA(String msg) {
        super(msg);
    }
}

class ExceptionB extends Exception {
    ExceptionB(String msg) {
        super(msg);
    }
}