
package imageprocessing;

import java.util.List;

public class Main{
    public static void main(String[] args) {
        List<String> tac = List.of(
                "LOAD sample.jpg",
                "GRAYSCALE",
                "RESIZE 200 200",
                "ROTATE 180",
                "SAVE result.jpg"
        );

        JITExecutor executor = new JITExecutor();
        executor.execute(tac);
    }
}