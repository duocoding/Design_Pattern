package adapter_pattern;

/**
 * @ClassName Mp4Player
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/7/26 9:39
 * @Version 1.0
 */
public class Mp4Player implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}
