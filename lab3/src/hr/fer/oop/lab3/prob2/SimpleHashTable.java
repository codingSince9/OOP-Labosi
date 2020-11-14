package hr.fer.oop.lab3.prob2;
import java.util.Arrays;

import hr.fer.oopj.lab4.data.Obrada;
import hr.fer.oopj.lab4.data.SimpleHashtable;
import hr.fer.oopj.lab4.data.blabla;

public class SimpleHashTable<K, V> {
	private TableEntry<K,V>[] table;
	private int size;
	public static final int DEFAULT_CAPACITY = 16;
	
	@SuppressWarnings("unchecked") 
	public SimpleHashTable(int cap) {
		this.table=(TableEntry<K,V>[]) new TableEntry[nextExp(cap)];
		this.size=0;
	}
	
	public SimpleHashTable() {
		this(SimpleHashTable.DEFAULT_CAPACITY);
	}
	
	public int size() { 
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size==0;
	}
	
	private int slot(K key) {
		return Math.abs(key.hashCode()) % table.length;
	}
	
	final static int nextExp(int number) { 
		double i=0;
		
		while (Math.pow(2, i)<number)
			i++;
		
		int result=(int)Math.pow(2, i);
		return result;	
	}
	
	public V get(K key) {
		if (key==null) return null;
		int slot=slot(key);
		TableEntry<K,V> entry=this.table[slot];
		while (entry!=null ) {
			
			if (entry.key.equals(key)) 
				return entry.value;
			
			entry=entry.next;
		}
		return null;
	}
	
	public void put(K key, V value) {
		if (key==null || value==null) return;
		int slot=slot(key);
		if (table[slot]==null) 
			table[slot]=new TableEntry<K,V>(key,value);
			
		else {
			TableEntry<K,V> current = table[slot];
			while(current.key != key && current.next != null) 
				{
				current = current.next;
			}
			
			if(current.key == key) 
				current.value = value;
			
			else {
				current.next = new TableEntry<K,V>(key,value);
				this.size++;
			}
		}
	}
	
	public boolean containsKey(K key) {
		if (key==null) return false;
		int slot=slot(key);
		TableEntry<K,V> entry=this.table[slot];
		while (entry!=null) {
			
			if (entry.key.equals(key)) 
				return true;
			
			entry=entry.next;
		}
		return false;
	}
	
	public boolean containsValue(V value) {
		if (value==null) return false;
		for(TableEntry<K,V> entry:this.table) {
			while (entry!=null) {
				
				if (entry.value.equals(value)) 
					return true;
				
				entry=entry.next;
			}
			
		}
		return false;
	}
	
	public void remove(K key) {
		if (key==null) 
			return;
		
		int slot=slot(key);
		TableEntry<K,V> entry=this.table[slot];
		
		if(table[slot].key.equals(key)) { 
			table[slot] = table[slot].next;
			this.size--;
		}
		
		else {			
			while(entry.next!=null) { 
				if(entry.next.key.equals(key)) { 
					entry.next=entry.next.next;
					this.size--;
					break;
				}
			}
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("SimpleHashtable(");
		
		for(int i = 0; i < table.length; i++) {
			TableEntry<K,V> entry = table[i];
			
			if(entry != null)
				sb.append(i).append("=>").append(entry.toString()).append(";");
			
		}
		return sb.append(")").toString();
	}
	
	


	private static class TableEntry<K,V> {
		private final K key;
		private V value;
		private TableEntry<K,V> next=null;
	
		public TableEntry(K key, V value) {
			this.key=key;
			this.value=value;
		}
		
		public K getKey() {
			return this.key;
		}
		
		public V getValue() {
			return this.value;
		}
		
		public void setValue(V value) {
			this.value=value;
		}
		
	public String toString() { 
		StringBuilder sb = new StringBuilder("(").append(key.toString()).append("=>").append(value.toString()).append(")");
		
		return next == null ? sb.toString()	: sb.append("->").append(next.toString()).toString();
	}
}

	
	public void forEach(Obrada<K,V> obrada) {
		for (TableEntry<K,V> mjesto:table) {
			TableEntry<K,V> current=mjesto;
			while (current!=null) {
				obrada.obradi(current.key, current.value);
				current=current.next;
			}
		}
	}

	public static void main(String[] args) {
		SimpleHashTable<String,Integer> examMarks = new SimpleHashTable<>(2);
		SimpleHashTable<String, Integer> table = new SimpleHashTable<>();
		table.put("003657138", 5);
		table.put("003657548", 3);
		table.put("003652348", 2);
		table.put("003623465", 2);
		table.put("003656788", 4);
		table.forEach(obrada);
		
		

//		Integer kristinaGrade = examMarks.get("Kristina");
//		System.out.println("Kristina's exam grade is: " + kristinaGrade); 
//		
//		System.out.println("Number of stored pairs: " + examMarks.size()); 
//		System.out.println("toString():" + examMarks.toString());
		
//		for(int i : Arrays.asList(0, 1, 2, 3, 4, 5))
//			System.out.println("nextExpo(" + i + "):" + nextExp(i));
	
	}

}