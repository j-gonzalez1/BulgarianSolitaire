// Author: Jose Luis Gonzalez
// Date: 4/1/2021
// Assignment: 07 Bulgarian Solitaire (Part 2)
// Class: Java CS/IS 139-1521


package bulgarianSolitaire;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BulgarianSolitaire
{

	public static void main(String[] args)
	{
		int cardNum = 46;
		int tempSum = 0;
		List<Integer> decks = new ArrayList<Integer>();					//create the ArrayList
		Random random = new Random();
		
		for (int i = 0; i < cardNum; i++)								//create the random decks
		{
			int number = random.nextInt(cardNum);
			decks.add(number);
			cardNum -= number;
		} 
		
		for(Integer number:decks)
		{
			tempSum += number;
		} 
		decks.add(45-tempSum);
		decks.removeAll(Collections.singleton(0));
		System.out.println(display(decks));								//print starting decks
	}

	public static String display(List<Integer> gameDecks) 
	{ 
		boolean check = false;
		List<Integer> perfDecks = new ArrayList<Integer>();
		for (int i = 1; i < 10; i++)
		{ 
            perfDecks.add(i);
		}
		Collections.sort(perfDecks, Collections.reverseOrder());

		while (check != true)
		{
			System.out.println("Decks : " + gameDecks.toString());		//print decks
			Collections.sort(gameDecks, Collections.reverseOrder());
			System.out.println("Decks : " + gameDecks.toString());		//print decks rearranged
			gameDecks.removeAll(Collections.singleton(0));
			gameDecks = newTurn(gameDecks);								//create new deck
			check = gameDecks.containsAll(perfDecks);
		}
		Collections.sort(gameDecks, Collections.reverseOrder());	
		System.out.println("Decks : " + gameDecks.toString());			//print final decks
		return "\nYou have reached a stable configuration! Congratulations!"; 
	} 
	
	public static List<Integer> newTurn(List<Integer> splitDecks)		//take a card from each deck
	{																	//and create a new one
		int newDeck = 0;
		
		for (int i = 0; i < splitDecks.size(); i++)
		{
			if (splitDecks.get(i) > 0)
			{
			splitDecks.set(i, splitDecks.get(i)-1);
			newDeck++;
			}
		}
		splitDecks.add(newDeck);
		splitDecks.removeAll(Collections.singleton(0));
		return splitDecks;
	}
}
