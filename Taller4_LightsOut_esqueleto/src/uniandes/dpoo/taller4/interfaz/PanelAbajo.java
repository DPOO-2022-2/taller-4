package uniandes.dpoo.taller4.interfaz;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

@SuppressWarnings("serial")
//Se va poner en el panel de abajo la cantidad de jugadas y el nombre del jugador
public class PanelAbajo extends JPanel
{
	private VentanaPrincipal primera;
//crear variables para cantidad jugadas y el nombre dado
	JLabel cantidadJugadas;
	JLabel nombreJugador;

	public PanelAbajo(VentanaPrincipal primera)
	{
		this.primera = primera;
		GridLayout layout = new GridLayout(0, 5, 10, 0);
		this.setLayout(layout);
		Border borderPrincipal = BorderFactory.createTitledBorder("Actividades del juego");
		this.setBorder(borderPrincipal);
		Border border = BorderFactory.createLineBorder(Color.BLUE, 2);
		JLabel jugadasLabel = new JLabel("Jugadas hechas");
		add(jugadasLabel);
		cantidadJugadas = new JLabel("0");
		cantidadJugadas.setBorder(border);
		add(cantidadJugadas);
		JLabel jugadorLabel = new JLabel("Jugador");
		add(jugadorLabel);
		nombreJugador = new JLabel("Null");
		nombreJugador.setBorder(border);
		add(nombreJugador);
	}
}
