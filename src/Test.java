public class Test {
    public static void main(String[] args) {
        Nashmap<Integer> map = new Nashmap<>(2);

        map.add("foobar", "meep");
        map.add("shrek", "heck");
        map.add("mopo", "fobo");
        map.add("succ", 1);

        System.out.println(map.get("foobar"));
        System.out.println(map.size());
        map.remove("foobar");
        System.out.println(map.get("shrek"));
        System.out.println(map.size());
        System.out.println(map.get("succ"));

        System.out.println("foobar".hashCode() % 100);
    }
}
