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


