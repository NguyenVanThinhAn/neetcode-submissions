 class DynamicArray {
        private int[] array;
        private int size = 0;
        private int capacity = 0;
        
        public DynamicArray(int capacity) {
            array = new int[capacity];
            this.capacity = capacity;
        }

        public int get(int i) {
            if(i >(size - 1) || (i < 0)){
                return -1;
            }
            return array[i];
        }

        public void set(int i, int n) {
            if(i >(size - 1) || (i < 0)){
                return;
            }
            array[i] = n;
        }

        public void pushback(int n) {
            if(size >= capacity){
                resize(capacity * 2);
            }
            
            array[size] = n;
            size += 1;
        }

        public int popback() {
            if(size == 0){
                return 0;
            }
            size--;
            return array[size];
        }

        private void resize(int size) {
            //size == capacity ||
            if( size < 0){
                return;
            }
            
            int[] tempArray = new int[size];
            int max = this.size;
            if(max > size){
                max = size;
            }
            for(int i = 0; i < max; i++){
                tempArray[i] =  array[i];
            }
            array = tempArray;
            capacity = size;
        }

        public int getSize() {

            return this.size;

        }

        public int getCapacity() {

            return this.capacity;

        }
    }