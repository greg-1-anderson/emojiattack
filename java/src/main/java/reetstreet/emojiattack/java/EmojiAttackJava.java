package reetstreet.emojiattack.java;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.Toolkit;
import playn.core.PlayN;
import playn.java.JavaPlatform;
import reetstreet.emojiattack.core.EmojiAttack;

public class EmojiAttackJava {

  public static void main(String[] args) {
    JavaPlatform.Config config = new JavaPlatform.Config();
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double width = screenSize.getWidth();
    double height = screenSize.getHeight();

    // use config to customize the Java platform, if needed
    config.width = (int) (width - 100);
    config.height = (int) (height - 100);
    JavaPlatform.register(config);
    PlayN.run(new EmojiAttack());
  }
}
