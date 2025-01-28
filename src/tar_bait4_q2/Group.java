package tar_bait4_q2;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Group {
    protected LinkedList<Integer> elements;

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
        for (int element : elements) {
            if (element == x) {
                return true;
            }
        }
        return false;
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

    public class GroupIterator {
        private int currentIndex = 0;

        public boolean hasNext() {
            return currentIndex < elements.size();
        }

        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();
            return elements.get(currentIndex++);
        }
    }
}
