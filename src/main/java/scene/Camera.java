package scene;

import org.joml.Matrix4f;
import org.joml.Vector3f;

import static org.lwjgl.glfw.GLFW.*;

public class Camera {

    private float speed = 1.0f;

    private float width  = 1.0f;
    private float height = 1.0f;

    private float fov =  20.0f;
    private float near =  0.1f;
    private float far =  1000.0f;

    Vector3f up = new Vector3f(0.0f, 1.0f, 0.0f);

    private Vector3f cameraPosition = new Vector3f(1, 1, 1);
    private Vector3f cameraTarget = new Vector3f(0, 0, 0);

    // cross on camera
    private Vector3f cameraDirection = new Vector3f();
    private Vector3f cameraUp = new Vector3f(0, 0, 0);
    private Vector3f cameraRight = new Vector3f(0, 0, 0);

    private Matrix4f projection = new Matrix4f();

    public Camera()
    {
        cameraPosition.sub(cameraTarget, cameraDirection);

        cameraDirection.cross(up, cameraRight);
        cameraRight.normalize();

        cameraRight.cross(cameraDirection, cameraUp);
        cameraUp.normalize();
    }


    public void update(long window, long deltaTime)
    {

        projection.perspective(fov, 800.0f / 800.0f, near, far);

        float cameraSpeed = speed * deltaTime;

        if (glfwGetKey(window, GLFW_KEY_W) == GLFW_PRESS)
            cameraPosition.add(new Vector3f(cameraDirection).mul(cameraSpeed));
        if (glfwGetKey(window, GLFW_KEY_S) == GLFW_PRESS)
            cameraPosition.sub(new Vector3f(cameraDirection).mul(cameraSpeed));
        if (glfwGetKey(window, GLFW_KEY_A) == GLFW_PRESS)
            cameraPosition.sub(new Vector3f(cameraDirection).cross(cameraUp).normalize().mul(cameraSpeed));
        if (glfwGetKey(window, GLFW_KEY_D) == GLFW_PRESS)
            cameraPosition.add(new Vector3f(cameraDirection).cross(cameraUp).normalize().mul(cameraSpeed));

    }

    public Matrix4f getLookAt()
    {
        return new Matrix4f().lookAt(cameraPosition, new Vector3f(cameraPosition).add(cameraTarget), up);
    }

    public Matrix4f getProjection()
    {
        return projection;
    }
}
