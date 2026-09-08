package models.attributes;

import org.joml.Vector3f;
import shaders.ShaderProgram;

public class Material {
    private ShaderProgram shader;
    private Vector3f color = new Vector3f(1, 1, 1);

    public Material()
    {

    }
}
