import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Armenia armenia = null;
		Buga buga = null;
		Cali cali = null;
		boolean salir = false;
		final int MINIMO_REFERENDO = 1500000;

		while (!salir) {
			System.out.println("\n--- MENÚ ---");
			System.out.println("1) Registro Armenia");
			System.out.println("2) Registro Buga");
			System.out.println("3) Registro Cali");
			System.out.println("4) Ciudad con mayor número de firmas recolectadas");
			System.out.println("5) Total de firmas válidas y si es par o impar");
			System.out.println("6) Porcentaje de firmas logradas frente al mínimo requerido");
			System.out.println("7) ¿El privilegio más cuestionado fue el mismo en más de una ciudad?");
			System.out.println("8) Ciudad más cerca del promedio general de firmas válidas");
			System.out.println("9) Salir");
			System.out.print("Seleccione una opción: ");
			int opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
				case 1:
					System.out.println("Registro Armenia");
					System.out.print("Ingrese el número de firmas recolectadas: ");
					int firmasArmenia = sc.nextInt();
					sc.nextLine();
					System.out.print("Ingrese el privilegio que generó más dudas: ");
					String privilegioArmenia = sc.nextLine();
					armenia = new Armenia(firmasArmenia, privilegioArmenia);
					System.out.println("Registro guardado: " + armenia);
					break;
				case 2:
					System.out.println("Registro Buga");
					System.out.print("Ingrese el número de firmas recolectadas: ");
					int firmasBuga = sc.nextInt();
					sc.nextLine();
					System.out.print("Ingrese el privilegio que generó más dudas: ");
					String privilegioBuga = sc.nextLine();
					buga = new Buga(firmasBuga, privilegioBuga);
					System.out.println("Registro guardado: " + buga);
					break;
				case 3:
					System.out.println("Registro Cali");
					System.out.print("Ingrese el número de firmas recolectadas: ");
					int firmasCali = sc.nextInt();
					sc.nextLine();
					System.out.print("Ingrese el privilegio que generó más dudas: ");
					String privilegioCali = sc.nextLine();
					cali = new Cali(firmasCali, privilegioCali);
					System.out.println("Registro guardado: " + cali);
					break;
				case 4:
					if (armenia == null || buga == null || cali == null) {
						System.out.println("Debe registrar las tres ciudades primero.");
						break;
					}
					int maxFirmas = Math.max(armenia.getFirmasRecolectadas(), Math.max(buga.getFirmasRecolectadas(), cali.getFirmasRecolectadas()));
					System.out.print("La ciudad con mayor número de firmas recolectadas es: ");
					if (armenia.getFirmasRecolectadas() == maxFirmas) System.out.print("Armenia ");
					if (buga.getFirmasRecolectadas() == maxFirmas) System.out.print("Buga ");
					if (cali.getFirmasRecolectadas() == maxFirmas) System.out.print("Cali ");
					System.out.println("con " + maxFirmas + " firmas.");
					break;
				case 5:
					if (armenia == null || buga == null || cali == null) {
						System.out.println("Debe registrar las tres ciudades primero.");
						break;
					}
					int validasArmenia = armenia.getFirmasRecolectadas() - armenia.getFirmasAnuladas();
					int validasBuga = buga.getFirmasRecolectadas() - buga.getFirmasAnuladas();
					int validasCali = cali.getFirmasRecolectadas() - cali.getFirmasAnuladas();
					int totalValidas = validasArmenia + validasBuga + validasCali;
					System.out.println("Total de firmas válidas: " + totalValidas);
					System.out.println("El total de firmas válidas es " + (totalValidas % 2 == 0 ? "par" : "impar"));
					break;
				case 6:
					if (armenia == null || buga == null || cali == null) {
						System.out.println("Debe registrar las tres ciudades primero.");
						break;
					}
					int totalValidas6 = (armenia.getFirmasRecolectadas() - armenia.getFirmasAnuladas()) +
						(buga.getFirmasRecolectadas() - buga.getFirmasAnuladas()) +
						(cali.getFirmasRecolectadas() - cali.getFirmasAnuladas());
					double porcentaje = (totalValidas6 * 100.0) / MINIMO_REFERENDO;
					System.out.printf("Porcentaje de firmas logradas: %.2f%%\n", porcentaje);
                    System.out.println("Total de firmas validas: " + totalValidas6);
                    System.out.println("Minimo requerido: " + MINIMO_REFERENDO);
					break;
				case 7:
					if (armenia == null || buga == null || cali == null) {
						System.out.println("Debe registrar las tres ciudades primero.");
						break;
					}
					String pA = armenia.getPrivilegio();
					String pB = buga.getPrivilegio();
					String pC = cali.getPrivilegio();
					if (pA.equalsIgnoreCase(pB) && pB.equalsIgnoreCase(pC)) {
						System.out.println("El privilegio más cuestionado fue el mismo en las tres ciudades.");
					} else if (pA.equalsIgnoreCase(pB) || pA.equalsIgnoreCase(pC) || pB.equalsIgnoreCase(pC)) {
						System.out.println("El privilegio más cuestionado fue el mismo en más de una ciudad.");
					} else {
						System.out.println("Todos los privilegios más cuestionados fueron distintos.");
					}
					break;
				case 8:
					if (armenia == null || buga == null || cali == null) {
						System.out.println("Debe registrar las tres ciudades primero.");
						break;
					}
					int vA = armenia.getFirmasRecolectadas() - armenia.getFirmasAnuladas();
					int vB = buga.getFirmasRecolectadas() - buga.getFirmasAnuladas();
					int vC = cali.getFirmasRecolectadas() - cali.getFirmasAnuladas();
					double promedio = (vA + vB + vC) / 3.0;
					double dA = Math.abs(vA - promedio);
					double dB = Math.abs(vB - promedio);
					double dC = Math.abs(vC - promedio);
					System.out.print("La ciudad más cerca del promedio de firmas válidas es: ");
					if (dA <= dB && dA <= dC) {
						System.out.println("Armenia");
						System.out.println("Fecha y hora de registro: " + armenia.getFechaRegistro());
					} else if (dB <= dA && dB <= dC) {
						System.out.println("Buga");
						System.out.println("Fecha y hora de registro: " + buga.getFechaRegistro());
					} else {
						System.out.println("Cali");
						System.out.println("Fecha y hora de registro: " + cali.getFechaRegistro());
					}
					break;
				case 9:
					salir = true;
					System.out.println("Saliendo del sistema...");
					break;
				default:
					System.out.println("Opción no válida.");
			}
		}
		sc.close();
	}
}
