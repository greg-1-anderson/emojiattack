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
public class LinkedPath implements Path {

    private final Point start;
    private final LinkedPath next;
    PathCalculation pathCalculation;

    public PathCalculation getPathCalculation() {
		return pathCalculation;
	}
	public LinkedPath(Point start) {
        this.start = start;
        this.next = null;
        this.pathCalculation = null;
    }
    public LinkedPath(Point start,LinkedPath continuation) {
        this.start = start;
        this.next = continuation;
        this.pathCalculation = new StraightLineCalculation();
    }
    public LinkedPath(LinkedPath start,LinkedPath continuation) {
        this.start = start.getStart();
        this.next = continuation;
        this.pathCalculation = start.getPathCalculation();
    }
	@Override
    public Point getStart() {
        return start;
    }

	@Override
    public Point getEnd() {
        if(this.getNext()==null){
            return this.getStart();
        }
        return this.getNext().getEnd();
    }

    public Point getSegmentEnd() {
        if(this.getNext()==null){
            return this.getStart();
        }
        return this.getNext().getStart();
    }

    public LinkedPath getNext() {
        return next;
    }
	@Override
	public float length() {
		float totalLength = this.length();
		if (this.getNext() != null) {
			totalLength = totalLength + this.getNext().length();
		}
		return totalLength;
	}
	public float segmentLength() {
		return pathCalculation.length(this);
	}
	@Override
	public Point location(float d) {
		if (d < this.segmentLength()) {
			return pathCalculation.location(this, d);
		}
		if (this.getNext() != null) {
			return this.getNext().location(d - this.segmentLength());
		}
		return this.getEnd();
	}
    
}
