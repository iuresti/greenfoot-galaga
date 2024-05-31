import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Actor
{
    private int speed = 3;
    private int counterGravityIncrease = 0;
    
    /**
     * Act - do whatever the Bomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {

        setLocation(getX(), getY() + speed);
        counterGravityIncrease++;
        if(counterGravityIncrease == 10){
            counterGravityIncrease = 0; 
            speed++;
        }
        
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}
