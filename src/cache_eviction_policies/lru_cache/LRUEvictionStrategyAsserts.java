public class LRUEvictionStrategyAsserts {

    public static void main(String[] args) {
        new LRUEvictionStrategyAsserts().testStrategy();
    }

    public void testStrategy() {
        
        LRUEvictionStrategy lrucache = new LRUEvictionStrategy(4);
        System.out.println("Start");
        assert lrucache.getNextEviction() == null;
        assert lrucache.size() == 0;
        assert lrucache.get("a").equals("miss");
        System.out.println("pass!");

        // cache status: ["a", null, null, null]
        System.out.println("Start");
        assert lrucache.getNextEviction() == null;
        assert lrucache.size() == 1;
        assert lrucache.get("a").equals("hit");
        assert lrucache.size() == 1;
        System.out.println("pass!");

        System.out.println("Start");
        assert lrucache.get("b").equals("miss");
        assert lrucache.getNextEviction() == null;
        assert lrucache.get("c").equals("miss");
        assert lrucache.get("d").equals("miss");
        System.out.println("pass!");

        // cache status: ["a", "b", "c", "d"]
        System.out.println("Start");
        assert lrucache.getNextEviction().equals("a");
        assert lrucache.get("b").equals("hit");
        System.out.println("pass!");
        // cache status: ["a", "c", "d", "b"]
        System.out.println("Start");
        assert lrucache.getNextEviction().equals("a");
        assert lrucache.get("a").equals("hit");
        System.out.println("pass!");
        // cache status: ["c", "d", "b", "a"]

        System.out.println("Start");
        assert lrucache.get("e").equals("miss");
        System.out.println("pass!");
        // cache status: ["d", "b", "a", "e"]

        System.out.println("Start");
        assert lrucache.getNextEviction().equals("d");
        assert lrucache.get("c").equals("miss");
        System.out.println("pass!");
        // cache status: ["b", "a", "e", "c"]

        System.out.println("Start");
        assert lrucache.getNextEviction().equals("b");
        assert lrucache.get("e").equals("hit");
        // cache status: ["b", "a", "c", "e"]
        assert lrucache.getNextEviction().equals("b");

        assert lrucache.get("x").equals("miss");
        System.out.println("pass!");
        // cache status: ["a", "c", "e", "x"]

        System.out.println("Start");
        assert lrucache.get("y").equals("miss");
        System.out.println("pass!");
        // cache status: ["c", "e", "x", "y"]

        System.out.println("Start");
        assert lrucache.get("z").equals("miss");
        System.out.println("pass!");
        // cache status: ["e", "x", "y", "z"]

        System.out.println("Start");
        assert lrucache.getNextEviction().equals("e");
        assert lrucache.get("w").equals("miss");
        System.out.println("pass!");
        // cache status: ["x", "y", "z", "w"]

        System.out.println("Start");
        assert lrucache.size() == 4;
        assert lrucache.getNextEviction().equals("x");    
        System.out.println("pass!");
    }
}
