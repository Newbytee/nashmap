public class Test {
    public static void main(String[] args) {
        Nashmap map = new Nashmap(10);

        map.put("foobar", "shrek");

        System.out.println(map.get("foobar"));
        System.out.println(map.delete("foobar"));
        System.out.println(map.get("foobar"));
    }
}
