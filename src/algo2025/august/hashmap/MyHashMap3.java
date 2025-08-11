package algo2025.august.hashmap;

// 해설지 참고
public class MyHashMap3 {
    /*
        - 고정 크기 배열을 버킷 배열로 선언 --> 여러 개의 연결 리스트 주소를 배열의 각 요소가 참조한다.
        - 각 버킷은 연결 리스트 형태로 키-값 쌍을 저장한다.
     */
    private static final int SIZE = 10000;
    private Node[] buckets; // Node 타입 배열 선언

    private static class Node {
        int key, value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap3() {
        buckets = new Node[SIZE];
    }

    private int getIndex(int key) {
        // int key 를 해시함수로 변환해 저장 위치를 결정 --> 저장할 버킷 위치 결정
        return key % SIZE; // SIZE 는 곧 buckets.length
    }

    public void put(int key, int value) {
        int idx = getIndex(key); // 저장할 buckets 인덱스 반환
        Node node = new Node(key, value);

        if(isNonExistHead(idx)) setHead(node);
        else setNode(node);
    }

    /* 특정 버킷의 요소(Node)가 null 이라면 true 를,
    null 이 아니라면(Node 객체를 참조하고 있다면) false 를 리턴한다. */
    private boolean isNonExistHead(int idx) {
        return buckets[idx]==null;
    }

    private void setHead(Node newNode) {
        buckets[getIndex(newNode.key)]=newNode;
    }

    private void setNode(Node newNode) {
        if (isExistNode(newNode)) setValue(newNode);
        else addNode(newNode);
    }

    private boolean isExistNode(Node newNode) {
        Node current=buckets[getIndex(newNode.key)];

        while(current != null) {
            if(current.key==newNode.key) return true;
            current=current.next;
        }
        return false;
    }

    private void setValue(Node newNode) {
        Node currentNode = getCurrentNode(newNode.key);
        currentNode.value= newNode.value;
    }

    private Node getCurrentNode(int key) {
        Node current=buckets[getIndex(key)];

        while(current != null) {
            if(current.key==key) return current;
            current=current.next;
        }
        throw new IllegalArgumentException("로직상 반드시 해당 키를 갖는 노드가 존재해야 하는데, 발견하지 못했다. key: "+key);
    }

    private void addNode(Node newNode) {
        Node lastNode = getLastNode(newNode.key);
        lastNode.next=newNode;
    }

    private Node getLastNode(int key) {
        Node current = buckets[getIndex(key)];
        Node prev = null;

        while(current != null) {
            prev = current;
            current=current.next;
        } return prev;
    }

    public int get(int key) {
        int idx = getIndex(key);
        Node current = buckets[idx];

        while(current != null) {
            if(current.key==key) {
                return current.key;
            }
            // 현재 Node 의 key 값이 인자로 전달받은 key 와 일치하지 않으면,
            current = current.next;
        }
        return -1;
    }

    public void remove(int key) {
        int idx = getIndex(key);
        Node current = buckets[idx];
        Node prev = null;

        while(current != null) {
            if(current.key==key) {
                if(prev==null) {
                    buckets[idx]=current.next;
                } else {
                    prev.next=current.next;
                }
            }
            prev = current;
            current=current.next;
        }
    }
}