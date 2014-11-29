package reetstreet.emojiattack.core;

import java.util.ArrayList;
import java.util.List;
import playn.core.Game;
import playn.core.GroupLayer;
import playn.core.Image;
import playn.core.ImageLayer;
import static playn.core.PlayN.*;
import playn.core.Pointer;


public class EmojiAttack extends Game.Default {
  private GroupLayer layer;
  private List<Actor> actors = new ArrayList<Actor>(0);

  public EmojiAttack() {
    super(33); // call update every 33ms (30 times per second)
  }

  @Override
  public void init() {
    // create a group layer to hold everything
    layer = graphics().createGroupLayer();
    graphics().rootLayer().add(layer);

    // create and add background image layer
    Image bgImage = assets().getImage("images/desert_dunes.png");
    ImageLayer bgLayer = graphics().createImageLayer(bgImage);
    layer.add(bgLayer);

    // add a listener for pointer (mouse, touch) input
    pointer().setListener(new Pointer.Adapter() {
      @Override
      public void onPointerEnd(Pointer.Event event) {
        addEmoji(event.x(), event.y());
      }
    });

    Actor village = new Village(layer, graphics().width() / 2, graphics().height() / 2);
    actors.add(village);
  }

  
  private void addEmoji(float x, float y) {
    Actor actor = new Emoji(layer, x, y);
    actors.add(actor);
  }

  @Override
  public void update(int delta) {
    for (Actor actor : actors) {
      actor.update(delta);
    }
  }

  @Override
  public void paint(float alpha) {
    // layers automatically paint themselves (and their children). The rootlayer
    // will paint itself, the background, and the pea group layer automatically
    // so no need to do anything here!
  }
}
