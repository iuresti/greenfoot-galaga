import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BabyBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BabyBullet extends Actor
{
    private int speed = 3;
    private int counterGravityIncrease = 0;
    private double m;
    private int xDirection;
    
    public BabyBullet(double m, int xDirection){
        this.m = m * xDirection;
        this.xDirection = xDirection;
    }
    
    public void act()
    {
        int newX = getX() + (1 * xDirection);
        int newY = (int)(m * newX);
        
        setLocation(newX, newY);
        
        
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}
