import javax.swing.*;
import java.text.DecimalFormat;

public class WidgetFactory {

    /*
    Lessons L1 - L3

    You have been asked by the manager of the Widget Factory to create a program which will tell how many days it will take to produce a number of widgets.
    It should also output the cost of the widgets, the cost to produce the widget and the profit.

    Specific Details:
     - 10 Widgets are made each hour
     - Plant runs 2 shifts of 8 hours a day, requiring 5 workers a shift
     - each worker makes $16.50 an hour
     - each widget sells for $10

     Programming Details:
     - prompt the user for the number of widgets using pop-up boxes
     - display # of widgets, # of days, Cost of production, Cost of widgets and profit
     - 2 or more (preferably more) methods - at least 1 to calculate # of day and one to calculate production costs
     - only WHOLE number of days, no half or partial days.
     - Output should be in proper currency form

     Example Run:

     Number of Widgets: 1000
     # of Days: 7
     Cost of Widgets: $10,000.00
     Cost of Production: $9,240.00
     Profit: $760.00

     */

    public static void main(String[] args) {
        int desiredWidgets = getInput("Please insert the number of widgets you desire to produce.");
        int days = wid2Days(desiredWidgets);
        double widgetCost = desiredWidgets * 10.0;
        double productionCost = proCost(days);
        outputResults(desiredWidgets, days, widgetCost, productionCost);
    }

    //prompt for number of widgets
    public static int getInput(String prompt){
        return Integer.parseInt(JOptionPane.showInputDialog(prompt));
    }


    //take the widgets and turn them into the hours needed to produce said widgets and round up.
   public static int wid2Days(int widgets){
        double hours = widgets / 10.0;
        return (int)Math.ceil(hours /  16.0);
    }

    /* turn days into the amount of workers needed to pay on those FULL days,
    Don't ask why I turned widgets to hours to days, and then immediately turned days back to hours.
    */
    public static double proCost(int days){
        return (16 * 16.5 * 5 * days);
    }

    //display message
    public static void outputResults(int widgets, int days, double wCost, double pCost){
        DecimalFormat round = new DecimalFormat("#,##0.00");
        String message = "Widgets: " + widgets + "\nDays: " + days + "\nCost of Widgets: $" + round.format(wCost) + "\nCost of Production: $" + round.format(pCost) + "\nProfit: $" +  round.format(wCost - pCost);
        JOptionPane.showMessageDialog(null, message);
    }

}
