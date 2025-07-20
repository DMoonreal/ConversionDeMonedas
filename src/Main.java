import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Elige la Función que quieras");
            System.out.println("1) Dólar =>> Peso Argentino");
            System.out.println("2) Peso Argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real Brasileño");
            System.out.println("4) Real Brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso Colombiano");
            System.out.println("6) Peso Colombiano =>> Dólar");
            System.out.println("7) Salir\n");

            opcion = lectura.nextInt();
            ConsultaApi consultaApi = new ConsultaApi();
            System.out.println("Cuanto vas a covertir");
            double amount = lectura.nextDouble();
            switch (opcion) {
                case 1 -> {
                    Conversion conversion = consultaApi.getConversion("USD", "ARS", amount);
                    System.out.printf("💱 %.2f USD equivalen a %.2f ARS%n", (double) amount, conversion.conversion_result());
                }
                case 2 -> {
                    Conversion conversion = consultaApi.getConversion("ARS", "USD", amount);
                    System.out.printf("💱 %.2f ARS equivalen a %.2f USD%n", (double) amount, conversion.conversion_result());
                }
                case 3 -> {
                    Conversion conversion = consultaApi.getConversion("USD", "BRL", amount);
                    System.out.printf("💱 %.2f USD equivalen a %.2f BRL%n", (double) amount, conversion.conversion_result());
                }
                case 4 -> {
                    Conversion conversion = consultaApi.getConversion("BRL", "USD", amount);
                    System.out.printf("💱 %.2f BRL equivalen a %.2f USD%n", (double) amount, conversion.conversion_result());
                }
                case 5 -> {
                    Conversion conversion = consultaApi.getConversion("USD", "COP", amount);
                    System.out.printf("💱 %.2f USD equivalen a %.2f COP%n", (double) amount, conversion.conversion_result());
                }
                case 6 -> {
                    Conversion conversion = consultaApi.getConversion("COP", "USD", amount);
                    System.out.printf("💱 %.2f COP equivalen a %.2f USD%n", (double) amount, conversion.conversion_result());
                }
                case 7 -> System.out.println("👋 Saliendo del programa...");
                default -> System.out.println("❌ Opción inválida.");
            }
        } while (opcion != 7);
    }
}
