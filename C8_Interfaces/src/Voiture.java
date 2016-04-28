
public class Voiture {

	private float reservoir;
	private float qteMaxReservoir;

	public Voiture(float f) {
		this.reservoir = 0;
		this.qteMaxReservoir = f;
	}

	public void prendreEssence(EssenceInterface st) {
		reservoir = st.donnerEssenceInterface(qteMaxReservoir);
	}

}
