package shaders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.lwjgl.opengl.GL20.*;

public class Shader {
    private int id;
    private int type;
    private String filename;

    public Shader(int type, String filename) {
        this.type = type;
        this.filename = filename;
        load();
    }

    private void load(){
        // read the shader's source code from given file
        String shaderSource;
        try {
            shaderSource = String.join("\n", Files.readAllLines(Paths.get(filename)));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load shader file: " + filename);
        }

        // create & compile shader
        id = glCreateShader(type);
        glShaderSource(id, shaderSource);
        glCompileShader(id);

        // check if compilation failed
        int compilationStatus = glGetShaderi(id, GL_COMPILE_STATUS);
        if (compilationStatus == 0) {
            String errorLog = glGetShaderInfoLog(id);
            System.out.println("errorLog: " + errorLog);
            glDeleteShader(id);
            throw new RuntimeException("Shader compilation failed: consult the log above");
        }
    }

    public int getHandle() {
        return id;
    }
}
