package marsrover;

import java.util.List;
import java.util.ArrayList;

public class MarsRover{

    public Location position;
    public char puntoCardinal;
    public String movimientos;
   // List <Integer> coordenadasRover = new ArrayList();

    public MarsRover (int x, int y, char puntoCardinal) {
    	//FALTA EXCEPTION DE ALFO NADA QUE VER
   // public MarsRover(int x, int y, char puntoCardinal) {
    	this.puntoCardinal = puntoCardinal;
        position = new Location(x, y);
    }

  // PREGUNTAR:
  //  public Location getPosition() {
  //  	return position;
  // opcion con listas:
  //  	List coordenada1 = coordenadasRover.add(position.x);
  // 	List coordenada2 = coordenada1.add(position.y);
        
  //  }
    
    public int getPositionEjeX() {
    	return position.x;
    }
    
    public int getPositionEjeY() {
    	return position.y;
    }

    public boolean isHeadingNorth() {
        return true;
    }

    public void comandos(String movimientos) {
    	// FALTA EXCEPTION DE UN COMANDO NADA QUE VER
    	// deberiamos hacer la lista finita???
    	
    	for (int comando = 0 ; comando <= movimientos.length(); comando++ ) {
    		if (puntoCardinal == 'N') {
    			if (comando == 'f') {
    				position.y += 1;
    		}
    			if (comando == 'b'){
    				position.y -= 1;
    			}
    			if (comando == 'l'){
    				puntoCardinal = 'O';
    			}
    			if (comando == 'r'){
    				puntoCardinal = 'E';
    			}
    		}
    		
    		if (puntoCardinal == 'S'){
    			
    			if (comando == 'f') {
    				position.y -= 1;
    		}
    			if (comando == 'b'){
    				position.y += 1;
    			}
    			if (comando == 'l'){
    				puntoCardinal = 'E';
    			}
    			if (comando == 'r'){
    				puntoCardinal = 'O';
    			}
    		}
    		
    		if (puntoCardinal == 'E') {
    			
    			if (comando == 'f') {
    				position.x += 1;
    		}
    			if (comando == 'b'){
    				position.x -= 1;
    			}
    			if (comando == 'l'){
    				puntoCardinal = 'N';
    			}
    			if (comando == 'r'){
    				puntoCardinal = 'S';
    			}
    		}
    		
    		if (puntoCardinal == 'O') {
    			
    			if (comando == 'f') {
    				position.x -= 1;
    		}
    			if (comando == 'b'){
    				position.x += 1;
    			}
    			if (comando == 'l'){
    				puntoCardinal = 'S';
    			}
    			if (comando == 'r'){
    				puntoCardinal = 'N';
    			}
    		}		
    			
    		} 
    	}
}

