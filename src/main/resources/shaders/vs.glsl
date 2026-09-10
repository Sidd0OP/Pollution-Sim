#version 330

// fed from vbo (0) containing vertex attributes
layout (location = 0) in vec3 vertex;

//mesh transformation
uniform mat4 model;
//camera transformation
uniform mat4 view;
//screen and fov
uniform mat4 projection;

out vec4 vertexColor;

void main()
{
    gl_Position = projection * view * model * vec4(vertex, 1.0);
    vertexColor = vec4(0.5, 0.0, 0.0, 1.0);
}