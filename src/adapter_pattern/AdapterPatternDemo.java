package adapter_pattern;

/**
 * @ClassName AdapterPatternDemo
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/7/26 9:50
 * @Version 1.0
 */
public class AdapterPatternDemo {

    public static void main(String[] args) {

        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.paly("mp3", "beyond the horizon.mp3");
        audioPlayer.paly("mp4", "alone.mp4");
        audioPlayer.paly("vlc", "far far away.vlc");
        audioPlayer.paly("avi", "mind me.avi");
    }
}
