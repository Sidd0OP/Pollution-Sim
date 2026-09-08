package models.attributes;

import org.joml.Vector3f;
import shaders.Shader;
import shaders.ShaderProgram;

import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;

public class Material {
    private ShaderProgram shader;
    private Vector3f color = new Vector3f(1, 1, 1);

    public Material()
    {
        loadShaders();
    }

    private void loadShaders()
    {
        Shader vs = new Shader(GL_VERTEX_SHADER, "src/main/resources/shaders/vs.glsl");
        Shader fs = new Shader(GL_FRAGMENT_SHADER, "src/main/resources/shaders/fr.glsl");
        shader = new ShaderProgram(vs, fs);
    }

    public void bind()
    {
        shader.use();
    }


}
