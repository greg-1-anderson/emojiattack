/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reetstreet.emojiattack.core;

import java.lang.Math;

/**
 *
 * @author ga
 */
public class StraightLineCalculation implements PathCalculation {
    @Override
	public Point location(final Path p, final float d) {
    	float t = d / this.length(p);
    	float startX= p.getStart().getX();
    	float endX= p.getEnd().getX();
    	float x=startX+((endX-startX)*t); 
    	float startY= p.getStart().getY();
    	float endY= p.getEnd().getY();
    	float y=startY+((endY-startY)*t); 
        return new Point(x,y);
    }
    @Override
    public float length(final Path p) {
    	float startX= p.getStart().getX();
    	float endX= p.getEnd().getX();
    	float startY= p.getStart().getY();
    	float endY= p.getEnd().getY();
    	float deltaY=endY-startY;
    	float deltaX=endX-startX;
        return (float) Math.sqrt((deltaX*deltaX) + (deltaY*deltaY));
    }
}
