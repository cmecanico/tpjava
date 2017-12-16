package logica;

import java.util.ArrayList;

import entidades.Persona;
import datos.DataPersona;

public class CtrlABMCPersona {

	private ArrayList<Persona> personas;
	
	public CtrlABMCPersona(){				
		personas = new ArrayList<Persona>();
	}
	
	public boolean getLogin(String usuario, String contrasenia) throws Exception{
		DataPersona datapers = new DataPersona();
		return datapers.getLogin(usuario, contrasenia);
	}
	
	public void add(Persona p)throws Exception{
		DataPersona datapers = new DataPersona();
		datapers.add(p);
	}
	
	public void delete(Persona p)throws Exception{
		DataPersona datapers = new DataPersona();
		datapers.delete(p);
	}
	
	public void update(Persona p)throws Exception{				
		DataPersona datapers = new DataPersona();
		datapers.delete(p);
		datapers.add(p);
				
	}
	
	public Persona consulta(Persona p)throws Exception{			
		Persona pEncontrada = this.buscaPersona(p);
		return pEncontrada;
	}
	
	public Persona buscaPersona(Persona p)throws Exception{
		DataPersona datapers = new DataPersona();
		Persona pEncontrada = datapers.getByDni(p);
		return pEncontrada;
	}
}
