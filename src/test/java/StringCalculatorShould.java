import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorShould {
    @Test
    void consider_an_empty_string_as_zero(){
        assertThat(StringCalculator.add("")).isEqualTo("0");
    }
    @Test
    void not_sum_when_only_have_one_number(){
        assertThat(StringCalculator.add("5")).isEqualTo("5");
    }
    @Test
    void sum_two_numbers_separated_by_commas(){
        assertThat(StringCalculator.add("5,5")).isEqualTo("10");
        assertThat(StringCalculator.add("5,5,5")).isEqualTo("15");
    }
    @Test
    void allow_new_lines_as_a_separator(){
        assertThat(StringCalculator.add("5\n5,5")).isEqualTo("15");
    }
    @Test
    void allow_custom_separators(){

        assertThat(StringCalculator.add("//;\n1;2")).isEqualTo("3");
        assertThat(StringCalculator.add("//ggg\n1ggg2ggg3")).isEqualTo("6");
        assertThat(StringCalculator.add("//ggg\n//hhh\n1ggg2hhh3")).isEqualTo("6");
    }
    @Test
    void not_allow_negative_numbers(){
        Assertions.assertThrows(NegativesNotAllowedException.class,()-> StringCalculator.add("5,-5")) ;
    }
    @Test
    void ignore_a_number_greater_than_a_thousand(){
        assertThat(StringCalculator.add("5,1001")).isEqualTo("5");
    }
}
