package reetstreet.emojiattack.android;

import playn.android.GameActivity;
import playn.core.PlayN;

import reetstreet.emojiattack.core.EmojiAttack;

public class EmojiAttackActivity extends GameActivity {

  @Override
  public void main(){
    PlayN.run(new EmojiAttack());
  }
}
