package Week_02.hash;

/**
 * 如何设计hash表
 * 1.设计好的hash函数
 * 2.定义好装载因子的阈值，动态扩容机制.
 * 3.选择合适的散列冲突解决方案(链表法,开发寻址法)
 * @param <K>
 * @param <V>
 */
public class HashTable<K,V> {
    /**
     * 散列表默认长度
     */
    private static final int DEFAULT_INITAL_CAPACITY = 8;
    /**
     * 装载因子
     */
    private static final float LOAD_FACTOR = 0.75f;
    /**
     * 初始化散列数组
     */
    private Entry<K,V>[] table;
    /**
     * 实际元素数量
     */
    private int size = 0;
    /**
     * 散列表索引数量
     */
    private int use = 0;

    public HashTable(Entry<K, V>[] table) {
        this.table = (Entry<K, V>[]) new Entry[DEFAULT_INITAL_CAPACITY];
    }

    /**
     * 新增
     * @param key
     * @param value
     */
    public void put(K key,V value){
        int index = hash(key);
        /**
         * 根据hahs值获取数组的元素
         * 如果元素是null则创建链表头节点
         * 将头节点设置给下标值为，hash值的位置
         */
        if(table[index] == null){
            table[index] = new Entry<K, V>(null,null,null);
        }
        /**
         * 再根据hahs值从数组获取头节点
         */
        Entry<K, V> tmp = table[index];
        /**
         * 如果头节点的后继节点为null
         * 则将新的节点赋值给 后继节点
         */
        if(tmp.next == null){
            tmp.next = new Entry<K, V>(key,value,null);
            //元素个数加一
            size++;
            //索引数量加一
            use++;
            //动态扩容
            /**
             * 这里计算的是元素的个数
             * 负载因子 = 元素个数 / 散列表长度
             */
            if(use>= table.length * LOAD_FACTOR ){
                resize();
            }
            //解决散列冲突
        }else {
            //1.检查链表中是否存在key相同的节点，有则覆盖value
            do{
                //（head是null的）先获取下一个节点
                tmp = tmp.next;
                //key相同覆盖旧的数据
                if(tmp.key  == key){
                    tmp.value = value;
                    return;
                }
            }while (tmp.next!=null);
            //2.将新的节点添加到哨兵节点的后面。
            Entry<K,V> temp = table[index].next;
            //（冲突节点）新节点变成哨兵的下一个节点。
            table[index].next = new Entry<K, V>(key,value,temp);
            size++;
        }
    }

    /**
     * 删除
     * @param key
     */
    public void remove(K key){
        int index = hash(key);
        Entry<K, V> kvEntry = table[index];
        if(kvEntry==null || kvEntry.next == null){
            return;
        }
        Entry pre;
        Entry<K, V> kvEntry1 = table[index];
        do {
            //获取头节点 （head节点一般为null）
            pre = kvEntry1;
            kvEntry1 = kvEntry1.next;
            if(key == kvEntry1.key){
                pre.next = kvEntry1.next;
                size--;
                if(kvEntry1.next == null){
                    use--;
                }
                return;
            }
        }while (kvEntry1.next!=null);
    }
    public V get(K key){
        int index = hash(key);
        if(table[index] == null || table[index].next ==null){
            return null;
        }
        Entry<K, V> kvEntry = table[index];
        while (kvEntry.next!=null){
            kvEntry = kvEntry.next;
            if(kvEntry.key==key){
                return kvEntry.value;
            }
        }
        return null;
    }

    private void resize() {
        //旧的散列
        Entry<K,V>[] oldTable = table;
        //新的散列
        table = (Entry<K, V>[]) new Entry[table.length *2];
        use = 0;
        for(int i = 0;i<oldTable.length;i++){
            if(oldTable[i] == null || oldTable[i].next == null){
                continue;
            }
            Entry<K,V> e = oldTable[i];
            while (e.next!=null){
                e = e.next;
                int index = hash(e.key);
                if(table[index] == null){
                    use++;
                    //创建头节点
                    table[index] = new Entry<K, V>(null,null,null);
                }
                table[index].next = new Entry<K, V>(e.key,e.value,table[index].next);
            }
        }
    }

    private int hash(Object key){
        int h;
        return (key == null)?0:((h=key.hashCode())^(h>>>16))%table.length;

    }



    private class Entry<K,V>{
        K key;
        V value;
        Entry<K,V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
