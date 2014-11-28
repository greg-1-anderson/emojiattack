package reetstreet.emojiattack.java;

import playn.core.PlayN;
import playn.java.JavaPlatform;

import reetstreet.emojiattack.core.EmojiAttack;

public class EmojiAttackJava {

  public static void main(String[] args) {
    JavaPlatform.Config config = new JavaPlatform.Config();
    // use config to customize the Java platform, if needed
    JavaPlatform.register(config);
    PlayN.run(new EmojiAttack());
  }
}
