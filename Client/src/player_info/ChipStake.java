package player_info;

public class ChipStake {
	private int stakeSize;
	
	public ChipStake() {
		stakeSize = 0;
	}
	
	public ChipStake(int stakeSize) {
		this.stakeSize = stakeSize;
	}

	public int getStakeSize() {
		return stakeSize;
	}

	public void setStakeSize(int stakeSize) {
		this.stakeSize = stakeSize;
	}
}
