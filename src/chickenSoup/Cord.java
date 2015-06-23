package chickenSoup;

public class Cord {
	private int i;
	private int j;

	public Cord() {
		i = 0;
		j = 0;
	}

	public Cord(int i, int j) {
		this.i = i;
		this.j = j;
	}

	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Cord) {
			return this.i == ((Cord) obj).getI() && this.j == ((Cord) obj).getJ();
		}
		return false;
	}

	@Override
	public String toString() {
		return "(" + i + "," + j + ")";
	}
}

