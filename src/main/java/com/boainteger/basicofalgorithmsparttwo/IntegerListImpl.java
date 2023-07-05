package com.boainteger.basicofalgorithmsparttwo;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {

    private final Integer[] elements;
    private int size;

    public IntegerListImpl() {
        elements = new Integer[10];
    }

    public IntegerListImpl(int initialSize) {
        this.elements = new Integer[initialSize];
    }


    private void valueItem(Integer item) {
        if (item == null) {
            throw new ItemValueNullException();
        }
    }

    private void valueSize() {
        if (size == elements.length) {
            throw new SizeValueNullException();
        }
    }

    private void valueIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexValueNullException();
        }
    }

    @Override
    public Integer add(Integer item) {
        valueSize();
        valueItem(item);
        elements[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        valueSize();
        valueItem(item);
        valueIndex(index);
        if (index == size) {
            elements[size++] = item;
            return item;
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        valueItem(item);
        valueIndex(index);
        elements[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        valueItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new ElementNotFoundException();
        }
        return remove(index);
    }

    @Override
    public Integer remove(int index) {
        valueIndex(index);
        int item = elements[index];
        if (index != size - 1) {
            System.arraycopy(elements, index + 1, elements, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public void sort(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[i - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    @Override
    public boolean binarySearch(Integer[] arr, Integer item) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == arr[mid]) {
                return true;
            }

            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Integer item) {
        Integer[] storageCopy = toArray();
        sort(storageCopy);
        return binarySearch(storageCopy, item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index){
        valueIndex(index);
        return elements[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(elements, size);
    }
}
