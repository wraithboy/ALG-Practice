package array;

public class CircularQueue {

    int[] queue;
    int size;
    int front;
    int rear;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public void MyCircularQueue(int k) {
        queue=new int[k];
        size=0;
        int rear=-1;
        int front=-1;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {

        if(!isFull())
        {
            rear = (rear+1)%queue.length;
            queue[rear]=value;
            size++;
            return true;
        }

        return false;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (!isEmpty())
        {
            front=(front+1)%queue.length;
            size--;
            return true;
        }

        return false;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(!isEmpty())
        {
            return queue[front];
        }

        return -1;
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(!isEmpty())
        {
            return queue[rear];
        }

        return -1;
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size==0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size==queue.length;
    }

}
