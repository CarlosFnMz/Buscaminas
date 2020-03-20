package buscaminas;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BuscaminasTest {

	@Test
	public void testBuscarMina() {
		List<String> y = new ArrayList<>();
		y.add("*");
		y.add(".");
		List<List<String>> campo = new ArrayList<>();
		campo.add(y);
		String r = Buscaminas.buscarMina(1, 1, campo);
		assertEquals("1", r);
	}

	@Test(expected = Exception.class)
	public void testLeerArchivo() throws IOException {
		Buscaminas.leerArchivo("archivo.txt");
	}

}
