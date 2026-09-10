package scene;

public interface Scene {

    void init();
    void loadElements();
    void update(long window, long delta);
    void draw();

}
