import java.util.*;

public class Demineur{
	int[][] tab;
	int taille = 12;
	boolean[][] tab2;
	boolean[][] drap;
	
	public Demineur(){ //Constructeur avec le tableau de nombres, le tableau de cases ouvertes et le tableau de drapeaux
		tab = new int[taille][taille];
		for (int i=0; i<taille; i++) {
			for (int j=0; j<taille; j++) {
				tab[i][j] = 1;
			}
		}
		tab2 = new boolean[taille][taille];
		for (int i=0; i<taille; i++) {
			for (int j=0; j<taille; j++) {
				tab2[i][j] = false;
			}
		}
		drap = new boolean[taille][taille];
		for (int i=0; i<taille; i++) {
			for (int j=0; j<taille; j++) {
				drap[i][j] = false;
			}
		}
	}
	
	public void afficherChamps(){ //Méthode inutilisée en pratique, mais permet de voir les nombres (mines et mines autour
		
		for (int i=0; i<taille; i++) {
			for (int j=0; j<taille; j++) {
				System.out.print(tab[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void afficherChampsBoolean(){ //Méthode d'affichage dans le tableur du plateau de jeu
		int cpt = 0;
		int cpt2 = 1;
		
		for (int i=-1; i<taille; i++) {
			for (int j=-1; j<taille; j++) {
				if(i==-1){
					if(j!=-1 && j!=9 && j!=10 && j!=11 && j!=12){
						System.out.print(cpt+"  ");
						cpt++;
					}else if(j==11){
						System.out.println(cpt);
					}else if(j==-1){
						System.out.print(cpt+"    ");
						cpt++;
					}else{
						System.out.print(cpt+" ");
						cpt++;
					}
				}
				
				if(j==-1 && i!=-1){
					if(i!=9 && i!=10 && i!=11 && i!=12){
						System.out.print(cpt2+"    ");
						cpt2++;
					}else{
						System.out.print(cpt2+"   ");
						cpt2++;
					}
				}
					
				if (i!=-1 && j!=-1 && drap[i][j] == false){
					if (tab2[i][j] == false){
					System.out.print("X" + "  ");
					}
					if (tab2[i][j] == true){
					System.out.print(tab[i][j] + "  ");
					}
				}
				if (i!=-1 & j!=-1 && drap[i][j]==true){
					System.out.print("D" + "  ");
					if (tab2[i][j] == true){
					System.out.print(tab[i][j] + "  ");
					}
				}
			}
			System.out.println();
		}
	}
	
	public void demandeDrap(){ //Méthode demandant la pose d'un drapeau
		
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Voulez-vous poser un drapeau ? ( y / n )");
		String answer = sc2.nextLine();
		if(answer.equals("y")){
				
			System.out.println("Donnez les coordonnées du drapeau");
	
			System.out.println("Donnez la ligne (1 à "+taille+")");
			int a = sc.nextInt()-1;

			while(a<0 || a>11){
				System.out.println("Donnez la ligne (1 à "+taille+")");
				a = sc.nextInt()-1;
			}
				
				System.out.println("Donnez la colonne (1 à "+taille+")");
			int b = sc.nextInt()-1;
		
			while(b<0 || b>11){
				System.out.println("Donnez la colonne (1 à "+taille+")");
				b = sc.nextInt()-1;
			}
				
			drap[a][b]=true;
			afficherChampsBoolean();
			demandeDrap();
		}
	}
		
	public void decouvreMine(int i, int j){ //Méthode permettant de découvrir les mines
		
		if (tab2[i][j] == false && tab[i][j] != 0 && tab[i][j] != 9){
			tab2[i][j] = true;
			
		}else if (tab[i][j] == 9){
			tab2[i][j] = true;
			
		}else if(tab2[i][j] == false && tab[i][j] == 0){
			
			//open the adjacents
			
			
				if (i == 0 && j== 0 && tab[i][j] != 9) { //left up
					tab2[i][j] = true;
					for (int k=0; k<2; k++) {
						for (int l=0; l<2; l++) {
								decouvreMine(k,l);
						}
					}
				}
				if (i == taille-1 && j== 0 && tab[i][j] != 9) { // down left
					tab2[i][j] = true;
					for (int k=i-1; k<=i; k++) {
						for (int l=0; l<2; l++) {
								decouvreMine(k,l);
						}
					}
				}
				if (i == 0 && j== taille-1 && tab[i][j] != 9) { // up right
					tab2[i][j] = true;
					for (int k=0; k<=1; k++) {
						for (int l=j-1; l<=j; l++) {
								decouvreMine(k,l);
						}
					}
				}				
				if (i == taille-1 && j== taille-1 && tab[i][j] != 9) { // down right
					tab2[i][j] = true;
					for (int k=i-1; k<=i; k++) {
						for (int l=j-1; l<=j; l++) {
								decouvreMine(k,l);
						}
					}
				}
				if (i == 0 && j!=0 && j!= taille-1 && tab[i][j] != 9) { // 1 line
					tab2[i][j] = true;
					for (int k=0; k<=1; k++) {
						for (int l=j-1; l<=j+1; l++) {
								decouvreMine(k,l);
						}
					}
				}
				if (i == taille -1 && j!=0 && j!= taille-1 && tab[i][j] != 9) { // last line
					tab2[i][j] = true;
					for (int k=i-1; k<=i; k++) {
						for (int l=j-1; l<=j+1; l++) {
								decouvreMine(k,l);
						}
					}
				}
				if (i != 0 && j==0 && i!= taille-1 && tab[i][j] != 9) { // 1 row
					tab2[i][j] = true;
					for (int k=i-1; k<=i+1; k++) {
						for (int l=j; l<=j+1; l++) {
								decouvreMine(k,l);
						}
					}
				}
				if (i != 0 && j==taille-1 && i!= taille-1 && tab[i][j] != 9) { // last row
					tab2[i][j] = true;
					for (int k=i-1; k<=i+1; k++) {
						for (int l=j-1; l<=j; l++) {
								decouvreMine(k,l);
							}	
						}
					
				}
				else if(i!=0 && i!= taille-1 && j!=0 && j!= taille-1 && tab[i][j] != 9){
					tab2[i][j] = true;
					for (int k=i-1; k<=i+1; k++) {
						for (int l=j-1; l<=j+1; l++) {
								decouvreMine(k,l);
						}	
					}
				}	
		}
	}	
	
	public void genereMines (int k, int l){ //Méthode permettant de générer les mines
		
		double ratio = 1/6.0;
		for (int i=0; i<taille; i++) {
			for (int j=0; j<taille; j++) {
				if (Math.random() <= 0.2) {
					tab[i][j] = 9;
				}
			}
		}
		if (k == 0 && l== 0) { //left up
			for (int i=0; i<2; i++) {
				for (int j=0; j<2; j++) {
					tab[i][j]=0;
				}
			}
		}
		if (k == taille-1 && l== 0) { // down left
			for (int i=taille-2; i<taille; i++) {
				for (int j=0; j<2; j++) {
					tab[i][j]=0;
				}
			}
		}
		if (k == 0 && l== taille-1) { // up right
			for (int i=0; i<2; i++) {
				for (int j=taille-2; j<taille; j++) {
					tab[i][j]=0;
				}
			}
		}
				
		if (k == taille-1 && l== taille-1) { // down right
			for (int i=taille-2; i<taille; i++) {
				for (int j=taille-2; j<taille; j++) {
					tab[i][j]=0;
				}
			}
		}
		if (k == 0 && l!=0 && l!= taille-1) { // 1 line
			for (int i=0; i<2; i++) {
				for (int j=l-1; j<l+2; j++) {
					tab[i][j]=0;
				}
			}
		}
				
		if (k == taille -1 && l!=0 && l!= taille-1) { // last line
			for (int i=taille-2; i<taille; i++) {
				for (int j=l-1; j<l+2; j++) {
					tab[i][j]=0;
				}
			}
		}

		if (k != 0 && l==0 && k!= taille-1) { // 1 row
			for (int i=k-1; i<k+2; i++) {
				for (int j=0; j<2; j++) {
					tab[i][j]=0;
				}
			}
		}

		if (k != 0 && l==taille-1 && k!= taille-1) { // last row
			for (int i=k-1; i<k+2; i++) {
				for (int j=taille-2; j<taille; j++) {
					tab[i][j]=0;
				}
			}
		}

		else if (k!=0 && k!= taille-1 && l!=0 && l!= taille-1) {
			for (int i=k-1; i<k+2; i++) {
				for (int j=l-1; j<l+2; j++) {
					tab[i][j]=0;
				}
			}
		}	
	}
	
	public void genereNombres(){ // Méthode permettant de compter le nb de mines autour d'une case
		
		for (int i=0; i<taille; i++) {
			for (int j=0; j<taille; j++) {
				
				
				if (i == 0 && j== 0 && tab[i][j] != 9) { //left up
					tab[i][j] = 0;
					for (int k=0; k<2; k++) {
						for (int l=0; l<2; l++) {
							if (tab[k][l] == 9){
								tab[i][j]++;
							}
						}
					}
				}
				if (i == taille-1 && j== 0 && tab[i][j] != 9) { // down left
					tab[i][j] = 0;
					for (int k=i-1; k<=i; k++) {
						for (int l=0; l<2; l++) {
							if (tab[k][l] == 9){
								tab[i][j]++;
							}
						}
					}
				}
				if (i == 0 && j== taille-1 && tab[i][j] != 9) { // up right
					tab[i][j] = 0;
					for (int k=0; k<=1; k++) {
						for (int l=j-1; l<=j; l++) {
							if (tab[k][l] == 9){
								tab[i][j]++;

							}
						}
					}
				}
				
				if (i == taille-1 && j== taille-1 && tab[i][j] != 9) { // down right
					tab[i][j] = 0;
					for (int k=i-1; k<=i; k++) {
						for (int l=j-1; l<=j; l++) {
							if (tab[k][l] == 9){
								tab[i][j]++;

							}
						}
					}
				}
				if (i == 0 && j!=0 && j!= taille-1 && tab[i][j] != 9) { // 1 line
					tab[i][j] = 0;
					for (int k=0; k<=1; k++) {
						for (int l=j-1; l<=j+1; l++) {
							if (tab[k][l] == 9){
								tab[i][j]++;
							}
						}
					}
				}
				
				if (i == taille -1 && j!=0 && j!= taille-1 && tab[i][j] != 9) { // last line
					tab[i][j] = 0;
					for (int k=i-1; k<=i; k++) {
						for (int l=j-1; l<=j+1; l++) {
							if (tab[k][l] == 9){
								tab[i][j]++;
							}
						}
					}
				}
				if (i != 0 && j==0 && i!= taille-1 && tab[i][j] != 9) { // 1 row
					tab[i][j] = 0;
					for (int k=i-1; k<=i+1; k++) {
						for (int l=j; l<=j+1; l++) {
							if (tab[k][l] == 9){
								tab[i][j]++;
							}
						}
					}
				}
				if (i != 0 && j==taille-1 && i!= taille-1 && tab[i][j] != 9) { // last row
					tab[i][j] = 0;
					for (int k=i-1; k<=i+1; k++) {
						for (int l=j-1; l<=j; l++) {
							if (tab[k][l] == 9){
								tab[i][j]++;
							}
						}
					}
				}
				else if (i!=0 && i!= taille-1 && j!=0 && j!= taille-1 && tab[i][j] != 9) {
					tab[i][j] = 0;
					for (int k=i-1; k<=i+1; k++) {
						for (int l=j-1; l<=j+1; l++) {
							if (tab[k][l] == 9){
								tab[i][j]++;
							}
						}
					}
				}	
			}
		}		
	}
	
	public boolean winGame(){ //Méthode renvoyant un boolean true si le joueur a gagné
		
		boolean win = false;
		int nbMines = 0;
		int nbFalse = 0;
		for (int i=0; i<taille; i++) {
			for (int j=0; j<taille; j++) {
				if(tab[i][j]==9){
					nbMines++;
				}
				if(tab2[i][j]==false){
					nbFalse++;
				}
			}
		}
		if(nbFalse == nbMines){
			win=true;
		}
		return win;
	}
	
	public void startGame(){ //Méthode gérant le jeu

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Donnez la ligne (1 à "+taille+")");
		int i = sc.nextInt()-1;

		while(i<0 || i>11){
			System.out.println("Donnez la ligne (1 à "+taille+")");
			i = sc.nextInt()-1;
		}
		
		System.out.println("Donnez la colonne (1 à "+taille+")");
		int j = sc.nextInt()-1;
		
		while(j<0 || j>11){
			System.out.println("Donnez la colonne (1 à "+taille+")");
			j = sc.nextInt()-1;
		}
			
		genereMines(i,j);
		genereNombres();
		decouvreMine(i,j);
		System.out.println();
		afficherChampsBoolean();
		System.out.println();
		while (tab[i][j]!=9 && winGame()==false){
			
			demandeDrap();
			
			System.out.println("Donnez la ligne (1 à "+taille+")");
			i = sc.nextInt()-1;
			while(i<0 || i>11){
				System.out.println("Donnez la ligne (1 à "+taille+")");
				i = sc.nextInt()-1;
			}
			System.out.println("Donnez la colonne (1 à "+taille+")");
			j = sc.nextInt()-1;
			while(j<0 || j>11){
				System.out.println("Donnez la colonne (1 à "+taille+")");
				j = sc.nextInt()-1;
			}
			
			decouvreMine(i,j);
			System.out.println();
			afficherChampsBoolean();
			}
			
		if(tab[i][j] == 9){
			System.out.println("Vous avez marché sur une mine. Sans menace de mort imminente, est-ce encore de la science ?");
		}
		if(winGame()==true){
			System.out.println("Aucun sujet n'a jamais battu son fidèle démineur de voyage aussi rapidement que vous. Bravo.");
		}
		
	}	
}

