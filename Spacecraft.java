import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Spacecraft here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
 public class Spacecraft extends Actor
{
    private int bulletCounter = 0;
    
    /**
     * Act - do whatever the Spacecraft wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
       
        handleKeyboardEvents();
        
        handleBombCrashes();
        
       
    }
    
    private void handleBombCrashes(){
        Actor bomb = getOneIntersectingObject(Bomb.class);
        
        if(bomb != null){
            
            World world = getWorld();
            List<RocketLife> lifes = world.getObjects(RocketLife.class);
            
            world.removeObject(bomb);
            world.removeObject(lifes.remove(lifes.size() - 1)); //solo si hay no hay vidas
            
            if(world.getObjects(RocketLife.class).isEmpty()){
                Greenfoot.setWorld(new GameOver());
            }
        }
    }
    
    private void handleKeyboardEvents(){
        int y = getY();
        
        
        if(Greenfoot.isKeyDown("RIGHT")) {
            setLocation(getX()+5, y);
        } 
        
        if(Greenfoot.isKeyDown("LEFT")) {
            setLocation(getX()-5, y);
        }
        
        if(Greenfoot.isKeyDown("SPACE")) {
            fire();
        } else {
            bulletCounter = 0;
        }
    }
    
    private void fire(){
        if(bulletCounter-- > 0){
            return;
        }
        
        SpacecraftBullet bullet = new SpacecraftBullet();
        World world = getWorld();
        
        world.addObject(bullet, getX(), getY()-60);
        
        bulletCounter = 15;
    }
}

