import java.util.Scanner;
import java.lang.RuntimeException;
import numeric.DecimalFloating;
import Jama.EigenvalueDecomposition;
public class PageRank {

	DecimalFloating f = new DecimalFloating();
	Scanner s = new Scanner(System.in);

	public double [][] A ()
	{
		System.out.println("Sheno rendin per matricen A:");
		int n = s.nextInt();
		double [][] matricaA = new double [n][n];
		return matricaA;
	}
	public double[][] B ()
	{
		System.out.println("Sheno rendin per matricen B:");
		int n = s.nextInt();
		f.setNumDigits(3);
		f.setRounding(DecimalFloating.ROUNDING);
		double [][] matricaB = new double[n][n];
		for(int i = 0; i<matricaB.length;i++)
		{
			for(int j = 0; j<matricaB.length;j++)
			{
				matricaB[i][j]=f.fl(1.0/n);
			}
		}
		return matricaB;
	}
	public double [][] add (double [][]A,double [][] B)
	{
		double [][]C = new double[A.length][A.length];
		if(A.length == B.length)
		{
			for(int i = 0; i<C.length;i++)
			{
				for(int j = 0; j<C.length;j++)
				{
					C[i][j] = A[i][j] + B[i][j];
				}
			}
		}
		return C;
	}
	public double [][] mult (double l,double [][] A)
	{
		double[][] C = new double[A.length][A.length];
		double [][] matricaA = A;
		double L = l;
		for(int i = 0; i<matricaA.length;i++)
		{
			for(int j = 0; j<matricaA.length;j++)
			{
				C[i][j] = L * matricaA[i][j]; 			}
		}
		return C;
	}
	public double [][] M(double p, double[][] A,double [][] B)
	{
		double diff = 1-p;
		double [][] matricaM = new double[A.length][A.length];
		if(A.length == B.length)
		{
			matricaM= this.add(this.mult(diff, A),this.mult(p, B));
		}
		return matricaM;
		
	}
	public double[][] paraqitjaM(double[][] M)
	{
		double[][] matricaM = M;
		f.setNumDigits(3);
		f.setRounding(DecimalFloating.ROUNDING);
        for(int i=0; i<M.length; i++)
        {
        	System.out.print("");
            for(int j=0; j<M.length; j++)
            {	
            	System.out.print(" " + f.fl(matricaM[i][j]));
            }	 
            System.out.println();
        }
        return matricaM;
	}
	public double[][] identity()
	{
		System.out.println("Sheno rendin e njejte me matricen A per te krijuar matricen njesi:");
		int n = s.nextInt();
		double[][] I = new double[n][n];
		for(int i = 0;i <I.length;i++)
		{
			for(int j = 0;j<I.length;j++)
			{
				I[i][i] = 1.0;
			}
		}
		return I;
	}
	public double [][] sub (double [][]A,double [][] I)
	{
		double [][]C = new double[A.length][A.length];
		if(A.length == I.length)
		{
			for(int i = 0; i<C.length;i++)
			{
				for(int j = 0; j<C.length;j++)
				{
					C[i][j] = A[i][j] - I[i][j];
				}
			}
		}
		return C;
	}
	public static void paraqitjaV(double[] x)
	{
		double[] t = x;
		System.out.println("Paraqitja e vektorit:");
		for(int i = 0; i < x.length; i++)
		{
			System.out.print(" " + t[i]);
			System.out.println(" ");
		}
		System.out.println();
	}
	
	public static void main(String [] args) throws RuntimeException
	{
		GaussianElimination ge = new GaussianElimination();
		PageRank pr = new PageRank();
		pr.A();
		double[][] matricaB = pr.B();
		double [][] matricaI = pr.identity();
		System.out.println("Paraqitja e matrices I:");
		pr.paraqitjaM(matricaI);
		double [][] matricaA = {{0,1,0.5,0},{0.5,0,0.5,0},{0,0,0,1},{0.5,0,0,0}};
		double [] b = {0,0,0,0};
		System.out.println("Paraqitja e matrices A:");
		pr.paraqitjaM(matricaA);
		System.out.println("Paraqitja e matrices (A-I):");
		double[][] M = pr.sub(matricaA, matricaI);
		pr.paraqitjaM(M);
		System.out.println("Paraqitja e matrices M:");
		double[][] M2 = pr.M(0.15, matricaA, matricaB);
		pr.paraqitjaM(M2);
		System.out.println("Paraqitja e vektorit:");
		try
		{
			double [] v = ge.lsolve(M2, b);
			pr.paraqitjaV(v);
		}

		catch (RuntimeException re)
		{
			System.out.println("Runtime Exception!");
			System.out.println("Matrica eshte singulare ose gati singulare.");
		}

		
	}
	
	
}
