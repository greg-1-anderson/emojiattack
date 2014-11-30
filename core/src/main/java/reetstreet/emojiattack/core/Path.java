/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reetstreet.emojiattack.core;

/**
 *
 * @author ga
 */
public interface Path {
    Point start();
    Point end();
    Path next ();
    Point location(float t);
    float distance(float t);
    float advance(float t,float delta);
}
