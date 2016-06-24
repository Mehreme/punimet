
public class Operacione {

	public double [][] shuma(double[][] m, double o)
	{
		double[][] result = new double[m.length][m.length];
		for(int i = 0; i < m.length; i++)
		{
			for(int j = 0; j < m.length; j++)
			{
				result[i][j] = o * m[i][j];
			}
		}
		return result;
	}
	
	public double[][] zbitja(double[][] m, double[][] n)
	{
		double[][] result = new double[m.length][m.length];
		if(m.length == n.length)
		{
			for(int i = 0; i < m.length; i++)
			{
				for(int j = 0; j < m.length; j++)
				{
					result[i][j] = m[i][j] - n[i][j];
				}
			}
		}
		else
		{
			System.out.println("Zbritja nuk mund te realizohet");
		}
		return result;
	}
	public double[][] zbitjaV(double[][] m, double[][] n)
	{
		double[][] result = new double[m.length][1];
		if(m.length == n.length)
		{
			for(int i = 0; i < m.length; i++)
			{
				for(int j = 0; j < 1; j++)
				{
					result[i][j] = m[i][j] - n[i][j];
				}
			}
		}
		else
		{
			System.out.println("Mbledhja nuk mund te realizohet");
		}
		return result;
	}
	
	public double[][] add(double[][] m, double[][] n)
	{
		double[][] result = new double[m.length][m.length];
		if(m.length == n.length)
		{
			for(int i = 0; i < m.length; i++)
			{
				for(int j = 0; j < m.length; j++)
				{
					result[i][j] = m[i][j] + n[i][j];
				}
			}
		}
		else
		{
			System.out.println("Mbledhja nuk mund te realizohet");
		}
		return result;
	}
	
	public double[][] addV(double[][] m, double[][] n)
	{
		double[][] result = new double[m.length][1];
		if(m.length == n.length)
		{
			for(int i = 0; i < m.length; i++)
			{
				for(int j = 0; j < 1; j++)
				{
					result[i][j] = m[i][j] + n[i][j];
				}
			}
		}
		else
		{
			System.out.println("Mbledhja nuk mund te realizohet");
		}
		return result;
	}
	
	public double[][] multMatrix(double[][] m,double[][] s)
	{
		int n = m.length;
		double[][] result = new double[m.length][m.length];
		double sum = 0;
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				for(int k = 0; k < n; k++)
				{
					sum = sum + (m[i][k]*s[k][j]);
				}
				result[i][j] = sum;
				sum = 0;
			}
		}
		return result;
	}
	
	public double[][] multVector(double[][] m, double[][] v)
	{
		int n = m.length;
		double[][] result = new double[n][1];
		double sum = 0;
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < 1; j++)
			{
				for(int k = 0; k < n; k++)
				{
					sum = sum + (m[i][k]*v[k][j]);
				}
				result[i][j] = sum;
				sum = 0;
			}
		}
		return result;
	}
	
	public double infinitM(double[][] m)
	{
		double max = 0;
		for(int i = 0; i <m.length;i++)
		{
			double sum = 0;
			for(int j = 0; j<1; j++)
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
	
	
}
