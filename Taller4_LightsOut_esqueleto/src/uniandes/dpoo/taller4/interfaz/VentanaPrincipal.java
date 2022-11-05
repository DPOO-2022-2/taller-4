package uniandes.dpoo.taller4.interfaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame implements ActionListener
{
	private Tablero tablero;
	/**
	 * Empieza la ejecución de la aplicación
	 * 
	 * @param args
	 */

	PanelArriba elDeArriba;
	PanelAbajo elDeAbajo;
	PanelDerecha elDeLaDerecha;
	TableroPanel izquierda;

	JButton Nuevo;
	JButton Reiniciar;
	JButton Top_10;
	JButton CambiarJugador;

	JRadioButton easy;
	JRadioButton medium;
	JRadioButton hard;

	JComboBox<String> cb;
	Integer size = 4;
	Integer dificultad = 1; // TODO: Ajustar dificultad antes de la última entrega

	Top10Ventana ventanaTop10;
	static Top10 top10;
	JLabel cantidadJugadas;

	/*
	 * CONSTRUCTOR
	 */
	public VentanaPrincipal(String nombreJugador)
	{
		tablero = new Tablero(size);
		setLayout(new BorderLayout());
		pack();
		setTitle("Lights Out");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(true);

		setSize(800, 700);

		/*
		 * Window listener para cuando se cierre la ventana.
		 */
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				try
				{
					salvarTop10();
				} catch (FileNotFoundException e1)
				{
					System.err.println("\nNo se encontró el archvio.\n");
					e1.printStackTrace();
				} catch (UnsupportedEncodingException e1)
				{
					System.err.println("\nUnsupportedEncoding!\n");
					e1.printStackTrace();
				}
			}
		});

//cargan los TOP-10 y crea ventana del mismo
		top10 = new Top10();
		this.cargarTop10();
		ventanaTop10 = new Top10Ventana(top10);

		// Panel de arriba
		elDeArriba = new PanelArriba(this);
		add(elDeArriba, BorderLayout.NORTH);

		elDeAbajo = new PanelAbajo(this);
		elDeAbajo.nombreJugador.setText(nombreJugador);
		add(elDeAbajo, BorderLayout.SOUTH);

		elDeLaDerecha = new PanelDerecha(this);
		add(elDeLaDerecha, BorderLayout.EAST);

		izquierda = new TableroPanel(this);

		add(izquierda, BorderLayout.CENTER);

		int PanelX = (getWidth() - izquierda.getWidth() - getInsets().left - getInsets().right) / 2;
		int PanelY = (getHeight() - izquierda.getHeight() - getInsets().top - getInsets().bottom) / 2;

		izquierda.setLocation(PanelX, PanelY);

		setLocationRelativeTo(null);
		setVisible(true);

		nuevoJuego();

	}

	/**
	 * Se inicia un nuevo juego.
	 */

	public void nuevoJuego()
	{

		elDeAbajo.cantidadJugadas.setText("0");
		tablero = new Tablero(size);
		tablero.desordenar(dificultad);
		izquierda.nuevoPanel(tablero);

	}

	/**
	 * Se cargan los top 10 del archivo en data.
	 */
	public void cargarTop10()
	{
		String dataDirectory = System.getProperty("user.dir") + "/data/top10.csv";
		File archivoFile = new File(dataDirectory);
		top10.cargarRecords(archivoFile);
	}

	/**
	 * Se guarda el top10 en el CSV.
	 * 
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	@SuppressWarnings("static-access")
	public void salvarTop10() throws FileNotFoundException, UnsupportedEncodingException
	{
		String dataDirectory = System.getProperty("user.dir") + "/data/top10.csv";
		File archivoFile = new File(dataDirectory);
		this.top10.salvarRecords(archivoFile);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{

		// Botones panel de la derecha

		Nuevo = elDeLaDerecha.Nuevo;
		Reiniciar = elDeLaDerecha.Reiniciar;
		Top_10 = elDeLaDerecha.Top_10;
		CambiarJugador = elDeLaDerecha.CambiarJugador;

		// Botones panel de arriba

		easy = elDeArriba.easy;
		medium = elDeArriba.medium;
		hard = elDeArriba.hard;

		cb = elDeArriba.cb;

		// Panel de la derecha

		if (e.getSource() == Nuevo)
		{
			nuevoJuego();
		}

		else if (e.getSource() == Reiniciar)
		{
			tablero.reiniciar();
			izquierda.nuevoPanel(tablero);
			elDeAbajo.cantidadJugadas.setText("0");
		}

		else if (e.getSource() == Top_10)
		{
			ventanaTop10.changeVisibility();
		}

		else if (e.getSource() == CambiarJugador)
		{
			new IngresarNombre();
		}

		// Panel de arriba

		else if (e.getSource() == easy)
		{
			dificultad = 3;
			nuevoJuego();
		}

		else if (e.getSource() == medium)
		{
			dificultad = 5;
			nuevoJuego();
		}

		else if (e.getSource() == hard)
		{
			dificultad = 7;
			nuevoJuego();
		}

		else if (e.getSource() == cb)
		{
			String selectedSize = (String) cb.getSelectedItem();
			if (selectedSize.equals("4x4"))
			{
				size = 4;
				nuevoJuego();
			}

			else if (selectedSize.equals("5x5"))
			{
				size = 5;
				nuevoJuego();
			}

			else if (selectedSize.equals("6x6"))
			{
				size = 6;
				nuevoJuego();
			}

			else if (selectedSize.equals("7x7"))
			{
				size = 7;
				nuevoJuego();
			}

			else if (selectedSize.equals("8x8"))
			{
				size = 8;
				nuevoJuego();
			}

			else if (selectedSize.equals("9x9"))
			{
				size = 9;
				nuevoJuego();
			}

		}

	}

	public void Jugar(int i, int j)
	{
		tablero.jugar(i, j);
		Integer cantidad = izquierda.cantidadJugadas;
		elDeAbajo.cantidadJugadas.setText(cantidad.toString());

		int puntaje = tablero.calcularPuntaje();
		int jugadas = Integer.parseInt(elDeAbajo.cantidadJugadas.getText());

		if (tablero.tableroIluminado() == true)
		{
			if (top10.esTop10(puntaje))
			{
				top10.agregarRegistro(elDeAbajo.nombreJugador.getText(), puntaje);
			}
			new VentanaFinal(jugadas, puntaje, this);
		}

	}

}
