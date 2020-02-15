//HY-252
//Assigment1 - Part 1 - Palindromic
package Homework1;

import java.util.Arrays;
import java.util.Scanner;

 class Palindromic {

	public static void main(String[] args) {
		
		char[] word;	//Se afton ton pinaka apothikeuoume tin leksi pou dinei o xristis
		Scanner scan = new Scanner(System.in); //Xrisimopoioume tin Scanner gia na diavasoume
		System.out.println("Please insert the word for check if palindromic!");
		String r1 = scan.nextLine(); //Sto string r1 kratame to string pou edwse o xristis.
		String r2 = r1; //kanoume to string r2 idio me to string r1 gia na emfanisoume tin frasi opws tin edwse o xristis sto telos.
		r1 = r1.replace(" ", ""); //antikathistoume ola ta space (" ") me tipota ("")
		r1=r1.replaceAll("[^A-Za-z]+", ""); //kanoume antikatastasi osa den einai xaraktires se tipota ("")
		word=r1.toCharArray();//metatrepoume to string r1 se array
		char[] reverseWord = new char[r1.length()]; //dimiourgoume ton pinaka pou tha exei tin leksei anapoda
		for (int i = 0; i < word.length; i++) {
			  word[i]=Character.toLowerCase(word[i]); //kanoume ola ta grammata mikra
			  reverseWord[i] = word[word.length - 1 - i]; //topothetoume to telos tou pinaka siga siga stin arxi tou reverse
			  reverseWord[i]=Character.toLowerCase(reverseWord[i]); //kanoume ton pinaka reverse ksana mikra dioti otan kaname mikra ola tou pinaka word den eginan mikra ola.
			}
		boolean statement=true;
		while (statement){
			if (Arrays.equals(word, reverseWord)) {//tsekaroume an einai isoi oi pinakes.
				System.out.print("The word <" );
				System.out.print(r2);//emfanizoume tin leksi opws tin edwse o xristis.
				System.out.println("> is a palindromic!" );
				statement=false;//stamatame tin epanalipsi
			}
			else
			{
				statement=false; 
				System.out.print("The word <" );
				System.out.print(r2);//emfanizoume tin leksi opws tin edwse o xristis.
				System.out.println("> isn't a palindromic!" );
			}
		}
	}
 }
//Author Tasos Anastasas Csd3166