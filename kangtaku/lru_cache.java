class LRUCache {
        LinkedList<Ele> used = new LinkedList<>();
        Map<Integer, Ele> mp = new HashMap<>();
        int capacity;
        public LRUCache(int capacity) {

            this.capacity = capacity;
        }

        public int get(int key) {
            if (mp.containsKey(key)) {
                Ele ele = mp.get(key);
                used.remove(ele);
                Ele prev = ele.prev;
                Ele next = ele.next;

                if (prev != null) {
                    prev.next = next;
                }
                if (next != null) {
                    next.prev = prev;
                }

                if (used.size() > 0) {
                    Ele last = used.getLast();
                    last.next = ele;
                    ele.prev = last;
                }
                ele.next = null;
                used.addLast(ele);

                return ele.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (mp.containsKey(key)) {
                Ele ele = mp.get(key);
                Ele prev = ele.prev;
                Ele next = ele.next;
                used.remove(ele);

                if (prev != null) {
                    prev.next = next;
                }
                if (next != null) {
                    next.prev = prev;
                }

                if (used.size() > 0) {
                    Ele last = used.getLast();
                    last.next = ele;
                    ele.prev = last;
                }
                ele.next = null;
                ele.value = value;
                used.addLast(ele);
            } else {
                if (mp.size() == capacity) {
                    Ele removingEle = used.getFirst();
                    mp.remove(removingEle.key);
                    used.removeFirst();
                    if (used.size() > 0) {
                        used.getFirst().prev = null;
                    }

                    Ele ele = new Ele();
                    ele.key = key;
                    ele.value = value;
                    if (used.size() > 0) {
                        ele.prev = used.getLast();
                    }
                    ele.next = null;
                    used.addLast(ele);
                    mp.put(key, ele);
                } else {
                    Ele ele = new Ele();
                    ele.key = key;
                    ele.value = value;
                    if (used.size() > 0) {
                        Ele lastEle = used.getLast();
                        lastEle.next = ele;
                        ele.prev = lastEle;
                        ele.next = null;
                    }
                    mp.put(key, ele);
                    used.addLast(ele);
                }
            }
        }
    }

    class Ele {
        int key;
        int value;
        Ele prev;
        Ele next;
    }
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
