package models.entities;

import models.attributes.Material;
import models.attributes.Mesh;
import models.attributes.Transform;

public class Floor {

    public Mesh mesh;
    public Transform transform;
    public Material material;


    //temp
    float[] vertices = {
            -0.5f, -0.5f, 0.0f,  // bottom-left
            0.5f, -0.5f, 0.0f,  // bottom-right
            0.5f,  0.5f, 0.0f,  // top-right

            -0.5f, -0.5f, 0.0f,  // bottom-left
            0.5f,  0.5f, 0.0f,  // top-right
            -0.5f,  0.5f, 0.0f   // top-left
    };

    public Floor()
    {
        this.mesh = new Mesh(vertices, null, null);
        this.material = new Material();
    }

    void Load()
    {

    }


    void draw()
    {

    }
}
