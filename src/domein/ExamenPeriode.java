package domein;

public class ExamenPeriode
{
	private int behaald = 0, total = 0;

	public double getProcent()
	{
		return ((double) behaald / total) * 100;
	}

	public int getBehaald()
	{
		return behaald;
	}

	public int getTotal()
	{
		return total;
	}

	public void addPunten(int studiepunten, int punten)
	{
		this.behaald += punten * studiepunten;
		this.total += 20 * studiepunten;
	}

	public void reset()
	{
		this.behaald = 0;
		this.total = 0;
	}

}
