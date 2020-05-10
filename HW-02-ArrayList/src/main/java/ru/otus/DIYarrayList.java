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
        return new ListItr();
    }

    public void sort(Comparator<? super T> c){
        Arrays.sort((T[])elements, c);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

//---------------------------------------------------------------------------------------------------

    private class Itr implements Iterator<T>{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }
    }

//---------------------------------------------------------------------------------------------------

    private class ListItr extends Itr implements ListIterator<T>{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public T previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(T e) {

        }

        @Override
        public void add(T e) {

        }
    }

//------------------------------------------------------------------------------------------------------------------

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }
}
