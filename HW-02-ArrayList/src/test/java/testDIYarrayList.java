import ru.otus.DIYarrayList;

import java.util.Collections;
import java.util.List;

public class testDIYarrayList {
    public static void test() {
        List<String> dfs = new DIYarrayList<>();
        dfs.add("First");
        dfs.add("Second");
        dfs.set(1, "Third");
        Collections.addAll(dfs, "Four", "Five", "Six", "Seven", "8", "9", "10", "12");
        dfs.add("11");
        for(int i=0; i<dfs.size(); i++) {
            System.out.println(dfs.get(i));
        }
    }
}
