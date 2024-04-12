
package maps;

import java.util.ArrayList;

public class ChainHashMap1<K,V> extends AbstractHashMap<K,V> {
    private UnsortedTableMap<K,V>[] table;

    // New constructor to allow setting maximum load factor
    public ChainHashMap1(double maxLoad) {
        super(maxLoad);
    }

    public ChainHashMap1(double maxLoad, int cap) {
        super(maxLoad, cap);
    }

    public ChainHashMap1(double maxLoad, int cap, int p) {
        super(maxLoad, cap, p);
    }

    @Override
    @SuppressWarnings({"unchecked"})
    protected void createTable() {
        table = (UnsortedTableMap<K,V>[]) new UnsortedTableMap[capacity];
    }

    @Override
    protected V bucketGet(int h, K k)
    {
        UnsortedTableMap<K,V> bucket = table[h];
        if (bucket == null) return null;
        return bucket.get(k);
    }

    @Override
    protected V bucketPut(int h, K k, V v)
    {
        UnsortedTableMap<K,V> bucket = table[h];
        if (bucket == null)
            bucket = table[h] = new UnsortedTableMap<>();
        int oldSize = bucket.size();
        V answer = bucket.put(k,v);
        n += (bucket.size() - oldSize);   // size may have increased
        return answer;
    }

    @Override
    protected V bucketRemove(int h, K k)
    {
        UnsortedTableMap<K,V> bucket = table[h];
        if (bucket == null) return null;
        int oldSize = bucket.size();
        V answer = bucket.remove(k);
        n -= (oldSize - bucket.size());   // size may have decreased
        return answer;
    }

    @Override
    public Iterable<Entry<K,V>> entrySet()
    {
        ArrayList<Entry<K,V>> buffer = new ArrayList<>();
        for (int h=0; h < capacity; h++)
            if (table[h] != null)
                for (Entry<K,V> entry : table[h].entrySet())
                    buffer.add(entry);
        return buffer;
    }
}
