package ru.app.project.algo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RingBuffer<E> {
    private final List<E> elements;

    private final int capacity;
    private int nextItemPosition = 0;

    public RingBuffer(int capacity) {
        this.capacity = capacity;
        this.elements = new ArrayList<>(capacity);
    }

    public RingBuffer(Collection<? extends E> coll) {
        this.capacity = coll.size();
        this.elements = new ArrayList<>(coll);
    }

    public void reset() {
        this.nextItemPosition = 0;
    }

    public int capacity() { return this.capacity; }


    public E getNext() {
        E item = elements.get(nextItemPosition);
        nextItemPosition = (nextItemPosition + 1) % capacity;

        return item;
    }

    public List<E> getElements() {
        return elements;
    }
}
