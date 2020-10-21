package Model.entidades;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class reserva {

	private Integer rommNamber;
	private Date entrada;
	private Date saida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public reserva(Integer rommNamber, Date entrada, Date saida) {
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
		long diff = entrada.getTime() - saida.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void update(Date entrada, Date saida) {
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
