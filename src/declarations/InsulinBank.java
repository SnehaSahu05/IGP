package declarations;

public class InsulinBank {

	private static InsulinBank IBInstance = null;
	private static Double currentIlvl = 0.0;
	private double maxIlvl = AssemblyConstants.HUNDRED;

	public InsulinBank() {
		currentIlvl = maxIlvl;
	}

	public Double checkInsulinLevel(double calculatedIDose) {
		synchronized (currentIlvl) {
			currentIlvl -= calculatedIDose;
			if (calculatedIDose > 0) {
				// included in accesorystatus in ComputeDosage
				//IgpsGuiController.addMessage(String.format("Injected %s Dose of Insulin", calculatedIDose),Color.GREEN);
			}
		}
		return currentIlvl / 100.0;
	}

	public static void setInsulinLevel(Double value) {
		currentIlvl = value;
	}

	public static synchronized InsulinBank getInstance() {
		if (IBInstance == null) {
			IBInstance = new InsulinBank();
		}
		return IBInstance;

	}
}
