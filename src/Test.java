public class Test {
    public static void main(String[] args) {
        long test = System.nanoTime();
        Nashmap map = new Nashmap(1000000);

        for (int i = 0; i < 1000000; i++) {
            map.add("foobar" + Integer.toString(i), "meep");
            map.add("shrek" + Integer.toString(i), "heck");
            map.add("mopo" + Integer.toString(i), "fobo");
            map.add("succ" + Integer.toString(i), 1);
        }



        //System.out.println(map.get("foobar"));
        //System.out.println(map.size());
        //map.remove("foobar");
        //System.out.println(map.get("shrek"));
        //map.resize(0);
        System.out.println(map.elements());
        System.out.println(map.size());
        System.out.println(map.exists("succ999"));
        //System.out.println(map.get("succ"));

        //System.out.println("foobar".hashCode() % 100);
        System.out.println(System.nanoTime() - test);
    }
}
