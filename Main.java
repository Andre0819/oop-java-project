public class Main {
    public static void main(String[] args) {
        MyFarmModel farm = new MyFarmModel();
        MyFarmView view = new MyFarmView();
        MyFarmController controller = new MyFarmController(view, farm);
        
    }
}