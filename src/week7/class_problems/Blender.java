package week7.class_problems;
public class Blender extends KitchenTool implements Washable {
    public String prepare(){ return "Blending at speed "+getSpeedLevel(); }
    public String clean(){ return "Blender rinsed and dried"; }
}