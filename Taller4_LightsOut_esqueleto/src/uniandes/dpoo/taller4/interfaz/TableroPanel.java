package uniandes.dpoo.taller4.interfaz;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import uniandes.dpoo.taller4.modelo.Tablero;

@SuppressWarnings("serial")
public class TableroPanel extends JPanel implements MouseListener
{
//llama a la ventana Principal
	private VentanaPrincipal primera;
//crea cantidades
    private int[][] cantidades;
//crea variable de lo largo del tablero
    private int largo;
// crea tablero
    private boolean[][] tablero;
//crea cantidad de jugadas
    public int cantidadJugadas;



    public TableroPanel(VentanaPrincipal primera){
//crea tablero del panel y se decide el tamanio
        setSize(700,700);
        this.primera = primera;
        this.addMouseListener(this);
    }

    public void nuevoPanel(Tablero tableroC){
  //cada panel nuevo
        this.removeAll();
        this.tablero = tableroC.darTablero();
        this.largo = tablero.length;
        this.cantidades = new int[largo][largo];
        cantidadJugadas = 1;
        GridLayout l = new GridLayout(largo,largo);
        setLayout(l);
        actulizarPanel();
    }
//en esta función buscamos pintar y hacer el panel del juego basicamente.
    public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2d = (Graphics2D) g;
            int la = Math.min(this.getWidth()/largo, this.getHeight()/largo);
            int ancho = (getWidth()-la*largo)/2;
            int alto = (getHeight()-la*largo)/2;
            for (int i = 0; i < largo; i++) {
                int anchx = ancho;
                for (int ii = 0; ii < largo; ii++) {
                    GradientPaint gp;
                    Color colorT;
                    if (tablero[i][ii]) {
                        gp = new GradientPaint(anchx, alto, Color.MAGENTA, anchx + la, alto + la, Color.ORANGE);
                        colorT = Color.BLACK;
                    }else{
                        gp = new GradientPaint(anchx, alto, Color.BLUE, anchx + la, alto + la, Color.BLACK);
                        colorT = Color.WHITE;
                    }
                    g2d.setPaint(gp);
                    g2d.fillRoundRect(anchx,alto,la,la,20,20);
                    g2d.setColor(colorT);
                    g2d.drawString(String.valueOf(cantidades[i][ii]),anchx +(int)(la*0.1),alto+(int)(la*0.1));

                    anchx += la;
                }
                alto += la;
            }
        }
    public void actulizarPanel(){
        repaint();
    }
@Override
    public void mouseClicked(MouseEvent click) {
         int click_x = click.getX();
         int click_y = click.getY();
         int[] casilla = convertirCoordenadasACasilla(click_x, click_y);

         cantidades[casilla[0]][casilla[1]]++;
         primera.Jugar(casilla[0], casilla[1]);
         cantidadJugadas +=1;
         
         repaint();
    }
	private int[] convertirCoordenadasACasilla(int x, int y)
	{
		int ladoTablero = tablero.length; int altoPanelTablero = getHeight(); int anchoPanelTablero = getWidth();
		int altoCasilla = altoPanelTablero / ladoTablero; int anchoCasilla = anchoPanelTablero / ladoTablero; int fila = (int) (y / altoCasilla);
		int columna = (int) (x / anchoCasilla);
		return new int[] { fila, columna };
	}
	@Override
	public void mousePressed(MouseEvent click) {
	}
	@Override
	public void mouseReleased(MouseEvent click) {
	}
	@Override
	public void mouseEntered(MouseEvent click) {
	}
	@Override
	public void mouseExited(MouseEvent click) {	
	}
}
