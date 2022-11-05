package uniandes.dpoo.taller4.interfaz;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.ButtonGroup;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.awt.event.ActionListener;
import java.awt.GridLayout;


public class VentanaFinal extends JFrame implements ActionListener
{
	private VentanaPrincipal ventana;
	JButton inicio;
	JButton salir;
//crear ventana final
	public VentanaFinal(int jugadas, int puntaje, VentanaPrincipal ventana)
	{
		this.ventana = ventana;
		this.setTitle("Fin del juego!");
		GridLayout layout = new GridLayout(10,5);
		setLayout(layout);
		JLabel texto1 = new JLabel("Ganaste");
		JLabel texto2 = new JLabel("Ha terminado el juego en: " + jugadas + " jugada(s)! :O");
		JLabel texto3 = new JLabel("Su puntaje ha sido: " + puntaje + " punto(s)! :)");
		inicio = new JButton("Volver a iniciar");
		inicio.setMinimumSize(new Dimension(300, 100));
		inicio.addActionListener(this);
		salir = new JButton("Finalizar");
		salir.setMinimumSize(new Dimension(300, 100));
		salir.addActionListener(this);
		JPanel panel = new JPanel();
		panel.setLayout( new FlowLayout());
		panel.add(inicio);
		panel.add(salir);
		add(texto1);
		add(texto2);
		add(texto3);
		add(panel);
		setSize(400, 400);
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == inicio)
		{
			new IngresarNombre();
			this.dispose();
			try
			{
				this.ventana.salvarTop10();
			} catch (FileNotFoundException | UnsupportedEncodingException e1)
			{
				e1.printStackTrace();
			}
			this.ventana.dispose();
		}
		else if(e.getSource()==salir)
		{
			try
			{
				this.ventana.salvarTop10();
			} catch (FileNotFoundException | UnsupportedEncodingException e1)
			{
				e1.printStackTrace();
			}
			System.exit(0);
			this.dispose();
		}
	}
}
