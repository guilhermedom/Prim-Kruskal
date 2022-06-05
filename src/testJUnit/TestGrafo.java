package testJUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import estruturas.Grafo;
import estruturas.Grafo.Adjacencia;

public class TestGrafo{

/*	@Test
	public void test(){
		int total = 300;
		boolean direcionado = false;
		Grafo<Integer> a = new Grafo<Integer>(direcionado);
		for(int i = 0; i < total; i++)
			assertEquals(true, a.addVertice(i));
		for(int i = 0; i < total; i++)
			assertEquals(false, a.addVertice(i));
		for(int i = 0; i < total; i++)
			a.insereAresta(1, i, 10);
		for(int i = 0; i < total; i++)
			assertEquals(true, a.existeAresta(1, i));
		for(int i = 0; i < total; i++)
			assertEquals(!direcionado || i == 1, a.existeAresta(i, 1));
		for(int i = 0; i < total; i++)
			assertEquals((i == 1) && !direcionado, a.existeAresta(4, i));
		Adjacencia b = a.primeiroAdjacente(1);
		int c = 0;
		while(b != null) {
			c++;
			b = a.proximoAdjacente(b);
		}
		assertEquals(total, c);
		for(int i = 0; i < total; i++)
			assertEquals(true, a.removeAresta(1, i));
		c = 0;
		while(b != null) {
			c++;
			b = a.proximoAdjacente(b);
		}
		assertEquals(0, c);
	}

	@Test
	public void test2(){
		int total = 1000;
		boolean direcionado = true;
		Grafo<Integer> a = new Grafo<Integer>(direcionado);
		for(int i = 0; i < total; i++)
			assertEquals(true, a.addVertice(i));
		for(int j = 0; j < total; j++)
			for(int i = 0; i < total; i++)
				a.insereAresta(j, i, 10);
		for(int j = 0; j < total; j++)
			for(int i = 0; i < total; i++)
				assertEquals(true, a.existeAresta(j, i));

		for(int j = 0; j < total; j++) {
			Adjacencia b = a.primeiroAdjacente(j);
			int c = 0;
			while(b != null) {
				c++;
				b = a.proximoAdjacente(b);
			}
			assertEquals(total, c);
			for(int i = 0; i < total; i++)
				assertEquals(true, a.removeAresta(j, i));
			c = 0;
			while(b != null) {
				c++;
				b = a.proximoAdjacente(b);
			}
			assertEquals(0, c);
		}

	}

	@Test
	public void testPrimKruskal1(){
		boolean direcionado = true;
		Grafo<Integer> a = new Grafo<Integer>(direcionado);
		for(int i = 0; i < 6; i++)
			assertEquals(true, a.addVertice(i));
		a.insereAresta(0, 2, 1);
		a.insereAresta(0, 1, 6);
		a.insereAresta(0, 3, 5);

		a.insereAresta(1, 2, 2);
		a.insereAresta(2, 3, 2);
		a.insereAresta(4, 2, 6);
		a.insereAresta(4, 5, 3);
		a.insereAresta(5, 3, 4);
		a.insereAresta(5, 2, 4);
		a.insereAresta(1, 4, 5);
		System.out.println("Grafo 1");
		System.out.println(a.toString());
		
		System.out.println("Arvore Minima Prim");
		Grafo<Integer> r = a.executarPrim(0, direcionado);
		System.out.println(r.toString());

		System.out.println("Arvore Minima Kruskal");
		Grafo<Integer> r2 = a.executarKruskal(0, direcionado);
		System.out.println(r2.toString());
		

	}
	
	@Test
	public void testPrimKruskal2(){
		boolean direcionado = false;
		Grafo<Integer> a = new Grafo<Integer>(direcionado);
		for(int i = 0; i < 6; i++)
			assertEquals(true, a.addVertice(i));
		a.insereAresta(0, 2, 1);
		a.insereAresta(0, 1, 6);
		a.insereAresta(0, 3, 5);

		a.insereAresta(1, 2, 2);
		a.insereAresta(2, 3, 2);
		a.insereAresta(4, 2, 6);
		a.insereAresta(4, 5, 3);
		a.insereAresta(5, 3, 4);
		a.insereAresta(5, 2, 4);
		a.insereAresta(1, 4, 5);
		System.out.println("Grafo 1");
		System.out.println(a.toString());
		
		System.out.println("Arvore Minima Prim");
		Grafo<Integer> r = a.executarPrim(0, direcionado);
		System.out.println(r.toString());

		System.out.println("Arvore Minima Kruskal");
		Grafo<Integer> r2 = a.executarKruskal(0, direcionado);
		System.out.println(r2.toString());

	}

	@Test
	public void testPrimKruskal3(){
		int total = 1000;
		boolean direcionado = false;
		
		java.util.Random r = new java.util.Random();
		Grafo<Integer> a = new Grafo<Integer>(direcionado);
		for(int i = 0; i < total; i++)
			a.addVertice(i);
		for(int j = 0; j < total; j++)
			for(int i = 0; i < total; i++)
				a.insereAresta(j, i, r.nextInt(2000) + 1);
		
		Grafo<Integer> re = a.executarPrim(0, direcionado);
		ArrayList<Integer> ar = new ArrayList<Integer>();
		ArrayList<Adjacencia> adj1 = new ArrayList<Adjacencia>();
		for(int j = 0; j < total; j++) {
			Adjacencia b = re.primeiroAdjacente(j);
			while(b != null) {
				adj1.add(b);
				assertEquals(false,direcionado && ar.contains(b.destino()));
				ar.add(b.destino());
				b = re.proximoAdjacente(b);
			}
		}
		assertEquals(total - 1, ar.size()/ ((direcionado)?1:2));
		
		Grafo<Integer> re2 = a.executarPrim(0, direcionado);
		ar = new ArrayList<Integer>();
		ArrayList<Adjacencia> adj2 = new ArrayList<Adjacencia>();
		for(int j = 0; j < total; j++) {
			Adjacencia b = re2.primeiroAdjacente(j);
			while(b != null) {
				adj2.add(b);
				assertEquals(false, direcionado && ar.contains(b.destino()));
				ar.add(b.destino());
				b = re2.proximoAdjacente(b);
			}
		}
		if(!direcionado){
			for(Adjacencia e : adj1){
				assertEquals(true, adj2.contains(e));
			}
			for(Adjacencia e : adj2){
				assertEquals(true, adj1.contains(e));
			}
		}
		
		assertEquals(total - 1, ar.size()/ ((direcionado)?1:2));
	}
	
	@Test
	public void testPrimKruskal4(){
		int total = 1000;
		boolean direcionado = true;
		
		java.util.Random r = new java.util.Random();
		Grafo<Integer> a = new Grafo<Integer>(direcionado);
		for(int i = 0; i < total; i++)
			a.addVertice(i);
		for(int j = 0; j < total; j++)
			for(int i = 0; i < total; i++)
				a.insereAresta(j, i, r.nextInt(2000) + 1);
		
		Grafo<Integer> re = a.executarPrim(0, direcionado);
		ArrayList<Integer> ar = new ArrayList<Integer>();
		ArrayList<Adjacencia> adj1 = new ArrayList<Adjacencia>();
		for(int j = 0; j < total; j++) {
			Adjacencia b = re.primeiroAdjacente(j);
			while(b != null) {
				adj1.add(b);
				assertEquals(false,direcionado && ar.contains(b.destino()));
				ar.add(b.destino());
				b = re.proximoAdjacente(b);
			}
		}
		assertEquals(total - 1, ar.size()/ ((direcionado)?1:2));
		
		Grafo<Integer> re2 = a.executarPrim(0, direcionado);
		ar = new ArrayList<Integer>();
		ArrayList<Adjacencia> adj2 = new ArrayList<Adjacencia>();
		for(int j = 0; j < total; j++) {
			Adjacencia b = re2.primeiroAdjacente(j);
			while(b != null) {
				adj2.add(b);
				assertEquals(false, direcionado && ar.contains(b.destino()));
				ar.add(b.destino());
				b = re2.proximoAdjacente(b);
			}
		}
		if(!direcionado){
			for(Adjacencia e : adj1){
				assertEquals(true, adj2.contains(e));
			}
			for(Adjacencia e : adj2){
				assertEquals(true, adj1.contains(e));
			}
		}
		
		assertEquals(total - 1, ar.size()/ ((direcionado)?1:2));
	}
*/
}
