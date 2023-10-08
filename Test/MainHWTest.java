import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import seminars.third.hw.MainHW;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class MainHWTest {

    private MainHW mainHW;

    @BeforeEach
    void setUp() {
        mainHW = new MainHW();
    }

    //HW 3.1
    @ParameterizedTest
    @ValueSource(ints = {0, 2, 4, 6, 8, 10})
    void testEven(int i) {
        assertThat(mainHW.even(i)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9, 11})
    void testNotEven(int i) {
        assertThat(mainHW.even(i)).isFalse();
    }

    //HW 3.2
    @ParameterizedTest
    @ValueSource(ints = {26, 50, 99})
    void testNumberInterval(int i) {
        assertThat(mainHW.interval(i)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10, 25, 100, 555})
    void testNumberNotInterval(int i) {
        assertThat(mainHW.interval(i)).isFalse();
    }
}
