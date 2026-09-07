package models.attributes;

import org.joml.Matrix4f;
import org.joml.Vector3f;

public class Transform {

    public Vector3f position =  new Vector3f();
    public Vector3f rotation =  new Vector3f();
    public Vector3f scale =  new Vector3f(1.0f, 1.0f, 1.0f);

    void setPosition(float x, float y, float z)
    {

    }

    void setRotation()
    {

    }


    void setScale(float x, float y, float z)
    {

    }

    Matrix4f getModelMatrix()
    {
        return new Matrix4f()
                .translate(position)
                .rotateXYZ(rotation.x, rotation.y, rotation.z)
                .scale(scale);
    }

}
