package frames.common.parents;

/*
 * Created by Jonah on 5/1/2016.
 */

import global.Dimensions;
import utils.DateUtils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SalePanel extends JPanel
{
    private final JLabel typeOfProductLbl = new JLabel("Type Of Product");
    private final JLabel amountSoldLbl = new JLabel("Amount (Grams)");
    private final JLabel numOfSeedsLbl = new JLabel("Seeds");
    private final JLabel numOfImmPlantsLbl = new JLabel("Immature Plants");
    private final JLabel salePriceLbl = new JLabel("Price");
    private final JLabel dobLbl = new JLabel("D.O.B.   (M-D-YYYY)");

    private final JComboBox<String> typesOfProducts= new JComboBox<>();
    private final JTextField amountSoldTf = new JTextField("Amount");
    private final JCheckBox seedsOrPlantsBoughtCheckBox = new JCheckBox("Purchased Seeds Or Plants?");
    private final JTextField numOfSeedsTf = new JTextField("Seeds");
    private final JTextField numOfPlantsTf = new JTextField("Plants");
    private final JTextField salePriceTf = new JTextField("Price");
    private final JTextField dobTf = new JTextField("D.O.B.");

    private final JButton makeSaleBtn = new JButton("Make Sale");
    private final JButton resetSaleInfoBtn = new JButton("Reset Sale Info");
    private final JButton hideSalePanelBtn = new JButton("Hide Sale Bar");

    private final DateUtils dateUtils = new DateUtils();

    private int x = 0, y = 0;

    public SalePanel()
    {
        initComponents();
        addComponents();
    }

    private void initComponents()
    {
        //This
        setBackground(Color.RED);

        //Amount Sold Text Field
        amountSoldTf.setBorder(null);

        //Num Of Seeds Label
        numOfSeedsLbl.setVisible(false);

        //Num Of Seeds Text Field
        numOfSeedsTf.setVisible(false);
        numOfSeedsTf.setBorder(null);

        //Num Of Imm. Plants Label
        numOfImmPlantsLbl.setVisible(false);

        //Num Of Imm. Plant Text Field
        numOfPlantsTf.setVisible(false);
        numOfPlantsTf.setBorder(null);

        //Seeds Or Plants Checkbox
        seedsOrPlantsBoughtCheckBox.setBackground(null);

        seedsOrPlantsBoughtCheckBox.addItemListener(e1 ->
        {
            if(seedsOrPlantsBoughtCheckBox.isSelected())
            {
                numOfSeedsLbl.setVisible(true);
                numOfSeedsTf.setVisible(true);

                numOfImmPlantsLbl.setVisible(true);
                numOfPlantsTf.setVisible(true);
                x = 1;
                y = 1;

                revalidate();
                repaint();
            }
            else
            {
                numOfSeedsLbl.setVisible(false);
                numOfSeedsTf.setVisible(false);

                numOfImmPlantsLbl.setVisible(false);
                numOfPlantsTf.setVisible(false);

                x = 0;
                y = 0;

                revalidate();
                repaint();
            }
        });

        //Sale Price Text Field
        salePriceTf.setBorder(null);

        //D.O.B. Text Field
        dobTf.setBorder(null);

        makeSaleBtn.addActionListener(e ->
        {
            int age = dateUtils.calculateAge(dobTf.getText());

            if(age >= 18 && age < 21)
            {
                //Todo - Add Actual Logic

                System.out.println("Customer Better Have A Med Card!");
            }
            else if(age >= 21)
            {
                System.out.println("Legal Age For Recreational, Sell Away!");
            }
            else
            {
                System.out.println("Don't Make Sale!");
            }
        });

        resetSaleInfoBtn.addActionListener(e ->
        {

        });
    }

    private void addComponents()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(10, 5, 10, 5);
        gbc.weightx = 1.0;

        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(typeOfProductLbl, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(typesOfProducts, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(amountSoldLbl, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(amountSoldTf, gbc);

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(seedsOrPlantsBoughtCheckBox, gbc);

        gbc.gridwidth = 1;
        gbc.gridx = x;
        gbc.gridy = y + 3;
        add(numOfSeedsLbl, gbc);

        gbc.gridx = x + 1;
        gbc.gridy = y + 3;
        add(numOfSeedsTf, gbc);

        gbc.gridx = x;
        gbc.gridy = y + 4;
        add(numOfImmPlantsLbl, gbc);

        gbc.gridx = x + 1;
        gbc.gridy = y + 4;
        add(numOfPlantsTf, gbc);

        gbc.gridx = x;
        gbc.gridy = y + 5;
        add(salePriceLbl, gbc);

        gbc.gridx = x + 1;
        gbc.gridy = y + 5;
        add(salePriceTf, gbc);

        gbc.gridx = x;
        gbc.gridy = y + 6;
        add(dobLbl, gbc);

        gbc.gridx = x + 1;
        gbc.gridy = y + 6;
        add(dobTf, gbc);

        gbc.gridx = x;
        gbc.gridy = y + 7;
        gbc.gridwidth = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(makeSaleBtn, gbc);

        gbc.gridx = x;
        gbc.gridy = y + 8;
        add(resetSaleInfoBtn, gbc);

        gbc.gridx = x;
        gbc.gridy = y + 9;
        gbc.weighty = 1.0;
        add(hideSalePanelBtn, gbc);
    }

    //Keep For Layout Sizing Purposes
    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(250, Dimensions.screen.height);
    }

    public void addHideSaleBtnAction(AbstractAction action)
    {
        hideSalePanelBtn.addActionListener(action);
    }
}