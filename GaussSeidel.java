import java.util.Scanner;
public class GaussSeidel {

		public static void main(String [] args)
		{
			Scanner s = new Scanner(System.in);
			GaussSeidel gs = new GaussSeidel();
			Gauss g = new Gauss();
			Operacione o = new Operacione();
			
			System.out.println("Sheno rendin e matrices:");
			int n = s.nextInt(); // rendi i matrices
			double[][] x0 = new double[n][1];//vektori fillestar
			for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < 1; j++)
				{
					x0[i][j] = 0;
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
			

			s.close();
			double[][] diagonal = gs.D(M);//matrica diagonale
			double[][] lower = gs.L(M);//matrica trekendeshe e poshtme
			double[][] upper = gs.U(M);//matrica trekendeshe e siperme
			
			
			//matrica T
			
			double[][] zbritja1 = o.sub(diagonal, lower);
			double[][] inversi1 = g.inversi(zbritja1);
			
			double[][] T = o.multMatrix(inversi1, upper);
			
			//vektori c
			
			double[][] c = o.multVector(inversi1, b);
		
			
			//vektori x
			int nI= gs.numIterations(10);
			double tol = gs.setTolerance(1e-3);
			int f = 0;
			boolean found = false;
			
			while(!found && f < nI)
			{
				double[][] x = o.addV(o.multVector(T, x0), c);
				double test = (o.infinitM(o.subV(x, x0)))/(o.infinitM(x));
				if(test < tol)
				{
					found = true;
					System.out.println("Iteracioni " + f);
					gs.paraqitjaV(x);
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

