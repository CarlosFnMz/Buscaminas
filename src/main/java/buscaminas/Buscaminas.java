package buscaminas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Buscaminas {
	public static void main(String arg[]) {
		List<List<String>> campo = new ArrayList<List<String>>();
		try {
			campo = leerArchivo(arg[0]);
			int x=0;
			for(List<String> fila: campo) {
				int y=0;
				for(String celda: fila) {
					if(celda.equals("*")) {
						System.out.print("*");
						y++;
					}else {
						System.out.print(buscarMina(x,y, campo));
						y++;
					}
				}
				System.out.println("");
				x++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String buscarMina(int x, int y, List<List<String>> campo) {
		int contador=0;
		for(int cx=x-1;cx<=x+1;cx++) {
			for(int cy=y-1;cy<=y+1;cy++){
				try{
					if(campo.get(cx).get(cy).equals("*"))
						contador++;
				}catch (Exception e) {}
			}
		}
		
		return String.valueOf(contador);
	}
	
	public static List<List<String>> leerArchivo(String file) throws IOException {
		ArrayList<List<String>> campo = new ArrayList<List<String>>();
		String cadena;
		FileReader f = new FileReader(file);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
        		ArrayList<String> fila = new ArrayList<String>();
        		for(int i = 0; i<=cadena.length()-1; i++){
        			fila.add(Character.toString(cadena.charAt(i)));
        		}
        		campo.add(fila);
        }
        b.close();
        return campo;
	}
}
