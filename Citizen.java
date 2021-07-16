package trading;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a citizen in a trading simulation. Each citizen has an amount of
 * gems and an inventory of goods.
 * 
 * Student Solution to JP2 Lab Exam, 30th November 2020
 * 
 * @author Adam Fairlie <2461352f@student.gla.ac.uk>
 */
public class Citizen {
	/** The number of gems */
	private int gems;
	/** The goods this citizen currently has */
	private Map<Goods, Integer> inventory;

	/**
	 * Creates a new citizen with the given amount of gems.
	 * 
	 * @param gems The number of gems
	 */
	public Citizen(int gems) {
		this.gems = gems;
		this.inventory = new HashMap<Goods, Integer>();
	}

	/**
	 * @return The citizen's gems
	 */
	public int getGems() {
		return gems;
	}

	/**
	 * Gets the number of goods of a certain type this citizen has
	 * 
	 * @param goods The type of goods
	 * @return The number of goods of that type the citizen has (0 if none)
	 */
	public int getAmount(Goods goods) {
		// return 0 if not in inventory
		if (!(inventory.containsKey(goods))) {
			return 0;
		}
		return inventory.get(goods);
	}

	/**
	 * Attempts to execute a trade.
	 * 
	 * @param trade The trade to attempt to execute
	 * @return True if the trade was successful, and false if not
	 * @see Trade#getGems()
	 * @see Trade#getGoods()
	 * @see #getAmount(Goods)
	 * @see Trade#getAmount()
	 */
	public boolean executeTrade(Trade trade) {
		// Return false if not enough gems
		if (trade.getGems() > this.gems) {
			return false;
		}

		// Remove gems and update inventory
		this.gems -= trade.getGems();
		this.inventory.put(trade.getGoods(), this.getAmount(trade.getGoods()) + trade.getAmount());
		return true;
	}

}
