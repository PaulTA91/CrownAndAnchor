package crownAndAnchor;

import java.io.Serializable;

public class Player implements Serializable {
	
	private String name;
	private int stake;
	private int banker;
	
	public Player() {
		name = "";
		stake = 0;
	}
	
	public Player(String name, int stakeAdjust) {
		this.name = name;
		this.stake = stakeAdjust;
		banker = 100;
	}
	
	public void increaseStake(int stakeAdjust) {
		stake += stakeAdjust;
	}
	
	public void decreaseStake(int stakeAdjust) {
		stake -= stakeAdjust;
	}

	public void increaseBank(int stakeAdjust) {
		banker += stakeAdjust;
	}
	
	public void decreaseBank(int stakeAdjust) {
		banker -= stakeAdjust;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStake() {
		return stake;
	}

	public void setStake(int stake) {
		this.stake = stake;
	}

	public int getBanker() {
		return banker;
	}

	public void setBanker(int banker) {
		this.banker = banker;
	}
	
}
