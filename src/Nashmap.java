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

    private int getHash(String key) {
        int hash = key.hashCode();

        if (hash < 0) {
            hash = hash * -1;
        }

        return hash;
    }

    // Generic method for finding the index of a key and returning it
    private int findObject(int hashedKey) {

        int i = hashedKey % this.buckets.length;

        do {
            if (this.buckets[i] != null && this.buckets[i].getKey() == hashedKey) {
                return i;
            }

            i = (i + 3) % this.buckets.length;
        } while (buckets[i] == null);

        return -1;
    }

    private int findNull(int hashedKey) {

        hashedKey = hashedKey % this.buckets.length;

        do {
            if (this.buckets[hashedKey] == null) {
                return hashedKey;
            }

            hashedKey = (hashedKey + 3) % this.buckets.length;
        } while (buckets[hashedKey] != null);

        return -1;
    }

    // Add an item to the map
    public boolean put(String key, Object object) {
        int hashedKey = getHash(key);
        int index = findNull(hashedKey);

        if (index >= 0) {
            this.buckets[index] = new Bucket<>(hashedKey, object);
            return true;
        } else {
            return false;
        }
    }

    // Returns item from the map associated with specified key
    public Object get(String key) {
        int index = findObject(getHash(key));

        if (index >= 0) {
            return this.buckets[index].getValue();
        } else {
            return null;
        }
    }

    // Delete item associated with specified key and return whether anything was deleted
    public boolean delete(String key) {
        int index = findObject(getHash(key));

        if (index >= 0) {
            this.buckets[index] = null;
            return true;
        } else {
            return false;
        }
    }

    // Return whether there is an item associated with specified key
    public boolean exists(String key) {
        int index = findObject(getHash(key));

        return index >= 0;
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
