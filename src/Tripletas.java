import java.util.Scanner;

/*
 *   Author: Maria F
 */

public class Tripletas {

	public int[][] Construir() {

		try (Scanner sc = new Scanner(System.in)) {
			int opc = 0, cont = 1, f = 0, c = 0, d = 0;
			int[][] Matriz;

			System.out.print("Ingrese la cantidad de filas: ");
			int n = sc.nextInt();

			System.out.print("Ingrese la cantidad de columnas: ");
			int m = sc.nextInt();

			Matriz = new int[n][m];

			Nodo matriz;

			//Ciclo para recorrer la matriz creada y solicitar datos
			do {

				System.out.print("Ingrese La Fila: ");
				f = sc.nextInt();

				System.out.print("Ingrese La Columna: ");
				c = sc.nextInt();

				System.out.print("Ingrese El Dato: ");
				d = sc.nextInt();

				Matriz[f][c] = d;
				cont += 1;  //Conteo de datos diferentes de cero

				System.out.print("Desea ingresar otro dato: \n 1. Si \n 2. No \n");
				opc = sc.nextInt();

			} while (opc == 1);

			/*

			for (int x=0; x < n; x++) {
				for (int y=0; y < m; y++) {
					Matriz[x][y] = (int) (Math.random()*9+0);
					cont += 1;
				}
			}*/

			matriz = new Nodo(cont);

			matriz.construirTripleta(Matriz, n, m);

			return Matriz;
		}
	}

	public static void imprimirMatriz(int matriz[][]) {

		System.out.println(".... Matriz Dispersa ....");
		for (int i = 0; i < matriz.length; i++) {//Ciclo filas
			for (int j = 0; j < matriz.length; j++) { //Ciclo columnas
				System.out.print(matriz[i][j]);
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {

		//int[][] matriz = Construir();
		//imprimirMatriz(matriz);

	}
}
