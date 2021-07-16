package trading;

/**
 * Represents a trade of goods in a trading simulation. Each trade includes a
 * number of goods, a type of good and a number of gems.
 * 
 * Student Solution to JP2 Lab Exam, 30th November 2020
 * 
 * @author Adam Fairlie <2461352f@student.gla.ac.uk>
 */
public class Trade {
	/** The number of gems */
	private int gems;
	/** The amount of the goods */
	private int amount;
	/** The type of goods */
	private Goods goods;

	/**
	 * Creates a new trade with the given amount of gems and goods of a given type.
	 * 
	 * @param gems   The number of gems
	 * @param amount The amount of the goods
	 * @param goods  The type of goods
	 */
	public Trade(int gems, int amount, Goods goods) {
		this.gems = gems;
		this.amount = amount;
		this.goods = goods;
	}

	/**
	 * @return The trade's gems
	 */
	public int getGems() {
		return gems;
	}

	/**
	 * @return The trade's amount of goods
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @return The trade's goods type
	 */
	public Goods getGoods() {
		return goods;
	}

	/**
	 * Computes a hash code based on the number of gems, amount of goods and type of
	 * goods.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + gems;
		result = prime * result + ((goods == null) ? 0 : goods.hashCode());
		return result;
	}

	/**
	 * Computes equality based on the number of gems, amount of goods and type of
	 * goods.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trade other = (Trade) obj;
		if (amount != other.amount)
			return false;
		if (gems != other.gems)
			return false;
		if (goods != other.goods)
			return false;
		return true;
	}

	/**
	 * Returns a well formatted string representing this trade.
	 */
	@Override
	public String toString() {
		return "" + this.gems + " gem for " + this.amount + " " + this.goods.name();
	}

	/**
	 * Executes a trade between a trader and a citizen.
	 * 
	 * @param trader  The trader offering the trade
	 * @param citizen The citizen engaging in this trade
	 * @see Trader#getTrades()
	 * @see Citizen#executeTrade(Trade)
	 * @see Trader#addRandomTrade()
	 */
	public void execute(Trader trader, Citizen citizen) {
		// Throw exception if trade is not offered
		if (!(trader.getTrades().contains(this))) {
			throw new IllegalArgumentException("The trader does not offer this trade!");
		}
		// Execute trade and add new trade to trader if successful
		if (citizen.executeTrade(this)) {
			trader.addRandomTrade();
		}
	}

}
