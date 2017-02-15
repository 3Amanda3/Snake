import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class snakeWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SnakeWorld  extends World
{
    private final int MAX_DOTS = (600*400)/(20*20);
    
    private int [] x = new int[MAX_DOTS];
    private int [] y = new int[MAX_DOTS];
    private int dots = 4;
    private int count = 0;
    private Dot body;


    /**
     * Constructor for objects of class snakeWorld.
     * 
     */
    public SnakeWorld()
    {    
        
        super(600, 400, 1);
        
        for(int i = 0; i < dots; i++){
            x[i] = 100 - i*20;
            y[i] = 20;
        }
        
        addObject( new Food(), Greenfoot.getRandomNumber(12)*50+25, Greenfoot.getRandomNumber(8)*50+25);
        
        
        
        prepareSnake();
    }
    
    /**
     * act handles the sction that must be taken every time the program is run
     * @param has no parameters
     * @return act does not return aything
     */
    public void act()
    {
        for(int i = dots; i > 0; i--)
        {
           x[i] = x[i-1];
           y[i] = y[i-1];
        }
    }
    
    /**
     * prepareSnake adds the dot objects to the world to create our snake
     * @Param has no parameters
     * @Return prepareSnake doesn not return anything
     */
    private void prepareSnake(){
        for(int i = 0; i < dots; i++){
           body = new Dot(i);
           addObject(body, x[i], y[i]);
        }       
    }
    /**
     * setDX changes the stored x coordinate for a given dot object
     * @param d is the Dot num
     * @param dx is the new x coordinate of the for object
     * @return setDX does not return anything
     */
    public void setDX(int d, int dx)
    {
     x[d] = dx;
     
    }
    
    /**
     * setDY changes the stored y coordinate for a given dot object
     * @param d is the Dot num
     * @param dy is the new x coordinate of the for object
     * @return setDX does not return anything
     */
     public void setDY(int d, int dy)
    {
     y[d] = dy;
     
    }
   /**
    * getMyX will return the x postion of the given fot object
    * @param d is the dot num
    * @return will return an int that represents x coodinate
    */ 
    public int getMyX(int d)
    {
      return x[d];  
    }
    
   /**
    * getMyY will get the Y postion of the given dot object
    * @param d is the dot num
    * @return will return an int that represents y coodinate
    */ 
    public int getMyY(int d)
    {
      return y[d];    
    }
    /**
     * addFood will add food to the world randomly
     * @param has no parameters
     * @return will return nothing
     */
    public void addFood()
    {
     if(getObjects(Food.class).size() < 10)
      {
      for(int i = 0; i < Greenfoot.getRandomNumber(2) + 1; i++)
      {
          addObject( new Food(), Greenfoot.getRandomNumber(12)*50+25, Greenfoot.getRandomNumber(8)*50+25);  
      }
    }
  }
    /**
     * addDot will add a dot
     * @param has no parameters
     * @return nothinf is returned
     */
    public void addDot()
    {
       int parentX = x[dots-1];
       int parentY = y[dots-1];

       
       body = new Dot(dots);
       addObject( body, parentX, parentY );
       dots++;
       count++;
       showText("you have eaten " +count,  200, 300);
    }
    
    
    
    
}
