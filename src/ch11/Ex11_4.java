package ch11;

import java.util.*;

//최근 5개의 명령어 보여주기
public class Ex11_4 {
    static final int MAX_SIZE = 5;
    static Queue q = new LinkedList();

    public static void main(String[] args) {
        while (true) {
            System.out.print(">>");
            try{
                Scanner s = new Scanner(System.in);
                String input = s.nextLine().trim();

                if("".equals(input)) continue;
                else if(input.equalsIgnoreCase("q"))System.exit(0);
                else if(input.equalsIgnoreCase("help")){
                    System.out.println(" help - 도움말을 보여줍니다");
                    System.out.println(" q 또는 Q - 프로그램을 종료합니다");
                    System.out.println(" history - 최근에 입력한 명령어 " + (MAX_SIZE+1) + "를 보여줍니다");
                }
                else if(input.equalsIgnoreCase("history")){
                    save(input);
                    final int size = q.size();
                    LinkedList ll = (LinkedList) q;
                    for(int i = 0 ; i < size ; i ++){
                        System.out.println((i+1) + " : " + ll.get(i));
                    }
                }
                else{
                    save(input);
                }
            }catch(Exception e){
                System.out.println("예외가 발생했습니다.");
            }
        }
    }

    static void save(String s){
        if(!"".equals(s))   // s 가 null 로 들어오면 s.equals("") 시에 NullPointerException 발생함.
                            // 그래서 이런 방법으로 해준거임. 개신기함.
            q.offer(s);

        if (q.size() > MAX_SIZE) {
            q.poll();
        }
    }
}
