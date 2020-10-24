package Aplicacao;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import Model.entidades.reserva;
import Model.excecoes.DominioEntidades;

public class Programa {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.println("Numero do Quarto: ");
			int numero = ler.nextInt();
			System.out.println("Data de entrada: ");
			Date entrada = sdf.parse(ler.next());
			System.out.println("Data de saida: ");
			Date saida = sdf.parse(ler.next());

			reserva reserva = new reserva(numero, entrada, saida);
			System.out.println("Reserva: " + reserva);

			System.out.println();
			System.out.println("Entre com a nova data");
			System.out.println("Data de entrada: ");
			entrada = sdf.parse(ler.next());
			System.out.println("Data de saida: ");
			saida = sdf.parse(ler.next());

			reserva.update(entrada, saida);
			System.out.println("Reserva: " + reserva);
			
		} catch (ParseException e) {
			System.out.println("Data Invalida");
			
		}catch (DominioEntidades e) {
		   System.out.println("Errorin Reservation: "+e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Error inexperado.");
		}

		ler.close();

	}

}
