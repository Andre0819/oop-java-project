//TO DO: Need to include MyFarmModel

import java.awt.event.*;

public class MyFarmController {

    private MyFarmView myFarmView;

    public MyFarmController(MyFarmView myFarmView) {
        this.myFarmView = myFarmView;

        //NOTE
        //setFeedbackTextArea for feedback when player has action
        //setPlayerDataTextArea for player data update (?)

        //button listeners for the tiles
        this.myFarmView.setTileButtonListeners(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object o = e.getSource();

                for (int i = 0; i < 50; i++) {
                    if (o == myFarmView.getTileButtons().get(i)) {

                        //testing feedback in GUI
                        myFarmView.setFeedbackTextArea("Tile [" + i + "]");
                        break;
                    }
                }
            }
        });

        //setting plow btn listener
        this.myFarmView.setPlowBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myFarmView.setFeedbackTextArea("Plow selected"); //testing feedback
            }
        });

        //setting plow btn listener
        this.myFarmView.setWaterBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myFarmView.setFeedbackTextArea("Watering can selected"); //test
            }
        });

        //setting fert btn listener
        this.myFarmView.setFertBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myFarmView.setFeedbackTextArea("Fertilizer selected"); //test
            }
        });

        //setting pickaxe btn listener
        this.myFarmView.setPickaxeBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myFarmView.setFeedbackTextArea("Pickaxe selected"); //test
            }
        });

        //setting shovel btn listener
        this.myFarmView.setShovelBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myFarmView.setFeedbackTextArea("Shovel selected"); //test
            }
        });

        //setting harvest btn listener
        this.myFarmView.setHarvestBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myFarmView.setFeedbackTextArea("Harvest selected"); //test
            }
        });

        //setting regFarm btn listener
        this.myFarmView.setRegFarmBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myFarmView.setFeedbackTextArea("Register selected"); //test
            }
        });

        //setting plant btn listener
        this.myFarmView.setPlantBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myFarmView.setFeedbackTextArea("Plant selected"); //test
            }
        });

        //setting end day btn listener
        this.myFarmView.setEndDayBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myFarmView.setFeedbackTextArea("End day selected"); //test
            }
        });

        //setting ghost btn listener
        //ghost button for fun, and para pantay yung buttons sa GUI
        this.myFarmView.setGhostBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myFarmView.setFeedbackTextArea("Boo!"); //test
            }
        });

        //setting option buttons listener
        this.myFarmView.setOptionButtonListeners(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object o = e.getSource();

                for (int i = 0; i < 8; i++) {
                    if (o == myFarmView.getOptionButtons().get(i)) {
                        myFarmView.setFeedbackTextArea("Option [" + i + "]"); //test
                        break;
                    }
                }
            }
        });
    }
}
