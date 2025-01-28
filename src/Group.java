import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Iterator;

public class Group implements Iterable<Integer> {
    private LinkedList<Integer> elements;

    public Group() {
        elements = new LinkedList<>();
    }

    public boolean add(int element) {
        if (!elements.contains(element)) {
            elements.add(element);
            return true;
        }
        return false;
    }

    public boolean remove(int element) {
        return elements.remove((Integer) element);
    }

    public boolean search(int element) {
        return elements.contains(element);
    }

    public boolean containsElement(int x) {
        return elements.contains(x);
    }

    public Group intersection(Group R) {
        Group result = new Group();
        for (int element : this.elements) {
            if (R.containsElement(element)) {
                result.add(element);
            }
        }
        return result;
    }

    public Group union(Group R) {
        Group result = new Group();
        for (int element : this.elements) {
            result.add(element);
        }
        for (int element : R.elements) {
            result.add(element);
        }
        return result;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new GroupIterator();
    }

    private class GroupIterator implements Iterator<Integer> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < elements.size();
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return elements.get(currentIndex++);
        }
    }
}
