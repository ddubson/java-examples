package streams;

import lombok.Builder;
import lombok.Getter;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class StreamsTest {
	@Test
	public void flattenListExample() {
		Product product1 = Product.builder().tags(asList("tag1", "tag2")).build();
		Product product2 = Product.builder().tags(asList("tag2", "tag3")).build();
		List<Product> products = asList(product1, product2);
		List<String> listOfTags = products.stream().flatMap(product -> product.getTags().stream()).collect(Collectors.toList());
		assertThat(listOfTags).containsExactly("tag1", "tag2", "tag2", "tag3");
	}

	@Test
	public void mergeListExample() {
		List<Integer> listOfOdds = asList(1,3,5,7,9);
		List<Integer> listOfEvens = asList(2,4,6,8,10);
		List<Integer> listOfAll = Stream.concat(listOfOdds.stream(), listOfEvens.stream()).collect(Collectors.toList());
		assertThat(listOfAll).containsExactly(1,3,5,7,9,2,4,6,8,10);
	}

	@Getter
	@Builder
	static class Product {
		private final List<String> tags;
	}
}
