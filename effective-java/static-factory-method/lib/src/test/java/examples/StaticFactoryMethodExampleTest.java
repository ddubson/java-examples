package examples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class StaticFactoryMethodExampleTest {
	@Test
	void testSomeLibraryMethod() {
		assertNotNull(StaticFactoryMethodExample.verySpecific());
		assertNotNull(StaticFactoryMethodExample.allPurpose());
	}
}
