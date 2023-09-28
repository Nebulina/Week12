package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.params.provider.Arguments.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

class TestDemoJUnitTest {

	private TestDemo testDemo;
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
	//given
		if(!expectException) {
	
	//when
		int actual = testDemo.addPositive(a, b);
	//then
		assertThat(actual).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	//Arguments that shows solutions can be true or false.
static Stream<Arguments> argumentForAddPositive() {
	// @formatter:off
return Stream.of(
		arguments(2, 4, 6, false),
		arguments(-1, -2, -3, true),
		arguments(1, -1, 0, true),
		arguments(-1, 3, 2, true)
		);
// @formatter:on
}
////Asserts that both numbers added are positive.
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		
		assertThat(testDemo.addPositive(4,5)).isEqualTo(9);

		assertThat(testDemo.addPositive(40,50)).isEqualTo(90);
		
	}
	
	//Asserts that both numbers multiplied are positive.
	@Test
	void assertThatPositivePairsMultiplyCorrectly() {
		
		assertThat(testDemo.multiplyPositive(4,5)).isEqualTo(20);

		assertThat(testDemo.multiplyPositive(10,9)).isEqualTo(90);
		
	}

	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}
	
	
	
	
 }
	
