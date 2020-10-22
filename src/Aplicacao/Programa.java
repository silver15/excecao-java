package Aplicacao;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import Model.entidades.reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Scanner ler = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Numero do Quarto: ");
		int numero = ler.nextInt();
		System.out.println("Data de entrada: ");
		Date entrada = sdf.parse(ler.next());
		System.out.println("Data de saida: ");
		Date saida = sdf.parse(ler.next());

		if (!saida.after(entrada)) {
			System.out.println("Error - Entrada maior do que a saida: ");
		} else {
			reserva reserva = new reserva(numero, entrada, saida);
			System.out.println("Reserva: " + reserva);

			System.out.println();
			System.out.println("Entre com a nova data");
			System.out.println("Data de entrada: ");
			entrada = sdf.parse(ler.next());
			System.out.println("Data de saida: ");
			saida = sdf.parse(ler.next());

			
				String error = reserva.update(entrada, saida);
				
				if(error!=null) {
					System.out.println("Error in Reservation: "+reserva);
				}
				else {
					
					System.out.println("Reserva: " + reserva);
			}

		}
		ler.close();

	}
}
