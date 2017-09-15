package logica;

import java.util.ArrayList;

import entidades.Persona;
import datos.DataPersona;

public class CtrlABMCPersona {

	private ArrayList<Persona> personas;
	
	public CtrlABMCPersona(){				
		personas = new ArrayList<Persona>();
		//datapers = new DataPersona();				no me deja
	}
	
	public void add(Persona p)throws Exception{
		//personas.add(p);
		DataPersona datapers = new DataPersona();
		datapers.add(p);
	}
	
	public void delete(Persona p)throws Exception{
		//Persona pEncontrada = this.buscaPersona(p);
		//personas.remove(pEncontrada);	
		DataPersona datapers = new DataPersona();
		datapers.delete(p);
	}
	
	public void update(Persona p)throws Exception{				//mantener id al modificar?
		//Persona pEncontrada = this.buscaPersona(p);
		//personas.remove(pEncontrada);
		//personas.add(p);
		DataPersona datapers = new DataPersona();
		datapers.delete(p);
		datapers.add(p);
				
	}
	
	public Persona consulta(Persona p)throws Exception{			//no muestra id
		Persona pEncontrada = this.buscaPersona(p);
		return pEncontrada;
	}
	
	public Persona buscaPersona(Persona p)throws Exception{
		/*Persona pEncontrada = null;
		for (Persona pActual : personas) {
			if (p.getDni() == pActual.getDni()){
				pEncontrada = pActual;
				break;
			}
		} */
		DataPersona datapers = new DataPersona();
		Persona pEncontrada = datapers.getByDni(p);
		return pEncontrada;
	}
}
