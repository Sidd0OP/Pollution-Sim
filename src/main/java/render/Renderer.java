package render;

import models.entities.Floor;

import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.glDrawArrays;
import static org.lwjgl.opengl.GL20.glUseProgram;

public class Renderer {

    static Floor floor =  new Floor();

    public static void update()
    {

    }

    public static void draw()
    {
        floor.draw();
    }

}
