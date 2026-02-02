import java.util.Objects;

public class ArrayQueue<E> implements QueueADT<E> {
    private final E[] data;
    private int front = 0;  // index of the front element
    private int size = 0;   // number of elements in the queue

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("capacity must be > 0");
        this.data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        // TODO: return current number of elements
        return size;
    }

    @Override
    public boolean isEmpty() {
        // TODO: return true if size == 0
        return size == 0;
    }

    @Override
    public E first() {
        // TODO: if empty return null; else return data[front]
        if (isEmpty()) return null;
        return data[front];
    }

    @Override
    public void enqueue(E e) {
        Objects.requireNonNull(e, "Null elements are not supported in this assignment.");

        if (size == data.length) {
            throw new IllegalStateException("Queue is full");
        }

        int avail = (front + size) % data.length;  // rear index
        data[avail] = e;
        size++;
    }


    @Override
    public E dequeue() {
        if (isEmpty()) return null;

        E answer = data[front];
        data[front] = null;  // help GC
        front = (front + 1) % data.length;
        size--;

        return answer;
    }


    // Helpful for debugging (not graded)
    int capacity() { return data.length; }
}
