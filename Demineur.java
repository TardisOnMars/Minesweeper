

public class Demineur{
	int[][] tab;
	int taille = 12;
	boolean[][] tab2;
	
	public Demineur(){
		tab = new int[taille][taille];
		for (int i=0; i<taille; i++) {
			for (int j=0; j<taille; j++) {
				tab[i][j] = 1;
			}
		}
	}
	
	public void afficherChamps(){
		for (int i=0; i<taille; i++) {
			for (int j=0; j<taille; j++) {
				System.out.print(tab[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void decouvreMine(int x, int y){
		if (tab2[x][y] == true){
		}
		else if (tab2[x][y] == false && tab[x][y] != 0 && tab[x][y] != 9){
			tab2[x][y] == true;
		}
		else if (tab2[x][y] == false && tab[x][y] == 9){
			tab2[x][y] == true;
			//game over
		}
		else if(tab2[x][y] == false && tab[x][y] == 0){
			
			//open the adjacents
		}
		
		
	}
	
	
	public void genereMines (){
		double ratio = 1/6.0;
		for (int i=0; i<taille; i++) {
			for (int j=0; j<taille; j++) {
				if (Math.random() <= 0.2) {
					tab[i][j] = 9;
				}
			}
		}
		System.out.println(ratio);
	}
	
	public void genereNombres(){
		
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
							if (tab[i][j] == 9){
								tab[i][j]++;

							}
						}
					}
				}
				
				if (i == taille-1 && j== taille-1 && tab[i][j] != 9) { // down right
					tab[i][j] = 0;
					for (int k=i-1; k<=i; k++) {
						for (int l=j-1; l<=j; l++) {
							if (tab[i][j] == 9){
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
}
