package scene;

import models.entities.Floor;

public class EmptyScene implements Scene{

    Camera camera = new Camera();
    Floor floor =  new Floor();

    @Override
    public void init()
    {
//        camera = new Camera();
    }

    @Override
    public void loadElements()
    {

    }

    @Override
    public void update(long window, long delta)
    {
        camera.update(window, delta);
    }

    @Override
    public void draw()
    {
        //entity
        floor.draw(camera.getLookAt(), camera.getProjection());
    }
}
