package uniandes.dpoo.taller4.interfaz;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.formdev.flatlaf.FlatLightLaf;
@SuppressWarnings("serial")
public class IngresarNombre extends JFrame implements ActionListener
{
	//Crean variables que nos van a servir para hacer la interfaz
	JButton boton;
	JTextField texto;
	String nombreJugador;

	public IngresarNombre()
	{
		this.setTitle("Ingresar");
		JLabel nombre = new JLabel("Ingrese su nombre para iniciar el juego");

// crear el boton de jugar
		boton = new JButton("Jugar");
		boton.addActionListener(this);
// crear 16 columnas 
		texto= new JTextField(16);
		texto.addActionListener(this);
// crear un panel para a�adir las opciones y el texto  
		JPanel panel = new JPanel();
		JLabel imagen = new JLabel();
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("./data/logo.png").getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
		imagen.setIcon(imageIcon);
// a�adir los botones y el texto al panel 
		panel.add(imagen);
		panel.add(nombre);
		panel.add(texto);
		panel.add(boton);
// a�adir el panel al frame 
		add(panel);
//decidir el tama�o del frame
		setSize(350, 350);
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == boton)
		{
			nombreJugador = texto.getText();
			new VentanaPrincipal(nombreJugador);
			this.dispose();
		}

	}

	public static void main(String[] args)
	{
		FlatLightLaf.install();
		new IngresarNombre();

	}

}
