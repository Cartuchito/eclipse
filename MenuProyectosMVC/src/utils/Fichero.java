package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Fichero {

	public static List<String> cargaFicheroCfg() throws FileNotFoundException, IOException {
		String archivo = "archivo.txt";
		FileReader f = new FileReader(archivo);
		BufferedReader b = new BufferedReader(f);
		List<String> cfg = new ArrayList<String>();
		cfg.add(b.readLine());
		cfg.add(b.readLine());
		cfg.add(b.readLine());
		cfg.add(b.readLine());
		cfg.add(b.readLine());
		b.close();
		return cfg;
	}
	
}