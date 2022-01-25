package advancedstreams;

import java.util.NoSuchElementException;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CubeSupplier implements Supplier<Integer> {

    private int num = 1;

    @Override
    public Integer get() {
        Integer res = num * num * num;
        if (res < 0) {
            throw new NoSuchElementException();
        } else {
            num += 1;
            return res;
        }
    }

    public static Stream<Integer> cubeStream() {
        CubeSupplier cubeSupplier = new CubeSupplier();
        Stream<Integer> stream = Stream.generate(cubeSupplier::get);
        return stream;
    }

    public static Stream<Integer> boundedCubeStream(int start, int end) {
        Stream<Integer> originalStream = cubeStream();
        return originalStream.limit(end).skip(start);
    }

    public static Stream<Integer> palindromicCubes(int start, int end) {
        Stream<Integer> originalStream = boundedCubeStream(start, end);
        // what is decimal string??
        return originalStream.filter(n -> IsPalindrome.isPalindrome(n.toString()));
    }
}
