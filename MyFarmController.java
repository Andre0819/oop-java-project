

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
/**
 * MyFarmController class represents the controller of the game.
 *
 */
public class MyFarmController {
    private MyFarmModel myFarmModel;
    private MyFarmView myFarmView;
    private Integer selected;
    private boolean plantBtnClicked;

    /**
     * This constructor assigns the initial values to the attributes of MyFarmController
     * It takes in MyFarmView and MyFarmModel objects as parameters.
     * This also contains the action listeners to be set to the buttons from MyFarmView
     * which is connected to the MyFarmModel.
     *
     * @param myFarmView MyFarmView object
     * @param myFarmModel MyFarmModel object
     *
     */

    public MyFarmController(MyFarmView myFarmView, MyFarmModel myFarmModel) {
        this.myFarmView = myFarmView;
        this.myFarmModel = myFarmModel;
        this.selected = null;
        this.plantBtnClicked = false;
        //NOTE
        //setFeedbackTextArea for feedback when player has action
        //setPlayerDataTextArea for player data update (?)
        ArrayList<Tile> farmLot = myFarmModel.getPlayer().getFarmLot();
        Player player = myFarmModel.getPlayer();

        //button listeners for the tiles
        this.myFarmView.setTileButtonListeners(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartPopup();
                Object o = e.getSource();

                for (int i = 0; i < 50; i++) {
                    if (o == myFarmView.getTileButtons().get(i)) {
                        selected = i;
                        //testing feedback in GUI
                        myFarmView.setFeedbackTextArea("Tile [" + (selected + 1) + "] Status:" +
                                "\nPlowed: " + farmLot.get(selected).getIsPlowed() +
                                "\nRocks: " + farmLot.get(selected).getHasRocks() +
                                (farmLot.get(selected).getSeed() != null ? ("\nSeed: " + farmLot.get(selected).getSeed().getSeedName() +
                                        "\nTimes Watered: " + farmLot.get(selected).getWateredCrop() +
                                        "\nTimes Fertilized: " + farmLot.get(selected).getFertilizedCrop() +
                                        "\nCrop Withered: " + farmLot.get(selected).getWitherStatus() +
                                        "\nDay Planted: " + farmLot.get(selected).getDayPlanted() +
                                        "\nHarvest Day: " + (farmLot.get(selected).getDayPlanted() + farmLot.get(selected).getSeed().getHarvestTime())) : "\nSeed: None")
                        );
                        if (farmLot.get(selected).getSeed() != null) {
                            if (farmLot.get(selected).getDayPlanted() + farmLot.get(selected).getSeed().getHarvestTime() == myFarmModel.getDay())
                                myFarmView.setHarvestBtnClickable(true);
                            else myFarmView.setHarvestBtnClickable(false);
                        }
                        myFarmView.setTileClicked(true);
                        break;
                    }
                }
            }
        });

        //setting plow btn listener
        this.myFarmView.setPlowBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartPopup();
                if (myFarmView.isTileClicked()) {
                    myFarmView.setTileClicked(false);
                    // Show a confirmation dialog with action cost when the button is clicked
                    int result = JOptionPane.showConfirmDialog(null, actionConfirmation(2), "Action Confirmation", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        if (myFarmModel.getTools().get(2).useTool(farmLot.get(selected), myFarmModel.getPlayer())) {
                            myFarmView.setFeedbackTextArea("Plow used on Tile " + (selected + 1));
                        } else myFarmView.setFeedbackTextArea("You cannot perform the action on Tile " + (selected + 1));
                    }
                    myFarmView.setPlayerDataTextArea(
                            player.getFarmerLevel(),
                            player.getFarmerExp(),
                            player.getObjectcoin(),
                            player.getFarmerType().getTypeName(),
                            myFarmModel.getDay());
                    selected = null;
                } else myFarmView.setFeedbackTextArea("Select a tile first");
            }
        });

        //setting plow btn listener
        this.myFarmView.setWaterBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartPopup();
                if (myFarmView.isTileClicked()) {
                    myFarmView.setTileClicked(false);
                    // Show a confirmation dialog with action cost when the button is clicked

                    int result = JOptionPane.showConfirmDialog(null, actionConfirmation(4), "Action Confirmation", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        if (myFarmModel.getTools().get(4).useTool(farmLot.get(selected), myFarmModel.getPlayer())) {
                            myFarmView.setFeedbackTextArea("Watering Can used on Tile " + (selected + 1));
                        } else
                            myFarmView.setFeedbackTextArea("You cannot perform the action on Tile " + (selected + 1));
                    }
                    myFarmView.setPlayerDataTextArea(
                            player.getFarmerLevel(),
                            player.getFarmerExp(),
                            player.getObjectcoin(),
                            player.getFarmerType().getTypeName(),
                            myFarmModel.getDay());
                    selected = null;
                } else myFarmView.setFeedbackTextArea("Select a tile first");
            }
        });

        //setting fert btn listener
        this.myFarmView.setFertBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartPopup();
                if (myFarmView.isTileClicked()) {
                    myFarmView.setTileClicked(false);
                    // Show a confirmation dialog with action cost when the button is clicked

                    int result = JOptionPane.showConfirmDialog(null, actionConfirmation(0), "Action Confirmation", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        if (myFarmModel.getTools().get(0).useTool(farmLot.get(selected), myFarmModel.getPlayer())) {
                            myFarmView.setFeedbackTextArea("Fertilizer used on Tile " + (selected + 1));
                        } else
                            myFarmView.setFeedbackTextArea("You cannot perform the action on Tile " + (selected + 1));
                    }
                    myFarmView.setPlayerDataTextArea(
                            player.getFarmerLevel(),
                            player.getFarmerExp(),
                            player.getObjectcoin(),
                            player.getFarmerType().getTypeName(),
                            myFarmModel.getDay());
                    selected = null;
                } else myFarmView.setFeedbackTextArea("Select a tile first");
            }
        });

        //setting pickaxe btn listener
        this.myFarmView.setPickaxeBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartPopup();
                if (myFarmView.isTileClicked()) {
                    myFarmView.setTileClicked(false);
                    // Show a confirmation dialog with action cost when the button is clicked

                    int result = JOptionPane.showConfirmDialog(null, actionConfirmation(1), "Action Confirmation", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        if (myFarmModel.getTools().get(1).useTool(farmLot.get(selected), myFarmModel.getPlayer())) {
                            myFarmView.setFeedbackTextArea("Pickaxe used on Tile " + (selected + 1));
                        } else
                            myFarmView.setFeedbackTextArea("You cannot perform the action on Tile " + (selected + 1));
                    }
                    myFarmView.setPlayerDataTextArea(
                            player.getFarmerLevel(),
                            player.getFarmerExp(),
                            player.getObjectcoin(),
                            player.getFarmerType().getTypeName(),
                            myFarmModel.getDay());
                    selected = null;
                } else myFarmView.setFeedbackTextArea("Select a tile first");
            }
        });

        //setting shovel btn listener
        this.myFarmView.setShovelBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartPopup();
                if (myFarmView.isTileClicked()) {
                    myFarmView.setTileClicked(false);
                    // Show a confirmation dialog with action cost when the button is clicked
                    int result = JOptionPane.showConfirmDialog(null, actionConfirmation(3), "Action Confirmation", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        if (myFarmModel.getTools().get(3).useTool(farmLot.get(selected), myFarmModel.getPlayer())) {
                            myFarmView.setFeedbackTextArea("Shovel used on Tile " + (selected + 1));
                        } else
                            myFarmView.setFeedbackTextArea("You do not have enough objectcoins.");
                    }
                    myFarmView.setPlayerDataTextArea(
                            player.getFarmerLevel(),
                            player.getFarmerExp(),
                            player.getObjectcoin(),
                            player.getFarmerType().getTypeName(),
                            myFarmModel.getDay());
                    selected = null;
                } else myFarmView.setFeedbackTextArea("Select a Tile first.");
            }
        });

        //setting harvest btn listener
        this.myFarmView.setHarvestBtnListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                restartPopup();
                myFarmView.setFeedbackTextArea("Harvest selected"); //test
                if (myFarmView.isTileClicked()) {
                    myFarmView.setTileClicked(false);

                    farmLot.get(selected).harvestCrop(player, myFarmModel.getDay());
                    myFarmView.setFeedbackTextArea("Tile "+selected+" successfully harvested." +
                            "\nProducts produced: "+ farmLot.get(selected).getHarvestProduce() +
                            "\nSold for a total of "+farmLot.get(selected).getFinalTotal()+" objectcoins.");

                    farmLot.get(selected).setHarvestProduce(0);
                    farmLot.get(selected).setFinalTotal(0);

                    myFarmView.setPlayerDataTextArea(
                            player.getFarmerLevel(),
                            player.getFarmerExp(),
                            player.getObjectcoin(),
                            player.getFarmerType().getTypeName(),
                            myFarmModel.getDay());
                    selected = null;
                    myFarmView.setHarvestBtnClickable(false);


                } else myFarmView.setFeedbackTextArea("Select a Tile first.");
            }
        });

        //setting regFarm btn listener
        this.myFarmView.setRegFarmBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartPopup();
                myFarmView.setFeedbackTextArea("Register selected"); //test
                int result = JOptionPane.showConfirmDialog(null, "Registration costs objectcoins", "Action Confirmation", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    if (player.updateFarmerType()) {
                        myFarmView.setFeedbackTextArea("Registration Successful!" +
                                "\nYou are now a " + player.getFarmerType() + "." +
                                "\nYou spent "+ player.getFarmerType().getRegFee()+" objectcoins.");
                        myFarmView.setPlayerDataTextArea(
                                player.getFarmerLevel(),
                                player.getFarmerExp(),
                                player.getObjectcoin(),
                                player.getFarmerType().getTypeName(),
                                myFarmModel.getDay());
                    } else {
                        myFarmView.setFeedbackTextArea("Registration Unsuccessful!" +
                                "\nYou do not have enough objectcoins.");
                    }
                }
            }
        });

        //setting plant btn listener
        this.myFarmView.setPlantBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartPopup();
                myFarmView.setFeedbackTextArea("Select seed to plant."); //test
                if (myFarmView.isTileClicked()) {
                    plantBtnClicked = true;
                    for (int i = 0; i < myFarmView.getSeedOptionBtns().size(); i++) {
                        if (player.getObjectcoin() > (myFarmModel.getSeeds().get(i).getSeedCost() - player.getFarmerType().getCostReduction()))
                            myFarmView.getSeedOptionBtns().get(i).setEnabled(true);
                    }
                    myFarmView.setPlayerDataTextArea(
                            player.getFarmerLevel(),
                            player.getFarmerExp(),
                            player.getObjectcoin(),
                            player.getFarmerType().getTypeName(),
                            myFarmModel.getDay());
                } else myFarmView.setFeedbackTextArea("Select a Tile first."); //test
            }
        });

        this.myFarmView.setSeedOptionBtns(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object o = e.getSource();
                if (plantBtnClicked && myFarmView.isTileClicked()) {
                    plantBtnClicked = false;
                    myFarmView.setTileClicked(false);
                    for (int i = 0; i < 7; i++) {
                        if (o == myFarmView.getSeedOptionBtns().get(i)) {
                            farmLot.get(selected).plantSeed(player, myFarmModel.getSeeds().get(i), myFarmModel.getDay());
                            break;
                        }
                    }
                    if(farmLot.get(selected).getSeed()!=null)
                        myFarmView.setFeedbackTextArea(farmLot.get(selected).getSeed().getSeedName() + " planted in Tile " + (selected + 1));
                    else myFarmView.setFeedbackTextArea("Plant unsuccessful.");
                    myFarmView.setPlayerDataTextArea(
                            player.getFarmerLevel(),
                            player.getFarmerExp(),
                            player.getObjectcoin(),
                            player.getFarmerType().getTypeName(),
                            myFarmModel.getDay());
                }
                for (JButton btn : myFarmView.getSeedOptionBtns()) {
                    btn.setEnabled(false);
                }
                selected = null;
            }
        });

        //setting end day btn listener
        this.myFarmView.setEndDayBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartPopup();
                myFarmModel.advanceNextDay();
                myFarmView.setPlayerDataTextArea(
                        player.getFarmerLevel(),
                        player.getFarmerExp(),
                        player.getObjectcoin(),
                        player.getFarmerType().getTypeName(),
                        myFarmModel.getDay());
                myFarmView.setFeedbackTextArea("End day selected"); //test

            }
        });

        //setting ghost btn listener
        //ghost button for fun, and para pantay yung buttons sa GUI
        this.myFarmView.setCheckGameEndBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(myFarmModel.checkGameEnd()){
                    myFarmView.setFeedbackTextArea("You still have tasks to do!\nPlay on!"); //test

                }else
                    myFarmView.setFeedbackTextArea("You still have tasks to do!\nPlay on!"); //test
            }
        });
    }

    /**
     * This method checks for whether the game will end.
     * If true, a pop-up asking for restarting the game will appear.
     * If option Yes is selected, the game will restart. Otherwise,
     * the application will close.
     *
     */

    public void restartPopup(){
        if(myFarmModel.checkGameEnd()) {
            int result = JOptionPane.showConfirmDialog(null, "Restart the Game?", "Game Over!", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                MyFarmView newView = new MyFarmView();
                MyFarmModel newModel = new MyFarmModel();
                MyFarmController newcontrol = new MyFarmController(newView, newModel);
            } else if (result == JOptionPane.NO_OPTION) {
                myFarmView.getMainFrame().dispose();
            }
        }
    }

    /**
     * This method confirms if action on the chosen tool is intended
     *
     * @param index of the tool
     * @return the string response
     */
    public String actionConfirmation(int index){
        Tool tool = myFarmModel.getTools().get(index);
        return tool.getToolName()+" costs "+tool.getUsageCost()+" objectcoins. Do you want to proceed?";
    }

}