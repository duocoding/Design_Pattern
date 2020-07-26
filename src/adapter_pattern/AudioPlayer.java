package adapter_pattern;

/**
 * @ClassName AudioPlayer
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/7/26 9:44
 * @Version 1.0
 */
public class AudioPlayer implements MediaPlayer{
    @Override
    public void paly(String audioType, String fileName) {

        //播放 mp3 音乐文件的内置支持
        if(audioType.equalsIgnoreCase("mp3")){
            System.out.println("Playing mp3 file. Name: "+ fileName);
        }
        //mediaAdapter 提供了播放其他文件格式的支持
        else if(audioType.equalsIgnoreCase("vlc")
                || audioType.equalsIgnoreCase("mp4")){
            MediaAdapter mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.paly(audioType, fileName);

        }
        else{
            System.out.println("Invalid media. "+
                    audioType + " format not supported");
        }
    }
}
