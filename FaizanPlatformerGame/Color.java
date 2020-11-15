public class Color
{
  private int red;
  private int green;
  private int blue;
  
  public Color(int r, int g, int b)
  {
    red = r;
    green = g;
    blue = b;
  }
  
  public int getRed()
  {
    return red;
  }
  
  public int getGreen()
  {
    return green;
  }
  
  public int getBlue()
  {
    return blue;
  }
  
  public boolean equals(Color otherColor)
  {
    return red == otherColor.getRed() && green == otherColor.getGreen() && blue == otherColor.getBlue();
  }
  
  public String toString()
  {
    return "(" + red + ", " + green + ", " + blue + ")";
  }
}