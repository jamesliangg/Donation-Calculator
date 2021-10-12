import java.io.File; //file calss
import java.io.IOException; // hangles errors
import java.io.FileWriter; //file writing
import javax.swing.JOptionPane; //fancy GUI
import java.time.format.DateTimeFormatter; //formatting date
import java.time.LocalDateTime; //get date and time
import javax.swing.ImageIcon; //image icons

/*
Creating files and variables
*/

class Main {
  public static void main(String[] args) {
    //variables
    double income, expenses, donation, donatePercent, roundedDonation;
    int confirm = 1;
    int confirmCharity = 1;
    String charity = null;

    //get and format the date and time in UTC
    //https://www.javatpoint.com/java-get-current-date
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();

    //create save file
    try
    {
      File donations = new File("donations.txt");
      if(donations.createNewFile())
      {
        System.out.println("Created save file: " + donations.getName());
      }
      else
      {
        System.out.println("File already exists");
      }
    }
    catch (IOException e)
    {
      System.out.println("An error occured ):");
      e.printStackTrace();
    }

    //write new session onto file and time
    try
    {
      FileWriter myWriter = new FileWriter("donations.txt", true);
      myWriter.write("\nNew Session at " + dtf.format(now) + " UTC");
      myWriter.close();
      System.out.println("Sucessfully wrote to file");
    }
    catch (IOException e)
    {
      System.out.println("An error occured ):");
      e.printStackTrace();
    }
    
    /*
    Icons and intial messages
    */

    //create icons for future JOptionPanes
    //https://www.youtube.com/watch?v=ChpZKgTCoJI
    ImageIcon earthicon = new ImageIcon("images/earth.png");
    ImageIcon covidicon = new ImageIcon("images/covid.png");
    ImageIcon donateicon = new ImageIcon("images/donate.png");
    ImageIcon uniceficon = new ImageIcon("images/unicef.png");
    ImageIcon redcrossicon = new ImageIcon("images/redcross.png");
    ImageIcon savethechildrenicon = new ImageIcon("images/savethechildren.jpg");
    ImageIcon directrelieficon = new ImageIcon("images/directrelief.png");
    ImageIcon dwbicon = new ImageIcon("images/dwb.jpg");
    ImageIcon hfhcicon = new ImageIcon("images/hfhc.png");
    ImageIcon twentyicon = new ImageIcon("images/20dollar.png");
    ImageIcon fiftyicon = new ImageIcon("images/50dollar.png");
    ImageIcon hundredicon = new ImageIcon("images/100dollar.png");
    ImageIcon hotmealicon = new ImageIcon("images/hotmeal.gif");
    ImageIcon groceriesicon = new ImageIcon("images/groceries.gif");
    ImageIcon infanticon = new ImageIcon("images/infant.gif");
    
    //output message using icon from before
    JOptionPane.showMessageDialog(null, "Over 119 Million people were pushed back into extreme poverty in 2020.\nPeople in extreme poverty earn less than $1.90 a DAY.\nThis increase is the first in over twenty years.", "Did you know?", JOptionPane.INFORMATION_MESSAGE, earthicon);

    //output message using icon from before
    //https://policyoptions.irpp.org/magazines/april-2020/covid-19-has-suddenly-deepened-charities-funding-challenges/
    JOptionPane.showMessageDialog(null, "Charities are facing a decreasing numbers of volunteers\nand a lull in charitable donations.", "Did you know?", JOptionPane.INFORMATION_MESSAGE, covidicon);

    //output message telling user use of program also using icon
    JOptionPane.showMessageDialog(null, "Every contribution and donation matters, no matter the size.\nSee how much you can donate.\nThis calculator calculates your leftover money after expenses.\nYou can enter the percent of that you'd like to donate\nand see how much that is.", "Donation Calculator", JOptionPane.INFORMATION_MESSAGE, donateicon);

    /*
    Donations
    */

    //gets input and calculates how much money is left after expenses
    income = Double.parseDouble(JOptionPane.showInputDialog("How much is your take home income after taxes per month?"));
    expenses = Double.parseDouble(JOptionPane.showInputDialog("How much are your expenses per month?"));
    JOptionPane.showMessageDialog(null, "You have $" + (income-expenses) + " left for the month.", "Calculator", JOptionPane.INFORMATION_MESSAGE);

    //do-while loop that calculates how much the user would like to donate rounded based on the percentage of their leftover money
    do
    {
    donatePercent = Double.parseDouble(JOptionPane.showInputDialog("What percentage of your remaining amount would you like to donate?"));
    donation = (income-expenses)*donatePercent/100;
    roundedDonation = Math.round(donation*100.0/100.0);
    if (roundedDonation < 20)
    {
      JOptionPane.showMessageDialog(null, "That would be a $" + roundedDonation + "." + "\nIf you donated $20, you could feed nutritious food to 14 children.", "Result", JOptionPane.INFORMATION_MESSAGE, twentyicon);
      confirm = JOptionPane.showConfirmDialog(null, "Would you like to donate that amount?", "Confirmation", JOptionPane.YES_NO_OPTION);
      //yes = 0, no = 1
    }
    else if (roundedDonation >= 20 && roundedDonation < 50)
    {
      JOptionPane.showMessageDialog(null, "That would be a $" + roundedDonation + "." + "\nIf you donated $50, you could provide live-saving vaccines to 59 children.", "Result", JOptionPane.INFORMATION_MESSAGE, fiftyicon);
      confirm = JOptionPane.showConfirmDialog(null, "Would you like to donate that amount?", "Confirmation", JOptionPane.YES_NO_OPTION);
      //yes = 0, no = 1
    }
    else if (roundedDonation >= 50 && roundedDonation < 75)
    {
      JOptionPane.showMessageDialog(null, "That would be a $" + roundedDonation + "." + "\nIf you donated $75, you could provide hot meals for a week.", "Result", JOptionPane.INFORMATION_MESSAGE, hotmealicon);
      confirm = JOptionPane.showConfirmDialog(null, "Would you like to donate that amount?", "Confirmation", JOptionPane.YES_NO_OPTION);
      //yes = 0, no = 1
    }
    else if (roundedDonation >= 75 && roundedDonation < 100)
    {
      JOptionPane.showMessageDialog(null, "That would be a $" + roundedDonation + "." + "\nIf you donated $100, you could provide safe and clean drinking water for 137 children.", "Result", JOptionPane.INFORMATION_MESSAGE, hundredicon);
      confirm = JOptionPane.showConfirmDialog(null, "Would you like to donate that amount?", "Confirmation", JOptionPane.YES_NO_OPTION);
      //yes = 0, no = 1
    }
    else if (roundedDonation >= 100 && roundedDonation < 150)
    {
      JOptionPane.showMessageDialog(null, "That would be a $" + roundedDonation + "." + "\nIf you donated $150, you could provide a family with groceries for five days.\nOr cover the cost of a sending a doctor to work for a day.", "Result", JOptionPane.INFORMATION_MESSAGE, groceriesicon);
      confirm = JOptionPane.showConfirmDialog(null, "Would you like to donate that amount?", "Confirmation", JOptionPane.YES_NO_OPTION);
      //yes = 0, no = 1
    }
    else if (roundedDonation >= 150 && roundedDonation < 200)
    {
      JOptionPane.showMessageDialog(null, "That would be a $" + roundedDonation + "." + "\nIf you donated $200, you could provide two infant care kits.", "Result", JOptionPane.INFORMATION_MESSAGE, infanticon);
      confirm = JOptionPane.showConfirmDialog(null, "Would you like to donate that amount?", "Confirmation", JOptionPane.YES_NO_OPTION);
      //yes = 0, no = 1
    }
    else if (roundedDonation >= 200)
    {
      JOptionPane.showMessageDialog(null, "That would be a $" + roundedDonation + "." + "\nWow! That's a generous donation!\nIt could provide the following things:\n$20 Nutritious food to 14 children\n$50 Live-saving vaccines for 59 children\n$75 Hot meals for a week\n$100 Safe cleaning and drinking water for 137 children\n$150 Cover cost of sending a doctor to work for a day\n$150 family groceries for five days\n$200 infant care kits", "Result", JOptionPane.INFORMATION_MESSAGE, twentyicon);
      confirm = JOptionPane.showConfirmDialog(null, "Would you like to donate that amount?", "Confirmation", JOptionPane.YES_NO_OPTION);
      //yes = 0, no = 1
    }
    } while (confirm != 0);

    /*
    Charity information
    */

    //while loop that keeps going as long as the user doesn't finalize their decision on which charity to donate to
    while (confirmCharity != 0)
    {
      //https://www.charitynavigator.org/
      //creating choices
      //http://www.java2s.com/Tutorial/Java/0240__Swing/Todisplaysadialogwithalistofchoicesinadropdownlistbox.htm
      String[] charityChoices = {"UNICEF", "Canadian Red Cross", "Save the Children", "Direct Relief", "Doctors Without Borders", "Hope for Haiti's Children"};
      //set charity equal to whatever option the user selects
      charity = (String) JOptionPane.showInputDialog(null, "Pick a charity to learn more about.", "Charity Options", JOptionPane.QUESTION_MESSAGE, null, charityChoices, charityChoices[0]);
      System.out.println(charity);
      //if statement for specific charity
      if (charity.equals("UNICEF"))
      {
        //displays mission for charity and their website
        JOptionPane.showMessageDialog(null, "Mission: \"UNICEF stands for every child, everywhere.\nWe are guided by the 1989 Convention on the Rights of the Child,\nadvocating for the protection of children’s rights, helping to meet their basic needs,\nand giving them a fair chance to reach their full potential.\"\nFind out more at: https://www.unicef.ca/en", "UNICEF", JOptionPane.INFORMATION_MESSAGE, uniceficon);
        //confirms that user wants to donate to charity and provides link
        confirmCharity = JOptionPane.showConfirmDialog(null, "They are rated 89.18/100 by Charity Navigator.\nWould you like to donate to UNICEF?\nDonate at: https://www.unicef.ca/en", "Confirmation", JOptionPane.YES_NO_OPTION);
      }
      //else if statement for specific charity
      else if (charity.equals("Canadian Red Cross"))
      {
        //displays mission for charity and their website
        JOptionPane.showMessageDialog(null, "Mission:  \"We help people and communities in Canada and around the world\nin times of need and support them in strengthening their resilience.\"\nFind out more at: https://www.redcross.ca", "Canadian Red Cross", JOptionPane.INFORMATION_MESSAGE, redcrossicon);
        //confirms that user wants to donate to charity and provides link
        confirmCharity = JOptionPane.showConfirmDialog(null, "They are rated 88.99/100 by Charity Navigator.\nWould you like to donate to Canadian Red Cross?\nDonate at: https://www.redcross.ca", "Confirmation", JOptionPane.YES_NO_OPTION);
      }
      //else if statement for specific charity
      else if (charity.equals("Save the Children"))
      {
        //displays mission for charity and their website
        JOptionPane.showMessageDialog(null, "Mission:  \"Our mission is to help the most marginalized and hard-to-reach\nchildren around the world. For 100 years, we have often been the\nfirst on the ground to respond to the needs of children in crisis, and the last to leave.\nOur innovative and collaborative programs tackle some of the\nworld’s most pressing issues for children.\"\nFind out more at: https://www.savethechildren.ca", "Save the Children", JOptionPane.INFORMATION_MESSAGE, savethechildrenicon);
        //confirms that user wants to donate to charity and provides link
        confirmCharity = JOptionPane.showConfirmDialog(null, "They are rated 91.82/100 by Charity Navigator.\nWould you like to donate to Save the Children?\nDonate at: https://www.savethechildren.ca", "Confirmation", JOptionPane.YES_NO_OPTION);
      }
      //else if statement for specific charity
      else if (charity.equals("Direct Relief"))
      {
        //displays mission for charity and their website
        JOptionPane.showMessageDialog(null, "Mission:  \"Direct Relief is a humanitarian aid organization, active in all 50 states\nand more than 80 countries,with a mission to improve the health and\nlives of people affected by povertyor emergencies – without regard\nto politics, religion, or ability to pay.\"\nFind out more at: https://www.directrelief.org", "Direct Relief", JOptionPane.INFORMATION_MESSAGE, directrelieficon);
        //confirms that user wants to donate to charity and provides link
        confirmCharity = JOptionPane.showConfirmDialog(null, "They are rated 100/100 by Charity Navigator.\nWould you like to donate to Direct Relief?\nDonate at: https://www.directrelief.org", "Confirmation", JOptionPane.YES_NO_OPTION);
      }
      //else if statement for specific charity
      else if (charity.equals("Doctors Without Borders"))
      {
        //displays mission for charity and their website
        JOptionPane.showMessageDialog(null, "Mission:  \"We provide free medical care to people who need it.\nIt doesn’t matter which country they are from, which religion they belong to,\nor what their political affiliations are.\nAll that matters is they are human beings in need.\"\nFind out more at: https://www.doctorswithoutborders.ca", "Doctors Without Borders", JOptionPane.INFORMATION_MESSAGE, dwbicon);
        //confirms that user wants to donate to charity and provides link
        confirmCharity = JOptionPane.showConfirmDialog(null, "They are rated 92.25/100 by Charity Navigator.\nWould you like to donate to Doctors Without Borders?\nDonate at: https://www.doctorswithoutborders.ca", "Confirmation", JOptionPane.YES_NO_OPTION);
      }
      else if (charity.equals("Hope for Haiti's Children"))
      {
        //displays mission for charity and their website
        JOptionPane.showMessageDialog(null, "Mission:  \"To demonstrate Christian compassion to poverty-bound Haitian children\nand their families, providing opportunities for these children to\nbecome leaders in their homes, churches, and communities.\"\nFind out more at: https://www.hopeforhaitischildren.org", "Hope for Haiti's Children", JOptionPane.INFORMATION_MESSAGE, hfhcicon);
        //confirms that user wants to donate to charity and provides link
        confirmCharity = JOptionPane.showConfirmDialog(null, "They are rated 100/100 by Charity Navigator.\nWould you like to donate to Hope for Haiti's Children?\nDonate at: https://www.hopeforhaitischildren.org", "Confirmation", JOptionPane.YES_NO_OPTION);
      }
    }
    //writes the charity and amount donated to file
    try
    {
      FileWriter myWriter = new FileWriter("donations.txt", true);
      myWriter.write("\nDonation of $" + roundedDonation + " to " + charity);
      myWriter.close();
      System.out.println("Sucessfully wrote to file");
    }
    catch (IOException e)
    {
      System.out.println("An error occured ):");
      e.printStackTrace();
    }

    /*
    Final messages
    */

    //output message thanking user and telling them what they've selected
    JOptionPane.showMessageDialog(null, "You've chosen to donate $" + roundedDonation + " to " + charity + ".\nThank you for using the donation calculator!\nYou can see your past donations in the donations.txt file.", "Calculator", JOptionPane.INFORMATION_MESSAGE);
    //exit with code 0
    System.exit(0);
  }
}