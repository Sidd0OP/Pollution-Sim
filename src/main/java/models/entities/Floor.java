package models.entities;

import models.attributes.Material;
import models.attributes.Mesh;
import models.attributes.Transform;
import org.joml.Matrix4f;
import org.joml.Vector4f;

import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.glDrawArrays;
import static org.lwjgl.opengl.GL20.glUseProgram;

public class Floor {

    private Mesh mesh;
    private Transform transform;
    private Material material;


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
        this.transform = new Transform();
    }




    public void draw(Matrix4f view, Matrix4f projection)
    {

        mesh.bind();
        material.bind()
                .setModel(transform.getModelMatrix())
                .setView(view)
                .setProjection(projection);

        glDrawArrays(GL_TRIANGLES, 0, 3);

        mesh.unbind();
        glUseProgram(0);

    }
}
