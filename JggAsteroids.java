

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JFrame;

// Tabela de cores RGB
//http://erikasarti.net/html/tabela-cores/

// reference: http://seumestredaweb.blogspot.com/2012/06/java-games-2deventos-do-mouse13.html

public class JggAsteroids extends JFrame {
 
	private static final long serialVersionUID = 1L; //Eclipse indicates this long...
 
	BufferedImage background; 
	int FPS = 30;
	int windowWidth = 800;
	int windowHeight = 600;
	int powerHit;
	
	float cont = (float) 1.0;
  
	
	static KeyInput keys;
	static MouseInput mousePad; 
	static JggAsteroids game;

  
	public void update() {	 

	}
 
	public void drawAllGrphics() {
		Graphics g = getGraphics(); 
		Graphics bgg = background.getGraphics();
		bgg.setColor(new Color(0,0,0));
		bgg.fillRect(0, 0, windowWidth, windowHeight); 
   		//bgg.setColor(Color.RED);
		bgg.setFont(new Font("helvica",Font.BOLD,20));
		
		
		
		int posX = 25;
		int posY = 50;		
		int size = 6;
		
		if(cont>=4){cont=1.0f;}
		else{
			
			bgg.setColor(Color.WHITE);
			
			drawFractal(bgg, (int)cont, posX, posY, posX+size, posY-size);
			drawFractal(bgg, (int)cont, posX+size, posY-size, posX+size*2, posY);
			drawFractal(bgg, (int)cont, posX+size*2, posY, posX+size, posY+size);
			drawFractal(bgg, (int)cont, posX+size, posY+size, posX, posY);
			
			posX = 315;
			posY = 219;		
			size = (int) (size/2);
			
			drawFractal(bgg, (int)cont, posX, posY, posX+size, posY-size);
			drawFractal(bgg, (int)cont, posX+size, posY-size, posX+size*2, posY);
			drawFractal(bgg, (int)cont, posX+size*2, posY, posX+size, posY+size);
			drawFractal(bgg, (int)cont, posX+size, posY+size, posX, posY);	
			
			posX = 215;
			posY = 419;		
			size = (int) (size*3);
			
			drawFractal(bgg, (int)cont, posX, posY, posX+size, posY-size);
			drawFractal(bgg, (int)cont, posX+size, posY-size, posX+size*2, posY);
			drawFractal(bgg, (int)cont, posX+size*2, posY, posX+size, posY+size);
			drawFractal(bgg, (int)cont, posX+size, posY+size, posX, posY);
			
			
		cont+=0.3;
		}
		


		//================================================================================== 
		g.drawImage(background, 0, 0, this);
	}
	
	private void drawFractal (Graphics g, int qtdeIterations, int x1, int y1, int x5, int y5){
        int dx, dy, x2, y2, x3, y3, x4, y4;

        if (qtdeIterations == 0){

            g.drawLine(x1, y1, x5, y5);
        }
        else{
              dx = x5 - x1;
              dy = y5 - y1;

              x2 = x1 + dx / 3;
              y2 = y1 + dy / 3;

              x3 = (int) (0.5 * (x1+x5) + Math.sqrt(3) * (y1-y5)/6);
              y3 = (int) (0.5 * (y1+y5) + Math.sqrt(3) * (x5-x1)/6);

              x4 = x1 + 2 * dx /3;
              y4 = y1 + 2 * dy /3;

              drawFractal (g,qtdeIterations-1, x1, y1, x2, y2);
              drawFractal (g,qtdeIterations-1, x2, y2, x3, y3);
              drawFractal (g,qtdeIterations-1, x3, y3, x4, y4);
              drawFractal (g,qtdeIterations-1, x4, y4, x5, y5);
          }
    }

 
	public void init() {
		setTitle("IMPACTA JAVA ASTEROIDS");
		setSize(windowWidth, windowHeight);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
		background = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_INT_RGB);
		
		//========= setting the window position at the middle screen ====================
		Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();                    //|
		Dimension dw = getSize();													   //|
		setLocation((ds.width - dw.width) / 2, (ds.height - dw.height) / 2);           //|
		// ==============================================================================
   
		addKeyListener(keys);
		addMouseListener(mousePad);
		addMouseMotionListener(mousePad);
  
		
		
	}
 
	public void play() {
		init();
		Sound.BACK.play();
		while (true) {
			update();
			drawAllGrphics();
			try {
				Thread.sleep(1000/FPS);
			} catch (Exception e) {
				System.out.println("Thread interrompida!");
			}
		}
	}
 
	public static void main(String[] args) {
		game = new JggAsteroids();
		keys = new KeyInput(game);
		mousePad = new MouseInput(game);
		game.play();
	}
}
   

   
