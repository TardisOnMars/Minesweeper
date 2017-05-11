
public class Test{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		Demineur a = new Demineur();

		a.genereMines();
		a.genereNombres();
		System.out.println();
		a.afficherChamps();
		
		while (true){
			System.out.println("Donnez 2 entiers delimite par un espace");
			
			//String s1 = s.substring(0, 1);
			//String s2 = s.substring(3, 5);
			
			int i = sc.nextInt();
			int j = sc.nextInt();
			
			a.decouvreMine(i,j);
			a.afficherChampsBoolean();
		}
	}
}
