package com.company;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.text.NumberFormat;



public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int opc;
        String vendedor, vendMay=" ", vendMen= " ";
        int contV=0;
        double mayor=0, menor=0;
        double venta, ventaM=0, promMensual=0;
        NumberFormat num = new DecimalFormat("#0.00");

        ArrayList lista = new ArrayList<String>();

        while (true) {
            System.out.println("\n\nMe Quede SA");
            System.out.println("1. Ingresar Venta");
            System.out.println("2. Ver Venta Mensual Total");
            System.out.println("3. Ver Estadisticas");
            System.out.println("4. Cumplimiento de Meta");
            System.out.println("5. Salir");
            System.out.print("OPCION: ");
            try {
                opc = Integer.parseInt(br.readLine());
            } catch (IOException e) {
                opc = 0;
            } catch (NumberFormatException e) {
                opc = 0;
            }

            switch(opc) {
                case 1:

                    System.out.println("Vamos a Ingresar un Vendedor");
                    while (true) {
                        System.out.print("Vendedor: ");
                        try {
                            vendedor = br.readLine();
                        } catch (IOException e) {
                            vendedor = null;
                            System.out.println("ERROR:: Nombre de Vendedor Invalido");
                            System.exit(-1);
                        }
                        System.out.print ("Venta: ");
                        try {
                            venta = Double.parseDouble(br.readLine());
                            ventaM += venta;
                            contV = contV + 1;
                        } catch (IOException e) {
                            venta = 0.0;
                            System.out.println("ERROR:: Monto de Venta Invalido");
                            System.exit(-1);
                        }
                        if (mayor < venta) {
                            mayor = venta;
                            vendMay = vendedor;
                        }else {
                            menor = venta;
                            vendMen = vendedor;
                        }

                        promMensual = ventaM /contV;
                        if (vendedor != "" && venta != 0) {
                            break;
                        }
                    }

                    lista.add(vendedor);
                    break;
                case 2:
                    System.out.println("La Venta Mensual Total es: " + ventaM);
                    break;

                case 3:
                    System.out.println("MAYOR VENTA: " + vendMay + " fue de " + num.format(mayor) );
                    System.out.println("MENOR VENTA: " + vendMen + " fue de " + num.format(menor));
                    System.out.println("VENTA PROMEDIO: " + num.format(promMensual));
                    break;
                case 4:
                    if (ventaM > 100000) {
                        System.out.println("MEQUEDE, SA CUMPLIO");
                    } else {
                        System.out.println("MEQUEDE, SA NO CUMPLIO");
                    }
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("ERROR::Opcion invalida!");
                    break;
            }
        }

    }
}