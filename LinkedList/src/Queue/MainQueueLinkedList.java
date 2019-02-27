package Queue;

public class MainQueueLinkedList {
    public static void main(String[] args) {
        QueueLinkedList<String> queue = new QueueLinkedList<String>();

        String[] str = "to be or not to - be - - that - - - is".split(" ");

        for (String s : str) {
            if (!s.equals("-")) {
                queue.enqueue(s);
            } else if (!queue.isEmpty()) {
                System.out.println(queue.dequeue());
            }
        }

        System.out.println("In queue " + queue.size());
    }
}
