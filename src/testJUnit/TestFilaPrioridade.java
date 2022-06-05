package testJUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import estruturas.FilaPrioridade;

public class TestFilaPrioridade{

	
	@Test
	public void test(){
		FilaPrioridade<Integer> fila = new FilaPrioridade<Integer>((a,b) -> a - b);
		for(int i = 1000; i >= 0 ; i--){
			fila.add(i);
			assertEquals(Integer.toString(i), Integer.toString(fila.peek()));
		}
		assertEquals(false,fila.isEmpty());
		assertEquals(1001,fila.size());
		for(int i = 0; i <= 1000; i++){
			assertEquals(true, fila.contains(i));
		}
		for(int i = 0; i <= 1000; i++){
			assertEquals(Integer.toString(i), Integer.toString(fila.poll()));
		}
		assertEquals(true,fila.isEmpty());
		assertEquals(0,fila.size());
	}

}
