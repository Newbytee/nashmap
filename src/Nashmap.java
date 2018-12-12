public class Nashmap {
    private Bucket[] buckets;
    private static class Bucket<Type> {
        Type value;
        int key;

        Bucket(int key, Type value) {
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
        this.buckets = new Bucket<?>[size];
    }

    // Generic method for finding the index of a key and returning it
    private int find(int hashedKey, boolean findNull) {
        int index, i = 0, cycles = 0;

        do {
            index = (this.buckets.length % hashedKey) + i;

            while (index >= this.buckets.length) {
                index -= this.buckets.length;
            }

            if (findNull) {
                if (this.buckets[index] == null) {
                    return index;
                }
            } else {
                if (this.buckets[index] != null && this.buckets[index].getKey() == hashedKey) {
                    return index;
                }
            }

            i += 3;
            cycles++;
        } while (this.buckets[index] == null && cycles < buckets.length);

        return -1;
    }

    // Add an item to the map
    public boolean put(String key, Object object) {
        int hashedKey = key.hashCode();
        int index = find(hashedKey, true);

        if (index >= 0) {
            this.buckets[index] = new Bucket<>(hashedKey, object);
            return true;
        } else {
            return false;
        }
    }

    // Returns item from the map associated with specified key
    public Object get(String key) {
        int index = find(key.hashCode(), false);

        if (index >= 0) {
            return this.buckets[index].getValue();
        } else {
            return null;
        }
    }

    // Delete item associated with specified key and return whether anything was deleted
    public boolean delete(String key) {
        int index = find(key.hashCode(), false);

        if (index >= 0) {
            this.buckets[index] = null;
            return true;
        } else {
            return false;
        }
    }

    // Return whether there is an item associated with specified key
    public boolean exists(String key) {
        int index = find(key.hashCode(), false);

        if (index >= 0) {
            return true;
        } else {
            return false;
        }
    }

    // Return the amount of elements with a value (that aren't null) in the map
    public int elements() {
        int elements = 0;

        for (int i = 0; i < this.buckets.length; i++) {
            if (this.buckets[i] != null) {
                elements++;
            }
        }

        return elements;
    }

    // Returns a boolean specifying whether the map has any elements with a value (in other words, aren't null)
    public boolean isEmpty() {
        return elements() == 0;
    }

    // Sets all elements in the map to null
    public void clear() {
        for (int i = 0; i < this.buckets.length; i++) {
            this.buckets[i] = null;
        }
    }

    // Returns the size of the internal array
    public int size() {
        return this.buckets.length;
    }
}
