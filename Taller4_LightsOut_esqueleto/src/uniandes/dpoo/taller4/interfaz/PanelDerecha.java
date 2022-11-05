package uniandes.dpoo.taller4.interfaz;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class PanelDerecha extends JPanel
{

	private VentanaPrincipal primera;

	JButton Nuevo;
	JButton Reiniciar;
	JButton Top_10;
	JButton CambiarJugador;

	public PanelDerecha(VentanaPrincipal primera)
	{

		this.primera = primera;
		GridLayout layout = new GridLayout(4, 1, 1, 1);
		this.setLayout(layout);
		Border border = BorderFactory.createTitledBorder("Menu");
		this.setBorder(border);
//Buscamos los .png de las imagenes que vamos a usar en la interfaz
		ImageIcon nuevoImage = new ImageIcon(new ImageIcon("./data/nuevo.png").getImage().getScaledInstance(200, 112, Image.SCALE_DEFAULT));
		Nuevo = new JButton();
		Nuevo.setIcon(nuevoImage);
		ImageIcon reiniciarImage = new ImageIcon(new ImageIcon("./data/reiniciar.png").getImage().getScaledInstance(200, 112, Image.SCALE_DEFAULT));
		Reiniciar = new JButton();
		Reiniciar.setIcon(reiniciarImage);
		ImageIcon top10Image = new ImageIcon(new ImageIcon("./data/top10.png").getImage().getScaledInstance(200, 112, Image.SCALE_DEFAULT));
		Top_10 = new JButton();
		Top_10.setIcon(top10Image);
		ImageIcon cambiarJugadorImage = new ImageIcon(new ImageIcon("./data/cambiarJugador.png").getImage().getScaledInstance(200, 112, Image.SCALE_DEFAULT));
		CambiarJugador = new JButton();
		CambiarJugador.setIcon(cambiarJugadorImage);

		Nuevo.addActionListener(primera);
		CambiarJugador.addActionListener(primera);
		Reiniciar.addActionListener(primera);
		Top_10.addActionListener(primera);
//añadirlos
		this.add(Nuevo);
		this.add(Reiniciar);
		this.add(Top_10);
		this.add(CambiarJugador);
	}

}
