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
interface PathCalculation {
    public Point location(final Path p, final float t);
    public float distance(final Path p, final float t);
    public float advance(final Path p, final float t, final float delta);        
}
