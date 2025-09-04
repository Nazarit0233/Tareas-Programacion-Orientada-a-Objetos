import java.time.LocalDateTime;
import java.util.Random;

public class Cali {
	private int firmasRecolectadas;
	private String privilegio;
	private int firmasAnuladas;
	private LocalDateTime fechaRegistro;

	public Cali(int firmasRecolectadas, String privilegio) {
		this.firmasRecolectadas = firmasRecolectadas;
		this.privilegio = privilegio;
		this.firmasAnuladas = new Random().nextInt(firmasRecolectadas + 1);
		this.fechaRegistro = LocalDateTime.now();
	}

	public int getFirmasRecolectadas() {
		return firmasRecolectadas;
	}

	public String getPrivilegio() {
		return privilegio;
	}

	public int getFirmasAnuladas() {
		return firmasAnuladas;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	@Override
	public String toString() {
		return "Cali: " + firmasRecolectadas + " firmas, Privilegio: " + privilegio + ", Anuladas: " + firmasAnuladas + ", Fecha: " + fechaRegistro;
	}
}
