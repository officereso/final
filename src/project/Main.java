package project;

import project.Sprites.*;

import java.applet.Applet;
import java.awt.*;


public class Main extends Applet {
    private static boolean start = false;  // Control for when game is started
    private static boolean playerHitShoulder = false;
    private static int score = 0;  // Default player score
    private static int Px = 150;  // Default Px(Player x)
    private Rectangle startBtn = new Rectangle(100, 100, 340, 600);  // Rectangle that the user presses to start the game
    private Rectangle lBtn = new Rectangle(480, 240, 150, 80);  // Rectangle that the player presses to move player to the left
    private Rectangle rBtn = new Rectangle(660, 240, 150, 80);  // Rectangle that the player presses to move player to the right

    private static void npcLocomotion(Graphics g) {  // Logic for spawning NPC objects
        if (score > 3) {
            new NPC1(g, Px);  // Px is passed to NPCs for collision detection purposes
        }
        if (score > 30) {
            new NPC2(g, Px);
        }
        if (score > 35) {
            new NPC3(g, Px);
        }
        if (score > 50) {
            new NPC4(g, Px);
        }
        if (score > 70) {
            new NPC5(g, Px);
        }
        if (score > 80) {
            new NPC6(g, Px);
        }
    }

    private static void playerLocomotion(Graphics g) {
        Player.make(g, Px, 427);  // Draw the player according to its Px
        if (Px <= 107 || Px >= 375) { // Logic to detect if player has it the shoulder of road
            playerHitShoulder = true;
        }
    }

    public void paint(Graphics g) {
        Expo.drawHeading(g, "Quentin Snow and Alekkai", "Final Project");
        if (start && !NPC1.collision && !NPC2.collision && !NPC3.collision && !NPC4.collision && !NPC5.collision && !NPC6.collision && !playerHitShoulder) {  // Start and keep game running if 1. startBtn has been pressed. 2. No NPCs have detected a collision and player hasn't hit shoulder.
            Draw.begin(g, score);
            playerLocomotion(g);
            npcLocomotion(g);

        }
        if (!start) {
            Draw.startScreen(g);  // Draw the start screen if the game has not started
        }

        if (NPC1.collision || NPC2.collision || NPC3.collision || NPC4.collision || NPC5.collision || NPC6.collision || playerHitShoulder) {  // If any NPCs report a collision or player has hit the shoulder draw the end screen
            Draw.end(g);
        }
    }

    public boolean mouseDown(Event e, int x, int y){
        if (startBtn.inside(x,y)){
            start = true;  // Set start to true if user has clicked startBtn
        }
        if (lBtn.inside(x,y)){
            Px -= 10;  // Move player 10 pixels to left when lBtn is pressed
        }
        if (rBtn.inside(x,y)){
            Px += 10;  // Move player 10 pixels to left when lBtn is pressed
        }
        score++;  // For every click increase users score
        repaint();  // Redraw everything
        return true;
    }
}