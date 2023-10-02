package lab2;

public class Task1_4 {
	public void moveTower (int disk, char source, char dest, char spare) {
		if (disk == 0) {
			System.out.println("Di chuyen dia " + disk + " tu " + source + " den " + dest);
		} else {
			moveTower(disk - 1, source, spare, dest);
			System.out.println("Di chuyen dia " + disk + " tu " + source + " den " + dest);
			moveTower(disk - 1, spare, dest, source);
		}
	}
	public static void main(String[] args) {
		Task1_4 TowersOfHanoi = new Task1_4();
		TowersOfHanoi.moveTower(3, 'A', 'B', 'C');
	}
}
