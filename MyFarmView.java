import javax.swing.border.Border;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class MyFarmView {

    private JFrame mainFrame;

    private JLabel introMsg;

    private JTextArea playerDataTextArea, feedbackTextArea;

    private JButton plowBtn, waterBtn, fertBtn, pickaxeBtn, shovelBtn, harvestBtn, regFarmBtn, plantBtn;

    private ArrayList<JButton> tileButtons, optionButtons;



    public MyFarmView() {
        mainFrame = new JFrame("MyFarm Simulation Game");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(750, 750);
        mainFrame.setLayout(new BorderLayout(10, 10));

        /* Dividing the frame to three panels */
        JPanel panelData = new JPanel(); //contains introductory comments
        JPanel panelTiles = new JPanel(); //contains the tiles
        JPanel panelActions = new JPanel(); //contains feedback + commands

        //characteristics of panels

        //dimensions
        panelData.setPreferredSize(new Dimension(100, 200));
        panelTiles.setPreferredSize(new Dimension(400, 200));
        panelActions.setPreferredSize(new Dimension(100, 200));

        //colors
        panelData.setBackground(Color.white);
        panelTiles.setBackground(Color.white);
        panelActions.setBackground(Color.white);

        /* panelData (NORTH) adding elements */
        //sub panels: introMsg (NORTH), playerData (CENTER)
        panelData.setLayout(new BorderLayout());

        //introductory msg
        ImageIcon introMsgIcon = new ImageIcon("introductoryMsg.png");
        JPanel subPanelIntro = new JPanel();
        introMsg = new JLabel();
        introMsg.setIcon(introMsgIcon);

        subPanelIntro.add(introMsg);
        panelData.add(subPanelIntro, BorderLayout.NORTH);

        //player data display
        JPanel subPanelPlayerData = new JPanel();
        playerDataTextArea = new JTextArea(" ");

        Border border1 = BorderFactory.createLineBorder(new Color(0, 100, 0),3);
        playerDataTextArea.setPreferredSize(new Dimension(400, 100));
        playerDataTextArea.setBorder(border1);
        playerDataTextArea.setEditable(false);

        subPanelPlayerData.add(playerDataTextArea);
        panelData.add(subPanelPlayerData, BorderLayout.CENTER);

        /* panelTiles (CENTER) adding the tile buttons */
        panelTiles.setLayout(new GridLayout(5, 10, 5, 5));

        tileButtons = new ArrayList<JButton>();
        ImageIcon tileIcon = new ImageIcon("landIcon.png");

        for (int i = 0; i < 50; i++) {
            tileButtons.add(new JButton(Integer.toString(i)));
            JButton tempButton = tileButtons.get(i);
            tempButton.setIcon(tileIcon);
            tempButton.setHorizontalTextPosition(JButton.CENTER);
            tempButton.setVerticalTextPosition(JButton.BOTTOM);
            tempButton.setIconTextGap(-10);
            panelTiles.add(tempButton);
        }

        /* panelActions (SOUTH) adding elements */
        // sub panels: feedback (WEST), playerCommands (EAST)
        panelActions.setLayout(new BorderLayout());

        //feedback text area
        JPanel subPanelFeedback = new JPanel();

        feedbackTextArea = new JTextArea(" ");
        feedbackTextArea.setPreferredSize(new Dimension(320, 170));
        Border border2 = BorderFactory.createLineBorder(new Color(92, 64, 51),3);
        feedbackTextArea.setBorder(border2);
        feedbackTextArea.setEditable(false);

        subPanelFeedback.add(feedbackTextArea);
        panelActions.add(subPanelFeedback, BorderLayout.WEST);

        //playerCommands
        //sub panels_2: tools, general, options

        JPanel subPanelPlayerCommands = new JPanel();
        subPanelPlayerCommands.setLayout(new BorderLayout());

        //subPanel2Tools
        JPanel subPanel2Tools = new JPanel();
        subPanel2Tools.setLayout(new GridLayout(2, 4, 1, 1));

        plowBtn = new JButton("Plow");
        ImageIcon plowIcon = new ImageIcon("plowIcon.png");
        plowBtn.setIcon(plowIcon);
        plowBtn.setHorizontalTextPosition(JButton.CENTER);
        plowBtn.setVerticalTextPosition(JButton.BOTTOM);

        waterBtn = new JButton("Watering Can");
        ImageIcon waterIcon = new ImageIcon("waterIcon.jpg");
        waterBtn.setIcon(waterIcon);
        waterBtn.setHorizontalTextPosition(JButton.CENTER);
        waterBtn.setVerticalTextPosition(JButton.BOTTOM);

        fertBtn = new JButton("Fertilizer");
        ImageIcon fertilizerIcon = new ImageIcon("fertilizerIcon.png");
        fertBtn.setIcon(fertilizerIcon);
        fertBtn.setHorizontalTextPosition(JButton.CENTER);
        fertBtn.setVerticalTextPosition(JButton.BOTTOM);

        pickaxeBtn = new JButton("Pickaxe");
        ImageIcon axeIcon = new ImageIcon("axeIcon.png");
        pickaxeBtn.setIcon(axeIcon);
        pickaxeBtn.setHorizontalTextPosition(JButton.CENTER);
        pickaxeBtn.setVerticalTextPosition(JButton.BOTTOM);

        shovelBtn = new JButton("Shovel");
        ImageIcon shovelIcon = new ImageIcon("shovelIcon.png");
        shovelBtn.setIcon(shovelIcon);
        shovelBtn.setHorizontalTextPosition(JButton.CENTER);
        shovelBtn.setVerticalTextPosition(JButton.BOTTOM);

        plantBtn = new JButton("Plant Seed");
        ImageIcon seedIcon = new ImageIcon("seedIcon.png");
        plantBtn.setIcon(seedIcon);
        plantBtn.setHorizontalTextPosition(JButton.CENTER);
        plantBtn.setVerticalTextPosition(JButton.BOTTOM);

        harvestBtn = new JButton("Harvest Crop");
        ImageIcon coinIcon = new ImageIcon("coinIcon.jpg");
        harvestBtn.setIcon(coinIcon);
        harvestBtn.setHorizontalTextPosition(JButton.CENTER);
        harvestBtn.setVerticalTextPosition(JButton.BOTTOM);

        regFarmBtn = new JButton("Register");
        ImageIcon farmerTypeIcon = new ImageIcon("farmerTypeIcon.png");
        regFarmBtn.setIcon(farmerTypeIcon);
        regFarmBtn.setHorizontalTextPosition(JButton.CENTER);
        regFarmBtn.setVerticalTextPosition(JButton.BOTTOM);

        subPanel2Tools.add(plowBtn);
        subPanel2Tools.add(waterBtn);
        subPanel2Tools.add(fertBtn);
        subPanel2Tools.add(pickaxeBtn);
        subPanel2Tools.add(shovelBtn);
        subPanel2Tools.add(plantBtn);
        subPanel2Tools.add(harvestBtn);
        subPanel2Tools.add(regFarmBtn);


        //subPanel2Options
        JPanel subPanel2Options = new JPanel();
        subPanel2Options.setLayout(new GridLayout(1, 8, 0, 0));
        optionButtons = new ArrayList<JButton>();

        for (int i = 0; i < 8; i++) { //8 options of seeds
            optionButtons.add(new JButton(Integer.toString(i + 1)));
            JButton tempButton = optionButtons.get(i);
            subPanel2Options.add(tempButton);
        }

        //storing to all subPanel2 to subPanelPlayerCommands
        subPanelPlayerCommands.add(subPanel2Tools, BorderLayout.CENTER);
        subPanelPlayerCommands.add(subPanel2Options, BorderLayout.SOUTH);
        panelActions.add(subPanelPlayerCommands);

        /* adding the panels to mainframe */
        mainFrame.add(panelData, BorderLayout.NORTH);
        mainFrame.add(panelTiles, BorderLayout.CENTER);
        mainFrame.add(panelActions, BorderLayout.SOUTH);

        mainFrame.setVisible(true);
    }

    //add setters here


}
