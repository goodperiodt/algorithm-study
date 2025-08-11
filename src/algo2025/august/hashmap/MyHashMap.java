package algo2025.august.hashmap;

public class MyHashMap<K, V> {
    // key-value 로 구성된 데이터를 저장할 초기 용량 정보
    private static final int INITIAL_CAPACITY = 16;
    private int size; // 현재 요소 수

    // table 이라는 배열이 있고, 배열의 각 요소는 Node<K, V> 타입의 객체(혹은 null)을 가리키고 있다.
    Node<K, V>[] table;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        // MyHashMap() initializes the object with an empty map.
        // table = (Node<K, V>) new Node[INITIAL_CAPACITY]; 제네릭 타입 배열 생성의 문제 발생
        // JVM 에서는 Node[] 라고만 알고 있고, Node<K, V>[] 라는 구체적인 타입을 런타임에 추적할 수 없다.

        // raw type Node 배열을 생성한 후 타입을 강제 캐스팅,
        // 컴파일러가 타입 안정성에 경고하므로 @SuppressWarnings("unchecked") 한다.
        table = (Node<K, V>[])new Node[INITIAL_CAPACITY];
    }

    public void put(K key, V value) {
        int hash = key.hashCode();
        // hashCode 의 값을 얻어서 객체가 존재하는지를 판별?

        // hash 값을 배열의 인덱스로 변환하기 위해?
        // hash%table.length 의 값이 음수일수도 있기에(int 의 범위가 음수, 정수, 0 이 속한다)
        int index = Math.abs(hash%table.length);

        // 역대급으로 이해안가는 코드
        /*
            java.util.HashMap 은 key - value data 를 저장할 때, 충돌(동일한 인덱스에 여러 데이터가 들어오는 경우)
            을 체이닝 방식으로 처리하고 있다. 즉, table 은 Node 라는 연결 리스트의 배열,
            배열의 각 칸은 링크드 리스트의 시작점(=head 노드)
         */
        Node<K, V> head = table[index];
        // Node<K, V> 타입 인스턴스를 참조하는 배열 table 의 index 번째 칸이 참조하는
        // 연결 리스트의 첫 번째 노드를 head 라는 변수로 참조하겠다?
        //--> table[index] 가 가리키는 Node(연결 리스트의 첫 노드)를 head 라는 변수가 참조하게 하고,
        // 거기서부터 리스트를 쭉 따라가보겠다.

        Node<K, V> current = head;

        while(current != null) {
            if(current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        Node<K, V> newNode = new Node<>(hash, key, value, head);
        table[index] = newNode;
        size++;
    }

    public V get(K key) {
        // 지금 인자로 받은 key 의 타입이 int 인데, K 타입의 key 의 hashCode() 의 값인 건가?
        // 아니면 table 의 인덱스 값인건가?
        int hash = key.hashCode();
        int index = Math.abs(hash % table.length);
        Node<K, V> head = table[index];
        Node<K, V> current = head;

        while(current != null) {
            if(current.key.equals(key))
                return current.value;
            current=current.next;
        }
        return null;
    }

    public void remove(K key) {
        int hash = key.hashCode();
        int index = Math.abs(hash % table.length);

        Node<K, V> current = table[index];

        // MyHashMap 내부의 table[index] 에는 연결 리스트가 있고,
        // 이 리스트에서 특정 키를 가진 노드를 찾아 삭제해야 한다.
        Node<K, V> prev=null;

        while(current != null) { // table[index] --> (처음에)배열의 특정 인덱스에 head 가 없지 않다면 --> 있다면
            // 배열의 특정 인덱스에 해당하는 head (즉, Node<K, V>) 의 key 의 값과 인자로 전달받은 key 의 값이 일치하다면
            if(current.key.equals(key)) {
                if(prev==null) {
                    // 당연히 처음부터 일치하다면, 처음에는 배열의 특정 인덱스에 해당하는 Node 의 주소값을 가리키는 것이니까
                    // 앞의 Node 가 없을 것이다.
                    // 앞에 Node 가 없다면,
                    // current.next 가 참조하는 Node 의 주소 값을 head 자리에 배치한다.
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }

            // table[index] 배열의 특정 요소를 prev 에 대입한다. ex. 앞 Node 가 head(Node 타입)
            prev = current;
            current = current.next;
            // current = prev.next;
        }
    }

    public int size() {
        return this.size;
    }

    static class Node<K, V> {
        int hash;
        final K key;
        V value;
        Node<K, V> next; // 다음 노드를 가리키는 참조

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }


    }



}
