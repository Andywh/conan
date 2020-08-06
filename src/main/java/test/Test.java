package test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ai Lun on 2020-08-06.
 */
public class Test {

    public static void main(String[] args) {
        Executor executor = new Executor() {
            @Override
            public void run() {
                System.out.println("run");
            }
        };
    }

    private void testRun(Executor executor) {
        executor.run();
    }
}
