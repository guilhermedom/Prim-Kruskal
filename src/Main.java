import estruturas.Grafo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * Classe com o executavel referente ao projeto.
 * 
 * @author Wallace Alves Esteves Manzano
 *		   Guilherme Domingos Faria Silva
 *		   Wellington Fernando Molina
 */
@SuppressWarnings("resource")
public class Main {
	public static void main(String[] args) {
		boolean _continue = false;
		do {
			Grafo<Ponto> g = new Grafo<Ponto>();
			LinkedHashMap<Ponto, Integer> gPrim, gKruskal;
			ArrayList<Ponto> pts = new ArrayList<Ponto>();
			BufferedReader r = null;
			BufferedWriter w1 = null, w2 = null;
			String buffer;
			Scanner scanner = new Scanner(System.in);
			int k;

			System.out.print("\n\n\n");

			System.out.print("Digite a quantidade de clusters desejada: ");
			k = scanner.nextInt();

			while (k < 1) {
				System.out.print("Digite a quantidade de clusters maior ou igual a 1: ");
				k = scanner.nextInt();
			}

			try {
				r = new BufferedReader(new FileReader("data.txt"));
				while ((buffer = r.readLine()) != null) {
					pts.add(new Ponto(Double.parseDouble(buffer.split("	")[0].trim()),
							Double.parseDouble(buffer.split("	")[1].trim())));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (r != null)
					try {
						r.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}

			for (Ponto e : pts)
				g.addVertice(e);

			
			for(int i = 0; i < pts.size(); i++)
				for(int j = (i + 1); j < pts.size(); j++)
					g.insereAresta(pts.get(i), pts.get(j), pts.get(i).distancia(pts.get(j)));

			gKruskal = g.agrupamentoKruskal(k);
			gPrim = g.agrupamentoPrim(k);
			;

			try {
				w1 = new BufferedWriter(new FileWriter("SaidaPrim.txt"));
				w2 = new BufferedWriter(new FileWriter("SaidaKruskal.txt"));
				for (Ponto e : pts) {
					w1.write(gPrim.get(e).toString());
					w1.newLine();
					w2.write(gKruskal.get(e).toString());
					w2.newLine();
				}
				w1.close();
				w2.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Arquivos de saida gerados (ver SaidaPrim.txt e SaidaKruskal.txt).");
			if (k == 7) {
				System.out.println(
						"RandIndex SaidaPrim com o arquivo classes: " + randIndex("classes.txt", "SaidaPrim.txt"));
				System.out.println("RandIndex SaidaKruskal com o arquivo classes: "
						+ randIndex("classes.txt", "SaidaKruskal.txt"));
				System.out.println(
						"RandIndex SaidaKruskal com SaidaPrim: " + randIndex("SaidaPrim.txt", "SaidaKruskal.txt"));
			} else {
				System.out.println(
						"RandIndex SaidaKruskal com SaidaPrim: " + randIndex("SaidaPrim.txt", "SaidaKruskal.txt"));
				System.out.println("RandIndex com o arquivo classes somente é calculado para 7 clusters");

			}

			scanner.nextLine();
			String aux;
			do {
				System.out.print("\nDeseja executar novamente?? (S/N)");
				aux = scanner.nextLine();
			} while (!(aux.equalsIgnoreCase("S") || aux.equalsIgnoreCase("N")));
			_continue = aux.equalsIgnoreCase("S");
		} while (_continue);
	}

	private static double randIndex(String p1, String p2) {
		BufferedReader r1 = null, r2 = null;
		String buffer;
		ArrayList<Integer> c1 = new ArrayList<Integer>(), c2 = new ArrayList<Integer>();
		int a = 0, b = 0;

		try {
			r1 = new BufferedReader(new FileReader(p1));
			r2 = new BufferedReader(new FileReader(p2));
			while ((buffer = r1.readLine()) != null) {
				c1.add(Integer.parseInt(buffer));
				c2.add(Integer.parseInt(r2.readLine()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (r1 != null)
				try {
					r1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (r2 != null)
				try {
					r2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

		for (int i = 0; i < c1.size(); i++) {
			for (int j = i + 1; j < c1.size(); j++) {
				if (c1.get(i) == c1.get(j) && c2.get(i) == c2.get(j))
					a++;
				if (c1.get(i) != c1.get(j) && c2.get(i) != c2.get(j))
					b++;
			}
		}

		// (a + b)/comb(n,2)
		return ((double) (a + b)) / ((c1.size() * (c1.size() - 1)) / 2);
	}

	static class Ponto {
		double x, y;

		public Ponto(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			long temp;
			temp = Double.doubleToLongBits(x);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			temp = Double.doubleToLongBits(y);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Ponto other = (Ponto) obj;
			if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
				return false;
			if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
				return false;
			return true;
		}

		public double distancia(Ponto a) {
			return Math.sqrt(Math.pow(x - a.x, 2) + Math.pow(y - a.y, 2));
		}

		public String toString() {
			return "(" + x + ", " + y + ")";
		}
	}
}

