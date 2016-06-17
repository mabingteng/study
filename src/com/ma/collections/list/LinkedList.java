package com.ma.collections.list;

import java.util.*;  


public class LinkedList<E>  
    extends AbstractSequentialList<E>  
    implements List<E>, Deque<E>, Cloneable, java.io.Serializable  
{  
    // ����ı�ͷ����ͷ�������κ����ݡ�Entry�Ǹ����������ݽṹ��  
    private transient Entry<E> header = new Entry<E>(null, null, null);  
 
    // LinkedList��Ԫ�ظ���  
    private transient int size = 0;  
 
    // Ĭ�Ϲ��캯��������һ���յ�����  
    public LinkedList() {  
        header.next = header.previous = header;  
    }  
 
    // ���������ϡ��Ĺ��캯��:����һ�����������ϡ���LinkedList  
    public LinkedList(Collection<? extends E> c) {  
        this();  
        addAll(c);  
    }  
 
    // ��ȡLinkedList�ĵ�һ��Ԫ��  
    public E getFirst() {  
        if (size==0)  
            throw new NoSuchElementException();  
 
        // ����ı�ͷheader�в��������ݡ�  
        // ���ﷵ��header��ָ��һ���ڵ������������ݡ�  
        return header.next.element;  
    }  
 
    // ��ȡLinkedList�����һ��Ԫ��  
    public E getLast()  {  
        if (size==0)  
            throw new NoSuchElementException();  
 
        // ����LinkedList��˫����������ͷheader���������ݡ�  
        // ��������ﷵ�ر�ͷheader��ǰһ���ڵ������������ݡ�  
        return header.previous.element;  
    }  
 
    // ɾ��LinkedList�ĵ�һ��Ԫ��  
    public E removeFirst() {  
        return remove(header.next);  
    }  
 
    // ɾ��LinkedList�����һ��Ԫ��  
    public E removeLast() {  
        return remove(header.previous);  
    }  
 
    // ��Ԫ����ӵ�LinkedList����ʼλ��  
    public void addFirst(E e) {  
        addBefore(e, header.next);  
    }  
 
    // ��Ԫ����ӵ�LinkedList�Ľ���λ��  
    public void addLast(E e) {  
        addBefore(e, header);  
    }  
 
    // �ж�LinkedList�Ƿ����Ԫ��(o)  
    public boolean contains(Object o) {  
        return indexOf(o) != -1;  
    }  
 
    // ����LinkedList�Ĵ�С  
    public int size() {  
        return size;  
    }  
 
    // ��Ԫ��(E)��ӵ�LinkedList��  
    public boolean add(E e) {  
        // ���ڵ�(�ڵ�������e)��ӵ���ͷ(header)֮ǰ��  
        // �������ڵ���ӵ�˫�������ĩ�ˡ�  
        addBefore(e, header);  
        return true;  
    }  
 
    // ��LinkedList��ɾ��Ԫ��(o)  
    // ������ʼ���ң������Ԫ��(o)��ɾ����Ԫ�ز�����true��  
    // ���򣬷���false��  
    public boolean remove(Object o) {  
        if (o==null) {  
            // ��oΪnull��ɾ�����  
            for (Entry<E> e = header.next; e != header; e = e.next) {  
                if (e.element==null) {  
                    remove(e);  
                    return true;  
                }  
            }  
        } else {  
            // ��o��Ϊnull��ɾ�����  
            for (Entry<E> e = header.next; e != header; e = e.next) {  
                if (o.equals(e.element)) {  
                    remove(e);  
                    return true;  
                }  
            }  
        }  
        return false;  
    }  
 
    // ��������(c)����ӵ�LinkedList�С�  
    // ʵ���ϣ��Ǵ�˫�������ĩβ��ʼ����������(c)����ӵ�˫�������С�  
    public boolean addAll(Collection<? extends E> c) {  
        return addAll(size, c);  
    }  
 
    // ��˫�������index��ʼ����������(c)����ӵ�˫�������С�  
    public boolean addAll(int index, Collection<? extends E> c) {  
        if (index < 0 || index > size)  
            throw new IndexOutOfBoundsException("Index: "+index+  
                                                ", Size: "+size);  
        Object[] a = c.toArray();  
        // ��ȡ���ϵĳ���  
        int numNew = a.length;  
        if (numNew==0)  
            return false;  
        modCount++;  
 
        // ���á���ǰҪ����ڵ�ĺ�һ���ڵ㡱  
        Entry<E> successor = (index==size ? header : entry(index));  
        // ���á���ǰҪ����ڵ��ǰһ���ڵ㡱  
        Entry<E> predecessor = successor.previous;  
        // ������(c)ȫ������˫��������  
        for (int i=0; i<numNew; i++) {  
            Entry<E> e = new Entry<E>((E)a[i], successor, predecessor);  
            predecessor.next = e;  
            predecessor = e;  
        }  
        successor.previous = predecessor;  
 
        // ����LinkedList��ʵ�ʴ�С  
        size += numNew;  
        return true;  
    }  
 
    // ���˫������  
    public void clear() {  
        Entry<E> e = header.next;  
        // �ӱ�ͷ��ʼ��������������Ա������Ľڵ�ִ��һ�²�����  
        // (01) ����ǰһ���ڵ�Ϊnull   
        // (02) ���õ�ǰ�ڵ������Ϊnull   
        // (03) ���ú�һ���ڵ�Ϊ���µĵ�ǰ�ڵ㡱  
        while (e != header) {  
            Entry<E> next = e.next;  
            e.next = e.previous = null;  
            e.element = null;  
            e = next;  
        }  
        header.next = header.previous = header;  
        // ���ô�СΪ0  
        size = 0;  
        modCount++;  
    }  
 
    // ����LinkedListָ��λ�õ�Ԫ��  
    public E get(int index) {  
        return entry(index).element;  
    }  
 
    // ����indexλ�ö�Ӧ�Ľڵ��ֵΪelement  
    public E set(int index, E element) {  
        Entry<E> e = entry(index);  
        E oldVal = e.element;  
        e.element = element;  
        return oldVal;  
    }  
   
    // ��indexǰ��ӽڵ㣬�ҽڵ��ֵΪelement  
    public void add(int index, E element) {  
        addBefore(element, (index==size ? header : entry(index)));  
    }  
 
    // ɾ��indexλ�õĽڵ�  
    public E remove(int index) {  
        return remove(entry(index));  
    }  
 
    // ��ȡ˫��������ָ��λ�õĽڵ�  
    private Entry<E> entry(int index) {  
        if (index < 0 || index >= size)  
            throw new IndexOutOfBoundsException("Index: "+index+  
                                                ", Size: "+size);  
        Entry<E> e = header;  
        // ��ȡindex���Ľڵ㡣  
        // ��index < ˫�������ȵ�1/2,���ǰ�Ⱥ����;  
        // ���򣬴Ӻ���ǰ���ҡ�  
        if (index < (size >> 1)) {  
            for (int i = 0; i <= index; i++)  
                e = e.next;  
        } else {  
            for (int i = size; i > index; i--)  
                e = e.previous;  
        }  
        return e;  
    }  
 
    // ��ǰ�����ң����ء�ֵΪ����(o)�Ľڵ��Ӧ��������  
    // �����ھͷ���-1  
    public int indexOf(Object o) {  
        int index = 0;  
        if (o==null) {  
            for (Entry e = header.next; e != header; e = e.next) {  
                if (e.element==null)  
                    return index;  
                index++;  
            }  
        } else {  
            for (Entry e = header.next; e != header; e = e.next) {  
                if (o.equals(e.element))  
                    return index;  
                index++;  
            }  
        }  
        return -1;  
    }  
 
    // �Ӻ���ǰ���ң����ء�ֵΪ����(o)�Ľڵ��Ӧ��������  
    // �����ھͷ���-1  
    public int lastIndexOf(Object o) {  
        int index = size;  
        if (o==null) {  
            for (Entry e = header.previous; e != header; e = e.previous) {  
                index--;  
                if (e.element==null)  
                    return index;  
            }  
        } else {  
            for (Entry e = header.previous; e != header; e = e.previous) {  
                index--;  
                if (o.equals(e.element))  
                    return index;  
            }  
        }  
        return -1;  
    }  
 
    // ���ص�һ���ڵ�  
    // ��LinkedList�Ĵ�СΪ0,�򷵻�null  
    public E peek() {  
        if (size==0)  
            return null;  
        return getFirst();  
    }  
 
    // ���ص�һ���ڵ�  
    // ��LinkedList�Ĵ�СΪ0,���׳��쳣  
    public E element() {  
        return getFirst();  
    }  
 
    // ɾ�������ص�һ���ڵ�  
    // ��LinkedList�Ĵ�СΪ0,�򷵻�null  
    public E poll() {  
        if (size==0)  
            return null;  
        return removeFirst();  
    }  
 
    // ��e���˫������ĩβ  
    public boolean offer(E e) {  
        return add(e);  
    }  
 
    // ��e���˫������ͷ  
    public boolean offerFirst(E e) {  
        addFirst(e);  
        return true;  
    }  
 
    // ��e���˫������ĩβ  
    public boolean offerLast(E e) {  
        addLast(e);  
        return true;  
    }  
 
    // ���ص�һ���ڵ�  
    // ��LinkedList�Ĵ�СΪ0,�򷵻�null  
    public E peekFirst() {  
        if (size==0)  
            return null;  
        return getFirst();  
    }  
 
    // �������һ���ڵ�  
    // ��LinkedList�Ĵ�СΪ0,�򷵻�null  
    public E peekLast() {  
        if (size==0)  
            return null;  
        return getLast();  
    }  
 
    // ɾ�������ص�һ���ڵ�  
    // ��LinkedList�Ĵ�СΪ0,�򷵻�null  
    public E pollFirst() {  
        if (size==0)  
            return null;  
        return removeFirst();  
    }  
 
    // ɾ�����������һ���ڵ�  
    // ��LinkedList�Ĵ�СΪ0,�򷵻�null  
    public E pollLast() {  
        if (size==0)  
            return null;  
        return removeLast();  
    }  
 
    // ��e���뵽˫������ͷ  
    public void push(E e) {  
        addFirst(e);  
    }  
 
    // ɾ�������ص�һ���ڵ�  
    public E pop() {  
        return removeFirst();  
    }  
 
    // ��LinkedList��ʼ�����ң�ɾ����һ��ֵΪԪ��(o)�Ľڵ�  
    // ������ʼ���ң�����ڽڵ��ֵΪԪ��(o)�Ľڵ㣬��ɾ���ýڵ�  
    public boolean removeFirstOccurrence(Object o) {  
        return remove(o);  
    }  
 
    // ��LinkedListĩβ��ǰ���ң�ɾ����һ��ֵΪԪ��(o)�Ľڵ�  
    // ������ʼ���ң�����ڽڵ��ֵΪԪ��(o)�Ľڵ㣬��ɾ���ýڵ�  
    public boolean removeLastOccurrence(Object o) {  
        if (o==null) {  
            for (Entry<E> e = header.previous; e != header; e = e.previous) {  
                if (e.element==null) {  
                    remove(e);  
                    return true;  
                }  
            }  
        } else {  
            for (Entry<E> e = header.previous; e != header; e = e.previous) {  
                if (o.equals(e.element)) {  
                    remove(e);  
                    return true;  
                }  
            }  
        }  
        return false;  
    }  
 
    // ���ء�index��ĩβ��ȫ���ڵ㡱��Ӧ��ListIterator����(List������)  
    public ListIterator<E> listIterator(int index) {  
        return new ListItr(index);  
    }  
 
    // List������  
    private class ListItr implements ListIterator<E> {  
        // ��һ�η��صĽڵ�  
        private Entry<E> lastReturned = header;  
        // ��һ���ڵ�  
        private Entry<E> next;  
        // ��һ���ڵ��Ӧ������ֵ  
        private int nextIndex;  
        // �����ĸı����������ʵ��fail-fast���ơ�  
        private int expectedModCount = modCount;  
 
        // ���캯����  
        // ��indexλ�ÿ�ʼ���е���  
        ListItr(int index) {  
            // index����Ч�Դ���  
            if (index < 0 || index > size)  
                throw new IndexOutOfBoundsException("Index: "+index+ ", Size: "+size);  
            // �� ��index С�� ��˫�������ȵ�һ�롯������ӵ�һ��Ԫ�ؿ�ʼ������ң�  
            // ���򣬴����һ��Ԫ����ǰ���ҡ�  
            if (index < (size >> 1)) {  
                next = header.next;  
                for (nextIndex=0; nextIndex<index; nextIndex++)  
                    next = next.next;  
            } else {  
                next = header;  
                for (nextIndex=size; nextIndex>index; nextIndex--)  
                    next = next.previous;  
            }  
        }  
 
        // �Ƿ������һ��Ԫ��  
        public boolean hasNext() {  
            // ͨ��Ԫ�������Ƿ���ڡ�˫�������С�����ж��Ƿ�ﵽ���  
            return nextIndex != size;  
        }  
 
        // ��ȡ��һ��Ԫ��  
        public E next() {  
            checkForComodification();  
            if (nextIndex == size)  
                throw new NoSuchElementException();  
 
            lastReturned = next;  
            // nextָ���������һ��Ԫ��  
            next = next.next;  
            nextIndex++;  
            return lastReturned.element;  
        }  
 
        // �Ƿ������һ��Ԫ��  
        public boolean hasPrevious() {  
            // ͨ��Ԫ�������Ƿ����0�����ж��Ƿ�ﵽ��ͷ��  
            return nextIndex != 0;  
        }  
 
        // ��ȡ��һ��Ԫ��  
        public E previous() {  
            if (nextIndex == 0)  
            throw new NoSuchElementException();  
 
            // nextָ���������һ��Ԫ��  
            lastReturned = next = next.previous;  
            nextIndex--;  
            checkForComodification();  
            return lastReturned.element;  
        }  
 
        // ��ȡ��һ��Ԫ�ص�����  
        public int nextIndex() {  
            return nextIndex;  
        }  
 
        // ��ȡ��һ��Ԫ�ص�����  
        public int previousIndex() {  
            return nextIndex-1;  
        }  
 
        // ɾ����ǰԪ�ء�  
        // ɾ��˫�������еĵ�ǰ�ڵ�  
        public void remove() {  
            checkForComodification();  
            Entry<E> lastNext = lastReturned.next;  
            try {  
                LinkedList.this.remove(lastReturned);  
            } catch (NoSuchElementException e) {  
                throw new IllegalStateException();  
            }  
            if (next==lastReturned)  
                next = lastNext;  
            else 
                nextIndex--;  
            lastReturned = header;  
            expectedModCount++;  
        }  
 
        // ���õ�ǰ�ڵ�Ϊe  
        public void set(E e) {  
            if (lastReturned == header)  
                throw new IllegalStateException();  
            checkForComodification();  
            lastReturned.element = e;  
        }  
 
        // ��e��ӵ���ǰ�ڵ��ǰ��  
        public void add(E e) {  
            checkForComodification();  
            lastReturned = header;  
            addBefore(e, next);  
            nextIndex++;  
            expectedModCount++;  
        }  
 
        // �ж� ��modCount��expectedModCount�Ƿ���ȡ���������ʵ��fail-fast���ơ�  
        final void checkForComodification() {  
            if (modCount != expectedModCount)  
            throw new ConcurrentModificationException();  
        }  
    }  
 
    // ˫������Ľڵ�����Ӧ�����ݽṹ��  
    // ����3���֣���һ�ڵ㣬��һ�ڵ㣬��ǰ�ڵ�ֵ��  
    private static class Entry<E> {  
        // ��ǰ�ڵ���������ֵ  
        E element;  
        // ��һ���ڵ�  
        Entry<E> next;  
        // ��һ���ڵ�  
        Entry<E> previous;  
 
        /**  
         * ����ڵ�Ĺ��캯����  
         * ����˵����  
         *   element  ���� �ڵ�������������  
         *   next      ���� ��һ���ڵ�  
         *   previous ���� ��һ���ڵ�  
         */ 
        Entry(E element, Entry<E> next, Entry<E> previous) {  
            this.element = element;  
            this.next = next;  
            this.previous = previous;  
        }  
    }  
 
    // ���ڵ�(�ڵ�������e)��ӵ�entry�ڵ�֮ǰ��  
    private Entry<E> addBefore(E e, Entry<E> entry) {  
        // �½��ڵ�newEntry����newEntry���뵽�ڵ�e֮ǰ����������newEntry��������e  
        Entry<E> newEntry = new Entry<E>(e, entry, entry.previous);  
        newEntry.previous.next = newEntry;  
        newEntry.next.previous = newEntry;  
        // �޸�LinkedList��С  
        size++;  
        // �޸�LinkedList���޸�ͳ����������ʵ��fail-fast���ơ�  
        modCount++;  
        return newEntry;  
    }  
 
    // ���ڵ��������ɾ��  
    private E remove(Entry<E> e) {  
        if (e == header)  
            throw new NoSuchElementException();  
 
        E result = e.element;  
        e.previous.next = e.next;  
        e.next.previous = e.previous;  
        e.next = e.previous = null;  
        e.element = null;  
        size--;  
        modCount++;  
        return result;  
    }  
 
    // ���������  
    public Iterator<E> descendingIterator() {  
        return new DescendingIterator();  
    }  
 
    // ���������ʵ���ࡣ  
    private class DescendingIterator implements Iterator {  
        final ListItr itr = new ListItr(size());  
        // ����������Ƿ���һ��Ԫ�ء�  
        // ʵ�������ж�˫������ĵ�ǰ�ڵ��Ƿ�ﵽ��ͷ  
        public boolean hasNext() {  
            return itr.hasPrevious();  
        }  
        // �����������ȡ��һ��Ԫ�ء�  
        // ʵ�����ǻ�ȡ˫�������ǰһ���ڵ�  
        public E next() {  
            return itr.previous();  
        }  
        // ɾ����ǰ�ڵ�  
        public void remove() {  
            itr.remove();  
        }  
    }  
 
 
    // ����LinkedList��Object[]����  
    public Object[] toArray() {  
    // �½�Object[]����  
    Object[] result = new Object[size];  
        int i = 0;  
        // �����������нڵ�����ݶ���ӵ�Object[]������  
        for (Entry<E> e = header.next; e != header; e = e.next)  
            result[i++] = e.element;  
    return result;  
    }  
 
    // ����LinkedList��ģ�����顣��νģ�����飬�����Խ�T��Ϊ�������������  
    public <T> T[] toArray(T[] a) {  
        // ������a�Ĵ�С < LinkedList��Ԫ�ظ���(��ζ������a��������LinkedList��ȫ��Ԫ��)  
        // ���½�һ��T[]���飬T[]�Ĵ�СΪLinkedList��С��������T[]��ֵ��a��  
        if (a.length < size)  
            a = (T[])java.lang.reflect.Array.newInstance(  
                                a.getClass().getComponentType(), size);  
        // �����������нڵ�����ݶ���ӵ�����a��  
        int i = 0;  
        Object[] result = a;  
        for (Entry<E> e = header.next; e != header; e = e.next)  
            result[i++] = e.element;  
 
        if (a.length > size)  
            a[size] = null;  
 
        return a;  
    }  
 
 
    // ��¡����������LinkedList�Ŀ�¡����  
    public Object clone() {  
        LinkedList<E> clone = null;  
        // ��¡һ��LinkedList��¡����  
        try {  
            clone = (LinkedList<E>) super.clone();  
        } catch (CloneNotSupportedException e) {  
            throw new InternalError();  
        }  
 
        // �½�LinkedList��ͷ�ڵ�  
        clone.header = new Entry<E>(null, null, null);  
        clone.header.next = clone.header.previous = clone.header;  
        clone.size = 0;  
        clone.modCount = 0;  
 
        // �����������нڵ�����ݶ���ӵ���¡������  
        for (Entry<E> e = header.next; e != header; e = e.next)  
            clone.add(e.element);  
 
        return clone;  
    }  
 
    // java.io.Serializable��д�뺯��  
    // ��LinkedList�ġ����������е�Ԫ��ֵ����д�뵽�������  
    private void writeObject(java.io.ObjectOutputStream s)  
        throws java.io.IOException {  
        // Write out any hidden serialization magic  
        s.defaultWriteObject();  
 
        // д�롰������  
        s.writeInt(size);  
 
        // �����������нڵ�����ݶ�д�뵽�������  
        for (Entry e = header.next; e != header; e = e.next)  
            s.writeObject(e.element);  
    }  
 
    // java.io.Serializable�Ķ�ȡ����������д�뷽ʽ�������  
    // �Ƚ�LinkedList�ġ�������������Ȼ�󽫡����е�Ԫ��ֵ������  
    private void readObject(java.io.ObjectInputStream s)  
        throws java.io.IOException, ClassNotFoundException {  
        // Read in any hidden serialization magic  
        s.defaultReadObject();  
 
        // ���������ж�ȡ��������  
        int size = s.readInt();  
 
        // �½������ͷ�ڵ�  
        header = new Entry<E>(null, null, null);  
        header.next = header.previous = header;  
 
        // ���������н������е�Ԫ��ֵ���������ӵ�������  
        for (int i=0; i<size; i++)  
            addBefore((E)s.readObject(), header);  
    }

	@Override
	public E remove() {
		// TODO �Զ����ɵķ������
		return null;
	}  
 
} 