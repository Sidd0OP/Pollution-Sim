package window;

import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
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


    private void init()
    {
        GLFWErrorCallback.createPrint(System.err).set();
        if ( !glfwInit() )throw new IllegalStateException("Unable to initialize GLFW");
        glfwDefaultWindowHints();

        window = glfwCreateWindow(300, 300, "Pollution Sim", NULL, NULL);
        if ( window == NULL )throw new RuntimeException("Failed to create the GLFW window");
        glfwMaximizeWindow(window);

        //update when resized
        glfwSetFramebufferSizeCallback(window, (long win, int width, int height) -> {
            this.width = width;
            this.height = height;
            glViewport(0, 0, width, height);
        });

        glfwMakeContextCurrent(window);
        glfwSwapInterval(1);
        glfwShowWindow(window);

    }


    private void loop()
    {
        GL.createCapabilities();
        glClearColor(1.0f, 1.0f, 1.0f, 0.0f);

        while ( !glfwWindowShouldClose(window) )
        {

            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            glfwSwapBuffers(window);
            glfwPollEvents();

            Renderer.update();
            Renderer.draw();
        }
    }

}
