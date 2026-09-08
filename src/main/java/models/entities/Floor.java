package models.entities;

import models.attributes.Material;
import models.attributes.Mesh;
import models.attributes.Transform;

import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.glDrawArrays;
import static org.lwjgl.opengl.GL20.glUseProgram;

public class Floor {

    public Mesh mesh;
    public Transform transform;
    public Material material;


    //traingle
    float[] vertices = {
            -0.5f, -0.5f, 0.0f,
            0.5f, -0.5f, 0.0f,
            0.0f,  0.5f, 0.0f
    };

    public Floor()
    {
        this.mesh = new Mesh(vertices, null, null);
        this.material = new Material();
    }

    void Load()
    {

    }


    public void draw()
    {
        material.bind();
        mesh.bind();

        glDrawArrays(GL_TRIANGLES, 0, 3);

        mesh.unbind();
        glUseProgram(0);

    }
}
