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
public class LinePath implements PathCalculation {
    public Point location(final Path p, final float t) {
        float startX= p.getStart().getX();
        float endX= p.getEnd().getX();
        float x=startX+((endX-startX)*t); 
        float startY= p.getStart().getY();
        float endY= p.getEnd().getY();
        float y=startY+((endY-startY)*t); 
        return new Point(x,y);
    }
    public float distance(final Path p, final float t) {
        return 0;
    }
    public float advance(final Path p, final float t, final float delta) {
        return 0;
    }
}
