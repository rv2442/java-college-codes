// Cconverter.java, version 1.02, file created, July 18, 2006.
//
// Applet for a currency converter.
//
// This file last updated July 12, 2007, by Rick WAgner.
// Copyright 2006-2006 by Adam Heard, all rights reserved.
//
// Use of this source code is authorized for educational purposes only. No use without
// proper attribution to Adam Heard
//
// The prefix naming convention used here is a modified Hungarian notation.
// "s" is string, "sf" is single precision floating point, "i" is integer, "b" is boolean,
// and "d" is dimension.

// This version is for Juan Morneo to improve.

import java.applet.*;
import java.awt.*;

public class Cconverter extends Applet
{
  // Applet instance variables:
  private String sVerNum = "1.02";                       // Only constructors can run here ("" is a constructor).
  private Dimension dApplet = null;                      // The applet panel size (set in calling html).
  private Image imOffScreen = null;                      // Offscreen image for double buffering.
  private Graphics grOffScreen = null;                   // Offscreen graphics for double buffering.
 
  private Button calculate = null;
  private TextField tfCurrencyInput = null;              // currency input box
  private TextField tfCurrencyOutput = null;             // currency output box
  private CheckboxGroup cbgCurrencyInputGroup = null;    // currency input sekection
  private Checkbox[] cbCurrencyInput = null;             // currency input buttons
  private CheckboxGroup currencyoutput_group = null;     // currency ouput sekection
  private Checkbox[] currencyoutput_buttons = null;      // currency output buttons
  private Panel panel1 = null;
  private Panel panel2 = null;
  private float sfExchangeRate = (float) 0.0;            // exchange rate to be used in calculations  
  private String sCurrencyOutput = null;

  private float DollarPound = 0;
  private float DollarEuro = 0;
  private float DollarYen = 0;
  private float PoundDollar = 0;
  private float PoundEuro = 0;
  private float PoundYen = 0;
  private float EuroDollar = 0;
  private float EuroPound = 0;
  private float EuroYen = 0;
  private float YenDollar = 0;
  private float YenPound = 0;
  private float YenEuro = 0;

  // To allow browsers to get information about the applet (not yet implemented in Netscape nor in MSIE):
  public String getAppletInfo()
  {
    return "currency converter applet, version " + sVerNum +
           ", by Adam Heard, copyright 2006,\nall rights reserved.\n\n" +
           "Compiled July 24, 2006. Modified by Rick Wagner and Juan Moreno, Source code use authorized for\n" +
           "educational purposes only. No use without attribution.\n";
  }

  // Initialize the applet
  public void init()
  {
    String sTemp = null;
    GridBagLayout gridbag = new GridBagLayout();    
    this.setBackground(Color.lightGray);
    dApplet = this.size();
    
    tfCurrencyInput = new TextField(15);			     

    tfCurrencyOutput = new TextField(15);
    tfCurrencyOutput.setEditable(false);
    
    cbgCurrencyInputGroup = new CheckboxGroup();
    cbCurrencyInput = new Checkbox[4];
    cbCurrencyInput[0] = new Checkbox("Dollars", cbgCurrencyInputGroup, true);
    cbCurrencyInput[1] = new Checkbox("Pounds", cbgCurrencyInputGroup, false);
    cbCurrencyInput[2] = new Checkbox("Euros", cbgCurrencyInputGroup, false);
    cbCurrencyInput[3] = new Checkbox("Yen", cbgCurrencyInputGroup, false);

    currencyoutput_group = new CheckboxGroup();
    currencyoutput_buttons = new Checkbox[4];
    currencyoutput_buttons[0] = new Checkbox("Dollars", currencyoutput_group, false);
    currencyoutput_buttons[1] = new Checkbox("Pounds", currencyoutput_group, true);
    currencyoutput_buttons[2] = new Checkbox("Euros", currencyoutput_group, false);
    currencyoutput_buttons[3] = new Checkbox("Yen", currencyoutput_group, false);

    panel1 = new Panel();
    panel1.setLayout(gridbag);
    panel2 = new Panel();
    panel2.setLayout(gridbag);

    constrain(panel1, new Label("Input Amount"), 0, 4, 1, 1);
    constrain(panel1, tfCurrencyInput, 0, 5, 1, 1);
    constrain(panel1, new Label("Input Currency"), 0, 6, 1, 1);
    constrain(panel1, cbCurrencyInput[0], 0, 7, 1, 1);
    constrain(panel1, cbCurrencyInput[1], 0, 8, 1, 1);
    constrain(panel1, cbCurrencyInput[2], 0, 9, 1, 1);
    constrain(panel1, cbCurrencyInput[3], 0, 10, 1, 1);

    constrain(panel2, new Label("Output Amount"), 0, 4, 1, 1);
    constrain(panel2, tfCurrencyOutput, 0, 5, 1, 1);
    constrain(panel2, new Label("Output Currency"), 0, 6, 1, 1);
    constrain(panel2, currencyoutput_buttons[0], 0, 7, 1, 1);
    constrain(panel2, currencyoutput_buttons[1], 0, 8, 1, 1);
    constrain(panel2, currencyoutput_buttons[2], 0, 9, 1, 1);
    constrain(panel2, currencyoutput_buttons[3], 0, 10, 1, 1);
    
    this.add(panel1);
    this.add(panel2);

    // Applet parameter:
    sTemp = getParameter("DollarPound");                        
    if (sTemp != null)
    {
      DollarPound = Float.valueOf(sTemp).floatValue();                       
    }
    sTemp = getParameter("DollarEuro");                        
    if (sTemp != null)
    {
      DollarEuro = Float.valueOf(sTemp).floatValue();                       
    }
    sTemp = getParameter("DollarYen");                        
    if (sTemp != null)
    {
      DollarYen = Float.valueOf(sTemp).floatValue();                       
    }
    sTemp = getParameter("PoundDollar");                        
    if (sTemp != null)
    {
      PoundDollar = Float.valueOf(sTemp).floatValue();                       
    }
    sTemp = getParameter("PoundEuro");                        
    if (sTemp != null)
    {
      PoundEuro = Float.valueOf(sTemp).floatValue();                       
    }
    sTemp = getParameter("PoundYen");                        
    if (sTemp != null)
    {
      PoundYen = Float.valueOf(sTemp).floatValue();                       
    }
    sTemp = getParameter("EuroDollar");                        
    if (sTemp != null)
    {
      EuroDollar = Float.valueOf(sTemp).floatValue();                       
    }
    sTemp = getParameter("EuroPound");                        
    if (sTemp != null)
    {
      EuroPound = Float.valueOf(sTemp).floatValue();                       
    }
    sTemp = getParameter("EuroYen");                        
    if (sTemp != null)
    {
      EuroYen = Float.valueOf(sTemp).floatValue();                       
    }
    sTemp = getParameter("YenDollar");                        
    if (sTemp != null)
    {
      YenDollar = Float.valueOf(sTemp).floatValue();                       
    }
    sTemp = getParameter("YenPound");                        
    if (sTemp != null)
    {
      YenPound = Float.valueOf(sTemp).floatValue();                       
    }
    sTemp = getParameter("YenEuro");                        
    if (sTemp != null)
    {
      YenEuro = Float.valueOf(sTemp).floatValue();                       
    }

    conversionSet();

  } // End of init()

 public void start()
  {
    System.out.println("\n" + this.getAppletInfo());         // Identify self to the Java console-aware user
 
  } // End of start()

  // Implements double buffering 
  public void update(Graphics g)
  {
    if (imOffScreen == null)
    {
      // Make sure the offscreen and graphics exist:
      imOffScreen = this.createImage(dApplet.width, dApplet.height);
      grOffScreen = imOffScreen.getGraphics();
      grOffScreen.clearRect(0, 0, dApplet.width, dApplet.height);
    }
    this.paint(grOffScreen);
    g.drawImage(imOffScreen, 0, 0, null);
  }

 // The applet frame painting function
  public void paint(Graphics g)
  {
    // Code for displaying images or drawing in the applet frame (called by the OS).
    g.clearRect(0, 0, dApplet.width, dApplet.height);        // Needed for double buffering.
    this.setBackground(Color.lightGray);                     // Ditto.
  
    drawFrame(g);                                            // Draw the frame abound the applet.\
  } // End of paint()

  private void drawFrame(Graphics g)
  {
    // Draw a recessed frame around the applet border. Designed for gray-on-gray browser background.
    g.setColor(Color.black);
    g.drawLine(0, 0, dApplet.width - 1, 0);
    g.drawLine(0, 0, 0, dApplet.height - 1);
    g.setColor(Color.white);
    g.drawLine(0, dApplet.height - 1, dApplet.width - 1, dApplet.height - 1);
    g.drawLine(dApplet.width - 1, 1, dApplet.width - 1, dApplet.height - 1);
  }
 
  private void conversionSet()
  {
    if (cbCurrencyInput[0].getState() && currencyoutput_buttons[0].getState()) // Dollars to Dollars
    { 
      sfExchangeRate = 1;
    }
    if (cbCurrencyInput[0].getState() && currencyoutput_buttons[1].getState()) // Dollars to Pounds
    { 
      sfExchangeRate = DollarPound;
    }
    if (cbCurrencyInput[0].getState() && currencyoutput_buttons[2].getState()) // Dollars to Euros 
    { 
      sfExchangeRate = DollarEuro;
    }
    if (cbCurrencyInput[0].getState() && currencyoutput_buttons[3].getState()) // Dollars to Yen
    { 
      sfExchangeRate = DollarYen;
    }
    if (cbCurrencyInput[1].getState() && currencyoutput_buttons[0].getState()) // Pounds to Dollars
    { 
      sfExchangeRate = PoundDollar;
    }
    if (cbCurrencyInput[1].getState() && currencyoutput_buttons[1].getState()) // Pounds to to Pounds
    { 
      sfExchangeRate = 1;
    }
    if (cbCurrencyInput[1].getState() && currencyoutput_buttons[2].getState()) // Pounds to to Euros 
    { 
      sfExchangeRate = PoundEuro;
    }
    if (cbCurrencyInput[1].getState() && currencyoutput_buttons[3].getState()) // Pounds to to Yen
    { 
      sfExchangeRate = PoundYen;
    }
    if (cbCurrencyInput[2].getState() && currencyoutput_buttons[0].getState()) // Euros to Dollars
    { 
      sfExchangeRate = EuroDollar;
    }
    if (cbCurrencyInput[2].getState() && currencyoutput_buttons[1].getState()) // Euros  to Pounds
    { 
      sfExchangeRate = EuroPound;
    }
    if (cbCurrencyInput[2].getState() && currencyoutput_buttons[2].getState()) // Euros to Euros 
    { 
      sfExchangeRate = 1;
    }
    if (cbCurrencyInput[2].getState() && currencyoutput_buttons[3].getState()) // Euros to Yen
    { 
      sfExchangeRate = EuroYen;
    }
    if (cbCurrencyInput[3].getState() && currencyoutput_buttons[0].getState()) // Yen to Dollars
    { 
      sfExchangeRate = YenDollar;
    }
    if (cbCurrencyInput[3].getState() && currencyoutput_buttons[1].getState()) // Yen to Pounds
    { 
      sfExchangeRate = YenPound;
    }
    if (cbCurrencyInput[3].getState() && currencyoutput_buttons[2].getState()) // Yen to Euros 
    { 
      sfExchangeRate = YenEuro;
    }
    if (cbCurrencyInput[3].getState() && currencyoutput_buttons[3].getState()) // Yen to Yen
    { 
      sfExchangeRate = 1;
    }
  }

  public boolean mouseDown(Event e, int x, int y)
  {
    return false;
  }

  // Button action events
  public boolean action(Event e, Object o)
  {
    try
    {
      if (e.target == cbCurrencyInput[0] || e.target == cbCurrencyInput[1] || e.target == cbCurrencyInput[2] || e.target == cbCurrencyInput[3] || e.target == currencyoutput_buttons[0] || e.target == currencyoutput_buttons[1] || e.target == currencyoutput_buttons[2] || e.target == currencyoutput_buttons[3] )                                          // Input text field
      {
        conversionSet();
        //System.out.println("Mouse down event in checkbox.");
        calculations();   
        return true;
      }
       return false;
    }
    catch (NumberFormatException e1) 
    {
      //System.out.println("Caught number format error in tfCurrencyInput");  // report error
    }
    return false; 
  }

  // Applet keystroke event
  public boolean keyDown(Event e, int k)                                      // Character is inserted in a TextField on keyDown:
  {
    int iLength = 0;
    float sfTemp = 0;
 
    if (k == 1006 || k == 1007)
    {
      return false;
    }

    if (k == 8)
    {                           
      try
      {
        String sTempInput = null;
        String sTempOutput = null;
        String sHalf1 = null;
        String sHalf2 = null;
        int iSelectStart = 0;
        int iSelectEnd = 0;  

        iSelectStart = tfCurrencyInput.getSelectionStart();                   // get start point of selected area for calculations
        iSelectEnd = tfCurrencyInput.getSelectionEnd();                       // get end point of selected area for calculations 
     
        sTempInput = tfCurrencyInput.getText();
        iLength = sTempInput.length();

        if (iLength == 1)
        {
         tfCurrencyOutput.setText(null);
         return false;  
        }
      
        sTempOutput = sTempInput.substring(0, iLength - 1);                   // Grab whole string except number about to be deleted

        if (iSelectStart == iSelectEnd && iSelectStart != iLength)            // if cursor is in middle of text delete previous character and form new string minus that character
        {
          //System.out.println("start = end && start != length");
          sHalf1 = sTempInput.substring(0, (iSelectStart - 1));
          sHalf2 = sTempInput.substring(iSelectEnd, iLength);
          sTempOutput = (sHalf1 + sHalf2); 
        }

        if (iSelectStart != iSelectEnd)                                       // if a section is highlighted and backspace is hit, then form new string from nonhighlighted area. 
        {
          sHalf1 = sTempInput.substring(0, iSelectStart);
          sHalf2 = sTempInput.substring(iSelectEnd, iLength);
          sTempOutput = (sHalf1 + sHalf2);
        }
             
        sfTemp = sfExchangeRate * Float.valueOf(sTempOutput).floatValue();    // calculate output currency based on input
        sCurrencyOutput = Float.toString(sfTemp);                             // set output currency
        tfCurrencyOutput.setText(sCurrencyOutput);
       
        return false;
      }   
      catch (StringIndexOutOfBoundsException e1)
      {
         //System.out.println("Caught out of bounds error in tfCurrencyInput");// report error
      }
      catch (NumberFormatException e1)
      {
        //System.out.println("Caught error in tfCurrencyInput on backspace input");// report error, allow backspace
        return false;
      }
    }

    if (k < 46 || k > 57 || k == 47) 
    {
        return true; 
    }

    if (e.target == tfCurrencyInput)                                           // Input text field
    {
      try
      {
        int iSelectStart = 0;
        int iSelectEnd = 0;      
        String sTemp = null;
        //int iLength = 0;
        String sHalf1 = null;
        String sHalf2 = null;
      
        iSelectStart = tfCurrencyInput.getSelectionStart();                   // get start point of selected area for calculations
        iSelectEnd = tfCurrencyInput.getSelectionEnd();                       // get end point of selected area for calculations
      
        sTemp = tfCurrencyInput.getText();                                    // make string from text input
        iLength = sTemp.length();                                             // get length for calculations below
     
        sHalf1 = sTemp.substring(0, iSelectStart);                            // form first half of string
        sHalf2 = sTemp.substring(iSelectEnd, iLength);                        // form second half
        sTemp = ( sHalf1 + (char) k + sHalf2);                                // combine the strings with k inbetween
       
        sfTemp = sfExchangeRate * Float.valueOf(sTemp).floatValue();          // calculate output currency based on input
        sCurrencyOutput = Float.toString(sfTemp);                             // set output currency
        tfCurrencyOutput.setText(sCurrencyOutput);                            // set to box                                                
      } 
      catch (NumberFormatException e1)
      {
        //System.out.println("Caught error in tfCurrencyInput");              // report error, trap if is a period
        if (k == 46)
        {
          return true;
        }
      }
      conversionSet();
      return false;
    }
    return false;  
  } // End of keyDown().

  private void calculations()
  {
    float sfTemp = 0;
    
    sfTemp = sfExchangeRate * Float.valueOf(tfCurrencyInput.getText()).floatValue(); // calculate output currency based on input
    sCurrencyOutput = Float.toString(sfTemp);                                  // set output currency
    //System.out.println(sCurrencyOutput);
    tfCurrencyOutput.setText(sCurrencyOutput);
  }

  private void calculations(int k)
  {
    float sfTemp = 0;

    sfTemp = sfExchangeRate * Float.valueOf(tfCurrencyInput.getText() +
             (char) k).floatValue();                                           // calculate output currency based on input
    sCurrencyOutput = Float.toString(sfTemp);                                  // set output currency
    //System.out.println(sCurrencyOutput);
    tfCurrencyOutput.setText(sCurrencyOutput);
  }

  public void constrain(Container container, Component component, int grid_x, 
                        int grid_y, int grid_width, int grid_height, int fill,
                        int anchor, double weight_x, double weight_y, int top,
                        int left, int bottom, int right)
                                             
  {
    GridBagConstraints c = new GridBagConstraints();
    c.gridx = grid_x; c.gridy = grid_y;
    c.gridwidth = grid_width; c.gridheight = grid_height;
    c.fill = fill; c.anchor = anchor;
    c.weightx = weight_x; c.weighty = weight_y;
    
    if (top+bottom+left+right > 0)
      c.insets = new Insets(top, left, bottom, right);
    
    ((GridBagLayout)container.getLayout()).setConstraints(component,c);
    container.add(component);
  }

  public void constrain(Container container, Component component, 
  int grid_x, int grid_y, int grid_width, int grid_height)
  {
    constrain(container, component, grid_x, grid_y, grid_width, grid_height, 
              GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, 0.0, 0.0, 0, 0, 0, 0);
  }

} // End of Applet class Cconverter.
