public class Nashmap {
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
        if (this.elements.length <= currentIndex) {
            NashmapElement[] elements = this.elements;
            this.elements = new NashmapElement<?>[elements.length * 2];
            System.arraycopy(elements, 0, this.elements, 0, elements.length);
        }
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

    public void resize(int size) {
        if (size > currentIndex) {
            NashmapElement[] elements = this.elements;
            this.elements = new NashmapElement<?>[size];
            System.arraycopy(elements, 0, this.elements, 0, elements.length);
        } else {
            throw new Error("Resize beyond minimum index.");
        }
    }

    public int size() {
        return currentIndex;
    }
}
