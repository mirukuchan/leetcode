package questions;

import java.util.HashMap;

public class lru_cache {

    class Node{
        public int data,key;
        public Node next, prev;
        Node(int key,int data){
            this.data = data;
            this.key = key;
            this.next = null;
            this.prev = null;
        }
        Node(){
            this.next = null;
            this.prev = null;
        }
    }

    class LRUCache {
        int capacity = 0;
        int size = 0;
        Node head, tail;
        HashMap<Integer, Node> map = new HashMap<>();
        private void insert_first(Node node){
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            size++;
        }
        private void remove(Node node){
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            node.prev = null;
            node.next = null;
            size--;
        }
            
        private void swap_first(Node node){
            remove(node);
            insert_first(node);
        }

        private Node remove_tail(){
            Node node = tail.prev;
            remove(node);
            return node;
        }

        public LRUCache(int capacity){
            this.size = 0;
            this.capacity = capacity;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key){
            Node node = map.get(key);
            if(node == null) return -1;
            swap_first(node);
            return node.data;
        }

        public void put(int key, int value){
            Node node = map.get(key);
            if(node == null){
                Node new_node = new Node(key, value);
                map.put(key, new_node);
                insert_first(new_node);
                if(size > capacity){
                    Node pop = remove_tail();
                    map.remove(pop.key);
                }
            } else {
                node.data = value;
                swap_first(node);
            }
        }

    }
}