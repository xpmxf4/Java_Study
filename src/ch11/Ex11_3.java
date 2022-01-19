package ch11;

import java.util.*;
//수식 괄호 갯구 맞게 했는 지

public class Ex11_3 {
    public static void main(String[] args) {
        Stack st = new Stack();
        String expression = "((3+5*8-2))";

        System.out.println("expression = " + expression);

        final int expLth = expression.length();

        try{
            for (int i = 0; i < expLth; i++) {
                char ch = expression.charAt(i);

                if(ch == '(') st.push(ch + "");
                if(ch == ')') st.pop();
            }
            if(st.empty()){
                System.out.println("괄호가 일치합니다");
            }else{
                System.out.println("괄호가 일치하지 않습니다");
            }
        }catch(Exception e){
            System.out.println("괄호가 일치하지 않습니다.(예외처리됨)");
        }

    }
}
