package queueandstack;

import java.util.ArrayDeque;
import java.util.Deque;

class ProductOfNumbers {

    Deque<Integer> queue = new ArrayDeque<>();

    public ProductOfNumbers() {

    }

    public void add(int num) {
        queue.addLast(num);
    }

    public int getProduct(int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int product = 1;
        for (int i = 0; i < k; i++) {
            int temp = queue.removeLast();
            product *= temp;
            deque.addLast(temp);
        }
        while (!deque.isEmpty()) {
            queue.addLast(deque.removeLast());
        }
        return product;
    }
}
