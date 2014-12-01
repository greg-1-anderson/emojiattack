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
public class SimplePath implements Path {

    public SimplePath(Point start) {
        this.start = start;
        this.next = null;
        this.pathCalculation = null;
    }
    public SimplePath(Point start,SimplePath continuation) {
        this.start = start;
        this.next = continuation;
        this.pathCalculation = new LinePath();
    }
    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        if(this.getNext()==null){
            return this.getStart();
        }
        return this.getNext().getStart();
    }

    public Path getNext() {
        return next;
    }
    
    private final Point start;
    private final SimplePath next;
    PathCalculation pathCalculation;
    public Point location(float t)
    {
        if (pathCalculation == null) {
            return this.getStart();
        }
        return pathCalculation.location(this, t);
    }
    public float distance(float t)
    {
        if (pathCalculation == null) {
            return 0;
        }
        return pathCalculation.distance(this, t);
    }
    public float advance(float t,float delta)
    {
        if (pathCalculation == null) {
            return 0;
        }
        return pathCalculation.advance(this, t, delta);
    }
}
