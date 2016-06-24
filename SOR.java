import java.util.Scanner;


public class SOR{

	public static void main(String [] args)
	{
		Scanner s = new Scanner(System.in);
		SOR sor = new SOR();
		Gauss g = new Gauss();
		Operacione o = new Operacione();
		
		System.out.println("Sheno rendin e matrices:");
		int n = s.nextInt(); // rendi i matrices
		double[][] x0 = new double[n][1];//vektori fillestar
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < 1; j++)
			{
				x0[i][j] = 1;
			}
		}
		double [][] M = new double[n][n];
		//mbushja e matrices nga perdoruesi
		System.out.println("Sheno elementet e matrices:");
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				M[i][j] = s.nextDouble();
			}
		}		
		
		double[][] b = new double[n][1];//rendi i vektorit te gjymtyres se lire
		//mbushja e vektorit nga perdoruesi
		System.out.println("Sheno elementet e gjymtyres se lire:");
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < 1; j++)
			{
				b[i][j] = s.nextDouble();
			}
		}
		
		System.out.println("Sheno vleren e omeges:");
		double omega = s.nextDouble(); // 0 < omega < 1
		s.close();
		double[][] diagonal = sor.D(M);
		double[][] lower = sor.L(M);
		double[][] upper = sor.U(M);
		
		
		//matrica T
		double[][] shumzimi1 = o.mult(lower, omega);
		double[][] zbritja1 = o.sub(diagonal, shumzimi1);
		double[][] inversi1 = g.inversi(zbritja1);
		double o2 = 1 - omega;
		double[][] shumzimi2 = o.mult(diagonal, o2);
		double[][] shumzimi3 = o.mult(upper, omega);
		double[][] mbledhja1 = o.add(shumzimi2, shumzimi3);
		double[][] T = o.multMatrix(inversi1, mbledhja1);
		
		//vektori c
		double[][] shumzimi4 = o.mult(inversi1, omega);
		double[][] c = o.multVector(shumzimi4, b);
	
		
		//vektori x
		int nI= sor.numIterations(10);
		double tol = sor.setTolerance(1e-3);
		int f = 0;
		boolean found = false;
		while(!found && f < nI)
		{
			double[][] x = o.addV(o.multVector(T, x0), c);
			if(o.infinitM(o.subV(x, x0)) < tol)
			{
				found = true;
				System.out.println("Iteracioni " + f);
				sor.paraqitjaV(x);
			}
			else
			{
				x0 = x;
				f++;
				
			}
			
		}

		
	}
	
	public int numIterations(int n)
	{
		int numIterations = n;
		return numIterations;
	}
	
	public double setTolerance(double t)
	{
		double tolerance = t;
		return tolerance;
	}
	
	public double [][] D (double[][] m)
	{
		double [][] diagonal = new double[m.length][m.length];
		for(int i = 0; i < m.length;i++)
		{
			for(int j = 0; j < m.length; j++)
			{
				if(i == j)
				{
					diagonal[i][j] = m[i][j];
				}
				else
				{
					diagonal[i][j] = 0;
				}
			}
		}
		return diagonal;
	}
	
	public double [][] L (double[][] m)
	{
		double [][] lower = new double[m.length][m.length];
		for(int i = 0; i <m.length; i++)
		{
			for(int j = 0; j<m.length; j++)
			{
				if(i > j)
				{
					lower[i][j] = -m[i][j];
				}
				else
				{
					lower[i][j] = 0;
				}
			}
		}
		return lower;
	}
	
	public double [][] U(double[][] m)
	{
		double [][] upper = new double[m.length][m.length];
		for(int i = 0; i < m.length; i++)
		{
			for(int j = 0; j < m.length; j++)
			{
				if(i < j)
				{
					upper[i][j] = -m[i][j];
				}
				else
				{
					upper[i][j] = 0;
				}
			}
		}
		return upper;
	}
	
	
	public double[][] paraqitjaV(double[][] m)
	{
		System.out.println("Paraqitja e zgjidhjes:");
		double[][] matrica = m;
        for(int i=0; i<m.length; i++)
        {
        	System.out.print("");
            for(int j=0; j<1; j++)
            {	
            	System.out.print(" " + matrica[i][j]);
            }	 
            System.out.println();
        }
        return matrica;
	}
	
	
}
