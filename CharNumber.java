package Numerike2;

public class CharNumber {
	

	public static int charToNumber(String a)
	{
		String lower = a.toLowerCase();
		int numeric = 0;
		switch(lower)
		{
		case "a":
			numeric = 6;
			break;
		case "b":
			numeric = 9;
			break;
		case "c":
			numeric = 12;
			break;
		case "d":
			numeric = 15;
			break;
		case "e":
			numeric = 18;
			break;
		case "f":
			numeric = 21;
			break;
		case "g":
			numeric = 24;
			break;
		case "h":
			numeric = 27;
			break;
		case "i":
			numeric = 30;
			break;
		case "j":
			numeric = 33;
			break;
		case "k":
			numeric = 36;
			break;
		case "l":
			numeric = 39;
			break;
		case "m":
			numeric = 42;
			break;
		case "n":
			numeric = 45;
			break;
		case "o":
			numeric = 48;
			break;
		case "p":
			numeric = 51;
			break;
		case "q":
			numeric = 54;
			break;
		case "r":
			numeric = 57;
			break;
		case "s":
			numeric = 60;
			break;
		case "t":
			numeric = 63;
			break;
		case "u":
			numeric = 66;
			break;
		case "v":
			numeric = 69;
			break;
		case "w":
			numeric = 72;
			break;
		case "x":
			numeric = 75;
			break;
		case "y":
			numeric = 78;
			break;
		case "z":
			numeric = 81;
			break;
					
		}
	return	numeric;
	}
	
	public static String numberToChar(double n)
	{	int num = (int)(n);
		String string = "";
		switch(num)
		{
		case 6:
			string = "a";
			break;
		case 9:
			string = "b";
			break;
		case 12:
			string = "c";
			break;
		case 15:
			string = "d";
			break;
		case 18:
			string = "e";
			break;
		case 21:
			string = "f";
			break;
		case 24:
			string = "g";
			break;
		case 27:
			string = "h";
			break;
		case 30:
			string = "i";
			break;
		case 33:
			string = "j";
			break;
		case 36:
			string = "k";
			break;
		case 39:
			string = "l";
			break;
		case 42:
			string = "m";
			break;
		case 45:
			string = "n";
			break;
		case 48:
			string = "o";
			break;
		case 51:
			string = "p";
			break;
		case 54:
			string = "q";
			break;
		case 57:
			string = "r";
			break;
		case 60:
			string = "s";
			break;
		case 63:
			string = "t";
			break;
		case 66:
			string = "u";
			break;
		case 69:
			string = "v";
			break;
		case 72:
			string = "w";
			break;
		case 75:
			string = "x";
			break;
		case 78:
			string = "y";
			break;
		case 81:
			string = "z";
			break;
			
		}
	return string;	
	}
}
