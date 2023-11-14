package lotto;

import java.util.List;
import java.util.Vector;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        StringBuilder numbersString = new StringBuilder();
        numbersString.append("[");

        numbers.sort(null);
        for (int i = 0; i < numbers.size(); i++) {
            numbersString.append(numbers.get(i).toString());
            if (i < numbers.size() - 1) {
                numbersString.append(", ");
            }
        }

        numbersString.append("]");
        return numbersString.toString();
    }

    public List<Integer> get() {
        return new Vector<>(numbers);
    }
}
