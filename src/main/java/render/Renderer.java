package render;

import models.entities.Floor;

import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.glDrawArrays;

public class Renderer {

    static Floor floor =  new Floor();

    public static void update()
    {

    }

    public static void draw()
    {
        //abstract this
        floor.mesh.bind();
        glDrawArrays(GL_TRIANGLES,0, 18);
        floor.mesh.unbind();
    }

}
