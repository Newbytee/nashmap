public class Test {
    public static void main(String[] args) {
        Nashmap map = new Nashmap(10);

        map.put("foobar", "shrek");

        map.get("foobar");
        System.out.println(map.isEmpty());
        map.delete("foobar");
        System.out.println(map.isEmpty());
        map.get("foobar");
    }
}
