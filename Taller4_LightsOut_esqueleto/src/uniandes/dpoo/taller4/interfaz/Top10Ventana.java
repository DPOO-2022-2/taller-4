package uniandes.dpoo.taller4.interfaz;
import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Top10;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


@SuppressWarnings("serial")
public class Top10Ventana extends JFrame
{
	Top10 Top10 = null;

	boolean esVisible = false;

	public Top10Ventana(Top10 cola)
	{
		this.Top10 = cola;
		setTitle("Top 10");
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setSize(150, 300);
//Window listener para cuando se cierre la ventana 
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent click)
			{
				changeVisibility(); 
			}
		});
// Panel principal
		JPanel panel = new JPanel();

		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
// Panel para el header
		JPanel headerPanel = new JPanel();
		headerPanel.setLayout(new GridLayout(1, 1, 0, 0));
// El Header
		JLabel header = new JLabel();
		ImageIcon imageIcon = new ImageIcon(new ImageIcon ("./data/TOP 10.png").getImage().getScaledInstance(300, 100, Image.SCALE_DEFAULT));
		header.setIcon(imageIcon);
		header.setVisible(true);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		headerPanel.add(header);
		panel.add(headerPanel);
// Lista del 10
		String lista10 = "";
		int contador = 1;
		for (RegistroTop10 i : Top10.darRegistros())
		{
			lista10 += contador + "    ";
			lista10 += i.darNombre() + "    ";
			lista10 += i.darPuntos();
			lista10 += ",";
			contador++;
		}
		String[] arrayLista = lista10.split(",");

		JList<String> listaTop10 = new JList<String>(arrayLista);
		listaTop10.setVisibleRowCount(10);
		DefaultListCellRenderer renderer = (DefaultListCellRenderer) listaTop10.getCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);

		listaTop10.setFixedCellHeight(20);
		JScrollPane scrollPane = new JScrollPane(listaTop10);
		scrollPane.setPreferredSize(new Dimension(100, 100));
		panel.add(scrollPane);
		add(panel);
		pack();
		setLocationRelativeTo(null);
//No se deberia ver al inicio
		setVisible(esVisible); 
		this.revalidate();
	}
	public void changeVisibility()
	{
		this.esVisible = !esVisible;
		this.setVisible(esVisible);
	}

}
