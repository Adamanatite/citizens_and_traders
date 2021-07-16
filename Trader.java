package trading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents a trader of goods in a trading simulation. Each trader has a list
 * of trades they offer.
 * 
 * Student Solution to JP2 Lab Exam, 30th November 2020
 * 
 * @author Adam Fairlie <2461352f@student.gla.ac.uk>
 */
public class Trader {
	/** The list of offered trades */
	private List<Trade> trades = new ArrayList<Trade>();
	/** The list of possible goods */
	private Goods[] goodTypes = Goods.values();

	/**
	 * Creates a new trader with one random trade.
	 * 
	 * @see #addRandomTrade()
	 */
	public Trader() {
		this.addRandomTrade();
	}

	/**
	 * @return The list of trades offered
	 */
	public List<Trade> getTrades() {
		return this.trades;
	}

	/**
	 * Adds a randomly generated trade to this Trader's list.
	 */
	public void addRandomTrade() {
		// Create randomiser
		Random rand = new Random();
		// Get random amount values (1-5)
		int noGems = rand.nextInt(5) + 1;
		int noGoods = rand.nextInt(5) + 1;
		// Get random good type from list of types
		Goods good = goodTypes[rand.nextInt(goodTypes.length)];

		// Add trade based on values
		trades.add(new Trade(noGems, noGoods, good));
	}

}
