import javax.swing.*;
public class Normat{

public double []vektori (){

   int k = Integer.parseInt(JOptionPane.showInputDialog("sa elemente"));
   double [] vektori = new double [k];
   return vektori;
    }
 public double [] vektori(double [] v){
    for (int i=0 ; i<v.length; i++)
   {v [i]= Double.parseDouble(JOptionPane.showInputDialog("Jepe elementin" + i));}
    return v ;
  
  }
 public double [] ndryshimi (double []a,double []b){
    double [] c= new double [a.length];
    if (a.length==b.length){
       for (int i=0;i<a.length;i++)
    c[i]= a[i]-b[i];}
  return c; 
  }
  public double [] sum (double []a,double []b){
       double [] h= new double [a.length];
    if (a.length==b.length){
       for (int i=0;i<a.length;i++)
      h[i]= a[i]+b[i];}
  return h; 
  }
  public double normaEuklidiane(double [] x)
	{
		double sum=0;
		for(int i=0;i<x.length;i++){
		sum=sum+x[i]*x[i];
		}
		return Math.sqrt(sum);
	}
    public double normaInfinit(double[] x)
	{
		double max=0;
		for(int i=0;i<x.length;i++)
		{
			if(Math.abs(x[i])>max)
			{
				max=Math.abs(x[i]);
			}
		}
		return max;
   

  }  public static void paraqitja( double[] x)
	{
		double[] t = x;
		System.out.println("Paraqitja e vektorit:");
		for(int i = 0; i<x.length; i++)
		{ System.out.print(" " + x[i]);
     	}
		System.out.println();
}



public static void main( String [] args){
	Normat n = new Normat();
	double[] v = n.vektori();
	n.vektori(v);
	double[] w = n.vektori();
	n.vektori(w);
   System.out.println("Ndryshimi:");
	n.paraqitja(n.ndryshimi(v,w));
   System.out.println("Mbledhja:");
	n.paraqitja(n.sum(v,w));
	System.out.println("Norma euklidiane" + n.normaEuklidiane(v));
   System.out.println("Norma infinit" + n.normaInfinit(v));
   System.out.println("Distanca euklidiane"+n.normaEuklidiane(v));
   System.out.println("Distanca euklidiane"+n.normaEuklidiane(w));
   

   
   }
  
   
     
      
   
}