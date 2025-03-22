import java.util.*;
public class BlackRedShooter {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] enemy={"Black","Red","Red","Black","Red"};
        String[] order={"top","top","top","bottom","top"};
        Deque<String> deque=new ArrayDeque<>();
        System.out.println(Arrays.asList(enemy));
        System.out.println(Arrays.asList(order));
        for(int i=0;i<enemy.length;i++){
            deque.push(sc.next());
        }
        for(int i=0;i<enemy.length;i++){
            if(order[i].equals("top") && !enemy[i].equals(deque.pollFirst())){
                System.out.print("You Lost!");
                return;
            }
            else if(order[i].equals("bottom") && !enemy[i].equals(deque.pollLast())){
                System.out.println("You Lost!");
                return;
            }
        }
        System.out.print("You Won!");
    }
}
