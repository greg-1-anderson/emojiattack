/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reetstreet.emojiattack.core;

import playn.core.GroupLayer;

/**
 *
 * @author ga
 */
public class Village extends Actor{

  public static String IMAGE = "sprites/homevillage.png";
  public static String JSON = "sprites/homevillage.json";

  public Village(final GroupLayer actorLayer, final float x, final float y) {
    super(actorLayer, IMAGE, JSON, x, y);
  }
  
}
