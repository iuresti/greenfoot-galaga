import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpacecraftBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpacecraftBullet extends Actor
{
    /**
     * Act - do whatever the SpacecraftBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setLocation(getX(), getY()-5);
        
        
        
        if(isAtEdge()){
        
            getWorld().removeObject(this);
        
        } else {  
            
            Actor baby = getOneIntersectingObject(Baby.class);
        
            if(baby != null){
                World world = getWorld();
                
                world.removeObject(baby);
                world.removeObject(this);
            }
        }
    
    }
}
