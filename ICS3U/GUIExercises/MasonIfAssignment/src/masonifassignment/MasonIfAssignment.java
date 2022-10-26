/*
Roan Mason
03/31/22

Flow Chart: https://lucid.app/lucidchart/47dfae7f-30dc-4ebb-b78c-917695e5b6f4/edit?beaconFlowId=1CEB1EF15194F1B7&invitationId=inv_d9cf11cb-3b34-438e-b25d-a5e323b636f9&page=0_0#

Create a program that simulates an online order form for a restaurant. 
You can pick any restaurant you like, real or fake.

Program Evaluation
		
Documentation
Flowchart(as .png file)				/ 6 T
Name, Date, Purpose of the Program		/ 1 C
Comments throughout the program
 and naming conventions				/ 2 C

Rough Copies Submitted on Time                  / 1 C 		

Output 
Formatted with $ and decimals			/ 1 C
Shows full breakdown of cost			/ 2 C

Input
Specific prompts and error checking		/ 1 A
User friendly form objects			/ 1 T

Processing
Correct calculations for totals			/ 2 A
Correctly applied discount			/ 1 A
Parallel structure				/ 2 A

Razzle Dazzle (must be listed)			/ 1 T

- add button to choose another pizza

 */
package masonifassignment;

import java.text.DecimalFormat;
import java.awt.Color;

public class MasonIfAssignment extends javax.swing.JFrame {

    double baseCost = 0;
    double toppingsCost = 0;
    double comboCost = 0;
    double total = 0;
    int NumOfPatties = 0;
    String recipt = "";
    String sToppings = "";

    DecimalFormat money = new DecimalFormat("$#,##0.00");

    public MasonIfAssignment() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupPatty = new javax.swing.ButtonGroup();
        btnGroupDrinks = new javax.swing.ButtonGroup();
        btnGroupSides = new javax.swing.ButtonGroup();
        pPatty = new javax.swing.JPanel();
        rbBeef = new javax.swing.JRadioButton();
        rbChicken = new javax.swing.JRadioButton();
        rbTurkey = new javax.swing.JRadioButton();
        rbVeggie = new javax.swing.JRadioButton();
        pToppings = new javax.swing.JPanel();
        cbCheese = new javax.swing.JCheckBox();
        cbLettuce = new javax.swing.JCheckBox();
        cbPickle = new javax.swing.JCheckBox();
        cbTomato = new javax.swing.JCheckBox();
        cbOnion = new javax.swing.JCheckBox();
        cbBacon = new javax.swing.JCheckBox();
        btnOrder = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        pCondiments = new javax.swing.JPanel();
        cbKetchup = new javax.swing.JCheckBox();
        cbMustard = new javax.swing.JCheckBox();
        cbMayo = new javax.swing.JCheckBox();
        cbRelish = new javax.swing.JCheckBox();
        pDrinks = new javax.swing.JPanel();
        rbDrinkSmall = new javax.swing.JRadioButton();
        rbDrinkMedium = new javax.swing.JRadioButton();
        rbDrinkLarge = new javax.swing.JRadioButton();
        pSides = new javax.swing.JPanel();
        rbFries = new javax.swing.JRadioButton();
        rbOnionRings = new javax.swing.JRadioButton();
        rbColeslaw = new javax.swing.JRadioButton();
        pNumOfPatties = new javax.swing.JPanel();
        spNumOfPatties = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        tpRecipt = new javax.swing.JTextPane();
        rbCombo = new javax.swing.JRadioButton();
        lblCombo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mason If Assignment (Burger GUI)");
        setBackground(new java.awt.Color(255, 255, 255));

        pPatty.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Patty", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Harlow Solid Italic", 0, 16))); // NOI18N
        pPatty.setPreferredSize(new java.awt.Dimension(125, 150));

        btnGroupPatty.add(rbBeef);
        rbBeef.setFont(new java.awt.Font("Harlow Solid Italic", 0, 14)); // NOI18N
        rbBeef.setText("Beef");

        btnGroupPatty.add(rbChicken);
        rbChicken.setFont(new java.awt.Font("Harlow Solid Italic", 0, 14)); // NOI18N
        rbChicken.setText("Chicken");

        btnGroupPatty.add(rbTurkey);
        rbTurkey.setFont(new java.awt.Font("Harlow Solid Italic", 0, 14)); // NOI18N
        rbTurkey.setText("Turkey");

        btnGroupPatty.add(rbVeggie);
        rbVeggie.setFont(new java.awt.Font("Harlow Solid Italic", 0, 14)); // NOI18N
        rbVeggie.setText("Veggie");

        javax.swing.GroupLayout pPattyLayout = new javax.swing.GroupLayout(pPatty);
        pPatty.setLayout(pPattyLayout);
        pPattyLayout.setHorizontalGroup(
            pPattyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPattyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPattyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbBeef)
                    .addComponent(rbChicken)
                    .addComponent(rbTurkey)
                    .addComponent(rbVeggie))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        pPattyLayout.setVerticalGroup(
            pPattyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPattyLayout.createSequentialGroup()
                .addComponent(rbBeef)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbChicken)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbTurkey, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbVeggie)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pToppings.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Toppings", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Harlow Solid Italic", 0, 16))); // NOI18N
        pToppings.setPreferredSize(new java.awt.Dimension(150, 200));

        cbCheese.setFont(new java.awt.Font("Harlow Solid Italic", 0, 14)); // NOI18N
        cbCheese.setText("Cheese");

        cbLettuce.setFont(new java.awt.Font("Harlow Solid Italic", 0, 14)); // NOI18N
        cbLettuce.setText("Lettuce");

        cbPickle.setFont(new java.awt.Font("Harlow Solid Italic", 0, 14)); // NOI18N
        cbPickle.setText("Pickle");

        cbTomato.setFont(new java.awt.Font("Harlow Solid Italic", 0, 14)); // NOI18N
        cbTomato.setText("Tomato");

        cbOnion.setFont(new java.awt.Font("Harlow Solid Italic", 0, 14)); // NOI18N
        cbOnion.setText("Onion");

        cbBacon.setFont(new java.awt.Font("Harlow Solid Italic", 0, 14)); // NOI18N
        cbBacon.setText("Bacon");

        javax.swing.GroupLayout pToppingsLayout = new javax.swing.GroupLayout(pToppings);
        pToppings.setLayout(pToppingsLayout);
        pToppingsLayout.setHorizontalGroup(
            pToppingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pToppingsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pToppingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbLettuce)
                    .addComponent(cbPickle)
                    .addComponent(cbTomato)
                    .addComponent(cbOnion)
                    .addComponent(cbBacon)
                    .addComponent(cbCheese))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        pToppingsLayout.setVerticalGroup(
            pToppingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pToppingsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbCheese)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbLettuce)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbPickle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTomato)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbOnion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbBacon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnOrder.setBackground(new java.awt.Color(0, 0, 0));
        btnOrder.setFont(new java.awt.Font("Harlow Solid Italic", 1, 36)); // NOI18N
        btnOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnOrder.setText("Order");
        btnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(0, 0, 0));
        btnReset.setFont(new java.awt.Font("Harlow Solid Italic", 1, 36)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblTitle.setText("Title");

        pCondiments.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Condiments", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Harlow Solid Italic", 0, 16))); // NOI18N
        pCondiments.setPreferredSize(new java.awt.Dimension(125, 200));

        cbKetchup.setFont(new java.awt.Font("Harlow Solid Italic", 0, 14)); // NOI18N
        cbKetchup.setText("Ketchup");

        cbMustard.setFont(new java.awt.Font("Harlow Solid Italic", 0, 14)); // NOI18N
        cbMustard.setText("Mustard");

        cbMayo.setFont(new java.awt.Font("Harlow Solid Italic", 0, 14)); // NOI18N
        cbMayo.setText("Mayo");

        cbRelish.setFont(new java.awt.Font("Harlow Solid Italic", 0, 14)); // NOI18N
        cbRelish.setText("Relish");

        javax.swing.GroupLayout pCondimentsLayout = new javax.swing.GroupLayout(pCondiments);
        pCondiments.setLayout(pCondimentsLayout);
        pCondimentsLayout.setHorizontalGroup(
            pCondimentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCondimentsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pCondimentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbKetchup)
                    .addComponent(cbMustard)
                    .addComponent(cbMayo)
                    .addComponent(cbRelish))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        pCondimentsLayout.setVerticalGroup(
            pCondimentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCondimentsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbKetchup)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbMustard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbMayo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbRelish)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pDrinks.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Drinks", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Harlow Solid Italic", 0, 16))); // NOI18N
        pDrinks.setEnabled(false);
        pDrinks.setPreferredSize(new java.awt.Dimension(150, 200));

        btnGroupDrinks.add(rbDrinkSmall);
        rbDrinkSmall.setFont(new java.awt.Font("Harlow Solid Italic", 0, 14)); // NOI18N
        rbDrinkSmall.setText("Small");
        rbDrinkSmall.setEnabled(false);

        btnGroupDrinks.add(rbDrinkMedium);
        rbDrinkMedium.setFont(new java.awt.Font("Harlow Solid Italic", 0, 14)); // NOI18N
        rbDrinkMedium.setText("Medium");
        rbDrinkMedium.setEnabled(false);

        btnGroupDrinks.add(rbDrinkLarge);
        rbDrinkLarge.setFont(new java.awt.Font("Harlow Solid Italic", 0, 14)); // NOI18N
        rbDrinkLarge.setText("Large");
        rbDrinkLarge.setEnabled(false);

        javax.swing.GroupLayout pDrinksLayout = new javax.swing.GroupLayout(pDrinks);
        pDrinks.setLayout(pDrinksLayout);
        pDrinksLayout.setHorizontalGroup(
            pDrinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDrinksLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pDrinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbDrinkSmall)
                    .addComponent(rbDrinkMedium)
                    .addComponent(rbDrinkLarge))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        pDrinksLayout.setVerticalGroup(
            pDrinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDrinksLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbDrinkSmall)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbDrinkMedium)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbDrinkLarge)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        pSides.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sides", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Harlow Solid Italic", 0, 16))); // NOI18N
        pSides.setEnabled(false);
        pSides.setPreferredSize(new java.awt.Dimension(150, 200));

        btnGroupSides.add(rbFries);
        rbFries.setFont(new java.awt.Font("Harlow Solid Italic", 0, 14)); // NOI18N
        rbFries.setText("Fries");
        rbFries.setEnabled(false);

        btnGroupSides.add(rbOnionRings);
        rbOnionRings.setFont(new java.awt.Font("Harlow Solid Italic", 0, 14)); // NOI18N
        rbOnionRings.setText("Onion Rings");
        rbOnionRings.setEnabled(false);

        btnGroupSides.add(rbColeslaw);
        rbColeslaw.setFont(new java.awt.Font("Harlow Solid Italic", 0, 14)); // NOI18N
        rbColeslaw.setText("Coleslaw");
        rbColeslaw.setDoubleBuffered(true);
        rbColeslaw.setEnabled(false);

        javax.swing.GroupLayout pSidesLayout = new javax.swing.GroupLayout(pSides);
        pSides.setLayout(pSidesLayout);
        pSidesLayout.setHorizontalGroup(
            pSidesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSidesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pSidesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbFries)
                    .addComponent(rbOnionRings)
                    .addComponent(rbColeslaw))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        pSidesLayout.setVerticalGroup(
            pSidesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSidesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbFries)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbOnionRings)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbColeslaw)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        pNumOfPatties.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Number of Patties", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Harlow Solid Italic", 0, 16))); // NOI18N
        pNumOfPatties.setPreferredSize(new java.awt.Dimension(150, 150));

        spNumOfPatties.setFont(new java.awt.Font("Harlow Solid Italic", 1, 36)); // NOI18N
        spNumOfPatties.setModel(new javax.swing.SpinnerNumberModel(1, 1, 3, 1));
        spNumOfPatties.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout pNumOfPattiesLayout = new javax.swing.GroupLayout(pNumOfPatties);
        pNumOfPatties.setLayout(pNumOfPattiesLayout);
        pNumOfPattiesLayout.setHorizontalGroup(
            pNumOfPattiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pNumOfPattiesLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(spNumOfPatties, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        pNumOfPattiesLayout.setVerticalGroup(
            pNumOfPattiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pNumOfPattiesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spNumOfPatties, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );

        tpRecipt.setEditable(false);
        tpRecipt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(tpRecipt);

        rbCombo.setFont(new java.awt.Font("Harlow Solid Italic", 0, 18)); // NOI18N
        rbCombo.setText("Combo Order");
        rbCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbComboActionPerformed(evt);
            }
        });

        lblCombo.setFont(new java.awt.Font("Harlow Solid Italic", 0, 18)); // NOI18N
        lblCombo.setText("Would you like a Combo Order?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pPatty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pCondiments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pToppings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pDrinks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pSides, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pNumOfPatties, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addComponent(lblCombo))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(95, 95, 95)
                                        .addComponent(rbCombo)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnOrder)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                                .addComponent(btnReset))
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset)
                    .addComponent(btnOrder))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pPatty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pCondiments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pNumOfPatties, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addComponent(lblCombo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbCombo)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pDrinks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pSides, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pToppings, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                        .addContainerGap(35, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(30, 30, 30))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderActionPerformed
        // TODO add your handling code here:

        btnOrder.setEnabled(false);

        recipt += "Your Recipt:\n\n";

        //Determining what patty the user has chosen. Then setting the price
        if (rbVeggie.isSelected() == true) { //veggie
            baseCost = 7.99;
            recipt += "Selected patty:\tVeggie\t$7.99\n";
        } else if (rbChicken.isSelected() == true) { //chicken 
            baseCost = 6.99;
            recipt += "Selected patty:\tChicken\t$6.99\n";
        } else if (rbTurkey.isSelected() == true) { //turkey
            baseCost = 6.99;
            recipt += "Selected patty:\tTurkey\t$6.99\n";
        } else { //beef is default
            baseCost = 5.99;
            recipt += "Selected patty:\tBeef\t$5.99\n";
        }

        //Number of Patties
        NumOfPatties = (int) spNumOfPatties.getValue();
        recipt += "Number of patties:\t" + NumOfPatties + "\t" + money.format(NumOfPatties * 0.99) + "\nToppings:\t\t\t";
        baseCost = baseCost + (NumOfPatties * 0.99);

        //Condiments and Toppings
        if (cbKetchup.isSelected() == true) {
            sToppings += "Ketchup, ";
            toppingsCost += 0.50;
        }
        if (cbMustard.isSelected() == true) {
            sToppings += "Mustard, ";
            toppingsCost += 0.50;
        }
        if (cbMayo.isSelected() == true) {
            sToppings += "Mayo, ";
            toppingsCost += 0.50;
        }
        if (cbRelish.isSelected() == true) {
            sToppings += "Relish, ";
            toppingsCost += 0.50;
        }
        if (cbCheese.isSelected() == true) {
            sToppings += "Cheese, ";
            toppingsCost += 0.50;
        }
        if (cbLettuce.isSelected() == true) {
            sToppings += "Lettuce, ";
            toppingsCost += 0.50;
        }
        if (cbPickle.isSelected() == true) {
            sToppings += "Pickle, ";
            toppingsCost += 0.50;
        }
        if (cbTomato.isSelected() == true) {
            sToppings += "Tomato, ";
            toppingsCost += 0.50;
        }
        if (cbOnion.isSelected() == true) {
            sToppings += "Onion, ";
            toppingsCost += 0.50;
        }
        if (cbBacon.isSelected() == true) {
            sToppings += "Bacon, ";
            toppingsCost += 1.00;
        }
        baseCost += toppingsCost;

        recipt += money.format(toppingsCost) + "\n" + sToppings + "\n\nBurger Cost:\t\t" + money.format(baseCost) + "\n\nCombo Order:\t";

        if (rbCombo.isSelected() == true) {
            recipt += "Yes\n";
            if (rbDrinkSmall.isSelected() == true) {
                comboCost += 1.99;
                recipt += "Drink size:\t\tSmall\n";
            } else if (rbDrinkMedium.isSelected() == true) {
                comboCost += 2.49;
                recipt += "Drink size:\t\tMedium\n";
            } else {
                comboCost += 2.99;
                recipt += "Drink size:\t\tLarge\n";
            }
            if (rbFries.isSelected() == true) {
                recipt += "Side:\t\tFries\n";
            } else if (rbOnionRings.isSelected() == true) {
                recipt += "Side:\t\tOnion Rings\n";
            } else {
                recipt += "Side:\t\tColeslaw\n";
            }
            comboCost += 4.99; //Combo default $ without drink $
            recipt += "\nCombo Cost:\t\t" + money.format(comboCost);
        } else {
            recipt += "No\n";
        }

        total = baseCost + comboCost;
        recipt += "\n\nSubTotal:\t\t" + money.format(total) + "\nTotal:\t\t" + money.format(total * 1.13);

        tpRecipt.setText(recipt);
    }//GEN-LAST:event_btnOrderActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:

        btnOrder.setEnabled(true); //re-enable order button

        //reset all variables
        tpRecipt.setText("");
        baseCost = 0;
        toppingsCost = 0;
        comboCost = 0;
        total = 0;
        NumOfPatties = 0;
        recipt = "";
        sToppings = "";

        rbCombo.setSelected(false); //reset combo box
        //unenable combo related peices of the GUI
        pDrinks.setEnabled(false);
        rbDrinkSmall.setEnabled(false);
        rbDrinkMedium.setEnabled(false);
        rbDrinkLarge.setEnabled(false);
        pSides.setEnabled(false);
        rbFries.setEnabled(false);
        rbOnionRings.setEnabled(false);
        rbColeslaw.setEnabled(false);
        //reset color of text
        lblCombo.setForeground(new Color(0, 0, 0));

        btnGroupPatty.clearSelection(); //unselect patty
        btnGroupDrinks.clearSelection(); //unselect drink size
        btnGroupSides.clearSelection(); //unselect sides

        spNumOfPatties.setValue(1); //reset spinner

        //reset all check boxes
        cbKetchup.setSelected(false);
        cbMustard.setSelected(false);
        cbMayo.setSelected(false);
        cbRelish.setSelected(false);
        cbCheese.setSelected(false);
        cbLettuce.setSelected(false);
        cbPickle.setSelected(false);
        cbTomato.setSelected(false);
        cbOnion.setSelected(false);
        cbBacon.setSelected(false);

    }//GEN-LAST:event_btnResetActionPerformed

    private void rbComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbComboActionPerformed
        // TODO add your handling code here:
        //Check if combo button is selected
        if (rbCombo.isSelected() == true) { //if yes. enable combo related peices of the GUI
            pDrinks.setEnabled(true);
            rbDrinkSmall.setEnabled(true);
            rbDrinkMedium.setEnabled(true);
            rbDrinkLarge.setEnabled(true);
            pSides.setEnabled(true);
            rbFries.setEnabled(true);
            rbOnionRings.setEnabled(true);
            rbColeslaw.setEnabled(true);
            lblCombo.setForeground(new Color(0, 191, 0));

        } else { //if no. unenable combo related peices of the GUI
            pDrinks.setEnabled(false);
            rbDrinkSmall.setEnabled(false);
            rbDrinkMedium.setEnabled(false);
            rbDrinkLarge.setEnabled(false);
            pSides.setEnabled(false);
            rbFries.setEnabled(false);
            rbOnionRings.setEnabled(false);
            rbColeslaw.setEnabled(false);
            lblCombo.setForeground(new Color(0, 0, 0));
        }

    }//GEN-LAST:event_rbComboActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MasonIfAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MasonIfAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MasonIfAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MasonIfAssignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MasonIfAssignment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupDrinks;
    private javax.swing.ButtonGroup btnGroupPatty;
    private javax.swing.ButtonGroup btnGroupSides;
    private javax.swing.JButton btnOrder;
    private javax.swing.JButton btnReset;
    private javax.swing.JCheckBox cbBacon;
    private javax.swing.JCheckBox cbCheese;
    private javax.swing.JCheckBox cbKetchup;
    private javax.swing.JCheckBox cbLettuce;
    private javax.swing.JCheckBox cbMayo;
    private javax.swing.JCheckBox cbMustard;
    private javax.swing.JCheckBox cbOnion;
    private javax.swing.JCheckBox cbPickle;
    private javax.swing.JCheckBox cbRelish;
    private javax.swing.JCheckBox cbTomato;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCombo;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pCondiments;
    private javax.swing.JPanel pDrinks;
    private javax.swing.JPanel pNumOfPatties;
    private javax.swing.JPanel pPatty;
    private javax.swing.JPanel pSides;
    private javax.swing.JPanel pToppings;
    private javax.swing.JRadioButton rbBeef;
    private javax.swing.JRadioButton rbChicken;
    private javax.swing.JRadioButton rbColeslaw;
    private javax.swing.JRadioButton rbCombo;
    private javax.swing.JRadioButton rbDrinkLarge;
    private javax.swing.JRadioButton rbDrinkMedium;
    private javax.swing.JRadioButton rbDrinkSmall;
    private javax.swing.JRadioButton rbFries;
    private javax.swing.JRadioButton rbOnionRings;
    private javax.swing.JRadioButton rbTurkey;
    private javax.swing.JRadioButton rbVeggie;
    private javax.swing.JSpinner spNumOfPatties;
    private javax.swing.JTextPane tpRecipt;
    // End of variables declaration//GEN-END:variables
}
