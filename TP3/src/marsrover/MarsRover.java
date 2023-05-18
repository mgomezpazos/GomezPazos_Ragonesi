package marsrover;

import java.util.List;
import java.util.ArrayList;

public class MarsRover{

    public Location position;
    public String movimientos;

    public MarsRover (int x, int y, char puntoCardinal) {
        position = new Location(x, y, puntoCardinal);
    }

  // PREGUNTAR:
  //  public Location getPosition() {
  //  	return position;
  // opcion con listas:
  //  	List coordenada1 = coordenadasRover.add(position.x);
  // 	List coordenada2 = coordenada1.add(position.y);
        
  //  }
    
    public boolean checkCoordinates(Location location) {
		if (this.position.x == location.x && this.position.y == location.y && this.position.puntoCardinal == location.puntoCardinal) {
			return true;
		}
		return false;
	}

    
//    public int getPositionEjeX() {
//    	return position.x;
//    }
//    
//    public int getPositionEjeY() {
//    	return position.y;
//    }

//    public boolean isHeadingNorth() {
//        return true;
//    }

    public void comandos(String movimientos) {
    	// FALTA EXCEPTION DE UN COMANDO NADA QUE VER
    	// deberiamos hacer la lista finita???
    	
    	for (int comando = 0 ; comando <= (movimientos.length() - 1 ); comando++ ) {
    		
    		char move = movimientos.charAt(comando);
            if (move != 'f' && move != 'b' && move != 'l' && move != 'r') {
                throw new RuntimeException("Comando inválido: " + move);
            }

    		if (position.puntoCardinal == 'N') {
    			if (movimientos.charAt(comando) == 'f'){
    				position.y += 1;
    			}
    			if (movimientos.charAt(comando) == 'b'){
    				position.y -= 1;
    			}
    			if (movimientos.charAt(comando) == 'l'){
    				position.puntoCardinal = 'O';
    			}
    			if (movimientos.charAt(comando) == 'r'){
    				position.puntoCardinal = 'E';
    			}
    		}
    		
    		else if (position.puntoCardinal == 'S'){
    			
    			if (movimientos.charAt(comando) == 'f') {
    				position.y -= 1;
    		}
    			if (movimientos.charAt(comando) == 'b'){
    				position.y += 1;
    			}
    			if (movimientos.charAt(comando) == 'l'){
    				position.puntoCardinal = 'E';
    			}
    			if (movimientos.charAt(comando) == 'r'){
    				position.puntoCardinal = 'O';
    			}
    		}
    		
    		else if (position.puntoCardinal == 'E') {
    			
    			if (movimientos.charAt(comando) == 'f') {
    				position.x += 1;
    		}
    			if (movimientos.charAt(comando) == 'b'){
    				position.x -= 1;
    			}
    			if (movimientos.charAt(comando) == 'l'){
    				position.puntoCardinal = 'N';
    			}
    			if (movimientos.charAt(comando) == 'r'){
    				position.puntoCardinal = 'S';
    			}
    		}
    		
    		else if (position.puntoCardinal == 'O') {
    			
    			if (movimientos.charAt(comando) == 'f') {
    			//if (comando == 'f') {
    				position.x -= 1;
    		}
    			if (movimientos.charAt(comando) == 'b'){
    				position.x += 1;
    			}
    			if (movimientos.charAt(comando) == 'l'){
    				position.puntoCardinal = 'S';
    			}
    			if (movimientos.charAt(comando) == 'r'){
    				position.puntoCardinal = 'N';
    			}
    		}		
    		
    		} 
    	}
}

