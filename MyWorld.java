import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.ArrayList;
import java.util.Random;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int NUMBER_OF_LIFES = 3;
    private int NUMBER_OF_ENEMIES = 10;
      
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        prepare();
    }
    
    public void act(){
        
    }
    
    private void prepare(){
        Spacecraft spacecraft = new Spacecraft();
        Random random = new Random();
        
        addObject(spacecraft,300,340);
               
        for(int i = 0; i < NUMBER_OF_ENEMIES; i++){
            addObject(new Baby(),300 + random.nextInt(300) - 150, 100 + random.nextInt(100) - 50);
        }
        
        
        for(int i = 0; i < NUMBER_OF_LIFES; i++){
            RocketLife life = new RocketLife();
            addObject(life, 30 + 30 * i, 370);
        }
        

        
    }
}
