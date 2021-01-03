package examples;

public class StaticFactoryMethodExample {
	private final SomeDependency1 dependency1;
	private final SomeDependency2 dependency2;

	protected StaticFactoryMethodExample(SomeDependency1 dependency1, SomeDependency2 dependency2) {

		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}

	protected StaticFactoryMethodExample(SomeDependency1 dependency1) {
		this.dependency1 = dependency1;
		this.dependency2 = new SomeDependency2();
	}

	public static StaticFactoryMethodExample verySpecific() {
		return new StaticFactoryMethodExample(new SomeDependency1());
	}

	public static StaticFactoryMethodExample allPurpose() {
		return new StaticFactoryMethodExample(new SomeDependency1(), new SomeDependency2());
	}
}

class SomeDependency1 {

}

class SomeDependency2 {

}
