package ch8;

public class ChainedExceptionEx {
    public static void main(String[] args) {
        try{
            install();
        }catch (InstallException22 ie){
            System.out.println("에러 메세지 : " + ie.getMessage());
            ie.printStackTrace();
        }
    }

    static void install() throws InstallException22{
        try {
            startInstall();
            copyFiles();
        } catch (SpaceException22 | MemoryException22 se) {
            InstallException22 ie = new InstallException22("설치 오류가 발생하였습니다.");
            ie.initCause(se);
            throw ie;
        } finally {
            deleteTempFiles();
        }
    }

    static void startInstall() throws SpaceException22, MemoryException22{
        if(!enoughSpace()){
            throw new SpaceException22("공간이 부족합니다");
        }
        if(!enoughMemory()){
            throw new MemoryException22("메모리가 부족합니다");
        }
        System.out.println("설치를 시작합니다...");
    }
    static void copyFiles(){
        System.out.println("설치에 필요한 파일을 복사합니다...");
    }
    static void deleteTempFiles(){
        System.out.println("임시 파일을 삭제합니다...");
    }

    static boolean enoughSpace(){
        // 공간이 충분한지 확인하는 코드...
        return true;    // 공간이 충분하다고 가정
    }

    static boolean enoughMemory(){
        // 메모리가 충분한지 확인하는 코드...
        return false;    // 메모리가 충분하다고 가정
    }
}

class MemoryException22 extends Exception{
    MemoryException22(String msg) {
        super(msg);
    }
}

class SpaceException22 extends Exception{
    SpaceException22(String msg) {
        super(msg);
    }
}

class InstallException22 extends Exception{
    InstallException22(String msg) {
        super(msg);
    }
}