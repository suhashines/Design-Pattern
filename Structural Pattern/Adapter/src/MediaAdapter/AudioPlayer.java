package MediaAdapter;

public class AudioPlayer implements MediaPlayer {


    @Override
    public void play(String audioType, String fileName) {
        
        if(audioType.equalsIgnoreCase("mp3")){
            System.out.println("Playing mp3 file " + fileName);
        }else if(audioType.equalsIgnoreCase("mp4")){
            new MediaAdapter(audioType).play(audioType,fileName);
        }else if(audioType.equalsIgnoreCase("vlc")){
            new MediaAdapter(audioType).play(audioType,fileName);
        }
    }
}
