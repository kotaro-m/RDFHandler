package Jaro_Winkler;

import org.apache.lucene.search.spell.JaroWinklerDistance;

public class Distance {
	public static double J_Distance(String one , String two){
		JaroWinklerDistance j_algo = new JaroWinklerDistance();
		return j_algo.getDistance(one,two);
	}
}
