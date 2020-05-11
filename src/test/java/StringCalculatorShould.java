import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorShould {
    @Test
    void return_zero_when_empty_string(){
        assertThat(StringCalculator.add("")).isEqualTo(0);
    }
    @Test
    void return_same_number(){
        assertThat(StringCalculator.add("5")).isEqualTo(5);
    }
    @Test
    void return_the_sum_of_two_numbers(){
        assertThat(StringCalculator.add("5,5")).isEqualTo(10);
    }
    @Test
    void return_the_sum_of_three_or_more_numbers()
    {
    assertThat(StringCalculator.add("5,5,5")).isEqualTo(15);
    assertThat(StringCalculator.add("5,5,5,5")).isEqualTo(20);
    }

}
