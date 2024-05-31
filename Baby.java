import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.Random;

/**
 * Write a description of class Baby here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Baby extends Actor
{
    
    private int step = 0;
    private int direction = 1;
    private int speed = 5;
    private static int bombCounter = 500;
    private static int bulletCounter = 300;
    private Random random = new Random();
    private int counterDirectionChange = 0;
    private int deltaX;
    private int deltaY;
    
    
    /**
     * Act - do whatever the Baby wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        handleDirection();
        
        handleBombs();
        
        handleBullets();
    }
    
    private void handleDirection(){
        int x = getX();
        int y = getY();
        
        if(counterDirectionChange-- <= 0){
            deltaX = random.nextInt(10) - 4;
            deltaY = random.nextInt(10) - 4;
            counterDirectionChange = 10;
        } 
        
        setLocation(x + deltaX, y + deltaY);
    }
    
    private void handleBombs(){
        bombCounter--;
        if(bombCounter == 0){
            bombCounter = 500;
             
            getWorld().addObject(new Bomb(), getX(), getY()+20);
        }
    }
    
    private void handleBullets(){
        bulletCounter--;
        if(bulletCounter == 0){
            bulletCounter = 300; 
            Spacecraft spacecraft = (Spacecraft)getWorld().getObjects(Spacecraft.class).get(0);
            
            double m = (spacecraft.getY() - getY()) / (double)(spacecraft.getX() - getX());
             
            getWorld().addObject(new BabyBullet(m, getX() < spacecraft.getX() ? 1 : -1), getX(), getY());
        }
    }
}
