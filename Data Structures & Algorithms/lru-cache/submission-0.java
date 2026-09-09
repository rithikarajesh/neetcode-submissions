class LRUCache {
    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head = new Node(-1,-1);
    private Node tail = new Node(-1,-1);
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        int val = -1;
        if(map.containsKey(key))
        {
            Node node = map.get(key);
            val = node.val;
            deleteNode(node);
            addtoFront(node);
        }

        return val;

    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            deleteNode(node);
            addtoFront(node);
        }
        else{
            Node node = new Node(key,value);
            map.put(key,node);
            addtoFront(node);
        }
        if(map.size()>capacity){
            Node node = tail.prev;
            deleteNode(node);
            map.remove(node.key);
        }

    }
    //  1->2->3
    private void addtoFront(Node node){
        Node currHead = head.next;
        currHead.prev = node;
        node.next = currHead;
        node.prev = head;
        head.next = node;
    }

    private void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    
}
class Node{
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}


