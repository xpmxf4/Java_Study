package ch8;

public class Exercise8_9 {
    public static void main(String[] args) throws Exception
    {
        throw new UnsupportedFuctionException(" 지원하지 않는 기능입니다 .",100);
    }

}

class UnsupportedFuctionException extends RuntimeException{
    final private int ERR_CODE;

    UnsupportedFuctionException(String msg, int num) {
        super(msg);
        ERR_CODE = num;
    }

    public int getErrorCode(){
        return ERR_CODE;
    }

    public String getMessage(){
        return "[" + ERR_CODE + "]" + super.getMessage();
    }
}