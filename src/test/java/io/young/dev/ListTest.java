package io.young.dev;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ListTest {

    @Test(dataProvider = "getData")
    public void listTest(List<String> input) {
        List<String> expected = Arrays.asList("apple", "ball");
        assertThat(input)
                .hasSize(3)
                .doesNotContain("cat")
                .containsAll(expected)
                .allSatisfy(str -> assertThat(str.length()).isGreaterThanOrEqualTo(4));
    }

    @DataProvider
    public Object[] getData() {
        return new Object[] {
                Arrays.asList("ball", "apple", "card")
        };
    }
}
