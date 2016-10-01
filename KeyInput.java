

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener{
	
	JggAsteroids game = new JggAsteroids();
	
	public KeyInput(JggAsteroids game){
		this.game = game;
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		 switch(e.getKeyCode())
		 {
		 	case KeyEvent.VK_R ://game.balls[0].posX = 200;	//game.balls[0].posY = 200; 
		 		break;
		 		
		 	case KeyEvent.VK_LEFT:
		 		
		 		break;		
		 		
		 	case KeyEvent.VK_RIGHT:
		 		
		 		break;	
		 		
		 	case KeyEvent.VK_UP:	
		 		break;	
		 		
		 	case KeyEvent.VK_DOWN:
		 		break;	
		 		
		 	case KeyEvent.VK_SPACE:
				
				break;
	     }
	}

	@Override
	public void keyReleased(KeyEvent e) {	}

	@Override
	public void keyTyped(KeyEvent e) {	}

}


