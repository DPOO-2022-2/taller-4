package uniandes.dpoo.taller4.interfaz;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelArriba extends JPanel
{
	private VentanaPrincipal primera; 
	JRadioButton easy;
	JRadioButton medium;
	JRadioButton hard;

	JComboBox<String> cb;

	public PanelArriba(VentanaPrincipal primera)
	{

		this.primera = primera;
		GridLayout layout = new GridLayout(0, 6, 10, 0);
		this.setLayout(layout);

		Border borde = BorderFactory.createTitledBorder("Opciones del juego");
		this.setBorder(borde);

		JLabel tamanio = new JLabel("Tamaño:");
		tamanio.setAlignmentX(LEFT_ALIGNMENT);
		this.add(tamanio);
//crear opciones de tamanio
		String[] opciones = { "4x4", "5x5", "6x6", "7x7", "8x8", "9x9" };
//crear variable para meter las opciones en una caja de la interfaz que pueda ver el usuario
		cb = new JComboBox<String>(opciones);
		cb.setMaximumSize(getPreferredSize());
		cb.setAlignmentX(LEFT_ALIGNMENT);
		cb.addActionListener(primera);

		this.add(cb);

		JLabel dificultadLbl = new JLabel("Dificultad:");
		this.add(dificultadLbl);
// La dificultad es facil por default
		easy = new JRadioButton("Fácil", true); 
		medium = new JRadioButton("Medio", false);
		hard = new JRadioButton("Difícil", false);
		
		ButtonGroup group = new ButtonGroup();
		group.add(easy);
		group.add(medium);
		group.add(hard);

		easy.addActionListener(primera);
		medium.addActionListener(primera);
		hard.addActionListener(primera);
//añadir las dificultades
		this.add(easy);
		this.add(medium);
		this.add(hard);
	}

}
