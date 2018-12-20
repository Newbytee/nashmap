public class Test {
    public static void main(String[] args) {
        Nashmap map = new Nashmap(10);

        System.out.println(20 % 10);

        map.put("foobkkar", "shrek");

        System.out.println(map.get("foobkkar"));
        System.out.println(map.isEmpty());
        map.delete("foobar");
        System.out.println(map.isEmpty());
        map.get("foobar");
        map.put("foobar", "zoop");
        System.out.println(map.get("foobar"));
    }
}
