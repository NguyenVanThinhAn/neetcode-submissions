class DynamicArray {
        private ArrayList<Integer> array;
        private int capacity = 0;
        
        public DynamicArray(int capacity) {
            array = new ArrayList<>(capacity);
            this.capacity = capacity;
        }

        public int get(int i) {
            if(i > array.size() || (i < 0)){
                return -1;
            }
            return (int)array.get(i);
        }

        public void set(int i, int n) {
            if(i >array.size() || (i < 0)){
                return;
            }
            array.set(i, n);
        }

        public void pushback(int n) {
            if(array.size() >= capacity){
                capacity *= 2;
            }
            
            array.add(n);
        }

        public int popback() {
            if(array.size() == 0){
                return 0;
            }
            return (int)array.remove(array.size() - 1);
        }

        public int getSize() {

            return array.size();

        }

        public int getCapacity() {

            return this.capacity;

        }
    }