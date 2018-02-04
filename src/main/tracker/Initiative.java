package tracker;

import java.util.Arrays;

public class Initiative {

    private final static int DEFAULT_SIZE = 10;

    private Character[] arr;
    private int first, last = 0;

    public Initiative() {
        arr = new Character[DEFAULT_SIZE];
    }

    public void add(Character character) {
        if(last == arr.length) {
            arr = Arrays.copyOf(arr, arr.length + DEFAULT_SIZE);
        }

        arr[last++] = character;
    }
}
