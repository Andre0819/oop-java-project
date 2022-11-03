public class Player {
    private Tiles farmLot;
    private double objectcoin;

    public Player(){
        this.farmLot = new Tiles();
        this.objectcoin = 100;
    }

    public Tiles getFarmLot(){return this.farmLot;}
    public double getObjectcoin(){return this.objectcoin;}
    public void setObjectcoin(double coin){this.objectcoin = coin;}
}

