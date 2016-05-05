package frames.admins.children;

/*
 * Created by Jonah on 5/1/2016.
 */

import frames.interfaces.panels.MainPanelI;
import utils.DateUtils;

import javax.swing.*;
import java.awt.*;

public class AdminRightPanel extends JPanel implements MainPanelI
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

    private final DateUtils dateUtils = new DateUtils();

    int x = 0, y = 0;

    public AdminRightPanel()
    {
        initComponents();
        addComponents();
    }

    @Override
    public void initComponents()
    {
        //This
        setBackground(Color.RED);

        //Num Of Seeds Label
        numOfSeedsLbl.setVisible(false);

        //Num Of Seeds Text Field
        numOfSeedsTf.setVisible(false);

        //Num Of Imm. Plants Label
        numOfImmPlantsLbl.setVisible(false);

        //Num Of Imm. Plant Text Field
        numOfPlantsTf.setVisible(false);

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

        makeSaleBtn.addActionListener(e ->
        {
            int age = dateUtils.calculateAge(dobTf.getText());

            if(!(age >= 18))
            {
                System.out.println("Don't Make Sale!!");
            }
        });
    }

    @Override
    public void addComponents()
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
        gbc.weightx = 0.1;
        gbc.weighty = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(makeSaleBtn, gbc);
    }

    @Override
    public Dimension getPreferredSize()
    {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        return new Dimension(250, screen.height);
    }
}