package me.bman.minecalc;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Command implements CommandExecutor {
  public boolean onCommand(CommandSender s, org.bukkit.command.Command cmd, String label, String[] args) {
    if (cmd.getLabel().equalsIgnoreCase("calc")) {
      if (s.hasPermission("minecalc.calculate")) {
        if (args.length == 0) {
          msgSend(s, "You did not attach any math to calculate!");
        }
        else if (args.length == 3) {
          String operation = args[1];
          String input1 = args[0];
          String input2 = args[2];
          boolean tof1 = isNumeric(input1);
          boolean tof2 = isNumeric(input2);
          if ((tof1) && (tof2)) {
            double num1 = Double.parseDouble(input1);
            double num2 = Double.parseDouble(input2);
            if ((operation.equalsIgnoreCase("*")) || (operation.equalsIgnoreCase("x"))) {
              double answer = num1 * num2;
              msgSend(s, num1 + " * " + num2 + " = " + answer);
            }
            else if (operation.equalsIgnoreCase("/")) {
              double answer = num1 / num2;
              msgSend(s, num1 + " / " + num2 + " = " + answer);
            }
            else if (operation.equalsIgnoreCase("+")) {
              double answer = num1 + num2;
              msgSend(s, num1 + " + " + num2 + " = " + answer);
            }
            else if (operation.equalsIgnoreCase("-")) {
              double answer = num1 - num2;
              msgSend(s, num1 + " - " + num2 + " = " + answer);
            }
            else if (operation.equalsIgnoreCase("^")) {
              double answer = Math.pow(num1, num2);
              msgSend(s, num1 + "^" + num2 + " = " + answer);
            }
            else {
              msgSend(s, "I'm sorry, but I don't think that " + operation + " is a valid mathmatical operation.");
            }
          }
          else {
            msgSend(s, "The expression " + input1 + operation + input2 + " is not valid.");
          }
        } else {
        	msgSend(s, "Incorrect format. Try this (replace <> with operation): /calc # <> #");
        }
      }
      else {
        msgSend(s, "You don't have permission to use this plugin.");
      }
    }
    return false;
  }
  
  public void msgSend(CommandSender s, String msg) {
    s.sendMessage(ChatColor.RED + "[" + ChatColor.AQUA + "MineCalc" + ChatColor.RED + 
      "] " + ChatColor.GREEN + msg);
  }
  
  public static boolean isNumeric(String str) {
    try {
      double d = Double.parseDouble(str);
    }
    catch (NumberFormatException nfe) {
      return false;
    }
    return true;
  }
}
