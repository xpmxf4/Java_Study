package ch13;

import java.util.*;

public class Exercise13_8 {
    Vector words = new Vector();
    String[] data = {"태연", "유리", "윤아", "효연", "수영", "서현", "티파니", "써니", "제시카"};
    int interval = 2 * 1000;

    WordGenerator wg = new WordGenerator();

    public static void main(String[] args) {
        Exercise13_8 game = new Exercise13_8();
        game.wg.start();        // wg 쓰레드 실행

        Vector words = game.words;

        while(true){
            System.out.println(words);

            String prompt = ">>";
            System.out.print(prompt);

            Scanner s = new Scanner(System.in);
            String input = s.nextLine().trim();

            int index = words.indexOf(input);
            if(index!= -1){
                words.remove(index);
            }
        }
    }

    class WordGenerator extends Thread{
        public void run(){
            while(true) {
                String idol = data[(int)(Math.random() * data.length)];
                words.add(idol);
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                }
            }

        }   // run()
    }   // WordGenerator
}
