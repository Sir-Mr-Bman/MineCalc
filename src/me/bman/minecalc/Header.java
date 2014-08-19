package me.bman.minecalc;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

public class Header
  extends JavaPlugin
{
  public final Logger logger = Logger.getLogger("Minecraft");
  
  public void onEnable()
  {
    log("Now enabling plugin...");
    getCommand("calc").setExecutor(new Command());
    log("Plugin has been initialized.");
  }
  
  public void onDisable()
  {
    log("Plugin has been disabled.");
  }
  
  public void log(String msg)
  {
    this.logger.info("[MineCalc] " + msg);
  }
}
