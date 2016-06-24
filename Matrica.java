import javax.swing.*;
public class Matrica {
 
  public double[][] matrica(){
   int n = Integer.parseInt(JOptionPane.showInputDialog("Sheno rendin e matrices: "));
		double[][] matrica =  new double[n][n]; 
		return matrica;
}
public double[][] inicializimiM(double[][] m){
	double[][] matrica = m;
     for(int i=0; i<m.length; i++) {
       for(int j=0; j<m.length; j++) {	
          matrica[i][j] =Double.parseDouble(JOptionPane.showInputDialog("Sheno elementet: "));
            }	        
        }
        return matrica;
	}
   public double NormaInfinitM(double[][] m){
		double max = 0;
		for(int i = 0; i <m.length;i++){
			double sum = 0;
			 for(int j = 0; j<m.length; j++)
			{
				sum = sum + Math.abs(m[i][j]);
			}
			
			if(sum > max)
			{
				max = sum;
			}
		}
		return max;


}   
public double[][] ParaqitjaEM(double[][] m)
	{
		System.out.println("Paraqitja e matrices:");
		double[][] matrica = m;
        for(int i=0; i<m.length; i++)
        {
        	System.out.print("");
            for(int j=0; j<m.length; j++)
            {	
            	System.out.print(" " + matrica[i][j]);
            }	 
            System.out.println();
        }
        return matrica;
	}
	
public double Frobenius(double[][] m)
	{
		double[][] matrica = m;
		double sum = 0;
		for(int i = 0; i < matrica.length;i++)
		{
			for(int j = 0; j< matrica.length; j++)
			{
				sum = sum + matrica[i][j]*matrica[i][j];
			}
		}
		return Math.sqrt(sum);
		

 }  
    
    public static void main(String [] args){
    Matrica m = new Matrica();
    double[][] n = m.matrica();
    m.inicializimiM(n);
    m.ParaqitjaEM(n);
    System.out.println("Norma infinit " + m.NormaInfinitM(n));
    System.out.println("Norma Frobenius " + m.Frobenius(n));
    
    
    
    }
}