package ru.otus;

import java.util.*;

public class DIYarrayList<T> implements List<T> {

    private int size;
    public Object[] elements;

    public DIYarrayList() {
        elements = new Object[10];
        size = 0;
    }

    @Override
    public boolean add(T t) {
        if (size == elements.length) {
            grow();
        }
        elements[size] = t;
        size++;
        return true;
    }

    private void grow() {
        elements = Arrays.copyOf(elements, elements.length*2);
    }

    @Override
    public T set(int index, T element) {
        if(index <0 || index >= size()) {
            throw new IndexOutOfBoundsException("Недопустимый индекс");
        }
        elements[index] = element;
        return element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        return (T)elements[index];
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("The method is not implemented");
    }

    public void sort(Comparator<? super T> c){
        Arrays.sort((T[])elements, 0, size, c);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException("The method is not implemented");
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("The method is not implemented");
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("The method is not implemented");
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("The method is not implemented");
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("The method is not implemented");
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException("The method is not implemented");
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("The method is not implemented");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("The method is not implemented");
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException("The method is not implemented");
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException("The method is not implemented");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("The method is not implemented");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("The method is not implemented");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("The method is not implemented");
    }

    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException("The method is not implemented");
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("The method is not implemented");
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("The method is not implemented");
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("The method is not implemented");
    }

    @Override
    public void add(int index, T element) {
        throw new UnsupportedOperationException("The method is not implemented");
    }
}
