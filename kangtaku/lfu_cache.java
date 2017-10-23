class LFUCache {
  FreqNode head;
  FreqNode tail;
  ArrayList<FreqNode> freqList;


  int size, capacity;
  int maxFreq = 0;
  HashMap<Integer, Node> mp;
  public LFUCache(int capacity) {
    this.capacity = capacity;
    freqList = new ArrayList<>(capacity + 1);
    for (int i = 0; i <= 10000; i++) {
      freqList.add(new FreqNode(i));
    }
    this.size = 0;
    head = null;
    tail = null;
    mp = new HashMap<>();
  }

  public int get(int key) {
    int ans = -1;
    if (mp.containsKey(key)) {
      Node node = mp.get(key);
      ans = node.val;
      FreqNode freqNode = node.freqNode;
      int freq = freqNode.freq;

      freqNode.removeNode(node);

      FreqNode nextFreqNode = freqList.get(freq + 1);
      maxFreq = Math.max(maxFreq, freq + 1);
      nextFreqNode.addLast(node);
    }
    return ans;
  }

  public void put(int key, int value) {
    if (mp.containsKey(key)) {
      Node v = mp.get(key);
      v.val = value;
      FreqNode freqNode = v.freqNode;
      freqNode.removeNode(v);
      FreqNode nextFreqNode = freqList.get(freqNode.freq + 1);
      nextFreqNode.addLast(v);
      return;
    }

    if (size == capacity) {
      for (int i = 1; i <= this.maxFreq; i++) {
        if (freqList.get(i).size != 0) {
          FreqNode freqNode = freqList.get(i);
          Node node = freqNode.head;
          mp.remove(node.key);
          freqNode.removeNode(node);
          size--;
          break;
        }
      }
    }

    if (capacity > size) {
      FreqNode freqNode = freqList.get(1);
      maxFreq = Math.max(maxFreq, 1);
      Node node = new Node(key, value, freqNode);
      freqNode.addLast(node);
      mp.put(key, node);
      size++;
    }
  }
}

class FreqNode {
  int freq, size;
  Node head, tail;
  public FreqNode(int freq) {
    this.freq = freq;
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  public void removeNode(Node node) {
    if (size == 1) {
      head = null;
      tail = null;
    } else {
      if (node.prev == null) {
        head = node.next;
      } else {
        node.prev.next = node.next;
      }
      if (node.next == null) {
        tail = node.prev;
      } else {
        node.next.prev = node.prev;
      }
    }
    this.size--;
  }

  public void addLast(Node node) {
    if (head == null) {
      node.prev = null;
      head = node;
      tail = node;
      node.next = null;
    } else {
      node.prev = tail;
      node.next = null;
      tail.next = node;
      tail = node;
    }
    node.freqNode = this;
    this.size++;
  }
}

class Node {
  int val;
  int key;
  FreqNode freqNode;
  Node prev, next;
  public Node(int key, int val, FreqNode freqNode) {
    this.key = key;
    this.val = val;
    this.freqNode = freqNode;
  }
}
