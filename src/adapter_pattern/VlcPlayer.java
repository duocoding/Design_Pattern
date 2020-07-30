package adapter_pattern;

/**
 * @ClassName VlcPlayer
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/7/26 9:38
 * @Version 1.0
 */
public class VlcPlayer implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}
