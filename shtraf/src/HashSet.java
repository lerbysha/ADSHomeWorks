import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 *
 * @author Kseniia
 * @param <T>
 */
public class HashSet<T> implements Set<T>{
    private final int DEFAULT_INITIAL_CAPACITY = 16;
//private final float DEFAULT_LOAD_FACTOR = 0.75f;

    private T[] data;

    public HashSet(){
        data = (T[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public HashSet(Collection<? extends T> c){
        addAll(c);

    }



    public HashSet(int initialCapacity){
        data = (T[]) new Object[initialCapacity];
    }
    @Override
    public int size() {
        return data.length;
    }

    @Override
    public boolean isEmpty() {
        return data.length==0;
    }

    @Override
    public boolean contains(Object o) {
        for(Object t:data){
            if(t.equals(o)){
                return true;
            }
        }
        return false;
    }




    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int count = data.length;
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < count;
            }

            @Override
            public T next() {
                if (index < count) {
                    return data[index++];
                } else {
                    throw new NoSuchElementException("No such element.");
                }
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Cannot remove item from array.");
            }
        }




        @Override
        public boolean add(T e) {
            if (data[e.hashCode()]!=null){
                if(data[e.hashCode()].equals(e)){
                    return false;
                }
            }
            else{
                data[e.hashCode()]=e;
                return true;
            }
            return false;
        }

        @Override
        public boolean remove(Object o) {
            if (data[o.hashCode()].equals(o)){
                data[o.hashCode()]=null;
                return true;
            }
            else{
                return false;
            }
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            for(Object t:c.toArray()){
                if(data[t.hashCode()].equals(t)){

                }else{
                    return false;
                }
            }
            return true;
        }

        @Override
        public boolean addAll(Collection<? extends T> c) {
            for(Object t:c.toArray()){
                add((T) t);

            }
            return true;
        }



        @Override
        public boolean removeAll(Collection<?> c) {
            for(Object x:c.toArray()){
                remove(x);
            }
            return true;
        }

        @Override
        public void clear() {
            for(T x:data){
                x=null;
            }
        }

        @Override
        public Object[] toArray() {
            return data;
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return (T[]) data;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }



    }