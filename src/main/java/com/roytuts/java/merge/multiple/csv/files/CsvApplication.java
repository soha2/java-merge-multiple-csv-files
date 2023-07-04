package com.roytuts.java.merge.multiple.csv.files;

import java.io.File;
import java.util.*;  
import java.io.IOException;
import com.roytuts.java.merge.multiple.csv.files.parser.CsvParser;
import com.roytuts.java.merge.multiple.csv.files.vo.CsvVo;

public class CsvApplication {

	public static void main(String[] args) throws IOException { 
		File csv1 = new File("/Users/sohasindhwani/Desktop/java-merge-multiple-csv-files2/src/main/java/com/roytuts/java/merge/multiple/csv/files/csv.csv");
		File csv2 = new File("/Users/sohasindhwani/Desktop/java-merge-multiple-csv-files2/src/main/java/com/roytuts/java/merge/multiple/csv/files/csv1.csv");

		List<String> csv1Headers = CsvParser.getHeadersFromACsv(csv1);
		// csv1Headers.forEach(h -> System.out.print(h + " "));
		// System.out.println();
		List<String> csv2Headers = CsvParser.getHeadersFromACsv(csv2);
		// csv2Headers.forEach(h -> System.out.print(h + " "));
		// System.out.println();

		List<String> allCsvHeaders = new ArrayList<>();
		allCsvHeaders.addAll(csv1Headers);
		allCsvHeaders.addAll(csv2Headers);
		// allCsvHeaders.forEach(h -> System.out.print(h + " "));
		// System.out.println();

		Set<String> uniqueHeaders = new HashSet<>(allCsvHeaders);
		// uniqueHeaders.forEach(h -> System.out.print(h + " "));
		// System.out.println();

		List<CsvVo> csv1Records = CsvParser.getRecodrsFromACsv(csv1, csv1Headers);
		List<CsvVo> csv2Records = CsvParser.getRecodrsFromACsv(csv2, csv2Headers);

		List<CsvVo> allCsvRecords = new ArrayList<>();
		allCsvRecords.addAll(csv1Records);
		allCsvRecords.addAll(csv2Records);


		String c = "/Users/sohasindhwani/Desktop/java-merge-multiple-csv-files2/src/main/java/com/roytuts/java/merge/multiple/csv/files/csv2.csv";
		CsvParser.writeToCsv(new File(c), uniqueHeaders, allCsvRecords);
	}

}
