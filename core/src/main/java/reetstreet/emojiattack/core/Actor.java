/**
 * Copyright 2011 The PlayN Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package reetstreet.emojiattack.core;

import static playn.core.PlayN.log;

import playn.core.GroupLayer;
import playn.core.util.Callback;

import playn.showcase.core.sprites.Sprite;
import playn.showcase.core.sprites.SpriteLoader;

public class Actor {
  protected final Sprite sprite;
  protected int spriteIndex = 0;
  protected float angle;
  private boolean hasLoaded = false; // set to true when resources have loaded and we can update

  public Actor(final GroupLayer actorLayer, final String image, final String json, final float x, final float y) {
    sprite = SpriteLoader.getSprite(image, json);

    // Add a callback for when the image loads.
    // This is necessary because we can't use the width/height (to center the
    // image) until after the image has been loaded
    sprite.addCallback(new Callback<Sprite>() {
      @Override
      public void onSuccess(Sprite sprite) {
        sprite.setSprite(spriteIndex);
        sprite.layer().setOrigin(sprite.width() / 2f, sprite.height() / 2f);
        sprite.layer().setTranslation(x, y);
        actorLayer.add(sprite.layer());
        hasLoaded = true;
      }

      @Override
      public void onFailure(Throwable err) {
        log().error("Error loading image!", err);
      }
    });
  }
  
  public boolean isLoaded() {
      return hasLoaded;
  }

  public void update(int delta) {
  }
}
