public class Nashmap<T> {
    private NashmapElement[] elements;
    private int currentIndex;
    private static class NashmapElement<Type> {
        Type value;
        int key;

        NashmapElement(int key, Type value) {
            this.value = value;
            this.key = key;
        }

        Type getValue() {
            return value;
        }

        int getKey() {
            return key;
        }
    }

    public Nashmap(int size) {
        this.elements = new NashmapElement<?>[size];
        this.currentIndex = 0;
    }

    public void add(String key, Object object) {
        this.elements[currentIndex] = new NashmapElement<>(key.hashCode(), object);
        this.currentIndex++;
    }

    public Object get(String key) {
        for (int i = 0; i < currentIndex; i++) {
            if (elements[i].getKey() == key.hashCode()) {
                return elements[i].getValue();
            }
        }
        return null;
    }

    public boolean remove(String key) {
        for (int i = 0; i < currentIndex; i++) {
            if (elements[i].getKey() == key.hashCode()) {
                elements[i] = null;
                for (int j = i + 1; j < currentIndex; j++) {
                    elements[i] = elements[j];
                }
                currentIndex--;
                return true;
            }
        }
        return false;
    }

    public int size() {
        return currentIndex;
    }
}
