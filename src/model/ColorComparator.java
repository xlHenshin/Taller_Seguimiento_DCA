package model;

import java.util.Comparator;

public class ColorComparator implements Comparator<Indicator> {

	@Override
	public int compare(Indicator arg0, Indicator arg1) {
		// TODO Auto-generated method stub
		return arg0.getColor()-arg1.getColor();
	}

}
