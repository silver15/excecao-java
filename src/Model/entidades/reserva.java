package Model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import Model.excecoes.DominioEntidades;

public class reserva {

	private Integer rommNamber;
	private Date entrada;
	private Date saida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public reserva(Integer rommNamber, Date entrada, Date saida) throws DominioEntidades {
		if (!saida.after(entrada)) {
			throw new DominioEntidades("Error in reservation: Data de saida antes da data de entrada.");
		}
		this.rommNamber = rommNamber;
		this.entrada = entrada;
		this.saida = saida;
	}

	public Integer getRommNamber() {
		return rommNamber;
	}

	public void setRommNamber(Integer rommNamber) {
		this.rommNamber = rommNamber;
	}

	public Date getEntrada() {
		return entrada;
	}

	public Date getSaida() {
		return saida;
	}
	
	public long duracao() {
		long diff = saida.getTime() - entrada.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void update(Date entrada, Date saida) throws DominioEntidades{
		Date now = new Date();
		if (entrada.before(now) || saida.before(now)) {
			throw new DominioEntidades("Error in reservation: Reservation dates for updade must be future");
		}
		if (!saida.after(entrada)) {
			throw new DominioEntidades("Error in reservation: Data de saida antes da data de entrada.");
		}
		this.entrada = entrada;
		this.saida = saida;
	}
	
	@Override
	public String toString() {
		return "Quarto "
				+rommNamber
				+", Entrada: "
				+sdf.format(entrada)
				+", Saida: "
				+sdf.format(saida)
				+", "
				+duracao()
				+" noites";
	}

}
