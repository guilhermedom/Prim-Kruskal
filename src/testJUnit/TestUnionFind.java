package testJUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import estruturas.UnionFind;

public class TestUnionFind{

	@Test
	public void test(){
		int size = 50;
		UnionFind a = new UnionFind(size);
		assertEquals(size,a.quantidadeGrupos());
		for(int i = 0; i < size; i++)
			assertEquals(i,a.find(i));
		for(int i = 1; i < size; i++){
			a.union(i-1, i);
			assertEquals(size - i,a.quantidadeGrupos());
		}
		assertEquals(1,a.quantidadeGrupos());
		for(int i = 0; i < size; i++)
			assertEquals(0,a.find(i));
	}

}
