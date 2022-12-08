public class Main {
    public static void main(String[] args) {
        MyFarmModel farm = new MyFarmModel();
        MyFarmView view = new MyFarmView();
        System.out.println("This is "+farm.getPlayer().getFarmLot().get(0).getIsPlowed());
        farm.getTools().get(2).useTool(farm.getPlayer().getFarmLot().get(0), farm.getPlayer());
        System.out.println("This is "+farm.getPlayer().getFarmLot().get(0).getIsPlowed());
        farm.getPlayer().getFarmLot().get(0).plantSeed(farm.getPlayer(), farm.getSeeds().get(2), 1 );
        System.out.println("Seed is "+farm.getPlayer().getFarmLot().get(0).getSeed().getSeedName()+" blNK");
        /*
        farm.spreadRocks();
        int amount = 1, truecount=0;
        for(Tile t:farm.getPlayer().getFarmLot()){
            System.out.println(amount+"  "+t.getHasRocks());
            if(t.getHasRocks()){
                truecount++;
            }
            amount++;
        }
        System.out.println((truecount));*/
        System.out.println(farm.getPlayer().getFarmerType().getTypeName());
        System.out.println(farm.getPlayer().updateFarmerType());
        System.out.println(farm.getPlayer().getFarmerType().getTypeName());
        System.out.println(farm.getPlayer().updateFarmerType());
        System.out.println(farm.getPlayer().getFarmerType().getTypeName());
    }
}