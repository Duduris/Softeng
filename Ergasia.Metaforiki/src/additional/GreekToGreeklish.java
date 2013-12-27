package additional;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class GreekToGreeklish {

	public static String convert(String input) {
		byte[] tn = null;
		int j = 0;
		int k = 0;
		boolean ou = false;
		try {
			tn = input.getBytes("UTF-8");
			char[] namearray = new char[tn.length];
			for (int i = 0; i < tn.length; i+=2 ){
				/*
				 * Capital
				 */
				if (tn[i] == (byte) 0xCE &&(tn[i+1] == (byte) 0x86 || tn[i+1] == (byte) 0x91)) //Á
					namearray[j] = 'A';
				else if (tn[i] == (byte) 0xCE && tn[i+1] == (byte) 0x92) //Â
					namearray[j] = 'B';
				else if (tn[i] == (byte) 0xCE && tn[i+1] == (byte) 0x93) //G
					namearray[j] = 'G';
				else if (tn[i] == (byte) 0xCE && tn[i+1] == (byte) 0x94) //D
					namearray[j] = 'D';
				else if (tn[i] == (byte) 0xCE && (tn[i+1] == (byte) 0x88 || tn[i+1] == (byte) 0x95)) //E
					namearray[j] = 'E';
				else if (tn[i] == (byte) 0xCE && tn[i+1] == (byte) 0x96) //Z
					namearray[j] = 'Z';
				else if (tn[i] == (byte) 0xCE && (tn[i+1] == (byte) 0x89 || tn[i+1] == (byte) 0x97)) //H
					namearray[j] = 'I';
				else if (tn[i] == (byte) 0xCE && tn[i+1] == (byte) 0x98){ //TH
					namearray[j] = 'T';
					j++;
					namearray[j] = 'H';
				}
				else if (tn[i] == (byte) 0xCE && (tn[i+1] == (byte) 0x8A || tn[i+1] == (byte) 0x99)) //I
					namearray[j] = 'I';
				else if (tn[i] == (byte) 0xCE && tn[i+1] == (byte) 0x9A) //K
					namearray[j] = 'K';
				else if (tn[i] == (byte) 0xCE && tn[i+1] == (byte) 0x9B) //L
					namearray[j] = 'L';
				else if (tn[i] == (byte) 0xCE && tn[i+1] == (byte) 0x9C) //M
					namearray[j] = 'M';
				else if (tn[i] == (byte) 0xCE && tn[i+1] == (byte) 0x9D) //N
					namearray[j] = 'N';
				else if (tn[i] == (byte) 0xCE && tn[i+1] == (byte) 0x9E){ //KS
					namearray[j] = 'K';
					j++;
					namearray[j] = 'S';
				}
				else if (tn[i] == (byte) 0xCE && (tn[i+1] == (byte) 0x8C || tn[i+1] == (byte) 0x9F)){ //O
					namearray[j] = 'O';
					ou = true;
					k = j;
				}
				else if (tn[i] == (byte) 0xCE && tn[i+1] == (byte) 0xA0) //P
					namearray[j] = 'P';
				else if (tn[i] == (byte) 0xCE && tn[i+1] == (byte) 0xA1) //R
					namearray[j] = 'R';
				else if (tn[i] == (byte) 0xCE && tn[i+1] == (byte) 0xA3) //S
					namearray[j] = 'S';
				else if (tn[i] == (byte) 0xCE && tn[i+1] == (byte) 0xA4) //T
					namearray[j] = 'T';
				else if (tn[i] == (byte) 0xCE && (tn[i+1] == (byte) 0x8E || tn[i+1] == (byte) 0xA5)) { //Y
					if(!ou)
						namearray[j] = 'I';
					else {
						namearray[j] = 'U';
						ou = false;
					}
				}
				else if (tn[i] == (byte) 0xCE && tn[i+1] == (byte) 0xA6) //F
					namearray[j] = 'F';
				else if (tn[i] == (byte) 0xCE && tn[i+1] == (byte) 0xA7) //X
					namearray[j] = 'X';
				else if (tn[i] == (byte) 0xCE && tn[i+1] == (byte) 0xA8){ //PS
					namearray[j] = 'P';
					j++;
					namearray[j] = 'S';
				}
				else if (tn[i] == (byte) 0xCE && (tn[i+1] == (byte) 0x8F || tn[i+1] == (byte) 0xA9)) //Omega
					namearray[j] = 'O';
				/*
				 * Small
				 */
				else if (tn[i] == (byte) 0xCE &&(tn[i+1] == (byte) 0xAC || tn[i+1] == (byte) 0xB1)) //Á
					namearray[j] = 'a';
				else if (tn[i] == (byte) 0xCE && tn[i+1] == (byte) 0xB2) //Â
					namearray[j] = 'b';
				else if (tn[i] == (byte) 0xCE && tn[i+1] == (byte) 0xB3) //G
					namearray[j] = 'g';
				else if (tn[i] == (byte) 0xCE && tn[i+1] == (byte) 0xB4) //D
					namearray[j] = 'd';
				else if (tn[i] == (byte) 0xCE && (tn[i+1] == (byte) 0xAD || tn[i+1] == (byte) 0xB5)) //E
					namearray[j] = 'e';
				else if (tn[i] == (byte) 0xCE && tn[i+1] == (byte) 0xB6) //Z
					namearray[j] = 'z';
				else if (tn[i] == (byte) 0xCE && (tn[i+1] == (byte) 0xAE || tn[i+1] == (byte) 0xB7)) //H
					namearray[j] = 'i';
				else if (tn[i] == (byte) 0xCE && tn[i+1] == (byte) 0xB8){ //TH
					namearray[j] = 't';
					j++;
					namearray[j] = 'h';
				}
				else if (tn[i] == (byte) 0xCE && (tn[i+1] == (byte) 0xAF || tn[i+1] == (byte) 0xB9)) //I
					namearray[j] = 'i';
				else if (tn[i] == (byte) 0xCE && tn[i+1] == (byte) 0xBA) //K
					namearray[j] = 'k';
				else if (tn[i] == (byte) 0xCE && tn[i+1] == (byte) 0xBB) //L
					namearray[j] = 'l';
				else if (tn[i] == (byte) 0xCE && tn[i+1] == (byte) 0xBC) //M
					namearray[j] = 'm';
				else if (tn[i] == (byte) 0xCE && tn[i+1] == (byte) 0xBD) //N
					namearray[j] = 'n';
				else if (tn[i] == (byte) 0xCE && tn[i+1] == (byte) 0xBE){ //KS
					namearray[j] = 'k';
					j++;
					namearray[j] = 's';
				}
				else if (tn[i] == (byte) 0xCE && (tn[i+1] == (byte) 0x8C || tn[i+1] == (byte) 0xBF)){ //O
					namearray[j] = 'o';
					ou = true;
					k = j;
				}
				else if (tn[i] == (byte) 0xCF && tn[i+1] == (byte) 0x80) //P
					namearray[j] = 'p';
				else if (tn[i] == (byte) 0xCF && tn[i+1] == (byte) 0x81) //R
					namearray[j] = 'r';
				else if (tn[i] == (byte) 0xCF && (tn[i+1] == (byte) 0x82 || tn[i+1] == (byte) 0x83)) //S
					namearray[j] = 's';
				else if (tn[i] == (byte) 0xCF && tn[i+1] == (byte) 0x84) //T
					namearray[j] = 't';
				else if (tn[i] == (byte) 0xCF && (tn[i+1] == (byte) 0x8D || tn[i+1] == (byte) 0x85)){ //Y
					if(!ou)
						namearray[j] = 'i';
					else {
						namearray[j] = 'u';
						ou = false;
					}
				}
				else if (tn[i] == (byte) 0xCF && tn[i+1] == (byte) 0x86) //F
					namearray[j] = 'f';
				else if (tn[i] == (byte) 0xCF && tn[i+1] == (byte) 0x87) //X
					namearray[j] = 'x';
				else if (tn[i] == (byte) 0xCF && tn[i+1] == (byte) 0x88){ //PS
					namearray[j] = 'p';
					j++;
					namearray[j] = 's';
				}
				else if (tn[i] == (byte) 0xCF && (tn[i+1] == (byte) 0x8E || tn[i+1] == (byte) 0x89)) //Omega
					namearray[j] = 'o';
				else {
					namearray[j] = (char) tn[i];
					i--;
				}
				if (ou ==  true && j-k >= 1)
					ou = false;
				j++;
			}
			namearray = Arrays.copyOf(namearray, j);
			String output = new String(namearray);
			return output;

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return input;
	}	

}
