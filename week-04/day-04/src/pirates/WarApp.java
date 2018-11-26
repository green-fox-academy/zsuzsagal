package pirates;

public class WarApp {
    public static void main(String[] args) {
        //  Create a WarApp class with a main method
        //  Create 2 armadas, fill them with ships
        //  Have a war!

        Armada armadaOur = new Armada("OUR ARMADA");
        armadaOur.fillArmada();
        armadaOur.printArmadaStatus();

        Armada armadaOther = new Armada("OPPONENT ARMADA");
        armadaOther.fillArmada();
        armadaOther.printArmadaStatus();

        armadaOur.war(armadaOther);
    }
}

