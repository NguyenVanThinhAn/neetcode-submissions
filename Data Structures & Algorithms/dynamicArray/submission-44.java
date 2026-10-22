 class DynamicArray {
    private ArrayList<Integer> array;
    private int capacity;

    public DynamicArray(int capacity) {
        array = new ArrayList<>(capacity);
        this.capacity = capacity;
    }

    public int get(int i) {
        if (i < 0 || i >= array.size()) {
            return -1;
        }
        return array.get(i);
    }

    public void set(int i, int n) {
        if (i < 0 || i >= array.size()) {
            return;
        }
        array.set(i, n);
    }

    public void pushback(int n) {
        if (array.size() >= capacity) {
            capacity *= 2;
        }
        array.add(n);
    }

    public int popback() {
        if (array.isEmpty()) {
            return 0;
        }
        return array.remove(array.size() - 1);
    }

    public int getSize() {
        return array.size();
    }

    public int getCapacity() {
        return capacity;
    }
}