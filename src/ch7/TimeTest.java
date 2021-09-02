package ch7;

class Time{
    private int hour;
    private int minute;
    private int second;

    public void setHour(int hour){
        if(isNotValidHour(hour)) return;
        this.hour = hour;
    }

    public int getHour(){
        return hour;
    }

    private boolean isNotValidHour(int hour){   // 내부에서만 쓸 메서드라 private 로 선언해서 씀. 만약 메서드를 변경하면 테스트를 다시 해야되는데,
                                                // private 인 테스트는 그 클래스 안에서만 테스트를 하면 된다는 걸 알 수 있다.
                                                // ==> 테스트의 범위를 줄일 수 있다 !!!!!
        return hour < 0 || hour > 24;
    }
}

public class TimeTest {
    public static void main(String[] args) {
        Time t = new Time();
//        t.hour = 22;
        t.setHour(22);  //  hour 의 값을 22로 변경.
        System.out.println(t.getHour());
        t.setHour(100);
        System.out.println(t.getHour());
    }
}
