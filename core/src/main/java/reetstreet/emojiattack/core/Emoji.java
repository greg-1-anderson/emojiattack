/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reetstreet.emojiattack.core;

import playn.core.GroupLayer;
import static playn.core.PlayN.log;
import playn.core.util.Callback;
import playn.showcase.core.sprites.Sprite;
import playn.showcase.core.sprites.SpriteLoader;

/**
 *
 * @author ga
 */
public class Emoji extends Actor{
  public static String IMAGE = "sprites/emoji.png";
  public static String JSON = "sprites/emojisprite.json";

  public Emoji(final GroupLayer actorLayer, final float x, final float y) {
    super(actorLayer, IMAGE, JSON, x, y);
  }

  @Override
  public void update(int delta) {
    if (this.isLoaded()) {
      if (Math.random() > 0.95) {
        spriteIndex = (spriteIndex + 1) % sprite.numSprites();
        sprite.setSprite(spriteIndex);
      }
      //angle += ((float)delta) / 100.0;
      //sprite.layer().setRotation(angle);
      
      float x = sprite.layer().tx();
      float y = sprite.layer().ty();
      //x += 0.3 * delta;//Math.random();
      y -= 0.3 * delta;//Math.random();
      
      sprite.layer().setTranslation(x, y);
    }
  }
    
}
