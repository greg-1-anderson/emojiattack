package reetstreet.emojiattack.html;

import playn.core.PlayN;
import playn.html.HtmlGame;
import playn.html.HtmlPlatform;

import reetstreet.emojiattack.core.EmojiAttack;

public class EmojiAttackHtml extends HtmlGame {

  @Override
  public void start() {
    HtmlPlatform.Config config = new HtmlPlatform.Config();
    // use config to customize the HTML platform, if needed
    HtmlPlatform platform = HtmlPlatform.register(config);
    platform.assets().setPathPrefix("emojiattack/");
    PlayN.run(new EmojiAttack());
  }
}
