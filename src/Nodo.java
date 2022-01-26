import java.util.Scanner;

/*   Tareas:
    - Crear
    - sumar filas
    - sumar columnas
    - insertar datos
    - eliminar datos Por: dato y posición
    - Sumar 2 matrices en la misma forma
    - Multiplicar 2 matrices en la misma forma
    * T + F2 = F1
*/

public class Nodo {

    Scanner sc = new Scanner(System.in);
    private int f, c, d;
    private int[][] Tri;
    private int N;

    // el conatador que se manda desde la clase Tripletas sirve para crear la
    // tripleta con 3 columnas y la "N" es el # de filas dependiento la cantidad de
    // datos
    public Nodo(int N) {
        this.N = N;
        Tri = new int[N][3];
    }

    void Menu() {

        System.out.print("Menú de Operaciones con Tripletas... \n");
        System.out.print("1. Mostrar Tripleta \n");
        System.out.print("2. Eliminar Tripleta \n");
        System.out.print("3. Buscar Dato Especifico \n");
        System.out.print("4. Insertar \n");
        System.out.print("5. Sumar por Fila \n");
        System.out.print("Elige una opción:  ");
        int opc = sc.nextInt();

        // Operaciones de las tripletas
        switch (opc) {

            case 1:
                mostrar(Tri);
                break;

            case 2:
                EliminarTripleta(Tri);
                break;

            case 3:
                BuscarDato(Tri);
                break;

            case 4:
                Insertar(Tri);
                break;

            case 5:
                Sumar(Tri);
                break;

            default:
                //
        }
    }

    // En construir, se manda la matriz con los datos del usuario
    // se manda también las filas "n" y las columnas "m"

    void construirTripleta(int[][] Matriz, int n, int m) {

        int k = 1;
        Tri[0][0] = n; // Número de filas en la matriz
        Tri[0][1] = m; // Número de columnas en la matriz
        Tri[0][2] = 0; // Número de datos diferentes a 0

        // Los "for" recorre la matriz dispersa y pasa los datos a la tripleta
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (Matriz[i][j] != 0) {
                    Tri[0][2] = Tri[0][2] + 1;
                    Tri[k][0] = i;
                    Tri[k][1] = j;
                    Tri[k][2] = Matriz[i][j];
                    k++;
                }

            }
        }

        Menu();
    }

    void mostrar(int[][] Tri) {
        System.out.println(".... Tripleta ....");
        for (int i = 0; i < Tri.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(Tri[i][j]);
            }
            System.out.println("");
        }

        Menu();
    }

    void EliminarTripleta(int[][] Tri) {

        System.out.print("1. Eliminar por dato \n");
        System.out.print("2. Eliminar por posición");
        System.out.print("Opción: ");
        int opc = sc.nextInt();

        switch (opc) {
            case 1:

                System.out.print("Ingrese El Dato: ");
                int d = sc.nextInt();

                for (int i = 1; i <= Tri[0][2]; i++) {
                    if (Tri[i][2] == d) {

                        System.out.println("Seguro de eliminar el dato: " + d);
                        System.out.println("1. Si ó 2. No");
                        int delDato = sc.nextInt();

                        if (delDato == 1) {
                            Tri[i][0] = 0;
                            Tri[i][1] = 0;
                            Tri[i][2] = 0;

                            Tri[0][2] = Tri[0][2] - 1;
                        }
                    }
                }

                for (int i = 0; i <= Tri[0][2]; i++) {
                    if (Tri[i][2] == 0) {
                        Tri[i][0] = Tri[i + 1][0];
                        Tri[i][1] = Tri[i + 1][1];
                        Tri[i][2] = Tri[i + 1][2];

                        Tri[i + 1][0] = 0;
                        Tri[i + 1][1] = 0;
                        Tri[i + 1][2] = 0;
                    }
                }
                break;

            case 2:
                System.out.print("Ingrese la fila: ");
                int f = sc.nextInt();

                System.out.print("Ingrese la columna: ");
                int c = sc.nextInt();

                for (int i = 1; i <= Tri[0][2]; i++) {
                    if ((Tri[i][0] == f) && (Tri[i][1] == c)) {

                        System.out.println("Seguro de eliminar el dato: " + Tri[i][2]);
                        System.out.println("1. Si ó 2. No");
                        int delDato = sc.nextInt();

                        if (delDato == 1) {
                            Tri[i][0] = 0;
                            Tri[i][1] = 0;
                            Tri[i][2] = 0;

                            Tri[0][2] = Tri[0][2] - 1;
                        }
                    }
                }

                for (int i = 0; i <= Tri[0][2]; i++) {
                    if (Tri[i][2] == 0) {
                        Tri[i][0] = Tri[i + 1][0];
                        Tri[i][1] = Tri[i + 1][1];
                        Tri[i][2] = Tri[i + 1][2];

                        Tri[i + 1][0] = 0;
                        Tri[i + 1][1] = 0;
                        Tri[i + 1][2] = 0;
                    }
                }
                break;
                
            default:
                break;
        }

        mostrar(Tri);
    }

    void BuscarDato(int[][] Tri) {

        System.out.print("Desea buscar un dato, en una columna y fila especificas: \n 1. Si \n 2. No \n");
        int opc = sc.nextInt();

        if (opc == 1) {

            System.out.print("Ingrese La Fila: ");
            f = sc.nextInt();

            System.out.print("Ingrese La Columna: ");
            c = sc.nextInt();

            for (int i = 1; i <= Tri[0][2]; i++) {
                if ((Tri[i][0] == f) && (Tri[i][1] == c)) {
                    System.out.print("Dato Buscado es: " + Tri[i][2] + "\n");
                }
            }
        }

        Menu();
    }

    void Insertar(int[][] A) {

        int k = 1;

        System.out.println("Ingrese la fila: ");
        int fila = sc.nextInt();

        System.out.print("Ingrese la columna: ");
        int columna = sc.nextInt();

        System.out.print("Ingrese el dato: ");
        int dato = sc.nextInt();

        if ((A[0][0] < fila) || (fila < 1) || (A[0][1] < columna) || (columna < 1)) {
            System.out.print("Tripleta Inválida");
        }

        while (A[k][0] < fila) {
            k = k + 1;
        }

        // lleva la cuenta de las posiciones teniendo en cuenta si la columna ingresada
        // es mayor
        while ((A[k][0] == fila) && (A[k][1] < columna)) {
            k = k + 1;
        }

        if ((A[k][0] == fila) && (A[k][1] == columna)) {
            System.out.print("Triplata ya existe");
        }

        int d = A[0][2] + 1;
        while (d >= k) {
            A[d + 1][0] = A[d][0];
            A[d + 1][1] = A[d][1];
            A[d + 1][2] = A[d][2];
            d = d - 1;
        }

        A[k][0] = fila;
        A[k][1] = columna;
        A[k][2] = dato;
        A[0][2] = A[0][2] + 1;

        /*
         * while (Tri[k][0] == fila) {
         * if (Tri[k][1] < columna) {
         * k++;
         * } else {
         * if (Tri[k][1] == columna) {
         * if (Tri[k][2] != 0) {
         * System.out.println("Ya existe un dato en esta posición..");
         * } else {
         * Tri[k][2] = dato;
         * }
         * } else if (Tri[k][1] > columna) {
         * Redenominar(Tri, fila, columna, dato);
         * }
         * }
         * }
         */
        Menu();

    }

    void Redenominar(int[][] Tri, int col, int fil, int dato) {

        int[][] Tri2 = new int[N][2];

        int k = 1;
        Tri2[0][0] = Tri[0][0] + 1; // Número de filas en la matriz
        Tri2[0][1] = Tri[0][1] + 1; // Número de columnas en la matriz
        Tri2[0][2] = 0; // Número de datos diferentes a 0

        // Los "for" recorre la matriz dispersa y pasa los datos a la tripleta
        for (int i = 1; i < Tri[0][2]; i++) {

            k++;
        }
    }

    void Sumar(int[][] Tri) {

        int[][] A = Tri;
        int[][] C;
        int k = 0;

        System.out.println(".... Tripleta ....");
        for (int i = 0; i < Tri.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(A[i][j]);
            }
            System.out.println("");
        }

        Tripletas B = new Tripletas();
        B.Construir();

    }
}