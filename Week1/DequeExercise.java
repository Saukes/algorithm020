import java.util.Deque;
import java.util.LinkedList;

public class DequeExercise {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("c");
        deque.addFirst("b");
        deque.addFirst("a");
        deque.addLast("d");
        deque.addLast("e");
        deque.addLast("f");
        System.out.println(deque);
        String peekFirst = deque.peekFirst();
        System.out.println("peekFirst: " + peekFirst);
        String peekLast = deque.peekLast();
        System.out.println("peekLast: " + peekLast);

        while (deque.size() > 0) {
            if (deque.size() % 2 == 0) {
                System.out.println("pollFirst: " + deque.pollFirst());
            } else {
                System.out.println("pollLast: " + deque.pollLast());
            }
        }
        System.out.println(deque);
    }
}
