import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dot here.
 * 
 * @author Demo 
 * @version (a version number or a date)
 */
public class Dot  extends Actor
{ 
    
    private int x;
    private int y;
    private int d;
    private final int DOT_SIZE=20;
   
    public Dot(int dot){
      GreenfootImage image1 = new GreenfootImage("SnakeHead.gif"); 
      image1.mirrorHorizontally();
      d = dot;
      
      if(d==0){
           setImage(image1);
           
           
      } else{
          setImage("close.png");
        }
    }

    /**
     * Act - do whatever the Head wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(d == 0)
        {
            lead();
            lookForFood();
            lookForEdge();
            lookForDot();
        }
        else
        {
         follow();   
        }
    } 
    /**
     * lead will control the movemt of the head of the snake
     * @param has no parameters
     * @retun s nothing
     */
    private void lead()
    {
        double angle;
        SnakeWorld myWorld = (SnakeWorld)getWorld();
        x = getX();
        y = getY();
        
        if( Greenfoot.isKeyDown("left")){
            setRotation(180);         
        }       
        else if( Greenfoot.isKeyDown("right")){
            setRotation(0);         
        }        
        else if( Greenfoot.isKeyDown("up")){
            setRotation(270);
        }
        else if( Greenfoot.isKeyDown("down")){
            setRotation(90); 
        }
        
        angle = Math.toRadians( getRotation());
        x = (int) Math.round( getX() + Math.cos(angle) *DOT_SIZE);
        y = (int) Math.round( getY() + Math.sin(angle) *DOT_SIZE);
        
        setLocation(x,y);
        myWorld.setDX(d, x);
        myWorld.setDY(d, y);
    }
    
    /**
     * lookForFood will check to see if the head has collided with food
     * @param has no parameter
     * @return s nothing
     */
    private void lookForEdge()
    {
        if(isAtEdge() )
        {
            getWorld().showText("YOU ARE A LOSER!",getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
        
    }
    
    /**
     * lookForEdge will check to see if the snkae has touched a food and will grow the tail
     * @param has no parameter
     * @return nothing is returned
     */
    private void lookForFood()
    {
       SnakeWorld world = (SnakeWorld)getWorld();
        
        if(isTouching(Food.class))
       {
         getWorld().removeObject(getOneIntersectingObject(Food.class));
         growTail();
         world.addFood();
       }
    }
    
    /**
     * lookForDot will check to see if the head has collided with body
     * @param has no parameter
     * @return s nothing
     */
    private void lookForDot()
    {
       if( isTouching(Dot.class))
       {
        getWorld().showText("YOU ARE A LOSER!",getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
       }
    }
    
     /**
     * follow will make the body follow the snake
     * @param has no parameters
     * @retun s nothing
     */
    private void follow()
    {
     SnakeWorld myWorld = (SnakeWorld)getWorld();
     x = myWorld.getMyX(d);
     y = myWorld.getMyY(d);
     setLocation(x, y);
    
     
    }
    /**
     * growTail will grow the tail of the snak when they eat a frog
     * @param no parameters
     * @return nothing is retunred
     */
    private void growTail()
    {
      SnakeWorld world = (SnakeWorld)getWorld();
      world.addDot();
    }
    
    
    
    
  
}
