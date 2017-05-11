
public class Test{
	public static void main(String[] args){
		
		
		Demineur a = new Demineur();
		a.genereMines();
		a.genereNombres();
		a.afficherChamps();
		a.afficherChampsPlayer();
		a.afficherBoolean();
		a.decouvreMine(1,1);
		a.afficherChamps();
		a.afficherBoolean();
		a.afficherChampsPlayer();

	}
}
