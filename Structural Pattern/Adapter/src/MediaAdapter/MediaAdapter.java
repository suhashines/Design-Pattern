package MediaAdapter;

public class MediaAdapter implements MediaPlayer{

    private AdvanceMediaPlayer player ;

    MediaAdapter(String audioType){

        if(audioType.equalsIgnoreCase("vlc")){
            player = new VLCMediaPlayer();
        }else if(audioType.equalsIgnoreCase("mp4")){
            player  = new MP4MediaPlayer();
        }
    }

    public void play(String audioType,String fileName){
        
        if(player instanceof VLCMediaPlayer){
            player.playVLC(fileName);
        }else{
            player.playMP4(fileName);
        }
    }
} 
