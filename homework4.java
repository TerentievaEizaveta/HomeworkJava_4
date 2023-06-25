/*
Даны два Deque, представляющие два целых числа. Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.
1) Умножьте два числа и верните произведение в виде связанного списка.
2) Сложите два числа и верните сумму в виде связанного списка. Одно или два числа могут быть отрицательными.

Даны два Deque, цифры в обратном порядке.
[3,2,1] - пример Deque
[5,4,3]- пример второго Deque
1) 123 * 345 = 42 435
Ответ всегда - связный список, в обычном порядке
[4,2,4,3,5] - пример ответа
 */

import java.util.*;
public class homework4 {
    public static void sum (Deque<Integer> d1, Deque<Integer> d2) {
        Deque <Integer> res=new ArrayDeque <Integer>();
        int temp = 0;
        while (!d1.isEmpty() || !d2.isEmpty()) { 
            int sum = temp;
            if (!d1.isEmpty()) {
                sum += d1.removeFirst();
            }
            if (!d2.isEmpty()) {
                sum += d2.removeFirst();
            }
            res.addFirst(sum % 10);
            temp = sum / 10; 
        }
        if (temp != 0) {
            res.addLast(temp);
        }
        System.out.println(res);
    }
    public static void proiz (Deque<Integer> d1, Deque<Integer> d2){
        Deque <Integer> result=new ArrayDeque <Integer>();
        int[] res = new int[d1.size() + d2.size()];
        int num1=0;
        int num2=0;
        int pr_num=0;
        Boolean flag=false;
        if ((d1.getLast()>0 && d2.getLast()>0)|| (d1.getLast()<0 && d2.getLast()<0 )) {
            flag=true;
        }
        
        for (int i = 0; i < d1.size(); i++) {
            num1= d1.removeFirst();
            int temp=0;
            for (int j = 0; j < d2.size(); j++){
                num2 = d2.removeFirst();
                pr_num = Math.abs( num1) *Math.abs( num2) + res[i + j] + temp;
                res[i + j] = pr_num % 10;
                temp = pr_num / 10;
                d2.addLast(num2);
                //System.out.println(d2);
            }
            if (temp > 0) {
                res[i + d2.size()] += temp;
            }
            d1.addLast(num1);
        }
        int i = res.length - 1;
        while (i >= 0 && res[i] == 0) {
            i--;
        }
        while (i >= 0) {
            result.addLast(res[i]);
            i--;
        }
        int num= result.getFirst();
        if (flag==false) {
            result.removeFirst();
            result.addFirst(-1*num);
        }
        System.out.println(result); 
    }
    
    public static void main(String[] args) {
        Deque <Integer> d1=new ArrayDeque <Integer>(Arrays.asList(3,2,-1));
        Deque <Integer> d2=new ArrayDeque <Integer>(Arrays.asList(6,5,-4));
        proiz(d1,d2);
        sum(d1,d2);
    }
}
