package com.lambdaexpressions.customsorting;

import java.util.Comparator;

@FunctionalInterface
public interface ProductSorter {
	Comparator<Product> sort();
}
