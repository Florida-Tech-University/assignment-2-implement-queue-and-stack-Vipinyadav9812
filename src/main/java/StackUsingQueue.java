import java.util.Objects;

public class StackUsingQueue<E> implements StackADT<E> {
    private final QueueADT<E> q;

    public StackUsingQueue(int capacity) {
        this.q = new ArrayQueue<>(capacity);
    }

    @Override
    public int size() {
        // TODO: return q.size()
        return q.size();
    }

    @Override
    public boolean isEmpty() {
        // TODO: return q.isEmpty()
        return q.isEmpty();
    }

    @Override
    public E top() {
        // TODO: return q.first()
        return q.first();
    }

    @Override
    public void push(E e) {
        Objects.requireNonNull(e, "Null elements are not supported in this assignment.");

        // TODO:
        // 1) q.enqueue(e)
        // 2) rotate (size-1) times:
        //    q.enqueue(q.dequeue());
        // so the newest element becomes the front of the queue.
         q.enqueue(e);

        int n = q.size();
        for (int i = 0; i < n - 1; i++) {
            q.enqueue(q.dequeue());
        }    
    }

    @Override
    public E pop() {
        // TODO: return q.dequeue()
        return q.dequeue();
    }
}
