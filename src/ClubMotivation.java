public class ClubMotivation extends Club{
    private double motivation;
    public ClubMotivation(double attack, double defence, double midfield, double form, double motivation) {
        super(attack, defence, midfield, form);
    }

    public double getMotivation() {
        return motivation;
    }
}
