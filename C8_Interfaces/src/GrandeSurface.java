
public class GrandeSurface implements EssenceInterface {
	private float citerne;

	public GrandeSurface() {
		citerne = 1000;
	}

	public GrandeSurface(float citerne) {
		this.citerne = citerne;
	}

	@Override
	public float donnerEssenceInterface(float qte) {
		float qteDelivree = qte;
		if (qte > citerne) {
			qteDelivree = citerne;
			citerne = 0;
		} else {
			citerne -= qte;
		}
		return qteDelivree;
	}

	public float getCiterne() {
		return citerne;
	}

	public void setCiterne(float citerne) {
		this.citerne = citerne;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getClass().getName()+" "+getCiterne();
	}

}
