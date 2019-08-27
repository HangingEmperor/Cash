package sample.Processors;

public class Pila<T> {

    private int top;
    private T[] pila;

    public Pila() {
        this.top = -1;
        this.pila = (T[]) new Object[10];
    }

    Pila(int size) {
        this.top = -1;
        this.pila = (T[]) new Object[size];
    }

    void push(T object) {
        if (!isFull()) {
            top++;
            pila[top] = object;
        }
    }

    T pop() {
        T x = null;
        if (!isEmpty()) {
            x = pila[top];
            top--;
        }
        return x;
    }

    private boolean isEmpty() {
        return top < 0;
    }

    private boolean isFull() {
        return top == pila.length - 1;
    }
}
