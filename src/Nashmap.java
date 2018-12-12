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

    public Object get(String key) {
        int index = find(key.hashCode(), false);

        if (index >= 0) {
            return this.buckets[index].getValue();
        } else {
            return null;
        }
    }

    public boolean delete(String key) {
        int index = find(key.hashCode(), false);

        if (index >= 0) {
            this.buckets[index] = null;
            return true;
        } else {
            return false;
        }
    }

    public boolean exists(String key) {
        int index = find(key.hashCode(), false);

        if (index >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public int elements() {
        int elements = 0;

        for (int i = 0; i < this.buckets.length; i++) {
            if (this.buckets[i] != null) {
                elements++;
            }
        }

        return elements;
    }

    public boolean isEmpty() {
        return elements() == 0;
    }

    public void clear() {
        for (int i = 0; i < this.buckets.length; i++) {
            this.buckets[i] = null;
        }
    }

    public int size() {
        return buckets.length;
    }
}
