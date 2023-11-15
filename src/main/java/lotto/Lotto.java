package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Vector;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicatedNumbers(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicatedNumbers(List<Integer> numbers) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(Integer number : numbers) {
            if(hashSet.contains(number)) {
                throw new IllegalArgumentException();
            }
            hashSet.add(number);
        }
    }

    @Override
    public String toString() {
        StringBuilder numbersString = new StringBuilder();
        numbersString.append("[");

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
