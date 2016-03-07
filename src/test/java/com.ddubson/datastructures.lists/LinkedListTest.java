package com.ddubson.datastructures.lists;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class LinkedListTest {
	@Test
	public void testSizeOfLinkedList() {
		List<String> list = new LinkedList<>();

		list.add("Hello");
		assertThat(list.size(), equalTo(1));
	}
}
