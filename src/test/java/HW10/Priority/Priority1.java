package HW10.Priority;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Priority1 {
    @Test(priority=7,dependsOnMethods = {"b"})
    public void a (){
        assertTrue(true);
    }
    @Test(priority=6,dependsOnMethods = {"c"})
    public void b (){
        assertTrue(true);
    }
    @Test(priority=5,dependsOnMethods = {"d"})
    public void c (){
        assertTrue(true);
    }
    @Test(priority=4,dependsOnMethods = {"e"})
    public void d (){
        assertTrue(true);
    }
    @Test(priority=3,dependsOnMethods = {"f"})
    public void e (){
        assertTrue(true);
    }
    @Test(priority=2,dependsOnMethods = {"g"})
    public void f (){
        assertTrue(true);
    }
    @Test(priority=1)
    public void g (){
        assertTrue(true);
    }
}
