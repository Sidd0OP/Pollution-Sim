package models.attributes;

import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;


public class Mesh {

    private int vaoId;
    private List<Integer> vboIds = new ArrayList<>();

    public Mesh(float[] vertices, float[] normals, float[] uvCoordinates)
    {
        vaoId = glGenVertexArrays();
        glBindVertexArray(vaoId);

        addVboAttribute(vertices,0,3);

        if(normals!=null)addVboAttribute(normals,1,3);
        if(uvCoordinates!=null)addVboAttribute(uvCoordinates,2,2);

        glBindVertexArray(0);
    }


    private int addVboAttribute(float[] data, int attributeIndex, int size)
    {
        int vboID = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboID);

        FloatBuffer buffer = BufferUtils
                .createFloatBuffer(data.length)
                .put(data)
                .flip();

        glBufferData(GL_ARRAY_BUFFER, buffer, GL_STATIC_DRAW);
        glVertexAttribPointer(attributeIndex,size, GL_FLOAT, false, 0, 0);
        glEnableVertexAttribArray(attributeIndex);

        glBindBuffer(GL_ARRAY_BUFFER, 0);
        return vboID;
    }

    public void bind()
    {
        glBindVertexArray(vaoId);
    }

    public void unbind()
    {
        glBindVertexArray(0);
    }


}
