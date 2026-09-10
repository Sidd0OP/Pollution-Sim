package window;

import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import render.Renderer;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Application {


    private long window;

    private int width, height;
    private double mouseX, mouseY;

    public void launch()
    {
        init();
        loop();
    }

    long currentTime = System.nanoTime();
    long deltaTime = 0;

    private void init()
    {
        GLFWErrorCallback.createPrint(System.err).set();
        if ( !glfwInit() )throw new IllegalStateException("Unable to initialize GLFW");
        glfwDefaultWindowHints();

        window = glfwCreateWindow(800, 800, "Pollution Sim", NULL, NULL);
        if ( window == NULL )throw new RuntimeException("Failed to create the GLFW window");
//        glfwMaximizeWindow(window);

//        update when resized
//        glfwSetFramebufferSizeCallback(window, (long win, int width, int height) -> {
//            this.width = width;
//            this.height = height;
//            glViewport(0, 0, width, height);
//        });

        glfwMakeContextCurrent(window);
        glfwSwapInterval(1);
        glfwShowWindow(window);

    }


    private void loop()
    {
        GL.createCapabilities();
        glClearColor(0.1f, 0.1f, 0.1f, 0.0f);

        while ( !glfwWindowShouldClose(window) )
        {

            long now = System.nanoTime();
            deltaTime = now - currentTime;
            currentTime = now;

            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

            // update and draw call
            Renderer.update(window, deltaTime);
            Renderer.draw();

            int error = glGetError();
            if (error != GL_NO_ERROR) {
                System.out.println("GL Error: " + error);
            }

            GL20.glDisableVertexAttribArray(0);
            GL30.glBindVertexArray(0);

            glfwSwapBuffers(window);
            glfwPollEvents();

        }
    }


}
