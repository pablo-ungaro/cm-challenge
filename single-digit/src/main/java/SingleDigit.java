import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SingleDigit {
    public static int generate(String sequence, int repetitions) {

        sequence = repeatSequence(sequence, repetitions);

        int sum = Stream.of(sequence.split(""))
                .mapToInt(Integer::valueOf)
                .reduce(0, (acc, next) -> acc + next);

        if (sum < 10) return sum;

        return generate(String.valueOf(sum), 0);
    }

    public static String repeatSequence(String sequence, int times) {
        if (times <= 0) return sequence;

        final String initialSequence = sequence;
        String finalSequence = "";

        return IntStream.range(0, times).mapToObj(a -> finalSequence.concat(initialSequence)).collect(Collectors.joining());
    }
}
