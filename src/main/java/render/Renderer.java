package render;

import scene.EmptyScene;
import scene.Scene;

public class Renderer {

    static Scene scene1 = new EmptyScene();

    public static void update(long window, long deltaTime)
    {
        scene1.update(window,deltaTime);
    }

    public static void draw()
    {
        scene1.draw();
    }

}
