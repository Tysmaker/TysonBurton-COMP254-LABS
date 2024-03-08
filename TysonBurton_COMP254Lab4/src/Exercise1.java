

public class Exercise1 {

    //interface Position
    public interface Position<E>
    {

    }
    //Interface PositionList
    public interface PositionalList<E>
    {
        Position<E> first();

        Position<E> last();

        Position<E> next(Position<E> p);

        Position<E> prev(Position<E> p);

        int indexOf(Position<E> p);

    }

    public static void main(String[] args)
    {

    }
}

