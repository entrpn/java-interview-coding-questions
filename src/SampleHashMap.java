package com.example.collections;

import java.util.Map;

public class SampleHashMap<K,V> {
	
	static final int DEFAULT_CAPACITY = 16;
	
	static final float DEFAULT_LOAD_FACTOR = 0.75f;
	
	int threshold;
	
	transient Entry[] table;
	
	int size = 0;
	
	public SampleHashMap(){
		table = new Entry[DEFAULT_CAPACITY];
		size = table.length;
		
		threshold = (int)(DEFAULT_CAPACITY * DEFAULT_LOAD_FACTOR);
	}
	
	static int hash(int h){
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
	}
	
	private int indexFor(int h, int length){
		return h & (length-1);
	}
	
	private V putForNullKey(V value){
		Entry<K,V> entry = table[0];
		V prevValue = null;
		if (entry != null){
			prevValue = entry.value;
		}
		table[0] = new Entry<K,V>(0,null,value,null);
		return prevValue;
	}
	
	public V put(K key, V value){
		if (key == null){
			return putForNullKey(value);
		}
		int hash = hash(key.hashCode());
		int index = indexFor(hash,table.length);
		for (Entry e = table[index]; e != null ; e = e.next){
			if (e.hash == hash && (e.key == key || e.key.equals(key))){
				V oldVal = (V) e.value;
				e.value = value;
				return oldVal;
			}
		}
		
		addEntry(hash,key,value,index);
		return null;
	}
	
	public Entry remove(K key){
		
		Entry retval = null;
		
		if (key == null){
			Entry e = table[0];
			if (e != null){
				retval = e;
			}
			table[0] = null;
			size--;
		} else{
			
			int hash = hash(key.hashCode());
			int index = indexFor(hash,table.length);
			Entry e = table[index];
			Entry prevEntry = e;
			while (e != null){
				Entry next = e.next;
				if (e.hash == hash && (e.key == key || e.key.equals(key))){
					retval = e;
					size--;
					if (prevEntry == e){
						table[index] = next;
					} else{
						prevEntry.next = next;
					}
					break;
				}
				prevEntry = e;
				e = next;
			}
		}
		
		return retval;
	}
	
	public V get(K key){
		if (key == null){
			Entry e = table[0];
			if (e != null){
				return (V) e.value;
			}
			return null;
		}
		
		int hash = hash(key.hashCode());
		for (Entry e = table[indexFor(hash, table.length)]; e != null; e = e.next){
			if (e.hash == hash && (e.key == key || e.equals(key))){
				return (V) e.value;
			}
		}
		return null;
	}
	
	private void addEntry(int hash, K key, V value, int bucketIndex){
		Entry<K,V> e = table[bucketIndex];
		table[bucketIndex] = new Entry(hash,key,value,e);
		if (size++ >= threshold){
			resize(2*table.length);
		}
		
	}
	
	private void resize(int newLength){
		Entry[] temp = new Entry[newLength];
		System.arraycopy(table, 0, temp, 0, table.length);
		table = temp;
		threshold = (int)(newLength * DEFAULT_LOAD_FACTOR);
	}
	
	private static class Entry<K,V> implements Map.Entry<K,V> {
	     private K key;
	     private int hash;
	     private V value;
	     private Entry<K,V> next;

		public Entry(int hash, K key, V value, Entry<K,V> next){
	    	 this.hash = hash;
	    	 this.key = key;
	    	 this.value = value;
	    	 this.next = next;
	     }
	     
		@Override
		public K getKey() {
			return key;
		}
		@Override
		public V getValue() {
			return value;
		}
		@Override
		public V setValue(V value) {
			this.value = value;
			return this.value;
		}
	}

}
