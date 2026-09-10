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

    private Vector3f cameraPosition = new Vector3f(0, 0, -5.0f);
    private Vector3f cameraTarget = new Vector3f(0.0f, 1.5f, 0.0f);

    // cross on camera
    private Vector3f cameraDirection = new Vector3f();
    private Vector3f cameraUp = new Vector3f(0, 0, 0);
    private Vector3f cameraRight = new Vector3f(0, 0, 0);

    private Matrix4f projection = new Matrix4f();

    public Camera()
    {
        cameraPosition.sub(cameraTarget, cameraDirection);

        cameraDirection.cross(up, cameraRight);
        cameraDirection.normalize();
        cameraRight.normalize();

        cameraRight.cross(cameraDirection, cameraUp);
        cameraUp.normalize();

        projection.perspective(fov, 800.0f / 800.0f, near, far);
    }


    public void update(long window, long deltaTime)
    {

        float cameraSpeed = speed;

        if (glfwGetKey(window, GLFW_KEY_W) == GLFW_PRESS) {
            System.out.println("W pressed");
            cameraPosition.add(new Vector3f(cameraDirection).mul(cameraSpeed));
        }

        if (glfwGetKey(window, GLFW_KEY_S) == GLFW_PRESS) {
            System.out.println("S pressed");
            cameraPosition.sub(new Vector3f(cameraDirection).mul(cameraSpeed));
        }

        if (glfwGetKey(window, GLFW_KEY_A) == GLFW_PRESS) {
            System.out.println("A pressed");
            cameraPosition.sub(
                    new Vector3f(cameraDirection)
                            .cross(cameraUp)
                            .normalize()
                            .mul(cameraSpeed)
            );
        }

        if (glfwGetKey(window, GLFW_KEY_D) == GLFW_PRESS) {
            System.out.println("D pressed");
            cameraPosition.add(
                    new Vector3f(cameraDirection)
                            .cross(cameraUp)
                            .normalize()
                            .mul(cameraSpeed)
            );
        }

    }

    public Matrix4f getLookAt()
    {
        Vector3f target = new Vector3f(cameraPosition)
                .add(cameraDirection);
        return new Matrix4f().lookAt(cameraPosition, target, up);
    }

    public Matrix4f getProjection()
    {
        return projection;
    }
}
