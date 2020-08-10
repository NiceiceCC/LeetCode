class LRUCache {
    private class Node{
        Node pre,next;
        int val;
        Node(int v){val = v; pre = null; next = null;}
        Node(){this(-1);}
    }
    private class List{
        Node head,tail;
        int size;
        int capacity;
        List(int maxsize){
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
            size = 0;
            capacity = maxsize;
        }
        
        void pushFront(Node nd){
            if (capacity < 1)
                return;
            
            Node first = head.next;
            head.next = nd;
            nd.pre = head;
            nd.next = first;
            first.pre = nd;
            ++size;    
        }
        void erase(Node nd){
            Node pred = nd.pre;
            Node succ = nd.next;
            pred.next = succ;
            succ.pre = pred;
            --size;
        }
        
    }

    public LRUCache(int capacity) {
        list = new List(capacity);
        data = new HashMap<Integer, Pair<Integer,Node>> ();
    }
    
    public int get(int key) {
        if (data.containsKey(key)){
            Node node = data.get(key).getValue();
            list.erase(node);
            list.pushFront(node);
            return data.get(key).getKey();
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (data.containsKey(key)){
            Node node = data.get(key).getValue();
            data.put(key, new Pair<Integer,Node>(value,node));
            list.erase(node);
            list.pushFront(node);
        }
        else{
            if(list.size == list.capacity){
                data.remove(list.tail.pre.val);
                list.erase(list.tail.pre);                
            }
            Node node = new Node(key);
            list.pushFront(node);
            data.put(key, new Pair<Integer,Node>(value,node));
        }
    }
    
    private HashMap<Integer, Pair<Integer,Node>> data;
    private List list;
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */