package shaders;

import static org.lwjgl.opengl.GL20.*;

public class ShaderProgram {

    private int id;
    private Shader vertexShader;
    private Shader fragmentShader;

    public ShaderProgram(Shader vertexShader, Shader fragmentShader)
    {
        this.vertexShader = vertexShader;
        this.fragmentShader = fragmentShader;
        createShaderProgram();
    }


    private void createShaderProgram()
    {
        id = glCreateProgram();
        glAttachShader(id, vertexShader.getHandle());
        glAttachShader(id, fragmentShader.getHandle());

        glLinkProgram(id);

        // check if linking failed
        int linkingStatus = glGetProgrami(id, GL_LINK_STATUS);
        if (linkingStatus == 0) {
            String errorLog = glGetProgramInfoLog(id);
            System.out.println("errorLog: " + errorLog);
            glDeleteShader(id);
            throw new RuntimeException("Shader linking failed: consult the log above");
        }
    }


    public void use(){
        glUseProgram(id);
    }

    //free up
    public void delete(){
        glDeleteProgram(id);
    }


    public int getHandle(){
        return id;
    }
}
