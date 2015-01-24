How We Generated the Project to Get Started
===========================================
We generated the project from the command line, like so:

$ mvn archetype:generate -DarchetypeGroupId=com.googlecode.playn -DarchetypeArtifactId=playn-archetype -DarchetypeVersion=1.8

Define value for property 'groupId': : reetstreet
Define value for property 'artifactId': : emojiattack
Define value for property 'version':  1.0-SNAPSHOT: : 
Define value for property 'package':  reetstreet: : reetstreet.emojiattack
Define value for property 'JavaGameClassName': : EmojiAttack


Instructions per this page:

https://code.google.com/p/playn/wiki/GettingStarted#Running_via_Eclipse


Run From the Command Line:
==========================

$ mvn test -Pjava


Import Into Netbeans and Run:
=============================

1. File -> Open
2. Open the root folder "EmojiAttack"
3. Click on "Files" tab
4. Navigate to: java -> src -> main -> java -> reetstreet -> emojiattack -> java -> EmojiAttackJava.java
5. Right-click on EmojiAttackJava.java. 
6. Select it as the main class and remember forever.

Now the "Run" button should simply run your project.


PATHS
=====

Imagine you have a path that goes from (A) to (B).

     (B)
     /|
    / |
   /  |
  /   |
(A)----

If (A) is located at Xa,Ya, and B is located at Xb,Yb, then:

  The horizontal distance between (A) and (B) is:  ~X = Xb - Xa
                                              OR:  deltaX = endX - startX

  The vertical distance between (A) and (B) is:    ~Y = Yb - Ya
                                              OR:  deltaY = endY - startY

  The distance between (A) and (B) (length) is:    sqrt((~X * ~X) + (~Y * ~Y) )
                                              n.b. ~X is deltaX

When emoji are traveling along a path, we want them to move at a constant
speed.  Some emoji may travel faster than others, but it should take longer
for an emoji to travel from (A) to (B) if they are farther apart.

To calculate the point that an item somewhere on the line between (A)
and (B), call it Xp,Yp at a distance d from (A), then:

  The percentage progress is:   t = d / length

  Xp = Xa + (t * ~X)
  
  Yp = Ya + (t * ~Y)


LINKED PATHS
============

Linked paths are made up of multiple path segments.

     (B)-----------(C)
     /              |
    /               |
   /               (D)-----------(E)
  /   
(A)

The distance from (A) to (E) equals the sum of the distance of all of the path 
segments that make it up.

To calculate Xp,Yp, for some distance d between (A) and (E) we must:

For line (L) in each simple path (A), (B), (C), (D), (E):
  if the total distance of (L) > d:
    calculate Xp,Yp of the simple path (L) at d
    return result
  else
    d = d - the total distance of (L)
    recursive call to the next segment in the path


DON'T REPEAT YOURSELF
=====================

Linked paths are made up of sequences of simple paths.  Each simple
path contains a start point, and a reference to the next simple path
in the sequence.  The end point of a simple path is therefore the start
point of the next path.

All types of paths are immutable; if you want to change them, you have to make 
a new copy.  This allows us to efficiently cache information about paths, 
such as the total length, to reduce the amount of repetitious calculations
that the program needs to do.

Note that a simple path can be part of more than one linked path; the
only restriction here is that, since the simple path is immutable, and
contains a reference to the next simple path in the set, then the end
portion of each shared path must always be the same.  This can be useful
if you have multiple ways to get to the end of the course, all of which
end up in the same location.

