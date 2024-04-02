package Module3;

import java.util.Iterator;
	public interface MapInterface<K, V> extends Iterable<MapEntry1<K,V>> {
	int get(String s, String l);
	boolean isEmpty(int h);
	boolean isFull();
	int getSize();
}
