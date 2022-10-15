package com.epam.rd.autocode.decorator;

import java.util.Iterator;
import java.util.List;

public class EvenIndexesListDecorator<T> extends AbstractDecorator<T> {
    private final List<T> list;

    public EvenIndexesListDecorator(List<T> source) {
        list = source;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException{
        return list.get(index * 2);
    }

    @Override
    public int size() {
        int actualSize = list.size();
        return actualSize % 2 == 0 ? actualSize / 2 : (actualSize / 2) + 1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index * 2 < list.size();
            }

            @Override
            public T next() {
                if(hasNext()) {
                    return get(index++);
                }
                return null;
            }
        };
    }
}
