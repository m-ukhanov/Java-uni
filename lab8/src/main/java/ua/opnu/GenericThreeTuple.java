package ua.opnu;

public class GenericThreeTuple<T,V,S> {

    private final GenericTwoTuple<T,V> tuple;
    public final S third;

    public GenericThreeTuple(T first, V second, S third) {
        this.tuple = new GenericTwoTuple<T,V>(first,second);
        this.third = third;
    }

    public T getFirst() {
        return tuple.first;
    }

    public V getSecond() {
        return tuple.second;
    }

    @Override
    public String toString() {
        return "(" + getFirst() + ", " + getSecond() + ", " + third + ")";
    }
}
