package ch7;

public class NotePad2 {
    public static void main(String[] args) {
        TimeTime t = new TimeTime(13, 24, 35);
        System.out.println(t.getHour());
        t.setHour(24);
        System.out.println(t.getHour());
    }
}

class TimeTime{
    private int hour;
    private int min;
    private int sec;

    TimeTime(int hour, int min, int sec) {
        this.hour = hour;
        this.min = min;
        this.sec = sec;
    }
    TimeTime(){
        this(0, 0, 0);
    }

    int getHour(){
        return this.hour;
    }

    void setHour(int hour){
        if(isNotValidHour(hour)) return;
        this.hour = hour;
    }

    private boolean isNotValidHour(int hour){
        return hour < 0 || hour > 24;
    }
}