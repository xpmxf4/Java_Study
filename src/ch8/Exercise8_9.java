package ch8;

public class Exercise8_9 {
    public static void main(String[] args) throws Exception
    {
        throw new UnsupportedFuctionException("지원하지 않는 기능입니다.",100);
    }
}

class UnsupportedFuctionException extends RuntimeException {
    final private int ERR_CODE;

    public int getErrorCode(){
        return ERR_CODE;
    }

    public String getMessage(){
        return super.getMessage();
    }

    UnsupportedFuctionException(String msg, int err_code){
        super("["+err_code+"]"+msg);
        ERR_CODE = err_code;
    }
}