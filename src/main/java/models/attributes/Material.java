package models.attributes;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;
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

    public Material bind()
    {
        shader.use();
        return this;
    }


    public Material setModel(Matrix4f model)
    {
        shader.bindUniformMat4("model", model);
        return this;
    }

    public Material setView(Matrix4f model)
    {
        shader.bindUniformMat4("view", model);
        return this;
    }

    public Material setProjection(Matrix4f model)
    {
        shader.bindUniformMat4("projection", model);
        return this;
    }


}
