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
            elements[i].getValue();
        }
        return null;
    }
}
