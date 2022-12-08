public class MyFarmController {
    private MyFarmView myFarmView;
    private MyFarmModel myFarmModel;

    public MyFarmController(MyFarmView view, MyFarmModel model){
        this.myFarmModel = model;
        this.myFarmView = view;
    }
}
