package ch7;

class Time{
    private int hour;
    private int minute;
    private int second;

    public void setHour(int hour){
        if (isNotValidHour(hour)) return;
        this.hour = hour;
    }

    public int getHour(){
        return this.hour;
    }

    //private boolean isValidHour(int hour){
    //    return (hour >= 0 && hour <= 24);
    //}

    private boolean isNotValidHour(int hour){
        return hour < 0 || hour > 24;
    }
}

public class TimeTest {
    public static void main(String[] args) {
        Time t = new Time();

        t.setHour(22);
        System.out.println(t.getHour());
        t.setHour(28);
        System.out.println(t.getHour());
    }
}
