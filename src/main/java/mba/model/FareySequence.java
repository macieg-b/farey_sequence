package mba.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Setter
@Getter
public class FareySequence {
	private int n;
	private int result;
	private List<String> terms;

	public void calculate() {
		terms = new ArrayList<String>();
		double x1 = 0, y1 = 1, x2 = 1, y2 = n;
		terms.add(String.format("%.0f/%.0f", x1, y1));
		terms.add(String.format("%.0f/%.0f", x2, y2));
		double x, y = y2;
		while (y != 1.0) {
			x = Math.floor((y1 + n) / y2) * x2 - x1;
			y = Math.floor((y1 + n) / y2) * y2 - y1;
			terms.add(String.format("%.0f/%.0f", x, y));
			x1 = x2;
			x2 = x;
			y1 = y2;
			y2 = y;
		}
	}

	@Override
	public String toString() {
		return terms.stream()
				.collect(Collectors.joining(", ", "{", "}"));
	}
}
