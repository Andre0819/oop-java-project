import javax.swing.*;
import java.awt.*;

public class MyFarmView {
    private JFrame mainFrame;
    private JLabel playerExpLbl, playerLvlLbl, farmerTypeLbl, objectcoinLbl, toolsLbl, seedsLbl, farmlotLbl, feedbackLbl;
    private JTextField playerExpTf, playerLvlTf, farmerTypeTf, objectcoinTf, feedbackTf;
    private JButton upgradeFarmerTypeBtn;
    private JButton[] tileBtn, toolBtn, seedBtn;
    private JTextArea employeeListTextArea;

    public MyFarmView(){
        this.mainFrame = new JFrame();

        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setLayout(new BorderLayout());
        this.mainFrame.setBackground(Color.DARK_GRAY);
        this.mainFrame.setSize(1024, 768);

        this.tileBtn = new JButton[50];

        playerExpLbl = new JLabel("playershit");
        feedbackLbl = new JLabel("feedback");
        toolsLbl = new JLabel("Tools");
        seedsLbl = new JLabel("Seeds");
        farmlotLbl = new JLabel("FarmLot\n");
        JPanel playerInfo = new JPanel();
        playerInfo.setPreferredSize(new Dimension(1024,192));

        JPanel playershit = new JPanel(new FlowLayout(FlowLayout.CENTER));
        playershit.setPreferredSize(new Dimension(128,64));
        playershit.add(playerExpLbl);
        JPanel tools = new JPanel(new FlowLayout(FlowLayout.LEFT));
        tools.setPreferredSize(new Dimension(128,512));
        tools.add(toolsLbl);
        JPanel seeds = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        seeds.setPreferredSize(new Dimension(128,512));
        seeds.add(seedsLbl);
        JPanel feedback = new JPanel(new FlowLayout(FlowLayout.CENTER));
        feedback.setPreferredSize(new Dimension(1024,64));
        feedback.add(feedbackLbl);
        JPanel farmlot = new JPanel();
        farmlot.setLayout(new FlowLayout());
        farmlot.setPreferredSize(new Dimension(768,512));
        farmlot.add(farmlotLbl, Component.CENTER_ALIGNMENT);
        JPanel tilegrid = new JPanel();
        tilegrid.setLayout(new GridLayout(5,10,5,5));
        tilegrid.setPreferredSize(new Dimension(702,300));
        tilegrid.setBackground(Color.DARK_GRAY);


        int i = 0;
        for(i=0;i<50;i++){
            tileBtn[i] = new JButton("Tile "+(i+1));
            tileBtn[i].setPreferredSize(new Dimension(60,30));
            tileBtn[i].setMargin(new Insets(1,1,1,1));
            tilegrid.add(tileBtn[i]);
        }
        farmlot.add(tilegrid);

        mainFrame.add(playershit, BorderLayout.NORTH);
        mainFrame.add(feedback, BorderLayout.NORTH);

        mainFrame.add(farmlot);
        mainFrame.add(tools, BorderLayout.WEST);
        mainFrame.add(seeds, BorderLayout.EAST);


        this.mainFrame.setVisible(true);
    }
}
